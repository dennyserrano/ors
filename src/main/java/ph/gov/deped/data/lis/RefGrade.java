/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_grade", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefGrade.findAll", query = "SELECT r FROM RefGrade r")})
public class RefGrade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean level;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String grade;
    @Column(name = "ref_code_setting_id")
    private Short refCodeSettingId;

    public RefGrade() {
    }

    public RefGrade(Short id) {
        this.id = id;
    }

    public RefGrade(Short id, boolean level, String grade) {
        this.id = id;
        this.level = level;
        this.grade = grade;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public boolean getLevel() {
        return level;
    }

    public void setLevel(boolean level) {
        this.level = level;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Short getRefCodeSettingId() {
        return refCodeSettingId;
    }

    public void setRefCodeSettingId(Short refCodeSettingId) {
        this.refCodeSettingId = refCodeSettingId;
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
        if (!(object instanceof RefGrade)) {
            return false;
        }
        RefGrade other = (RefGrade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.RefGrade[ id=" + id + " ]";
    }
    
}
