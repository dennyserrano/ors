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
@Table(name = "cohort_leaver_details", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cohort_indicator_id", "cohort_leaver_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CohortLeaverDetails.findAll", query = "SELECT c FROM CohortLeaverDetails c")})
public class CohortLeaverDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "cohort_indicator_id")
    private Integer cohortIndicatorId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12)
    private Float g1total;
    @Column(precision = 12)
    private Float g1male;
    @Column(precision = 12)
    private Float g1female;
    @Column(precision = 12)
    private Float g2total;
    @Column(precision = 12)
    private Float g2male;
    @Column(precision = 12)
    private Float g2female;
    @Column(precision = 12)
    private Float g3total;
    @Column(precision = 12)
    private Float g3male;
    @Column(precision = 12)
    private Float g3female;
    @Column(precision = 12)
    private Float g4total;
    @Column(precision = 12)
    private Float g4male;
    @Column(precision = 12)
    private Float g4female;
    @Column(precision = 12)
    private Float g5total;
    @Column(precision = 12)
    private Float g5male;
    @Column(precision = 12)
    private Float g5female;
    @Column(precision = 12)
    private Float g6total;
    @Column(precision = 12)
    private Float g6male;
    @Column(precision = 12)
    private Float g6female;
    @Column(precision = 12)
    private Float p1total;
    @Column(precision = 12)
    private Float p1male;
    @Column(precision = 12)
    private Float p1female;
    @Column(precision = 12)
    private Float p2total;
    @Column(precision = 12)
    private Float p2male;
    @Column(precision = 12)
    private Float p2female;
    @Column(precision = 12)
    private Float p3total;
    @Column(precision = 12)
    private Float p3male;
    @Column(precision = 12)
    private Float p3female;
    @Column(precision = 12)
    private Float p4total;
    @Column(precision = 12)
    private Float p4male;
    @Column(precision = 12)
    private Float p4female;
    @Column(precision = 12)
    private Float p5total;
    @Column(precision = 12)
    private Float p5male;
    @Column(precision = 12)
    private Float p5female;
    @Column(precision = 12)
    private Float p6total;
    @Column(precision = 12)
    private Float p6male;
    @Column(precision = 12)
    private Float p6female;
    @Column(precision = 12)
    private Float t1total;
    @Column(precision = 12)
    private Float t1male;
    @Column(precision = 12)
    private Float t1female;
    @Column(precision = 12)
    private Float t2total;
    @Column(precision = 12)
    private Float t2male;
    @Column(precision = 12)
    private Float t2female;
    @Column(precision = 12)
    private Float t3total;
    @Column(precision = 12)
    private Float t3male;
    @Column(precision = 12)
    private Float t3female;
    @Column(precision = 12)
    private Float t4total;
    @Column(precision = 12)
    private Float t4male;
    @Column(precision = 12)
    private Float t4female;
    @Column(precision = 12)
    private Float t5total;
    @Column(precision = 12)
    private Float t5male;
    @Column(precision = 12)
    private Float t5female;
    @Column(precision = 12)
    private Float t6total;
    @Column(precision = 12)
    private Float t6male;
    @Column(precision = 12)
    private Float t6female;
    private Integer generatedBy;
    @Column(name = "last_generationdt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastGenerationdt;
    @Column(name = "aggregation_level")
    private Integer aggregationLevel;
    @JoinColumn(name = "cohort_leaver_id", referencedColumnName = "id")
    @ManyToOne
    private CohortLeaver cohortLeaverId;

    public CohortLeaverDetails() {
    }

    public CohortLeaverDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCohortIndicatorId() {
        return cohortIndicatorId;
    }

    public void setCohortIndicatorId(Integer cohortIndicatorId) {
        this.cohortIndicatorId = cohortIndicatorId;
    }

    public Float getG1total() {
        return g1total;
    }

    public void setG1total(Float g1total) {
        this.g1total = g1total;
    }

    public Float getG1male() {
        return g1male;
    }

    public void setG1male(Float g1male) {
        this.g1male = g1male;
    }

    public Float getG1female() {
        return g1female;
    }

    public void setG1female(Float g1female) {
        this.g1female = g1female;
    }

    public Float getG2total() {
        return g2total;
    }

    public void setG2total(Float g2total) {
        this.g2total = g2total;
    }

    public Float getG2male() {
        return g2male;
    }

    public void setG2male(Float g2male) {
        this.g2male = g2male;
    }

    public Float getG2female() {
        return g2female;
    }

    public void setG2female(Float g2female) {
        this.g2female = g2female;
    }

    public Float getG3total() {
        return g3total;
    }

    public void setG3total(Float g3total) {
        this.g3total = g3total;
    }

    public Float getG3male() {
        return g3male;
    }

    public void setG3male(Float g3male) {
        this.g3male = g3male;
    }

    public Float getG3female() {
        return g3female;
    }

    public void setG3female(Float g3female) {
        this.g3female = g3female;
    }

    public Float getG4total() {
        return g4total;
    }

    public void setG4total(Float g4total) {
        this.g4total = g4total;
    }

    public Float getG4male() {
        return g4male;
    }

    public void setG4male(Float g4male) {
        this.g4male = g4male;
    }

    public Float getG4female() {
        return g4female;
    }

    public void setG4female(Float g4female) {
        this.g4female = g4female;
    }

    public Float getG5total() {
        return g5total;
    }

    public void setG5total(Float g5total) {
        this.g5total = g5total;
    }

    public Float getG5male() {
        return g5male;
    }

    public void setG5male(Float g5male) {
        this.g5male = g5male;
    }

    public Float getG5female() {
        return g5female;
    }

    public void setG5female(Float g5female) {
        this.g5female = g5female;
    }

    public Float getG6total() {
        return g6total;
    }

    public void setG6total(Float g6total) {
        this.g6total = g6total;
    }

    public Float getG6male() {
        return g6male;
    }

    public void setG6male(Float g6male) {
        this.g6male = g6male;
    }

    public Float getG6female() {
        return g6female;
    }

    public void setG6female(Float g6female) {
        this.g6female = g6female;
    }

    public Float getP1total() {
        return p1total;
    }

    public void setP1total(Float p1total) {
        this.p1total = p1total;
    }

    public Float getP1male() {
        return p1male;
    }

    public void setP1male(Float p1male) {
        this.p1male = p1male;
    }

    public Float getP1female() {
        return p1female;
    }

    public void setP1female(Float p1female) {
        this.p1female = p1female;
    }

    public Float getP2total() {
        return p2total;
    }

    public void setP2total(Float p2total) {
        this.p2total = p2total;
    }

    public Float getP2male() {
        return p2male;
    }

    public void setP2male(Float p2male) {
        this.p2male = p2male;
    }

    public Float getP2female() {
        return p2female;
    }

    public void setP2female(Float p2female) {
        this.p2female = p2female;
    }

    public Float getP3total() {
        return p3total;
    }

    public void setP3total(Float p3total) {
        this.p3total = p3total;
    }

    public Float getP3male() {
        return p3male;
    }

    public void setP3male(Float p3male) {
        this.p3male = p3male;
    }

    public Float getP3female() {
        return p3female;
    }

    public void setP3female(Float p3female) {
        this.p3female = p3female;
    }

    public Float getP4total() {
        return p4total;
    }

    public void setP4total(Float p4total) {
        this.p4total = p4total;
    }

    public Float getP4male() {
        return p4male;
    }

    public void setP4male(Float p4male) {
        this.p4male = p4male;
    }

    public Float getP4female() {
        return p4female;
    }

    public void setP4female(Float p4female) {
        this.p4female = p4female;
    }

    public Float getP5total() {
        return p5total;
    }

    public void setP5total(Float p5total) {
        this.p5total = p5total;
    }

    public Float getP5male() {
        return p5male;
    }

    public void setP5male(Float p5male) {
        this.p5male = p5male;
    }

    public Float getP5female() {
        return p5female;
    }

    public void setP5female(Float p5female) {
        this.p5female = p5female;
    }

    public Float getP6total() {
        return p6total;
    }

    public void setP6total(Float p6total) {
        this.p6total = p6total;
    }

    public Float getP6male() {
        return p6male;
    }

    public void setP6male(Float p6male) {
        this.p6male = p6male;
    }

    public Float getP6female() {
        return p6female;
    }

    public void setP6female(Float p6female) {
        this.p6female = p6female;
    }

    public Float getT1total() {
        return t1total;
    }

    public void setT1total(Float t1total) {
        this.t1total = t1total;
    }

    public Float getT1male() {
        return t1male;
    }

    public void setT1male(Float t1male) {
        this.t1male = t1male;
    }

    public Float getT1female() {
        return t1female;
    }

    public void setT1female(Float t1female) {
        this.t1female = t1female;
    }

    public Float getT2total() {
        return t2total;
    }

    public void setT2total(Float t2total) {
        this.t2total = t2total;
    }

    public Float getT2male() {
        return t2male;
    }

    public void setT2male(Float t2male) {
        this.t2male = t2male;
    }

    public Float getT2female() {
        return t2female;
    }

    public void setT2female(Float t2female) {
        this.t2female = t2female;
    }

    public Float getT3total() {
        return t3total;
    }

    public void setT3total(Float t3total) {
        this.t3total = t3total;
    }

    public Float getT3male() {
        return t3male;
    }

    public void setT3male(Float t3male) {
        this.t3male = t3male;
    }

    public Float getT3female() {
        return t3female;
    }

    public void setT3female(Float t3female) {
        this.t3female = t3female;
    }

    public Float getT4total() {
        return t4total;
    }

    public void setT4total(Float t4total) {
        this.t4total = t4total;
    }

    public Float getT4male() {
        return t4male;
    }

    public void setT4male(Float t4male) {
        this.t4male = t4male;
    }

    public Float getT4female() {
        return t4female;
    }

    public void setT4female(Float t4female) {
        this.t4female = t4female;
    }

    public Float getT5total() {
        return t5total;
    }

    public void setT5total(Float t5total) {
        this.t5total = t5total;
    }

    public Float getT5male() {
        return t5male;
    }

    public void setT5male(Float t5male) {
        this.t5male = t5male;
    }

    public Float getT5female() {
        return t5female;
    }

    public void setT5female(Float t5female) {
        this.t5female = t5female;
    }

    public Float getT6total() {
        return t6total;
    }

    public void setT6total(Float t6total) {
        this.t6total = t6total;
    }

    public Float getT6male() {
        return t6male;
    }

    public void setT6male(Float t6male) {
        this.t6male = t6male;
    }

    public Float getT6female() {
        return t6female;
    }

    public void setT6female(Float t6female) {
        this.t6female = t6female;
    }

    public Integer getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Integer generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Date getLastGenerationdt() {
        return lastGenerationdt;
    }

    public void setLastGenerationdt(Date lastGenerationdt) {
        this.lastGenerationdt = lastGenerationdt;
    }

    public Integer getAggregationLevel() {
        return aggregationLevel;
    }

    public void setAggregationLevel(Integer aggregationLevel) {
        this.aggregationLevel = aggregationLevel;
    }

    public CohortLeaver getCohortLeaverId() {
        return cohortLeaverId;
    }

    public void setCohortLeaverId(CohortLeaver cohortLeaverId) {
        this.cohortLeaverId = cohortLeaverId;
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
        if (!(object instanceof CohortLeaverDetails)) {
            return false;
        }
        CohortLeaverDetails other = (CohortLeaverDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.CohortLeaverDetails[ id=" + id + " ]";
    }
    
}
