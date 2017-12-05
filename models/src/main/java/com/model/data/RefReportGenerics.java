/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "ref_report_generics", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefReportGenerics.findAll", query = "SELECT r FROM RefReportGenerics r")})
public class RefReportGenerics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String title;
    @Basic(optional = false)
    @Column(nullable = false, length = 500)
    private String description;
    @OneToMany(mappedBy = "refReportGenericsId")
    private List<RefReports> refReportsList;

    public RefReportGenerics() {
    }

    public RefReportGenerics(Short id) {
        this.id = id;
    }

    public RefReportGenerics(Short id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<RefReports> getRefReportsList() {
        return refReportsList;
    }

    public void setRefReportsList(List<RefReports> refReportsList) {
        this.refReportsList = refReportsList;
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
        if (!(object instanceof RefReportGenerics)) {
            return false;
        }
        RefReportGenerics other = (RefReportGenerics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefReportGenerics[ id=" + id + " ]";
    }
    
}
