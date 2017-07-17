package ph.gov.deped.repo.jpa.ors.ds;

import ph.gov.deped.data.dto.KeyValue;

import java.util.List;

/**
 * Created by PSY on 2014/10/03.
 */
public interface DefaultCriteriaRepository {

    List<KeyValue> getSchoolYears();

    List<KeyValue> getGeneralClassifications();

    List<KeyValue> getGeneralCurricularOfferings();

    List<KeyValue> getSchoolTypes();

    List<KeyValue> getRegionsAndDivisions();

    List<KeyValue> searchSchool(int schoolYear, int levelOfEducation, Integer sectorId, Integer regionId, Integer divisionId, String schoolName);
    
    List<KeyValue> getDistrict();
    
    List<KeyValue> getProvince();
    
    List<KeyValue> getMunicipality();
    
    List<KeyValue> getLegislative();
    
}
