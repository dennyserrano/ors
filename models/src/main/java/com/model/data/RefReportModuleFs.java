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
@Table(name = "ref_report_module_fs", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefReportModuleFs.findAll", query = "SELECT r FROM RefReportModuleFs r")})
public class RefReportModuleFs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    @Column(length = 1000)
    private String value;
    @JoinColumn(name = "report_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefReportModule reportId;

    public RefReportModuleFs() {
    }

    public RefReportModuleFs(Integer id) {
        this.id = id;
    }

    public RefReportModuleFs(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        if (!(object instanceof RefReportModuleFs)) {
            return false;
        }
        RefReportModuleFs other = (RefReportModuleFs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefReportModuleFs[ id=" + id + " ]";
    }
    
}
