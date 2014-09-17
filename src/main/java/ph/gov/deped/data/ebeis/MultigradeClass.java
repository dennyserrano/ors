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
@Table(name = "multigrade_class", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "class_no"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MultigradeClass.findAll", query = "SELECT m FROM MultigradeClass m")})
public class MultigradeClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "report_history_id")
    private Integer reportHistoryId;
    @Basic(optional = false)
    @Column(name = "class_no", nullable = false)
    private short classNo;
    @Basic(optional = false)
    @Column(nullable = false)
    private short kinder;
    @Basic(optional = false)
    @Column(nullable = false)
    private short g1;
    @Basic(optional = false)
    @Column(nullable = false)
    private short g2;
    @Basic(optional = false)
    @Column(nullable = false)
    private short g3;
    @Basic(optional = false)
    @Column(nullable = false)
    private short g4;
    @Basic(optional = false)
    @Column(nullable = false)
    private short g5;
    @Basic(optional = false)
    @Column(nullable = false)
    private short g6;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;

    public MultigradeClass() {
    }

    public MultigradeClass(Integer id) {
        this.id = id;
    }

    public MultigradeClass(Integer id, short classNo, short kinder, short g1, short g2, short g3, short g4, short g5, short g6, Date createdAt, Date updatedAt) {
        this.id = id;
        this.classNo = classNo;
        this.kinder = kinder;
        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.g4 = g4;
        this.g5 = g5;
        this.g6 = g6;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(Integer reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
    }

    public short getClassNo() {
        return classNo;
    }

    public void setClassNo(short classNo) {
        this.classNo = classNo;
    }

    public short getKinder() {
        return kinder;
    }

    public void setKinder(short kinder) {
        this.kinder = kinder;
    }

    public short getG1() {
        return g1;
    }

    public void setG1(short g1) {
        this.g1 = g1;
    }

    public short getG2() {
        return g2;
    }

    public void setG2(short g2) {
        this.g2 = g2;
    }

    public short getG3() {
        return g3;
    }

    public void setG3(short g3) {
        this.g3 = g3;
    }

    public short getG4() {
        return g4;
    }

    public void setG4(short g4) {
        this.g4 = g4;
    }

    public short getG5() {
        return g5;
    }

    public void setG5(short g5) {
        this.g5 = g5;
    }

    public short getG6() {
        return g6;
    }

    public void setG6(short g6) {
        this.g6 = g6;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
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
        if (!(object instanceof MultigradeClass)) {
            return false;
        }
        MultigradeClass other = (MultigradeClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.MultigradeClass[ id=" + id + " ]";
    }
    
}
