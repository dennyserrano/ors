/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

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
@Table(name = "ref_position", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefPosition.findAll", query = "SELECT r FROM RefPosition r")})
public class RefPosition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Column(name = "position_code", length = 10)
    private String positionCode;
    @Column(length = 60)
    private String title;
    @Column(name = "teaching_position")
    private Short teachingPosition;
    @Column(length = 500)
    private String description;
    private Short rank;
    @Column(name = "group_id")
    private Short groupId;
    @Column(name = "co_gen_class")
    private Short coGenClass;
    @OneToMany(mappedBy = "positionId")
    private List<PersonnelPositionSummary> personnelPositionSummaryList;
    @OneToMany(mappedBy = "positionId")
    private List<SfGuardUserProfile> sfGuardUserProfileList;

    public RefPosition() {
    }

    public RefPosition(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getTeachingPosition() {
        return teachingPosition;
    }

    public void setTeachingPosition(Short teachingPosition) {
        this.teachingPosition = teachingPosition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public Short getGroupId() {
        return groupId;
    }

    public void setGroupId(Short groupId) {
        this.groupId = groupId;
    }

    public Short getCoGenClass() {
        return coGenClass;
    }

    public void setCoGenClass(Short coGenClass) {
        this.coGenClass = coGenClass;
    }

    @XmlTransient
    public List<PersonnelPositionSummary> getPersonnelPositionSummaryList() {
        return personnelPositionSummaryList;
    }

    public void setPersonnelPositionSummaryList(List<PersonnelPositionSummary> personnelPositionSummaryList) {
        this.personnelPositionSummaryList = personnelPositionSummaryList;
    }

    @XmlTransient
    public List<SfGuardUserProfile> getSfGuardUserProfileList() {
        return sfGuardUserProfileList;
    }

    public void setSfGuardUserProfileList(List<SfGuardUserProfile> sfGuardUserProfileList) {
        this.sfGuardUserProfileList = sfGuardUserProfileList;
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
        if (!(object instanceof RefPosition)) {
            return false;
        }
        RefPosition other = (RefPosition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisRefPosition[ id=" + id + " ]";
    }
    
}
