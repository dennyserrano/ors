/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "sbm_indicator", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SbmIndicator.findAll", query = "SELECT s FROM SbmIndicator s")})
public class SbmIndicator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String level;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String description;
    @Basic(optional = false)
    @Column(nullable = false)
    private int totalitems;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    private Short rank;
    @JoinColumn(name = "sbm_dimension_id", referencedColumnName = "id")
    @ManyToOne
    private SbmDimension sbmDimensionId;
    @JoinColumn(name = "sbm_assessment_id", referencedColumnName = "id")
    @ManyToOne
    private SbmAssessment sbmAssessmentId;
    @OneToMany(mappedBy = "sbmIndicatorId")
    private List<SbmMov> sbmMovList;

    public SbmIndicator() {
    }

    public SbmIndicator(Integer id) {
        this.id = id;
    }

    public SbmIndicator(Integer id, String level, String description, int totalitems) {
        this.id = id;
        this.level = level;
        this.description = description;
        this.totalitems = totalitems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(int totalitems) {
        this.totalitems = totalitems;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public SbmDimension getSbmDimensionId() {
        return sbmDimensionId;
    }

    public void setSbmDimensionId(SbmDimension sbmDimensionId) {
        this.sbmDimensionId = sbmDimensionId;
    }

    public SbmAssessment getSbmAssessmentId() {
        return sbmAssessmentId;
    }

    public void setSbmAssessmentId(SbmAssessment sbmAssessmentId) {
        this.sbmAssessmentId = sbmAssessmentId;
    }

    @XmlTransient
    public List<SbmMov> getSbmMovList() {
        return sbmMovList;
    }

    public void setSbmMovList(List<SbmMov> sbmMovList) {
        this.sbmMovList = sbmMovList;
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
        if (!(object instanceof SbmIndicator)) {
            return false;
        }
        SbmIndicator other = (SbmIndicator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.SbmIndicator[ id=" + id + " ]";
    }
    
}
