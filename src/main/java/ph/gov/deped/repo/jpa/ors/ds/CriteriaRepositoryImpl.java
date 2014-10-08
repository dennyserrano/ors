package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.data.dto.KeyValue;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PSY on 2014/10/03.
 */
public class CriteriaRepositoryImpl implements DefaultCriteriaRepository {

    private static final List<KeyValue> SCHOOL_YEARS = new ArrayList<>(Arrays.asList(
            new KeyValue("2014", "2014 - 2015"),
            new KeyValue("2013", "2013 - 2014"),
            new KeyValue("2012", "2012 - 2013"),
            new KeyValue("2011", "2011 - 2012")
    ));

    private static final List<KeyValue> GENERAL_CLASSIFICATIONS = new ArrayList<>(Arrays.asList(
            new KeyValue("", "All"),
            new KeyValue("PU", "Public"),
            new KeyValue("PR", "Private")
    ));

    private static final List<KeyValue> GENERAL_CURRICULAR_OFFERINGS = new ArrayList<>(Arrays.asList(
            new KeyValue("EL", "Elementary"),
            new KeyValue("SE", "Secondary")
    ));

    private static final List<KeyValue> SCHOOL_TYPES = new ArrayList<>(Arrays.asList(
            new KeyValue("0", "All"),
            new KeyValue("1", "School with no annexes"),
            new KeyValue("2", "Mobile school/center"),
            new KeyValue("3", "Mother school"),
            new KeyValue("4", "Annex or Extension school")
    ));

    private static final int REGION_OFFICE_TYPE = 191;

    private static final int DIVSION_OFFICE_TYPE = 192;

    private static final String REGIONS_SQL = "SELECT ro.id AS 'id', rr.short_name AS 'region_name' FROM ref_region rr " +
            "INNER JOIN ref_office ro on rr.id = ro.ref_region_id WHERE ro.office_type = ?";

    private static final String REGION_DIVISIONS_SQL = "SELECT id, office_name FROM ref_office WHERE parent_office = ? AND office_type = ?";

    //private static final String DIVISIONS_SQL = "SEELCT id, office_Name FROM ref_office WHERE office_type = ?";

    private DataSource dataSource;

    public @Autowired @Qualifier(AppMetadata.DS) void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<KeyValue> getSchoolYears() {
        return SCHOOL_YEARS;
    }

    public List<KeyValue> getGeneralClassifications() {
        return GENERAL_CLASSIFICATIONS;
    }

    public List<KeyValue> getGeneralCurricularOfferings() {
        return GENERAL_CURRICULAR_OFFERINGS;
    }

    public List<KeyValue> getSchoolTypes() {
        return SCHOOL_TYPES;
    }

    public List<KeyValue> getRegionsAndDivisions() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<KeyValue> regions = template.query(REGIONS_SQL,
                new Object[] { REGION_OFFICE_TYPE },
                new int[] { Types.INTEGER },
                (rs, rowNum) -> new KeyValue(String.valueOf(rs.getInt("id")), rs.getString("region_name")));
        regions.forEach(kv -> {
            List<KeyValue> divisions = template.query(REGION_DIVISIONS_SQL,
                    new Object[]{Integer.parseInt(kv.getKey()), DIVSION_OFFICE_TYPE},
                    new int[]{Types.INTEGER, Types.INTEGER},
                    (rs, rowNum) -> new KeyValue(String.valueOf(rs.getInt("id")), rs.getString("office_name")));
            kv.setChildKeyValues(divisions);
        });
        KeyValue nationwide = new KeyValue("", "Nationwide");
        regions.add(0, nationwide);
        return regions;
    }
}
