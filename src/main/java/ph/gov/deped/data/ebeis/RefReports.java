/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_reports", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ref_report_generics_id", "co_genclass_id", "general_classification_id", "school_subclassification_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefReports.findAll", query = "SELECT r FROM RefReports r")})
public class RefReports implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    private Short rank;
    @Basic(optional = false)
    @Column(name = "report_name", nullable = false, length = 500)
    private String reportName;
    @Column(name = "report_description", length = 1024)
    private String reportDescription;
    @JoinColumn(name = "ref_report_generics_id", referencedColumnName = "id")
    @ManyToOne
    private RefReportGenerics refReportGenericsId;
    @JoinColumn(name = "co_genclass_id", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting coGenclassId;
    @JoinColumn(name = "general_classification_id", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting generalClassificationId;
    @JoinColumn(name = "school_subclassification_id", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting schoolSubclassificationId;

    public RefReports() {
    }

    public RefReports(Short id) {
        this.id = id;
    }

    public RefReports(Short id, String reportName) {
        this.id = id;
        this.reportName = reportName;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public RefReportGenerics getRefReportGenericsId() {
        return refReportGenericsId;
    }

    public void setRefReportGenericsId(RefReportGenerics refReportGenericsId) {
        this.refReportGenericsId = refReportGenericsId;
    }

    public RefCodeSetting getCoGenclassId() {
        return coGenclassId;
    }

    public void setCoGenclassId(RefCodeSetting coGenclassId) {
        this.coGenclassId = coGenclassId;
    }

    public RefCodeSetting getGeneralClassificationId() {
        return generalClassificationId;
    }

    public void setGeneralClassificationId(RefCodeSetting generalClassificationId) {
        this.generalClassificationId = generalClassificationId;
    }

    public RefCodeSetting getSchoolSubclassificationId() {
        return schoolSubclassificationId;
    }

    public void setSchoolSubclassificationId(RefCodeSetting schoolSubclassificationId) {
        this.schoolSubclassificationId = schoolSubclassificationId;
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
        if (!(object instanceof RefReports)) {
            return false;
        }
        RefReports other = (RefReports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefReports[ id=" + id + " ]";
    }
    
}
