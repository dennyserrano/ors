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
@Table(name = "cohort_evolution", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cohort_leaver_id", "school_year"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CohortEvolution.findAll", query = "SELECT c FROM CohortEvolution c")})
public class CohortEvolution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cohort_leaver_id", nullable = false)
    private int cohortLeaverId;
    @Column(name = "school_year")
    private Short schoolYear;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12)
    private Float cohort1;
    @Column(precision = 12)
    private Float promotees1;
    @Column(precision = 12)
    private Float repeaters1;
    @Column(precision = 12)
    private Float cohort2;
    @Column(precision = 12)
    private Float promotees2;
    @Column(precision = 12)
    private Float repeaters2;
    @Column(precision = 12)
    private Float cohort3;
    @Column(precision = 12)
    private Float promotees3;
    @Column(precision = 12)
    private Float repeaters3;
    @Column(precision = 12)
    private Float cohort4;
    @Column(precision = 12)
    private Float promotees4;
    @Column(precision = 12)
    private Float repeaters4;
    @Column(precision = 12)
    private Float cohort5;
    @Column(precision = 12)
    private Float promotees5;
    @Column(precision = 12)
    private Float repeaters5;
    @Column(precision = 12)
    private Float cohort6;
    @Column(precision = 12)
    private Float promotees6;
    @Column(precision = 12)
    private Float repeaters6;
    @Column(precision = 12)
    private Float cohort7;
    @Column(precision = 12)
    private Float promotees7;
    @Column(precision = 12)
    private Float repeaters7;
    @Column(precision = 12)
    private Float cohort8;
    @Column(precision = 12)
    private Float promotees8;
    @Column(precision = 12)
    private Float repeaters8;
    @Column(precision = 12)
    private Float cohort9;
    @Column(precision = 12)
    private Float promotees9;
    @Column(precision = 12)
    private Float repeaters9;
    @Column(precision = 12)
    private Float cohort10;
    @Column(precision = 12)
    private Float promotees10;
    @Column(precision = 12)
    private Float repeaters10;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "created_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;
    @Basic(optional = false)
    @Column(name = "updated_by", nullable = false)
    private int updatedBy;
    @Basic(optional = false)
    @Column(name = "updated_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDt;

    public CohortEvolution() {
    }

    public CohortEvolution(Integer id) {
        this.id = id;
    }

    public CohortEvolution(Integer id, int cohortLeaverId, int createdBy, Date createdDt, int updatedBy, Date updatedDt) {
        this.id = id;
        this.cohortLeaverId = cohortLeaverId;
        this.createdBy = createdBy;
        this.createdDt = createdDt;
        this.updatedBy = updatedBy;
        this.updatedDt = updatedDt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCohortLeaverId() {
        return cohortLeaverId;
    }

    public void setCohortLeaverId(int cohortLeaverId) {
        this.cohortLeaverId = cohortLeaverId;
    }

    public Short getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Short schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Float getCohort1() {
        return cohort1;
    }

    public void setCohort1(Float cohort1) {
        this.cohort1 = cohort1;
    }

    public Float getPromotees1() {
        return promotees1;
    }

    public void setPromotees1(Float promotees1) {
        this.promotees1 = promotees1;
    }

    public Float getRepeaters1() {
        return repeaters1;
    }

    public void setRepeaters1(Float repeaters1) {
        this.repeaters1 = repeaters1;
    }

    public Float getCohort2() {
        return cohort2;
    }

    public void setCohort2(Float cohort2) {
        this.cohort2 = cohort2;
    }

    public Float getPromotees2() {
        return promotees2;
    }

    public void setPromotees2(Float promotees2) {
        this.promotees2 = promotees2;
    }

    public Float getRepeaters2() {
        return repeaters2;
    }

    public void setRepeaters2(Float repeaters2) {
        this.repeaters2 = repeaters2;
    }

    public Float getCohort3() {
        return cohort3;
    }

    public void setCohort3(Float cohort3) {
        this.cohort3 = cohort3;
    }

    public Float getPromotees3() {
        return promotees3;
    }

    public void setPromotees3(Float promotees3) {
        this.promotees3 = promotees3;
    }

    public Float getRepeaters3() {
        return repeaters3;
    }

    public void setRepeaters3(Float repeaters3) {
        this.repeaters3 = repeaters3;
    }

    public Float getCohort4() {
        return cohort4;
    }

    public void setCohort4(Float cohort4) {
        this.cohort4 = cohort4;
    }

    public Float getPromotees4() {
        return promotees4;
    }

    public void setPromotees4(Float promotees4) {
        this.promotees4 = promotees4;
    }

    public Float getRepeaters4() {
        return repeaters4;
    }

    public void setRepeaters4(Float repeaters4) {
        this.repeaters4 = repeaters4;
    }

    public Float getCohort5() {
        return cohort5;
    }

    public void setCohort5(Float cohort5) {
        this.cohort5 = cohort5;
    }

    public Float getPromotees5() {
        return promotees5;
    }

    public void setPromotees5(Float promotees5) {
        this.promotees5 = promotees5;
    }

    public Float getRepeaters5() {
        return repeaters5;
    }

    public void setRepeaters5(Float repeaters5) {
        this.repeaters5 = repeaters5;
    }

    public Float getCohort6() {
        return cohort6;
    }

    public void setCohort6(Float cohort6) {
        this.cohort6 = cohort6;
    }

    public Float getPromotees6() {
        return promotees6;
    }

    public void setPromotees6(Float promotees6) {
        this.promotees6 = promotees6;
    }

    public Float getRepeaters6() {
        return repeaters6;
    }

    public void setRepeaters6(Float repeaters6) {
        this.repeaters6 = repeaters6;
    }

    public Float getCohort7() {
        return cohort7;
    }

    public void setCohort7(Float cohort7) {
        this.cohort7 = cohort7;
    }

    public Float getPromotees7() {
        return promotees7;
    }

    public void setPromotees7(Float promotees7) {
        this.promotees7 = promotees7;
    }

    public Float getRepeaters7() {
        return repeaters7;
    }

    public void setRepeaters7(Float repeaters7) {
        this.repeaters7 = repeaters7;
    }

    public Float getCohort8() {
        return cohort8;
    }

    public void setCohort8(Float cohort8) {
        this.cohort8 = cohort8;
    }

    public Float getPromotees8() {
        return promotees8;
    }

    public void setPromotees8(Float promotees8) {
        this.promotees8 = promotees8;
    }

    public Float getRepeaters8() {
        return repeaters8;
    }

    public void setRepeaters8(Float repeaters8) {
        this.repeaters8 = repeaters8;
    }

    public Float getCohort9() {
        return cohort9;
    }

    public void setCohort9(Float cohort9) {
        this.cohort9 = cohort9;
    }

    public Float getPromotees9() {
        return promotees9;
    }

    public void setPromotees9(Float promotees9) {
        this.promotees9 = promotees9;
    }

    public Float getRepeaters9() {
        return repeaters9;
    }

    public void setRepeaters9(Float repeaters9) {
        this.repeaters9 = repeaters9;
    }

    public Float getCohort10() {
        return cohort10;
    }

    public void setCohort10(Float cohort10) {
        this.cohort10 = cohort10;
    }

    public Float getPromotees10() {
        return promotees10;
    }

    public void setPromotees10(Float promotees10) {
        this.promotees10 = promotees10;
    }

    public Float getRepeaters10() {
        return repeaters10;
    }

    public void setRepeaters10(Float repeaters10) {
        this.repeaters10 = repeaters10;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
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
        if (!(object instanceof CohortEvolution)) {
            return false;
        }
        CohortEvolution other = (CohortEvolution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.CohortEvolution[ id=" + id + " ]";
    }
    
}
