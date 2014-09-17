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
import javax.persistence.ManyToOne;
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
@Table(name = "disaster_calamities", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "discal_item_id", "discal_cat_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisasterCalamities.findAll", query = "SELECT d FROM DisasterCalamities d")})
public class DisasterCalamities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "discal_item_id", nullable = false)
    private short discalItemId;
    @Basic(optional = false)
    @Column(name = "discal_cat_id", nullable = false)
    private short discalCatId;
    @Column(length = 60)
    private String others;
    @Column(name = "dc_jun")
    private Short dcJun;
    @Column(name = "dc_jul")
    private Short dcJul;
    @Column(name = "dc_aug")
    private Short dcAug;
    @Column(name = "dc_sep")
    private Short dcSep;
    @Column(name = "dc_oct")
    private Short dcOct;
    @Column(name = "dc_nov")
    private Short dcNov;
    @Column(name = "dc_dec")
    private Short dcDec;
    @Column(name = "dc_jan")
    private Short dcJan;
    @Column(name = "dc_feb")
    private Short dcFeb;
    @Column(name = "dc_mar")
    private Short dcMar;
    @Column(name = "dc_apr")
    private Short dcApr;
    @Column(name = "dc_may")
    private Short dcMay;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @JoinColumn(name = "report_history_id", referencedColumnName = "id")
    @ManyToOne
    private ReportHistory reportHistoryId;

    public DisasterCalamities() {
    }

    public DisasterCalamities(Integer id) {
        this.id = id;
    }

    public DisasterCalamities(Integer id, short discalItemId, short discalCatId) {
        this.id = id;
        this.discalItemId = discalItemId;
        this.discalCatId = discalCatId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getDiscalItemId() {
        return discalItemId;
    }

    public void setDiscalItemId(short discalItemId) {
        this.discalItemId = discalItemId;
    }

    public short getDiscalCatId() {
        return discalCatId;
    }

    public void setDiscalCatId(short discalCatId) {
        this.discalCatId = discalCatId;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public Short getDcJun() {
        return dcJun;
    }

    public void setDcJun(Short dcJun) {
        this.dcJun = dcJun;
    }

    public Short getDcJul() {
        return dcJul;
    }

    public void setDcJul(Short dcJul) {
        this.dcJul = dcJul;
    }

    public Short getDcAug() {
        return dcAug;
    }

    public void setDcAug(Short dcAug) {
        this.dcAug = dcAug;
    }

    public Short getDcSep() {
        return dcSep;
    }

    public void setDcSep(Short dcSep) {
        this.dcSep = dcSep;
    }

    public Short getDcOct() {
        return dcOct;
    }

    public void setDcOct(Short dcOct) {
        this.dcOct = dcOct;
    }

    public Short getDcNov() {
        return dcNov;
    }

    public void setDcNov(Short dcNov) {
        this.dcNov = dcNov;
    }

    public Short getDcDec() {
        return dcDec;
    }

    public void setDcDec(Short dcDec) {
        this.dcDec = dcDec;
    }

    public Short getDcJan() {
        return dcJan;
    }

    public void setDcJan(Short dcJan) {
        this.dcJan = dcJan;
    }

    public Short getDcFeb() {
        return dcFeb;
    }

    public void setDcFeb(Short dcFeb) {
        this.dcFeb = dcFeb;
    }

    public Short getDcMar() {
        return dcMar;
    }

    public void setDcMar(Short dcMar) {
        this.dcMar = dcMar;
    }

    public Short getDcApr() {
        return dcApr;
    }

    public void setDcApr(Short dcApr) {
        this.dcApr = dcApr;
    }

    public Short getDcMay() {
        return dcMay;
    }

    public void setDcMay(Short dcMay) {
        this.dcMay = dcMay;
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

    public ReportHistory getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(ReportHistory reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
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
        if (!(object instanceof DisasterCalamities)) {
            return false;
        }
        DisasterCalamities other = (DisasterCalamities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.DisasterCalamities[ id=" + id + " ]";
    }
    
}
