/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_report_module_jasper", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefReportModuleJasper.findAll", query = "SELECT r FROM RefReportModuleJasper r")})
public class RefReportModuleJasper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "report_jasper_repository_uri", nullable = false, length = 255)
    private String reportJasperRepositoryUri;
    @Column(name = "aggregate_level", length = 16)
    private String aggregateLevel;
    @Column(name = "filter_level", length = 16)
    private String filterLevel;
    @Column(name = "general_classification")
    private Integer generalClassification;
    @Column(name = "curricular_offering")
    private Integer curricularOffering;
    @Column(name = "curricular_class")
    private Integer curricularClass;
    @Column(name = "multi_year")
    private Short multiYear;
    @Column(name = "sy_from")
    private Integer syFrom;
    @Column(name = "sy_to")
    private Integer syTo;
    @Column(name = "show_school")
    private Short showSchool;
    @Basic(optional = false)
    @Column(nullable = false)
    private int weight;
    @JoinColumn(name = "report_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefReportModule reportId;

    public RefReportModuleJasper() {
    }

    public RefReportModuleJasper(Integer id) {
        this.id = id;
    }

    public RefReportModuleJasper(Integer id, String reportJasperRepositoryUri, int weight) {
        this.id = id;
        this.reportJasperRepositoryUri = reportJasperRepositoryUri;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportJasperRepositoryUri() {
        return reportJasperRepositoryUri;
    }

    public void setReportJasperRepositoryUri(String reportJasperRepositoryUri) {
        this.reportJasperRepositoryUri = reportJasperRepositoryUri;
    }

    public String getAggregateLevel() {
        return aggregateLevel;
    }

    public void setAggregateLevel(String aggregateLevel) {
        this.aggregateLevel = aggregateLevel;
    }

    public String getFilterLevel() {
        return filterLevel;
    }

    public void setFilterLevel(String filterLevel) {
        this.filterLevel = filterLevel;
    }

    public Integer getGeneralClassification() {
        return generalClassification;
    }

    public void setGeneralClassification(Integer generalClassification) {
        this.generalClassification = generalClassification;
    }

    public Integer getCurricularOffering() {
        return curricularOffering;
    }

    public void setCurricularOffering(Integer curricularOffering) {
        this.curricularOffering = curricularOffering;
    }

    public Integer getCurricularClass() {
        return curricularClass;
    }

    public void setCurricularClass(Integer curricularClass) {
        this.curricularClass = curricularClass;
    }

    public Short getMultiYear() {
        return multiYear;
    }

    public void setMultiYear(Short multiYear) {
        this.multiYear = multiYear;
    }

    public Integer getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(Integer syFrom) {
        this.syFrom = syFrom;
    }

    public Integer getSyTo() {
        return syTo;
    }

    public void setSyTo(Integer syTo) {
        this.syTo = syTo;
    }

    public Short getShowSchool() {
        return showSchool;
    }

    public void setShowSchool(Short showSchool) {
        this.showSchool = showSchool;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public RefReportModule getReportId() {
        return reportId;
    }

    public void setReportId(RefReportModule reportId) {
        this.reportId = reportId;
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
        if (!(object instanceof RefReportModuleJasper)) {
            return false;
        }
        RefReportModuleJasper other = (RefReportModuleJasper) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefReportModuleJasper[ id=" + id + " ]";
    }
    
}
