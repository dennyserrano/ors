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
            new KeyValue("", "School Year"),
            new KeyValue("2014", "2014 - 2015"),
            new KeyValue("2013", "2013 - 2014"),
            new KeyValue("2012", "2012 - 2013"),
            new KeyValue("2011", "2011 - 2012"),
            new KeyValue("2010", "2010 - 2011"),
            new KeyValue("2009", "2009 - 2010"),
            new KeyValue("2008", "2008 - 2009"),
            new KeyValue("2007", "2007 - 2008"),
            new KeyValue("2006", "2006 - 2007"),
            new KeyValue("2005", "2005 - 2006"),
            new KeyValue("2004", "2004 - 2005"),
            new KeyValue("2003", "2003 - 2004"),
            new KeyValue("2002", "2002 - 2003")
    ));

    private static final List<KeyValue> GENERAL_CLASSIFICATIONS = new ArrayList<>(Arrays.asList(
            new KeyValue("", "General Classification"),
            new KeyValue("7", "Public"),
            new KeyValue("8", "Private")
    ));

    private static final List<KeyValue> GENERAL_CURRICULAR_OFFERINGS = new ArrayList<>(Arrays.asList(
            new KeyValue("", "General Curricular Offering"),
            new KeyValue("433", "Elementary"),
            new KeyValue("434", "Secondary")
    ));

    private static final List<KeyValue> SCHOOL_TYPES = new ArrayList<>(Arrays.asList(
            new KeyValue("", "School Type"),
            new KeyValue("290", "School with no annexes"),
            new KeyValue("291", "Mobile school(s)/center(s)"),
            new KeyValue("292", "Mother school"),
            new KeyValue("293", "Annex or Extension school(s)")
    ));

    private static final int REGION_OFFICE_TYPE = 191;

    private static final int DIVSION_OFFICE_TYPE = 192;

    private static final String REGIONS_SQL = "SELECT ro.id AS 'id', rr.short_name AS 'region_name' FROM ref_region rr " +
            "INNER JOIN ref_office ro on rr.id = ro.ref_region_id WHERE ro.office_type = ?";

    private static final String REGION_DIVISIONS_SQL = "SELECT id, office_name FROM ref_office WHERE parent_office = ? AND office_type = ?";

    //private static final String DIVISIONS_SQL = "SELECT id, office_Name FROM ref_office WHERE office_type = ?";

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
        nationwide.setChildKeyValues(new ArrayList<>(Arrays.asList(new KeyValue("", "Division"))));
        regions.add(0, nationwide);
        return regions;
    }
}
