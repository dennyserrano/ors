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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "personnel_localfund_summary", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "education_level_id", "fund_source_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonnelLocalfundSummary.findAll", query = "SELECT p FROM PersonnelLocalfundSummary p")})
public class PersonnelLocalfundSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "fund_source_id")
    private Short fundSourceId;
    @Column(name = "quantity_male")
    private Short quantityMale;
    @Column(name = "quantity_female")
    private Short quantityFemale;
    private Short total;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @JoinColumn(name = "education_level_id", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting educationLevelId;
    @JoinColumn(name = "report_history_id", referencedColumnName = "id")
    @ManyToOne
    private ReportHistory reportHistoryId;

    public PersonnelLocalfundSummary() {
    }

    public PersonnelLocalfundSummary(Integer id) {
        this.id = id;
    }

    public PersonnelLocalfundSummary(Integer id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getFundSourceId() {
        return fundSourceId;
    }

    public void setFundSourceId(Short fundSourceId) {
        this.fundSourceId = fundSourceId;
    }

    public Short getQuantityMale() {
        return quantityMale;
    }

    public void setQuantityMale(Short quantityMale) {
        this.quantityMale = quantityMale;
    }

    public Short getQuantityFemale() {
        return quantityFemale;
    }

    public void setQuantityFemale(Short quantityFemale) {
        this.quantityFemale = quantityFemale;
    }

    public Short getTotal() {
        return total;
    }

    public void setTotal(Short total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public RefCodeSetting getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(RefCodeSetting educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    public ReportHistory getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(ReportHistory reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
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
        if (!(object instanceof PersonnelLocalfundSummary)) {
            return false;
        }
        PersonnelLocalfundSummary other = (PersonnelLocalfundSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.PersonnelLocalfundSummary[ id=" + id + " ]";
    }
    
}
