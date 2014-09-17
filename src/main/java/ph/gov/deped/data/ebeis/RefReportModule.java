/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_report_module", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefReportModule.findAll", query = "SELECT r FROM RefReportModule r")})
public class RefReportModule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "report_name", nullable = false, length = 255)
    private String reportName;
    @Basic(optional = false)
    @Column(name = "is_hidden", nullable = false)
    private short isHidden;
    @Column(name = "ref_reports_generics_id")
    private Short refReportsGenericsId;
    @Column(name = "report_category_id")
    private Integer reportCategoryId;
    @Column(length = 255)
    private String filename;
    @Basic(optional = false)
    @Column(nullable = false, length = 16)
    private String type;
    @Column(length = 250)
    private String extra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportId")
    private List<RefReportModuleJasper> refReportModuleJasperList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportId")
    private List<RefReportModuleFs> refReportModuleFsList;

    public RefReportModule() {
    }

    public RefReportModule(Integer id) {
        this.id = id;
    }

    public RefReportModule(Integer id, String reportName, short isHidden, String type) {
        this.id = id;
        this.reportName = reportName;
        this.isHidden = isHidden;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public short getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(short isHidden) {
        this.isHidden = isHidden;
    }

    public Short getRefReportsGenericsId() {
        return refReportsGenericsId;
    }

    public void setRefReportsGenericsId(Short refReportsGenericsId) {
        this.refReportsGenericsId = refReportsGenericsId;
    }

    public Integer getReportCategoryId() {
        return reportCategoryId;
    }

    public void setReportCategoryId(Integer reportCategoryId) {
        this.reportCategoryId = reportCategoryId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @XmlTransient
    public List<RefReportModuleJasper> getRefReportModuleJasperList() {
        return refReportModuleJasperList;
    }

    public void setRefReportModuleJasperList(List<RefReportModuleJasper> refReportModuleJasperList) {
        this.refReportModuleJasperList = refReportModuleJasperList;
    }

    @XmlTransient
    public List<RefReportModuleFs> getRefReportModuleFsList() {
        return refReportModuleFsList;
    }

    public void setRefReportModuleFsList(List<RefReportModuleFs> refReportModuleFsList) {
        this.refReportModuleFsList = refReportModuleFsList;
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
        if (!(object instanceof RefReportModule)) {
            return false;
        }
        RefReportModule other = (RefReportModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefReportModule[ id=" + id + " ]";
    }
    
}
