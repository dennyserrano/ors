/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_office_history", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ref_office_id", "sy_from"}),
    @UniqueConstraint(columnNames = {"sy_from", "office_type", "office_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefOfficeHistory.findAll", query = "SELECT r FROM RefOfficeHistory r")})
public class RefOfficeHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ref_office_id", nullable = false)
    private int refOfficeId;
    @Basic(optional = false)
    @Column(name = "office_type", nullable = false)
    private short officeType;
    @Basic(optional = false)
    @Column(name = "office_name", nullable = false, length = 100)
    private String officeName;
    @Basic(optional = false)
    @Column(name = "office_location_cd", nullable = false)
    private int officeLocationCd;
    @Basic(optional = false)
    @Column(name = "office_adress", nullable = false, length = 255)
    private String officeAdress;
    @Column(name = "office_previous_name", length = 255)
    private String officePreviousName;
    @Column(name = "parent_office")
    private Integer parentOffice;
    @Column(name = "contact_person")
    private Integer contactPerson;
    @Column(name = "contact_person_position")
    private Integer contactPersonPosition;
    @Column(length = 60)
    private String telno;
    @Column(length = 60)
    private String faxno;
    @Column(length = 100)
    private String website;
    @Column(name = "office_description", length = 255)
    private String officeDescription;
    @Column(name = "office_code", length = 9)
    private String officeCode;
    @Column(name = "ref_region_id")
    private Short refRegionId;
    @Column(name = "office_head_name", length = 100)
    private String officeHeadName;
    @Column(name = "office_head_position", length = 100)
    private String officeHeadPosition;
    @Column(name = "office_head_assistant", length = 100)
    private String officeHeadAssistant;
    @Column(name = "office_head_assistant_position", length = 100)
    private String officeHeadAssistantPosition;
    @Column(name = "orig_ofc_cd", length = 20)
    private String origOfcCd;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "date_closed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateClosed;
    @Column(name = "ebeis_point_person", length = 100)
    private String ebeisPointPerson;
    @Column(name = "ebeis_point_person_email_add", length = 100)
    private String ebeisPointPersonEmailAdd;
    @Column(name = "ebeis_point_person_contact_no", length = 100)
    private String ebeisPointPersonContactNo;
    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;
    @Basic(optional = false)
    @Column(name = "sy_to", nullable = false)
    private short syTo;
    @Column(name = "bosy_start_encoding_date")
    @Temporal(TemporalType.DATE)
    private Date bosyStartEncodingDate;
    @Column(name = "eosy_start_encoding_date")
    @Temporal(TemporalType.DATE)
    private Date eosyStartEncodingDate;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "bosy_school_deadline")
    @Temporal(TemporalType.DATE)
    private Date bosySchoolDeadline;
    @Column(name = "eosy_school_deadline")
    @Temporal(TemporalType.DATE)
    private Date eosySchoolDeadline;
    @Column(name = "interim_office_id")
    private Integer interimOfficeId;

    public RefOfficeHistory() {
    }

    public RefOfficeHistory(Integer id) {
        this.id = id;
    }

    public RefOfficeHistory(Integer id, int refOfficeId, short officeType, String officeName, int officeLocationCd, String officeAdress, short syFrom, short syTo, int createdBy, Date createdAt) {
        this.id = id;
        this.refOfficeId = refOfficeId;
        this.officeType = officeType;
        this.officeName = officeName;
        this.officeLocationCd = officeLocationCd;
        this.officeAdress = officeAdress;
        this.syFrom = syFrom;
        this.syTo = syTo;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRefOfficeId() {
        return refOfficeId;
    }

    public void setRefOfficeId(int refOfficeId) {
        this.refOfficeId = refOfficeId;
    }

    public short getOfficeType() {
        return officeType;
    }

    public void setOfficeType(short officeType) {
        this.officeType = officeType;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getOfficeLocationCd() {
        return officeLocationCd;
    }

    public void setOfficeLocationCd(int officeLocationCd) {
        this.officeLocationCd = officeLocationCd;
    }

    public String getOfficeAdress() {
        return officeAdress;
    }

    public void setOfficeAdress(String officeAdress) {
        this.officeAdress = officeAdress;
    }

    public String getOfficePreviousName() {
        return officePreviousName;
    }

    public void setOfficePreviousName(String officePreviousName) {
        this.officePreviousName = officePreviousName;
    }

    public Integer getParentOffice() {
        return parentOffice;
    }

    public void setParentOffice(Integer parentOffice) {
        this.parentOffice = parentOffice;
    }

    public Integer getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Integer contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Integer getContactPersonPosition() {
        return contactPersonPosition;
    }

    public void setContactPersonPosition(Integer contactPersonPosition) {
        this.contactPersonPosition = contactPersonPosition;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String faxno) {
        this.faxno = faxno;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOfficeDescription() {
        return officeDescription;
    }

    public void setOfficeDescription(String officeDescription) {
        this.officeDescription = officeDescription;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Short getRefRegionId() {
        return refRegionId;
    }

    public void setRefRegionId(Short refRegionId) {
        this.refRegionId = refRegionId;
    }

    public String getOfficeHeadName() {
        return officeHeadName;
    }

    public void setOfficeHeadName(String officeHeadName) {
        this.officeHeadName = officeHeadName;
    }

    public String getOfficeHeadPosition() {
        return officeHeadPosition;
    }

    public void setOfficeHeadPosition(String officeHeadPosition) {
        this.officeHeadPosition = officeHeadPosition;
    }

    public String getOfficeHeadAssistant() {
        return officeHeadAssistant;
    }

    public void setOfficeHeadAssistant(String officeHeadAssistant) {
        this.officeHeadAssistant = officeHeadAssistant;
    }

    public String getOfficeHeadAssistantPosition() {
        return officeHeadAssistantPosition;
    }

    public void setOfficeHeadAssistantPosition(String officeHeadAssistantPosition) {
        this.officeHeadAssistantPosition = officeHeadAssistantPosition;
    }

    public String getOrigOfcCd() {
        return origOfcCd;
    }

    public void setOrigOfcCd(String origOfcCd) {
        this.origOfcCd = origOfcCd;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getEbeisPointPerson() {
        return ebeisPointPerson;
    }

    public void setEbeisPointPerson(String ebeisPointPerson) {
        this.ebeisPointPerson = ebeisPointPerson;
    }

    public String getEbeisPointPersonEmailAdd() {
        return ebeisPointPersonEmailAdd;
    }

    public void setEbeisPointPersonEmailAdd(String ebeisPointPersonEmailAdd) {
        this.ebeisPointPersonEmailAdd = ebeisPointPersonEmailAdd;
    }

    public String getEbeisPointPersonContactNo() {
        return ebeisPointPersonContactNo;
    }

    public void setEbeisPointPersonContactNo(String ebeisPointPersonContactNo) {
        this.ebeisPointPersonContactNo = ebeisPointPersonContactNo;
    }

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public short getSyTo() {
        return syTo;
    }

    public void setSyTo(short syTo) {
        this.syTo = syTo;
    }

    public Date getBosyStartEncodingDate() {
        return bosyStartEncodingDate;
    }

    public void setBosyStartEncodingDate(Date bosyStartEncodingDate) {
        this.bosyStartEncodingDate = bosyStartEncodingDate;
    }

    public Date getEosyStartEncodingDate() {
        return eosyStartEncodingDate;
    }

    public void setEosyStartEncodingDate(Date eosyStartEncodingDate) {
        this.eosyStartEncodingDate = eosyStartEncodingDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getBosySchoolDeadline() {
        return bosySchoolDeadline;
    }

    public void setBosySchoolDeadline(Date bosySchoolDeadline) {
        this.bosySchoolDeadline = bosySchoolDeadline;
    }

    public Date getEosySchoolDeadline() {
        return eosySchoolDeadline;
    }

    public void setEosySchoolDeadline(Date eosySchoolDeadline) {
        this.eosySchoolDeadline = eosySchoolDeadline;
    }

    public Integer getInterimOfficeId() {
        return interimOfficeId;
    }

    public void setInterimOfficeId(Integer interimOfficeId) {
        this.interimOfficeId = interimOfficeId;
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
        if (!(object instanceof RefOfficeHistory)) {
            return false;
        }
        RefOfficeHistory other = (RefOfficeHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefOfficeHistory[ id=" + id + " ]";
    }
    
}
