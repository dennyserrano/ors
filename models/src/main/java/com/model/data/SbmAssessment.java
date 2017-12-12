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
import javax.persistence.Lob;
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
@Table(name = "sbm_assessment", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SbmAssessment.findAll", query = "SELECT s FROM SbmAssessment s")})
public class SbmAssessment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String description;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "sbmAssessmentId")
    private List<SbmIndicator> sbmIndicatorList;
    @OneToMany(mappedBy = "sbmAssessmentId")
    private List<SbmDimension> sbmDimensionList;
    @OneToMany(mappedBy = "sbmAssessmentId")
    private List<SbmMov> sbmMovList;

    public SbmAssessment() {
    }

    public SbmAssessment(Integer id) {
        this.id = id;
    }

    public SbmAssessment(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @XmlTransient
    public List<SbmIndicator> getSbmIndicatorList() {
        return sbmIndicatorList;
    }

    public void setSbmIndicatorList(List<SbmIndicator> sbmIndicatorList) {
        this.sbmIndicatorList = sbmIndicatorList;
    }

    @XmlTransient
    public List<SbmDimension> getSbmDimensionList() {
        return sbmDimensionList;
    }

    public void setSbmDimensionList(List<SbmDimension> sbmDimensionList) {
        this.sbmDimensionList = sbmDimensionList;
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
        if (!(object instanceof SbmAssessment)) {
            return false;
        }
        SbmAssessment other = (SbmAssessment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.SbmAssessment[ id=" + id + " ]";
    }
    
}
