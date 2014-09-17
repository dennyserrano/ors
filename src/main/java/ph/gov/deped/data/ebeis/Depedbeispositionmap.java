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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depedbeispositionmap.findAll", query = "SELECT d FROM Depedbeispositionmap d")})
public class Depedbeispositionmap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "teaching_position")
    private Short teachingPosition;
    @Column(name = "depedbeisposition_id")
    private Short depedbeispositionId;
    @Column(name = "ref_position_id")
    private Short refPositionId;

    public Depedbeispositionmap() {
    }

    public Depedbeispositionmap(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getTeachingPosition() {
        return teachingPosition;
    }

    public void setTeachingPosition(Short teachingPosition) {
        this.teachingPosition = teachingPosition;
    }

    public Short getDepedbeispositionId() {
        return depedbeispositionId;
    }

    public void setDepedbeispositionId(Short depedbeispositionId) {
        this.depedbeispositionId = depedbeispositionId;
    }

    public Short getRefPositionId() {
        return refPositionId;
    }

    public void setRefPositionId(Short refPositionId) {
        this.refPositionId = refPositionId;
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
        if (!(object instanceof Depedbeispositionmap)) {
            return false;
        }
        Depedbeispositionmap other = (Depedbeispositionmap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.Depedbeispositionmap[ id=" + id + " ]";
    }
    
}
