/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import ph.gov.deped.data.JpaEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_code_setting", catalog = "orsdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefCodeSetting.findAll", query = "SELECT r FROM RefCodeSetting r")})
public class RefCodeSetting implements Serializable, JpaEntity<Short> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    private Short rank;
    @Column(length = 500)
    private String description;
    @Column(name = "group_code", length = 15)
    private String groupCode;
    @Column(name = "member_code", length = 15)
    private String memberCode;
    @Column(name = "mother_code", length = 15)
    private String motherCode;
    @Column(name = "group_id")
    private Short groupId;
    private Short orggroupid;
    @Basic(optional = false)
    @Column(name = "member_id", nullable = false)
    private short memberId;
    private Short orgmemberid;
    @Column(name = "mother_id")
    private Short motherId;
    private Short tmpid;
    private Short tmpgroupid;
    private Short tmpmemberid;
    private Short orgtmpid;
    @Column(name = "sy_from")
    private Short syFrom;
    @Column(name = "sy_to")
    private Short syTo;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @ManyToMany(mappedBy = "refCodeSettingList")
    private List<LearningOutcomes> learningOutcomesList;
    @OneToMany(mappedBy = "districtLabel")
    private List<RefLegislativeHistory> refLegislativeHistoryList;
    @OneToMany(mappedBy = "districtLabel")
    private List<RefLegislative> refLegislativeList;
    @OneToMany(mappedBy = "categoryId")
    private List<SummerProgramSummary> summerProgramSummaryList;
    @OneToMany(mappedBy = "typeOfUsageId")
    private List<InventoryFundSource> inventoryFundSourceList;
    @OneToMany(mappedBy = "fundSourceId")
    private List<InventoryFundSource> inventoryFundSourceList1;
    @OneToMany(mappedBy = "subjectId")
    private List<LearningOutcomesScoresRegion> learningOutcomesScoresRegionList;
    @OneToMany(mappedBy = "gender")
    private List<SfGuardUserProfile> sfGuardUserProfileList;
    @OneToMany(mappedBy = "subjectId")
    private List<LearningOutcomesScores> learningOutcomesScoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteOwnershipId")
    private List<School> schoolList;
    @OneToMany(mappedBy = "classOrganizationId")
    private List<School> schoolList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proofOfOwnershipId")
    private List<School> schoolList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownershipIssueId")
    private List<School> schoolList3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curricularClassId")
    private List<School> schoolList4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalClassificationId")
    private List<School> schoolList5;
    @OneToMany(mappedBy = "schoolSubclassificationId")
    private List<School> schoolList6;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topographyId")
    private List<School> schoolList7;
    @OneToMany(mappedBy = "curricularSubclassId")
    private List<School> schoolList8;
    @OneToMany(mappedBy = "educationLevelId")
    private List<PersonnelLocalfundSummary> personnelLocalfundSummaryList;
    @OneToMany(mappedBy = "curricularSubclassId")
    private List<SchoolProfileHistory> schoolProfileHistoryList;
    @OneToMany(mappedBy = "coGenclassId")
    private List<RefReports> refReportsList;
    @OneToMany(mappedBy = "generalClassificationId")
    private List<RefReports> refReportsList1;
    @OneToMany(mappedBy = "schoolSubclassificationId")
    private List<RefReports> refReportsList2;
    @OneToMany(mappedBy = "subjectId")
    private List<LearningOutcomesScoresDivision> learningOutcomesScoresDivisionList;

    public RefCodeSetting() {
    }

    public RefCodeSetting(Short id) {
        this.id = id;
    }

    public RefCodeSetting(Short id, short memberId, Date timestamp) {
        this.id = id;
        this.memberId = memberId;
        this.timestamp = timestamp;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMotherCode() {
        return motherCode;
    }

    public void setMotherCode(String motherCode) {
        this.motherCode = motherCode;
    }

    public Short getGroupId() {
        return groupId;
    }

    public void setGroupId(Short groupId) {
        this.groupId = groupId;
    }

    public Short getOrggroupid() {
        return orggroupid;
    }

    public void setOrggroupid(Short orggroupid) {
        this.orggroupid = orggroupid;
    }

    public short getMemberId() {
        return memberId;
    }

    public void setMemberId(short memberId) {
        this.memberId = memberId;
    }

    public Short getOrgmemberid() {
        return orgmemberid;
    }

    public void setOrgmemberid(Short orgmemberid) {
        this.orgmemberid = orgmemberid;
    }

    public Short getMotherId() {
        return motherId;
    }

    public void setMotherId(Short motherId) {
        this.motherId = motherId;
    }

    public Short getTmpid() {
        return tmpid;
    }

    public void setTmpid(Short tmpid) {
        this.tmpid = tmpid;
    }

    public Short getTmpgroupid() {
        return tmpgroupid;
    }

    public void setTmpgroupid(Short tmpgroupid) {
        this.tmpgroupid = tmpgroupid;
    }

    public Short getTmpmemberid() {
        return tmpmemberid;
    }

    public void setTmpmemberid(Short tmpmemberid) {
        this.tmpmemberid = tmpmemberid;
    }

    public Short getOrgtmpid() {
        return orgtmpid;
    }

    public void setOrgtmpid(Short orgtmpid) {
        this.orgtmpid = orgtmpid;
    }

    public Short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(Short syFrom) {
        this.syFrom = syFrom;
    }

    public Short getSyTo() {
        return syTo;
    }

    public void setSyTo(Short syTo) {
        this.syTo = syTo;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @XmlTransient
    public List<LearningOutcomes> getLearningOutcomesList() {
        return learningOutcomesList;
    }

    public void setLearningOutcomesList(List<LearningOutcomes> learningOutcomesList) {
        this.learningOutcomesList = learningOutcomesList;
    }

    @XmlTransient
    public List<RefLegislativeHistory> getRefLegislativeHistoryList() {
        return refLegislativeHistoryList;
    }

    public void setRefLegislativeHistoryList(List<RefLegislativeHistory> refLegislativeHistoryList) {
        this.refLegislativeHistoryList = refLegislativeHistoryList;
    }

    @XmlTransient
    public List<RefLegislative> getRefLegislativeList() {
        return refLegislativeList;
    }

    public void setRefLegislativeList(List<RefLegislative> refLegislativeList) {
        this.refLegislativeList = refLegislativeList;
    }

    @XmlTransient
    public List<SummerProgramSummary> getSummerProgramSummaryList() {
        return summerProgramSummaryList;
    }

    public void setSummerProgramSummaryList(List<SummerProgramSummary> summerProgramSummaryList) {
        this.summerProgramSummaryList = summerProgramSummaryList;
    }

    @XmlTransient
    public List<InventoryFundSource> getInventoryFundSourceList() {
        return inventoryFundSourceList;
    }

    public void setInventoryFundSourceList(List<InventoryFundSource> inventoryFundSourceList) {
        this.inventoryFundSourceList = inventoryFundSourceList;
    }

    @XmlTransient
    public List<InventoryFundSource> getInventoryFundSourceList1() {
        return inventoryFundSourceList1;
    }

    public void setInventoryFundSourceList1(List<InventoryFundSource> inventoryFundSourceList1) {
        this.inventoryFundSourceList1 = inventoryFundSourceList1;
    }

    @XmlTransient
    public List<LearningOutcomesScoresRegion> getLearningOutcomesScoresRegionList() {
        return learningOutcomesScoresRegionList;
    }

    public void setLearningOutcomesScoresRegionList(List<LearningOutcomesScoresRegion> learningOutcomesScoresRegionList) {
        this.learningOutcomesScoresRegionList = learningOutcomesScoresRegionList;
    }

    @XmlTransient
    public List<SfGuardUserProfile> getSfGuardUserProfileList() {
        return sfGuardUserProfileList;
    }

    public void setSfGuardUserProfileList(List<SfGuardUserProfile> sfGuardUserProfileList) {
        this.sfGuardUserProfileList = sfGuardUserProfileList;
    }

    @XmlTransient
    public List<LearningOutcomesScores> getLearningOutcomesScoresList() {
        return learningOutcomesScoresList;
    }

    public void setLearningOutcomesScoresList(List<LearningOutcomesScores> learningOutcomesScoresList) {
        this.learningOutcomesScoresList = learningOutcomesScoresList;
    }

    @XmlTransient
    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    @XmlTransient
    public List<School> getSchoolList1() {
        return schoolList1;
    }

    public void setSchoolList1(List<School> schoolList1) {
        this.schoolList1 = schoolList1;
    }

    @XmlTransient
    public List<School> getSchoolList2() {
        return schoolList2;
    }

    public void setSchoolList2(List<School> schoolList2) {
        this.schoolList2 = schoolList2;
    }

    @XmlTransient
    public List<School> getSchoolList3() {
        return schoolList3;
    }

    public void setSchoolList3(List<School> schoolList3) {
        this.schoolList3 = schoolList3;
    }

    @XmlTransient
    public List<School> getSchoolList4() {
        return schoolList4;
    }

    public void setSchoolList4(List<School> schoolList4) {
        this.schoolList4 = schoolList4;
    }

    @XmlTransient
    public List<School> getSchoolList5() {
        return schoolList5;
    }

    public void setSchoolList5(List<School> schoolList5) {
        this.schoolList5 = schoolList5;
    }

    @XmlTransient
    public List<School> getSchoolList6() {
        return schoolList6;
    }

    public void setSchoolList6(List<School> schoolList6) {
        this.schoolList6 = schoolList6;
    }

    @XmlTransient
    public List<School> getSchoolList7() {
        return schoolList7;
    }

    public void setSchoolList7(List<School> schoolList7) {
        this.schoolList7 = schoolList7;
    }

    @XmlTransient
    public List<School> getSchoolList8() {
        return schoolList8;
    }

    public void setSchoolList8(List<School> schoolList8) {
        this.schoolList8 = schoolList8;
    }

    @XmlTransient
    public List<PersonnelLocalfundSummary> getPersonnelLocalfundSummaryList() {
        return personnelLocalfundSummaryList;
    }

    public void setPersonnelLocalfundSummaryList(List<PersonnelLocalfundSummary> personnelLocalfundSummaryList) {
        this.personnelLocalfundSummaryList = personnelLocalfundSummaryList;
    }

    @XmlTransient
    public List<SchoolProfileHistory> getSchoolProfileHistoryList() {
        return schoolProfileHistoryList;
    }

    public void setSchoolProfileHistoryList(List<SchoolProfileHistory> schoolProfileHistoryList) {
        this.schoolProfileHistoryList = schoolProfileHistoryList;
    }

    @XmlTransient
    public List<RefReports> getRefReportsList() {
        return refReportsList;
    }

    public void setRefReportsList(List<RefReports> refReportsList) {
        this.refReportsList = refReportsList;
    }

    @XmlTransient
    public List<RefReports> getRefReportsList1() {
        return refReportsList1;
    }

    public void setRefReportsList1(List<RefReports> refReportsList1) {
        this.refReportsList1 = refReportsList1;
    }

    @XmlTransient
    public List<RefReports> getRefReportsList2() {
        return refReportsList2;
    }

    public void setRefReportsList2(List<RefReports> refReportsList2) {
        this.refReportsList2 = refReportsList2;
    }

    @XmlTransient
    public List<LearningOutcomesScoresDivision> getLearningOutcomesScoresDivisionList() {
        return learningOutcomesScoresDivisionList;
    }

    public void setLearningOutcomesScoresDivisionList(List<LearningOutcomesScoresDivision> learningOutcomesScoresDivisionList) {
        this.learningOutcomesScoresDivisionList = learningOutcomesScoresDivisionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefCodeSetting)) {
            return false;
        }
        RefCodeSetting other = (RefCodeSetting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisRefCodeSetting[ id=" + id + " ]";
    }
    
}
