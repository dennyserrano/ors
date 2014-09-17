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
@Table(name = "level", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Level.findAll", query = "SELECT l FROM Level l")})
public class Level implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "level_name", length = 255)
    private String levelName;
    @OneToMany(mappedBy = "levelId")
    private List<SchoolLevel> schoolLevelList;
    @OneToMany(mappedBy = "levelId")
    private List<EnrollmentAffiliation> enrollmentAffiliationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelId")
    private List<LearningOutcomes> learningOutcomesList;

    public Level() {
    }

    public Level(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @XmlTransient
    public List<SchoolLevel> getSchoolLevelList() {
        return schoolLevelList;
    }

    public void setSchoolLevelList(List<SchoolLevel> schoolLevelList) {
        this.schoolLevelList = schoolLevelList;
    }

    @XmlTransient
    public List<EnrollmentAffiliation> getEnrollmentAffiliationList() {
        return enrollmentAffiliationList;
    }

    public void setEnrollmentAffiliationList(List<EnrollmentAffiliation> enrollmentAffiliationList) {
        this.enrollmentAffiliationList = enrollmentAffiliationList;
    }

    @XmlTransient
    public List<LearningOutcomes> getLearningOutcomesList() {
        return learningOutcomesList;
    }

    public void setLearningOutcomesList(List<LearningOutcomes> learningOutcomesList) {
        this.learningOutcomesList = learningOutcomesList;
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
        if (!(object instanceof Level)) {
            return false;
        }
        Level other = (Level) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.Level[ id=" + id + " ]";
    }
    
}
