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
@Table(name = "ref_table_datasets", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ref_report_history_id", "table_code", "ref_beis_datasets_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefTableDatasets.findAll", query = "SELECT r FROM RefTableDatasets r")})
public class RefTableDatasets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Column(name = "ref_report_history_id")
    private Integer refReportHistoryId;
    @Basic(optional = false)
    @Column(name = "table_code", nullable = false, length = 3)
    private String tableCode;
    @Column(name = "ref_beis_datasets_id")
    private Short refBeisDatasetsId;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "updated_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDt;

    public RefTableDatasets() {
    }

    public RefTableDatasets(Short id) {
        this.id = id;
    }

    public RefTableDatasets(Short id, String tableCode, Date createdDt) {
        this.id = id;
        this.tableCode = tableCode;
        this.createdDt = createdDt;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Integer getRefReportHistoryId() {
        return refReportHistoryId;
    }

    public void setRefReportHistoryId(Integer refReportHistoryId) {
        this.refReportHistoryId = refReportHistoryId;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public Short getRefBeisDatasetsId() {
        return refBeisDatasetsId;
    }

    public void setRefBeisDatasetsId(Short refBeisDatasetsId) {
        this.refBeisDatasetsId = refBeisDatasetsId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
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
        if (!(object instanceof RefTableDatasets)) {
            return false;
        }
        RefTableDatasets other = (RefTableDatasets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefTableDatasets[ id=" + id + " ]";
    }
    
}
