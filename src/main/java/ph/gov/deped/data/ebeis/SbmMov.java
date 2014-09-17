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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "sbm_mov", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SbmMov.findAll", query = "SELECT s FROM SbmMov s")})
public class SbmMov implements Serializable {
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
    private Short rank;
    @JoinColumn(name = "sbm_indicator_id", referencedColumnName = "id")
    @ManyToOne
    private SbmIndicator sbmIndicatorId;
    @JoinColumn(name = "sbm_assessment_id", referencedColumnName = "id")
    @ManyToOne
    private SbmAssessment sbmAssessmentId;
    @JoinColumn(name = "sbm_dimension_id", referencedColumnName = "id")
    @ManyToOne
    private SbmDimension sbmDimensionId;

    public SbmMov() {
    }

    public SbmMov(Integer id) {
        this.id = id;
    }

    public SbmMov(Integer id, String description) {
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

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public SbmIndicator getSbmIndicatorId() {
        return sbmIndicatorId;
    }

    public void setSbmIndicatorId(SbmIndicator sbmIndicatorId) {
        this.sbmIndicatorId = sbmIndicatorId;
    }

    public SbmAssessment getSbmAssessmentId() {
        return sbmAssessmentId;
    }

    public void setSbmAssessmentId(SbmAssessment sbmAssessmentId) {
        this.sbmAssessmentId = sbmAssessmentId;
    }

    public SbmDimension getSbmDimensionId() {
        return sbmDimensionId;
    }

    public void setSbmDimensionId(SbmDimension sbmDimensionId) {
        this.sbmDimensionId = sbmDimensionId;
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
        if (!(object instanceof SbmMov)) {
            return false;
        }
        SbmMov other = (SbmMov) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.SbmMov[ id=" + id + " ]";
    }
    
}
