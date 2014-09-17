package ph.gov.deped.service.etl.ds;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.common.query.FromClauseBuilder;
import ph.gov.deped.common.query.ProjectionBuilder;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.service.etl.meta.MetadataHolder;

import java.util.List;

import static ph.gov.deped.common.query.Projections.column;
import static ph.gov.deped.common.query.QueryBuilders.read;

/**
 * Created by ej on 9/10/14.
 */
public class PhysicalTableToSqlItemProcessor implements ItemProcessor<MetadataHolder, DbTypeSqlMapping> {

    private static final Logger log = LogManager.getLogger(PhysicalTableToSqlItemProcessor.class);

    public DbTypeSqlMapping process(MetadataHolder item) throws Exception {
        log.entry(item);
        final String tmpTblPrefix = RandomStringUtils.randomAlphanumeric(5);
        final TableMetadata tableMetadata = item.getTableMetadata();
        final List<ColumnMetadata> columnMetadataList = item.getColumnMetadatas();
        final String tableName = tableMetadata.getTableName();
        final DbType dbType = DbType.findById(tableMetadata.getDbId());
        ProjectionBuilder projectionBuilder = read();
        FromClauseBuilder builder = columnMetadataList.stream()
                .map(cm -> projectionBuilder.select(column(tmpTblPrefix, cm.getColumnName(), cm.getColumnName())))
                .reduce((b1, b2) -> b2)
                .get();
        final StringBuilder sql = builder.from(tableName, tmpTblPrefix).build();
        log.trace("Generated SQL Statement: [{}]", sql);
        return log.exit(new DbTypeSqlMapping(dbType, sql, item));
    }
}
