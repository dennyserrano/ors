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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "school_class_user", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolClassUser.findAll", query = "SELECT s FROM SchoolClassUser s")})
public class SchoolClassUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sf_guard_user_id", nullable = false)
    private int sfGuardUserId;
    @Basic(optional = false)
    @Column(name = "school_class_id", nullable = false)
    private int schoolClassId;
    @Column(name = "school_id")
    private Integer schoolId;

    public SchoolClassUser() {
    }

    public SchoolClassUser(Integer id) {
        this.id = id;
    }

    public SchoolClassUser(Integer id, int sfGuardUserId, int schoolClassId) {
        this.id = id;
        this.sfGuardUserId = sfGuardUserId;
        this.schoolClassId = schoolClassId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSfGuardUserId() {
        return sfGuardUserId;
    }

    public void setSfGuardUserId(int sfGuardUserId) {
        this.sfGuardUserId = sfGuardUserId;
    }

    public int getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(int schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
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
        if (!(object instanceof SchoolClassUser)) {
            return false;
        }
        SchoolClassUser other = (SchoolClassUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.SchoolClassUser[ id=" + id + " ]";
    }
    
}
