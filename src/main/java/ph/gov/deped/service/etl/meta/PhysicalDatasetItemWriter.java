package ph.gov.deped.service.etl.meta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.ds.DatasetTable;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.repo.jpa.ors.ds.DatasetElementRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetHeadRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetTableRepository;
import ph.gov.deped.security.SecurityContextUtil;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by ej on 9/11/14.
 */
public class PhysicalDatasetItemWriter implements ItemWriter<MetadataHolder> {

    private static final Logger log = LogManager.getLogger(PhysicalDatasetItemWriter.class);

    private SecurityContextUtil securityContextUtil;

    private DatasetHeadRepository datasetHeadRepository;

    private DatasetTableRepository datasetTableRepository;

    private DatasetElementRepository datasetElementRepository;

    public PhysicalDatasetItemWriter() {}

    public PhysicalDatasetItemWriter(SecurityContextUtil securityContextUtil,
                                    DatasetHeadRepository datasetHeadRepository,
                                    DatasetTableRepository datasetTableRepository,
                                    DatasetElementRepository datasetElementRepository) {
        this.securityContextUtil = securityContextUtil;
        this.datasetHeadRepository = datasetHeadRepository;
        this.datasetTableRepository = datasetTableRepository;
        this.datasetElementRepository = datasetElementRepository;
    }

    public @Autowired void setSecurityContextUtil(SecurityContextUtil securityContextUtil) {
        this.securityContextUtil = securityContextUtil;
    }

    public @Autowired void setDatasetHeadRepository(DatasetHeadRepository datasetHeadRepository) {
        this.datasetHeadRepository = datasetHeadRepository;
    }

    public @Autowired void setDatasetTableRepository(DatasetTableRepository datasetTableRepository) {
        this.datasetTableRepository = datasetTableRepository;
    }

    public @Autowired void setDatasetElementRepository(DatasetElementRepository datasetElementRepository) {
        this.datasetElementRepository = datasetElementRepository;
    }

    public void write(List<? extends MetadataHolder> items) throws Exception {
        items.stream().forEach(this::processMetadata);
    }

    protected void processMetadata(MetadataHolder holder) {
        log.entry(holder);
        securityContextUtil.createInternalUserAuthentication("SYSTEM");
        TableMetadata table = holder.getTableMetadata();
        DbType dbType = DbType.values()[table.getDbId()];
        final String name = dbType.getDbName().toUpperCase() + "." + holder.getKeyClass().getSimpleName();
        DatasetHead head = datasetHeadRepository.findByName(name);
        if (head == null) {
            head = new DatasetHead();
            head.setName(dbType.getDbName().toUpperCase() + "." + holder.getKeyClass().getSimpleName());
            String description;
            if (!isBlank(table.getDescription())) {
                description = table.getDescription();
            }
            else {
                description = String.format("RAW or Physical Table [%s] from MySQL Database [%s].", table.getTableName(), dbType.getDbName());
            }
            head.setDescription(description);
            head.setOwnerId(0);
            datasetHeadRepository.save(head);

            DatasetTable datasetTable = new DatasetTable();
            datasetTable.setDatasetHead(head);
            datasetTable.setTableId(table.getTableId());
            datasetTableRepository.save(datasetTable);

            holder.columnMetadatas.forEach(c -> {
                DatasetElement element = new DatasetElement();
                element.setDatasetTable(datasetTable);
                element.setColumnId(c.getColumnId());
                element.setName(c.getColumnName());
                element.setMeaning(String.format("Physical column [%s] from table [%s].", c.getColumnName(), table.getTableName()));
                element.setDescription(table.getTableName() + "." + c.getColumnName());
                element.setAlias(c.getColumnName());
                datasetElementRepository.save(element);
            });
        }
        securityContextUtil.removeAuthentication();
        log.exit();
    }
}
