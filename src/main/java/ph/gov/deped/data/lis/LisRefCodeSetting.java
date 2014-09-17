/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ref_code_setting", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LisRefCodeSetting.findAll", query = "SELECT r FROM LisRefCodeSetting r")})
public class LisRefCodeSetting implements Serializable {
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
    @OneToMany(mappedBy = "gender")
    private List<LisSfGuardUserProfile> lisSfGuardUserProfileList;
    @OneToMany(mappedBy = "districtLabel")
    private List<LisRefLegislative> lisRefLegislativeList;
    @OneToMany(mappedBy = "curricularSubclassId")
    private List<LisSchool> lisSchoolList;
    @OneToMany(mappedBy = "curricularSubclassId")
    private List<LisSchoolProfileHistory> lisSchoolProfileHistoryList;

    public LisRefCodeSetting() {
    }

    public LisRefCodeSetting(Short id) {
        this.id = id;
    }

    public LisRefCodeSetting(Short id, short memberId, Date timestamp) {
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
    public List<LisSfGuardUserProfile> getLisSfGuardUserProfileList() {
        return lisSfGuardUserProfileList;
    }

    public void setLisSfGuardUserProfileList(List<LisSfGuardUserProfile> lisSfGuardUserProfileList) {
        this.lisSfGuardUserProfileList = lisSfGuardUserProfileList;
    }

    @XmlTransient
    public List<LisRefLegislative> getLisRefLegislativeList() {
        return lisRefLegislativeList;
    }

    public void setLisRefLegislativeList(List<LisRefLegislative> lisRefLegislativeList) {
        this.lisRefLegislativeList = lisRefLegislativeList;
    }

    @XmlTransient
    public List<LisSchool> getLisSchoolList() {
        return lisSchoolList;
    }

    public void setLisSchoolList(List<LisSchool> lisSchoolList) {
        this.lisSchoolList = lisSchoolList;
    }

    @XmlTransient
    public List<LisSchoolProfileHistory> getLisSchoolProfileHistoryList() {
        return lisSchoolProfileHistoryList;
    }

    public void setLisSchoolProfileHistoryList(List<LisSchoolProfileHistory> lisSchoolProfileHistoryList) {
        this.lisSchoolProfileHistoryList = lisSchoolProfileHistoryList;
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
        if (!(object instanceof LisRefCodeSetting)) {
            return false;
        }
        LisRefCodeSetting other = (LisRefCodeSetting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LisRefCodeSetting[ id=" + id + " ]";
    }
    
}
