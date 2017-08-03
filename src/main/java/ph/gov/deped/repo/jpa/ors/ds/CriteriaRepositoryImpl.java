package ph.gov.deped.repo.jpa.ors.ds;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.config.FilterSettings;
import ph.gov.deped.data.dto.KeyValue;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PSY on 2014/10/03.
 */
class CriteriaRepositoryImpl implements DefaultCriteriaRepository {

    private static final List<KeyValue> SCHOOL_YEARS = new ArrayList<>(Arrays.asList(
    		new KeyValue("2016", "2016 - 2017"),
    		new KeyValue("2015", "2015 - 2016"),
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

    private static final List<KeyValue> SCHOOL_TYPES = new ArrayList<>(Arrays.asList(
            new KeyValue("", "All"),
            new KeyValue("290", "School with no annexes"),
            new KeyValue("291", "Mobile school(s)/center(s)"),
            new KeyValue("292", "Mother school"),
            new KeyValue("293", "Annex or Extension school(s)")
    ));

    private DataSource dataSource;
    
    private FilterSettings filterSettings;

    public @Autowired @Qualifier(AppMetadata.DS) void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public @Autowired void setFilterSettings(FilterSettings filterSettings) {
        this.filterSettings = filterSettings;
    }

    public List<KeyValue> getSchoolYears() {
        return SCHOOL_YEARS;
    }


    public List<KeyValue> getGeneralClassifications() {
    	JdbcTemplate template = new JdbcTemplate(dataSource);
    	
    	KeyValue all=new KeyValue("", "All");
    	
    	KeyValue p1=new KeyValue("7", "Public");
    	
    	p1.setChildKeyValues(template.query(filterSettings.getSectorPublicSql(),
				(rs, rowNum) -> new KeyValue(String.valueOf(rs.getInt("id")), rs.getString("description"))));
    	
    	KeyValue pr=new KeyValue("8", "Private");
    	pr.setChildKeyValues(
    			template.query(filterSettings.getSectorPrivateSql(),
    					(rs, rowNum) -> new KeyValue(String.valueOf(rs.getInt("id")), rs.getString("description")))
    			);
    	
    	
    	return new ArrayList<>(Arrays.asList(all,p1,pr));
    }

    public List<KeyValue> getGeneralCurricularOfferings() 
    {
    	JdbcTemplate template = new JdbcTemplate(dataSource);
    	KeyValue kv1=new KeyValue("433", "Elementary");
    	
    	kv1.setChildKeyValues
    	(
    			template.query(filterSettings.getGeneralCurricularOfferingElem(),
    					(rs, rowNum) -> new KeyValue(String.valueOf(rs.getInt("id")), rs.getString("description")))
    	);
    	
        KeyValue kv2=new KeyValue("434", "Secondary");
        
        kv2.setChildKeyValues
    	(
    			template.query(filterSettings.getGeneralCurricularOfferingSeco(),
    					(rs, rowNum) -> new KeyValue(String.valueOf(rs.getInt("id")), rs.getString("description")))
    	);
        
        return new ArrayList<>(Arrays.asList(kv1,kv2));
    }

    public List<KeyValue> getSchoolTypes() {
        return SCHOOL_TYPES;
    }

    public List<KeyValue> getRegionsAndDivisions() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<KeyValue> regions = template.query(filterSettings.getRegionSql(),
                new Object[] { filterSettings.getRegionOfficeType() },
                new int[] { Types.INTEGER },
                (rs, rowNum) -> new KeyValue(String.valueOf(rs.getInt("id")), rs.getString("region_name")));
        regions.forEach(kv -> {
            List<KeyValue> divisions = template.query(filterSettings.getDivisionSql(),
                    new Object[] { Integer.parseInt(kv.getKey()), filterSettings.getDivisionOfficeType() },
                    new int[] { Types.INTEGER, Types.INTEGER },
                    (rs, rowNum) -> new KeyValue(String.valueOf(rs.getInt("id")), rs.getString("office_name")));
            kv.setChildKeyValues(divisions);
        });
        KeyValue nationwide = new KeyValue("", "Nationwide");
        nationwide.setChildKeyValues(new ArrayList<>(Arrays.asList(new KeyValue("", ""))));
        regions.add(0, nationwide);
        return regions;
    }
    
    public List<KeyValue> searchSchool(int schoolYear, int levelOfEducation, Integer sectorId, Integer regionId, Integer divisionId, String schoolName) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<Serializable> params = new ArrayList<>();
        List<Integer> paramTypes = new ArrayList<>();
        
        StringBuffer sql = new StringBuffer(filterSettings.getSchoolNameSql());
        
        params.add(schoolYear);
        paramTypes.add(Types.SMALLINT);
        
        params.add(levelOfEducation);
        paramTypes.add(Types.SMALLINT);
        
        params.add("%" + schoolName + "%");
        paramTypes.add(Types.VARCHAR);
        
        if (sectorId != null && sectorId > 0) {
            params.add(sectorId);
            paramTypes.add(Types.SMALLINT);
            sql.append(" AND sector_id = ?");
        }
        
        if (regionId != null && regionId > 0) {
            params.add(regionId);
            paramTypes.add(Types.TINYINT);
            sql.append(" AND region_id = ?");
        }
        
        if (divisionId != null && divisionId > 0) {
            params.add(divisionId);
            paramTypes.add(Types.INTEGER);
            sql.append(" AND division_id = ?");
        }
        
        return template.query(sql.toString(),
                params.toArray(new Object[params.size()]),
                ArrayUtils.toPrimitive(paramTypes.toArray(new Integer[paramTypes.size()])), 
                (rs, rowNum) -> {
                    String id = String.valueOf(rs.getInt("school_id"));
                    String name = rs.getString("school_name");
                    return new KeyValue(id, String.format("(%s) %s", id, name));
                });
    }

	@Override
	public List<KeyValue> getDistrict() {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		StringBuffer sql = new StringBuffer(filterSettings.getDistrictSql());
		return null;
	}

	@Override
	public List<KeyValue> getProvince() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KeyValue> getMunicipality() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KeyValue> getLegislative() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
