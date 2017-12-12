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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "learner_age_summary", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"type_id", "sy_from", "school_id", "age_category_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LearnerAgeSummary.findAll", query = "SELECT l FROM LearnerAgeSummary l")})
public class LearnerAgeSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type_id", nullable = false)
    private short typeId;
    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private int schoolId;
    @Basic(optional = false)
    @Column(name = "age_category_id", nullable = false)
    private short ageCategoryId;
    private Integer kmale;
    private Integer kfemale;
    @Column(name = "g1male_ecd")
    private Integer g1maleEcd;
    @Column(name = "g1female_ecd")
    private Integer g1femaleEcd;
    private Integer g1male;
    private Integer g1female;
    private Integer g2male;
    private Integer g2female;
    private Integer g3male;
    private Integer g3female;
    private Integer g4male;
    private Integer g4female;
    private Integer g5male;
    private Integer g5female;
    private Integer g6male;
    private Integer g6female;
    private Integer ngmale;
    private Integer ngfemale;
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

    public LearnerAgeSummary() {
    }

    public LearnerAgeSummary(Integer id) {
        this.id = id;
    }

    public LearnerAgeSummary(Integer id, short typeId, short syFrom, int schoolId, short ageCategoryId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.typeId = typeId;
        this.syFrom = syFrom;
        this.schoolId = schoolId;
        this.ageCategoryId = ageCategoryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getTypeId() {
        return typeId;
    }

    public void setTypeId(short typeId) {
        this.typeId = typeId;
    }

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public short getAgeCategoryId() {
        return ageCategoryId;
    }

    public void setAgeCategoryId(short ageCategoryId) {
        this.ageCategoryId = ageCategoryId;
    }

    public Integer getKmale() {
        return kmale;
    }

    public void setKmale(Integer kmale) {
        this.kmale = kmale;
    }

    public Integer getKfemale() {
        return kfemale;
    }

    public void setKfemale(Integer kfemale) {
        this.kfemale = kfemale;
    }

    public Integer getG1maleEcd() {
        return g1maleEcd;
    }

    public void setG1maleEcd(Integer g1maleEcd) {
        this.g1maleEcd = g1maleEcd;
    }

    public Integer getG1femaleEcd() {
        return g1femaleEcd;
    }

    public void setG1femaleEcd(Integer g1femaleEcd) {
        this.g1femaleEcd = g1femaleEcd;
    }

    public Integer getG1male() {
        return g1male;
    }

    public void setG1male(Integer g1male) {
        this.g1male = g1male;
    }

    public Integer getG1female() {
        return g1female;
    }

    public void setG1female(Integer g1female) {
        this.g1female = g1female;
    }

    public Integer getG2male() {
        return g2male;
    }

    public void setG2male(Integer g2male) {
        this.g2male = g2male;
    }

    public Integer getG2female() {
        return g2female;
    }

    public void setG2female(Integer g2female) {
        this.g2female = g2female;
    }

    public Integer getG3male() {
        return g3male;
    }

    public void setG3male(Integer g3male) {
        this.g3male = g3male;
    }

    public Integer getG3female() {
        return g3female;
    }

    public void setG3female(Integer g3female) {
        this.g3female = g3female;
    }

    public Integer getG4male() {
        return g4male;
    }

    public void setG4male(Integer g4male) {
        this.g4male = g4male;
    }

    public Integer getG4female() {
        return g4female;
    }

    public void setG4female(Integer g4female) {
        this.g4female = g4female;
    }

    public Integer getG5male() {
        return g5male;
    }

    public void setG5male(Integer g5male) {
        this.g5male = g5male;
    }

    public Integer getG5female() {
        return g5female;
    }

    public void setG5female(Integer g5female) {
        this.g5female = g5female;
    }

    public Integer getG6male() {
        return g6male;
    }

    public void setG6male(Integer g6male) {
        this.g6male = g6male;
    }

    public Integer getG6female() {
        return g6female;
    }

    public void setG6female(Integer g6female) {
        this.g6female = g6female;
    }

    public Integer getNgmale() {
        return ngmale;
    }

    public void setNgmale(Integer ngmale) {
        this.ngmale = ngmale;
    }

    public Integer getNgfemale() {
        return ngfemale;
    }

    public void setNgfemale(Integer ngfemale) {
        this.ngfemale = ngfemale;
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
        if (!(object instanceof LearnerAgeSummary)) {
            return false;
        }
        LearnerAgeSummary other = (LearnerAgeSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LearnerAgeSummary[ id=" + id + " ]";
    }
    
}
