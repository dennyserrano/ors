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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_income_class", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefIncomeClass.findAll", query = "SELECT r FROM RefIncomeClass r")})
public class RefIncomeClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Basic(optional = false)
    @Column(name = "class_group_id", nullable = false)
    private short classGroupId;
    @Basic(optional = false)
    @Column(nullable = false)
    private short rank;
    @Column(name = "income_code", length = 10)
    private String incomeCode;
    @Column(length = 100)
    private String description;
    @Basic(optional = false)
    @Column(name = "created_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;
    @Column(name = "created_by")
    private Short createdBy;
    @Basic(optional = false)
    @Column(name = "udpated_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date udpatedDt;
    @Column(name = "updated_by")
    private Short updatedBy;

    public RefIncomeClass() {
    }

    public RefIncomeClass(Short id) {
        this.id = id;
    }

    public RefIncomeClass(Short id, short classGroupId, short rank, Date createdDt, Date udpatedDt) {
        this.id = id;
        this.classGroupId = classGroupId;
        this.rank = rank;
        this.createdDt = createdDt;
        this.udpatedDt = udpatedDt;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getClassGroupId() {
        return classGroupId;
    }

    public void setClassGroupId(short classGroupId) {
        this.classGroupId = classGroupId;
    }

    public short getRank() {
        return rank;
    }

    public void setRank(short rank) {
        this.rank = rank;
    }

    public String getIncomeCode() {
        return incomeCode;
    }

    public void setIncomeCode(String incomeCode) {
        this.incomeCode = incomeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public Short getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Short createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUdpatedDt() {
        return udpatedDt;
    }

    public void setUdpatedDt(Date udpatedDt) {
        this.udpatedDt = udpatedDt;
    }

    public Short getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Short updatedBy) {
        this.updatedBy = updatedBy;
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
        if (!(object instanceof RefIncomeClass)) {
            return false;
        }
        RefIncomeClass other = (RefIncomeClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefIncomeClass[ id=" + id + " ]";
    }
    
}
