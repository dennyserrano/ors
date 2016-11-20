package ph.gov.deped.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @author ej
 * @since Nov 07, 2014 15:54
 */
@ConfigurationProperties(prefix = "filter", locations = {"classpath:" + FilterSettings.FILTER_PROPERTIES})
public class FilterSettings implements Serializable {
    
    public static final String FILTER_PROPERTIES = "filters.properties";
    
    private static final long serialVersionUID = -3751118298365958979L;

    private int regionId;
    
    private int divisionId;
    
    private int schoolNameId;
    
    private int schoolYearId;
    
    private int sectorId;
    
    private int levelOfEducationId;
    
    private String regionSql;

    private String divisionSql;

    private String schoolNameSql;
    
    private int regionOfficeType;
    
    private int divisionOfficeType;
    
    private String sectorPublicSql;
    
    private String sectorPrivateSql;
    
    private String generalCurricularOfferingElem;
    
    private String generalCurricularOfferingSeco;
    
    public String getGeneralCurricularOfferingElem() {
		return generalCurricularOfferingElem;
	}

	public void setGeneralCurricularOfferingElem(
			String generalCurricularOfferingElem) {
		this.generalCurricularOfferingElem = generalCurricularOfferingElem;
	}

	public String getGeneralCurricularOfferingSeco() {
		return generalCurricularOfferingSeco;
	}

	public void setGeneralCurricularOfferingSeco(
			String generalCurricularOfferingSeco) {
		this.generalCurricularOfferingSeco = generalCurricularOfferingSeco;
	}

	public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getSchoolNameId() {
        return schoolNameId;
    }

    public void setSchoolNameId(int schoolNameId) {
        this.schoolNameId = schoolNameId;
    }

    public String getRegionSql() {
        return regionSql;
    }

    public void setRegionSql(String regionSql) {
        this.regionSql = regionSql;
    }

    public String getDivisionSql() {
        return divisionSql;
    }

    public void setDivisionSql(String divisionSql) {
        this.divisionSql = divisionSql;
    }

    public String getSchoolNameSql() {
        return schoolNameSql;
    }

    public void setSchoolNameSql(String schoolNameSql) {
        this.schoolNameSql = schoolNameSql;
    }

    public int getRegionOfficeType() {
        return regionOfficeType;
    }

    public void setRegionOfficeType(int regionOfficeType) {
        this.regionOfficeType = regionOfficeType;
    }

    public int getDivisionOfficeType() {
        return divisionOfficeType;
    }

    public void setDivisionOfficeType(int divisionOfficeType) {
        this.divisionOfficeType = divisionOfficeType;
    }

    public int getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(int schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public int getLevelOfEducationId() {
        return levelOfEducationId;
    }

    public void setLevelOfEducationId(int levelOfEducationId) {
        this.levelOfEducationId = levelOfEducationId;
    }

	public String getSectorPublicSql() {
		return sectorPublicSql;
	}

	public void setSectorPublicSql(String sectorPublicSql) {
		this.sectorPublicSql = sectorPublicSql;
	}

	public String getSectorPrivateSql() {
		return sectorPrivateSql;
	}

	public void setSectorPrivateSql(String sectorPrivateSql) {
		this.sectorPrivateSql = sectorPrivateSql;
	}
    
    
}
