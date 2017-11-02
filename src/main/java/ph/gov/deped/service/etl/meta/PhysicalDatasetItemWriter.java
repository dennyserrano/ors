package ph.gov.deped.service.etl.meta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.cfg.NamingStrategy;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.SpringNamingStrategy;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.db.DatasetElement;
import com.model.db.DatasetHead;
import com.model.db.TableMetadata;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.repo.jpa.ors.ds.ElementRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.security.SecurityContextUtil;

import javax.sql.DataSource;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by ej on 9/11/14.
 */
public class PhysicalDatasetItemWriter implements ItemWriter<MetadataHolder> {

    private static final Logger log = LogManager.getLogger(PhysicalDatasetItemWriter.class);

    private SecurityContextUtil securityContextUtil;

    private DatasetRepository datasetRepository;

    private ElementRepository elementRepository;
    
    private NamingStrategy namingStrategy = new SpringNamingStrategy();
    
    private DataSource dataSource;

    public PhysicalDatasetItemWriter() {}

    public PhysicalDatasetItemWriter(SecurityContextUtil securityContextUtil,
                                    DatasetRepository datasetRepository,
                                    ElementRepository elementRepository,
                                    NamingStrategy namingStrategy, DataSource dataSource) {
        this.securityContextUtil = securityContextUtil;
        this.datasetRepository = datasetRepository;
        this.elementRepository = elementRepository;
        this.namingStrategy = namingStrategy;
        this.dataSource = dataSource;
    }

    public @Autowired void setSecurityContextUtil(SecurityContextUtil securityContextUtil) {
        this.securityContextUtil = securityContextUtil;
    }

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public @Autowired void setElementRepository(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }
    
    public void setNamingStrategy(NamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    public @Autowired @Qualifier(AppMetadata.DS) void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void write(List<? extends MetadataHolder> items) throws Exception {
        items.stream().forEach(this::processMetadata);
    }

    protected void processMetadata(MetadataHolder holder) {
        log.entry(holder);
        foreignKeyChecks(false);
        
        securityContextUtil.createInternalUserAuthentication("SYSTEM");
        TableMetadata table = holder.getTableMetadata();
        DbType dbType = DbType.values()[table.getDbId()];
        final String name = dbType.getDbName().toUpperCase() + "." + namingStrategy.tableName(table.getTableName());
        DatasetHead head = datasetRepository.findByName(name);
        if (head == null) {
            head = new DatasetHead();
            head.setName(name);
            String description;
            if (!isBlank(table.getDescription())) {
                description = table.getDescription();
            }
            else {
                description = String.format("RAW or Physical Table [%s] from MySQL Database [%s].", table.getTableName(), dbType.getDbName());
            }
            head.setDescription(description);
            head.setOwnerId(0);
            datasetRepository.save(head);

            AtomicInteger batch = new AtomicInteger(0);
            holder.columnMetadatas.parallelStream()
                    .map(c -> {
                        DatasetElement element = new DatasetElement();
                        element.setColumnId(c.getColumnId());
                        element.setName(c.getColumnName());
                        element.setMeaning(String.format(
                                "Physical column [%s] from table [%s].",
                                c.getColumnName(), table.getTableName()));
                        element.setDescription(table.getTableName() + "."
                                + c.getColumnName());
                        element.setAlias(c.getColumnName());
                        batch.incrementAndGet();
                        return element;
                    }).forEach(e -> insertColumn(e, batch.get() % 10 == 0));
        }
        securityContextUtil.removeAuthentication();
        foreignKeyChecks(true);
        log.exit();
    }
    
    public void insertColumn(DatasetElement element, boolean flush) {
        foreignKeyChecks(false);
        securityContextUtil.createInternalUserAuthentication("SYSTEM");
        elementRepository.save(element);
        securityContextUtil.removeAuthentication();
        if (flush) {
            elementRepository.flush();
        }
        foreignKeyChecks(true);
    }
    
    private void foreignKeyChecks(boolean enabled) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        if (!enabled) {
            template.execute("SET FOREIGN_KEY_CHECKS=0");
        }
        else {
            template.execute("SET FOREIGN_KEY_CHECKS=1");
        }
    }
}
