/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

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
@Table(catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lrn.findAll", query = "SELECT l FROM Lrn l")})
public class Lrn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "learner_registry_id", nullable = false)
    private int learnerRegistryId;
    @Basic(optional = false)
    @Column(nullable = false)
    private long lrn;
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private int schoolId;
    @Basic(optional = false)
    @Column(nullable = false)
    private short formal;
    private Short sy;
    @Basic(optional = false)
    @Column(nullable = false)
    private short standard;
    @Basic(optional = false)
    @Column(name = "final_lrn", nullable = false)
    private long finalLrn;
    @Basic(optional = false)
    @Column(name = "final_lr_id", nullable = false)
    private int finalLrId;
    @Basic(optional = false)
    @Column(name = "name_error", nullable = false)
    private short nameError;
    @Column(name = "first_name", length = 100)
    private String firstName;
    @Column(name = "last_name", length = 100)
    private String lastName;
    @Column(name = "middle_name", length = 100)
    private String middleName;
    @Column(name = "extension_name", length = 20)
    private String extensionName;
    @Column(name = "created_at")
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

    public Lrn() {
    }

    public Lrn(Integer id) {
        this.id = id;
    }

    public Lrn(Integer id, int learnerRegistryId, long lrn, int schoolId, short formal, short standard, long finalLrn, int finalLrId, short nameError, Date updatedAt) {
        this.id = id;
        this.learnerRegistryId = learnerRegistryId;
        this.lrn = lrn;
        this.schoolId = schoolId;
        this.formal = formal;
        this.standard = standard;
        this.finalLrn = finalLrn;
        this.finalLrId = finalLrId;
        this.nameError = nameError;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLearnerRegistryId() {
        return learnerRegistryId;
    }

    public void setLearnerRegistryId(int learnerRegistryId) {
        this.learnerRegistryId = learnerRegistryId;
    }

    public long getLrn() {
        return lrn;
    }

    public void setLrn(long lrn) {
        this.lrn = lrn;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public short getFormal() {
        return formal;
    }

    public void setFormal(short formal) {
        this.formal = formal;
    }

    public Short getSy() {
        return sy;
    }

    public void setSy(Short sy) {
        this.sy = sy;
    }

    public short getStandard() {
        return standard;
    }

    public void setStandard(short standard) {
        this.standard = standard;
    }

    public long getFinalLrn() {
        return finalLrn;
    }

    public void setFinalLrn(long finalLrn) {
        this.finalLrn = finalLrn;
    }

    public int getFinalLrId() {
        return finalLrId;
    }

    public void setFinalLrId(int finalLrId) {
        this.finalLrId = finalLrId;
    }

    public short getNameError() {
        return nameError;
    }

    public void setNameError(short nameError) {
        this.nameError = nameError;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lrn)) {
            return false;
        }
        Lrn other = (Lrn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.Lrn[ id=" + id + " ]";
    }
    
}
