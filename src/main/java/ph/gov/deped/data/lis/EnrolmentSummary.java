/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

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
@Table(name = "enrolment_summary", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"type_id", "sy_from", "school_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnrolmentSummary.findAll", query = "SELECT e FROM EnrolmentSummary e")})
public class EnrolmentSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type_id", nullable = false)
    private short typeId;
    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private int schoolId;
    @Column(name = "kmale_mono")
    private Integer kmaleMono;
    @Column(name = "kfemale_mono")
    private Integer kfemaleMono;
    @Column(name = "g1male_mono")
    private Integer g1maleMono;
    @Column(name = "g1female_mono")
    private Integer g1femaleMono;
    @Column(name = "g2male_mono")
    private Integer g2maleMono;
    @Column(name = "g2female_mono")
    private Integer g2femaleMono;
    @Column(name = "g3male_mono")
    private Integer g3maleMono;
    @Column(name = "g3female_mono")
    private Integer g3femaleMono;
    @Column(name = "g4male_mono")
    private Integer g4maleMono;
    @Column(name = "g4female_mono")
    private Integer g4femaleMono;
    @Column(name = "g5male_mono")
    private Integer g5maleMono;
    @Column(name = "g5female_mono")
    private Integer g5femaleMono;
    @Column(name = "g6male_mono")
    private Integer g6maleMono;
    @Column(name = "g6female_mono")
    private Integer g6femaleMono;
    @Column(name = "ngmale_mono")
    private Integer ngmaleMono;
    @Column(name = "ngfemale_mono")
    private Integer ngfemaleMono;
    @Column(name = "kmale_multi")
    private Integer kmaleMulti;
    @Column(name = "kfemale_multi")
    private Integer kfemaleMulti;
    @Column(name = "g1male_multi")
    private Integer g1maleMulti;
    @Column(name = "g1female_multi")
    private Integer g1femaleMulti;
    @Column(name = "g2male_multi")
    private Integer g2maleMulti;
    @Column(name = "g2female_multi")
    private Integer g2femaleMulti;
    @Column(name = "g3male_multi")
    private Integer g3maleMulti;
    @Column(name = "g3female_multi")
    private Integer g3femaleMulti;
    @Column(name = "g4male_multi")
    private Integer g4maleMulti;
    @Column(name = "g4female_multi")
    private Integer g4femaleMulti;
    @Column(name = "g5male_multi")
    private Integer g5maleMulti;
    @Column(name = "g5female_multi")
    private Integer g5femaleMulti;
    @Column(name = "g6male_multi")
    private Integer g6maleMulti;
    @Column(name = "g6female_multi")
    private Integer g6femaleMulti;
    @Column(name = "ngmale_multi")
    private Integer ngmaleMulti;
    @Column(name = "ngfemale_multi")
    private Integer ngfemaleMulti;
    @Column(name = "kmale_rep")
    private Integer kmaleRep;
    @Column(name = "kfemale_rep")
    private Integer kfemaleRep;
    @Column(name = "g1male_rep")
    private Integer g1maleRep;
    @Column(name = "g1female_rep")
    private Integer g1femaleRep;
    @Column(name = "g2male_rep")
    private Integer g2maleRep;
    @Column(name = "g2female_rep")
    private Integer g2femaleRep;
    @Column(name = "g3male_rep")
    private Integer g3maleRep;
    @Column(name = "g3female_rep")
    private Integer g3femaleRep;
    @Column(name = "g4male_rep")
    private Integer g4maleRep;
    @Column(name = "g4female_rep")
    private Integer g4femaleRep;
    @Column(name = "g5male_rep")
    private Integer g5maleRep;
    @Column(name = "g5female_rep")
    private Integer g5femaleRep;
    @Column(name = "g6male_rep")
    private Integer g6maleRep;
    @Column(name = "g6female_rep")
    private Integer g6femaleRep;
    @Column(name = "ngmale_rep")
    private Integer ngmaleRep;
    @Column(name = "ngfemale_rep")
    private Integer ngfemaleRep;
    @Column(name = "kmale_ba")
    private Integer kmaleBa;
    @Column(name = "kfemale_ba")
    private Integer kfemaleBa;
    @Column(name = "g1male_ba")
    private Integer g1maleBa;
    @Column(name = "g1female_ba")
    private Integer g1femaleBa;
    @Column(name = "g2male_ba")
    private Integer g2maleBa;
    @Column(name = "g2female_ba")
    private Integer g2femaleBa;
    @Column(name = "g3male_ba")
    private Integer g3maleBa;
    @Column(name = "g3female_ba")
    private Integer g3femaleBa;
    @Column(name = "g4male_ba")
    private Integer g4maleBa;
    @Column(name = "g4female_ba")
    private Integer g4femaleBa;
    @Column(name = "g5male_ba")
    private Integer g5maleBa;
    @Column(name = "g5female_ba")
    private Integer g5femaleBa;
    @Column(name = "g6male_ba")
    private Integer g6maleBa;
    @Column(name = "g6female_ba")
    private Integer g6femaleBa;
    @Column(name = "ngmale_ba")
    private Integer ngmaleBa;
    @Column(name = "ngfemale_ba")
    private Integer ngfemaleBa;
    @Column(name = "kmale_alive")
    private Integer kmaleAlive;
    @Column(name = "kfemale_alive")
    private Integer kfemaleAlive;
    @Column(name = "g1male_alive")
    private Integer g1maleAlive;
    @Column(name = "g1female_alive")
    private Integer g1femaleAlive;
    @Column(name = "g2male_alive")
    private Integer g2maleAlive;
    @Column(name = "g2female_alive")
    private Integer g2femaleAlive;
    @Column(name = "g3male_alive")
    private Integer g3maleAlive;
    @Column(name = "g3female_alive")
    private Integer g3femaleAlive;
    @Column(name = "g4male_alive")
    private Integer g4maleAlive;
    @Column(name = "g4female_alive")
    private Integer g4femaleAlive;
    @Column(name = "g5male_alive")
    private Integer g5maleAlive;
    @Column(name = "g5female_alive")
    private Integer g5femaleAlive;
    @Column(name = "g6male_alive")
    private Integer g6maleAlive;
    @Column(name = "g6female_alive")
    private Integer g6femaleAlive;
    @Column(name = "ngmale_alive")
    private Integer ngmaleAlive;
    @Column(name = "ngfemale_alive")
    private Integer ngfemaleAlive;
    @Column(name = "kmale_cct")
    private Integer kmaleCct;
    @Column(name = "kfemale_cct")
    private Integer kfemaleCct;
    @Column(name = "g1male_cct")
    private Integer g1maleCct;
    @Column(name = "g1female_cct")
    private Integer g1femaleCct;
    @Column(name = "g2male_cct")
    private Integer g2maleCct;
    @Column(name = "g2female_cct")
    private Integer g2femaleCct;
    @Column(name = "g3male_cct")
    private Integer g3maleCct;
    @Column(name = "g3female_cct")
    private Integer g3femaleCct;
    @Column(name = "g4male_cct")
    private Integer g4maleCct;
    @Column(name = "g4female_cct")
    private Integer g4femaleCct;
    @Column(name = "g5male_cct")
    private Integer g5maleCct;
    @Column(name = "g5female_cct")
    private Integer g5femaleCct;
    @Column(name = "g6male_cct")
    private Integer g6maleCct;
    @Column(name = "g6female_cct")
    private Integer g6femaleCct;
    @Column(name = "ngmale_cct")
    private Integer ngmaleCct;
    @Column(name = "ngfemale_cct")
    private Integer ngfemaleCct;
    @Column(name = "kmale_muslim")
    private Integer kmaleMuslim;
    @Column(name = "kfemale_muslim")
    private Integer kfemaleMuslim;
    @Column(name = "g1male_muslim")
    private Integer g1maleMuslim;
    @Column(name = "g1female_muslim")
    private Integer g1femaleMuslim;
    @Column(name = "g2male_muslim")
    private Integer g2maleMuslim;
    @Column(name = "g2female_muslim")
    private Integer g2femaleMuslim;
    @Column(name = "g3male_muslim")
    private Integer g3maleMuslim;
    @Column(name = "g3female_muslim")
    private Integer g3femaleMuslim;
    @Column(name = "g4male_muslim")
    private Integer g4maleMuslim;
    @Column(name = "g4female_muslim")
    private Integer g4femaleMuslim;
    @Column(name = "g5male_muslim")
    private Integer g5maleMuslim;
    @Column(name = "g5female_muslim")
    private Integer g5femaleMuslim;
    @Column(name = "g6male_muslim")
    private Integer g6maleMuslim;
    @Column(name = "g6female_muslim")
    private Integer g6femaleMuslim;
    @Column(name = "ngmale_muslim")
    private Integer ngmaleMuslim;
    @Column(name = "ngfemale_muslim")
    private Integer ngfemaleMuslim;
    @Column(name = "kmale_ip")
    private Integer kmaleIp;
    @Column(name = "kfemale_ip")
    private Integer kfemaleIp;
    @Column(name = "g1male_ip")
    private Integer g1maleIp;
    @Column(name = "g1female_ip")
    private Integer g1femaleIp;
    @Column(name = "g2male_ip")
    private Integer g2maleIp;
    @Column(name = "g2female_ip")
    private Integer g2femaleIp;
    @Column(name = "g3male_ip")
    private Integer g3maleIp;
    @Column(name = "g3female_ip")
    private Integer g3femaleIp;
    @Column(name = "g4male_ip")
    private Integer g4maleIp;
    @Column(name = "g4female_ip")
    private Integer g4femaleIp;
    @Column(name = "g5male_ip")
    private Integer g5maleIp;
    @Column(name = "g5female_ip")
    private Integer g5femaleIp;
    @Column(name = "g6male_ip")
    private Integer g6maleIp;
    @Column(name = "g6female_ip")
    private Integer g6femaleIp;
    @Column(name = "ngmale_ip")
    private Integer ngmaleIp;
    @Column(name = "ngfemale_ip")
    private Integer ngfemaleIp;
    @Column(name = "kmono_class")
    private Short kmonoClass;
    @Column(name = "g1mono_class")
    private Short g1monoClass;
    @Column(name = "g2mono_class")
    private Short g2monoClass;
    @Column(name = "g3mono_class")
    private Short g3monoClass;
    @Column(name = "g4mono_class")
    private Short g4monoClass;
    @Column(name = "g5mono_class")
    private Short g5monoClass;
    @Column(name = "g6mono_class")
    private Short g6monoClass;
    @Column(name = "ngmono_class")
    private Short ngmonoClass;
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

    public EnrolmentSummary() {
    }

    public EnrolmentSummary(Integer id) {
        this.id = id;
    }

    public EnrolmentSummary(Integer id, short typeId, short syFrom, int schoolId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.typeId = typeId;
        this.syFrom = syFrom;
        this.schoolId = schoolId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getTypeId() {
        return typeId;
    }

    public void setTypeId(short typeId) {
        this.typeId = typeId;
    }

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getKmaleMono() {
        return kmaleMono;
    }

    public void setKmaleMono(Integer kmaleMono) {
        this.kmaleMono = kmaleMono;
    }

    public Integer getKfemaleMono() {
        return kfemaleMono;
    }

    public void setKfemaleMono(Integer kfemaleMono) {
        this.kfemaleMono = kfemaleMono;
    }

    public Integer getG1maleMono() {
        return g1maleMono;
    }

    public void setG1maleMono(Integer g1maleMono) {
        this.g1maleMono = g1maleMono;
    }

    public Integer getG1femaleMono() {
        return g1femaleMono;
    }

    public void setG1femaleMono(Integer g1femaleMono) {
        this.g1femaleMono = g1femaleMono;
    }

    public Integer getG2maleMono() {
        return g2maleMono;
    }

    public void setG2maleMono(Integer g2maleMono) {
        this.g2maleMono = g2maleMono;
    }

    public Integer getG2femaleMono() {
        return g2femaleMono;
    }

    public void setG2femaleMono(Integer g2femaleMono) {
        this.g2femaleMono = g2femaleMono;
    }

    public Integer getG3maleMono() {
        return g3maleMono;
    }

    public void setG3maleMono(Integer g3maleMono) {
        this.g3maleMono = g3maleMono;
    }

    public Integer getG3femaleMono() {
        return g3femaleMono;
    }

    public void setG3femaleMono(Integer g3femaleMono) {
        this.g3femaleMono = g3femaleMono;
    }

    public Integer getG4maleMono() {
        return g4maleMono;
    }

    public void setG4maleMono(Integer g4maleMono) {
        this.g4maleMono = g4maleMono;
    }

    public Integer getG4femaleMono() {
        return g4femaleMono;
    }

    public void setG4femaleMono(Integer g4femaleMono) {
        this.g4femaleMono = g4femaleMono;
    }

    public Integer getG5maleMono() {
        return g5maleMono;
    }

    public void setG5maleMono(Integer g5maleMono) {
        this.g5maleMono = g5maleMono;
    }

    public Integer getG5femaleMono() {
        return g5femaleMono;
    }

    public void setG5femaleMono(Integer g5femaleMono) {
        this.g5femaleMono = g5femaleMono;
    }

    public Integer getG6maleMono() {
        return g6maleMono;
    }

    public void setG6maleMono(Integer g6maleMono) {
        this.g6maleMono = g6maleMono;
    }

    public Integer getG6femaleMono() {
        return g6femaleMono;
    }

    public void setG6femaleMono(Integer g6femaleMono) {
        this.g6femaleMono = g6femaleMono;
    }

    public Integer getNgmaleMono() {
        return ngmaleMono;
    }

    public void setNgmaleMono(Integer ngmaleMono) {
        this.ngmaleMono = ngmaleMono;
    }

    public Integer getNgfemaleMono() {
        return ngfemaleMono;
    }

    public void setNgfemaleMono(Integer ngfemaleMono) {
        this.ngfemaleMono = ngfemaleMono;
    }

    public Integer getKmaleMulti() {
        return kmaleMulti;
    }

    public void setKmaleMulti(Integer kmaleMulti) {
        this.kmaleMulti = kmaleMulti;
    }

    public Integer getKfemaleMulti() {
        return kfemaleMulti;
    }

    public void setKfemaleMulti(Integer kfemaleMulti) {
        this.kfemaleMulti = kfemaleMulti;
    }

    public Integer getG1maleMulti() {
        return g1maleMulti;
    }

    public void setG1maleMulti(Integer g1maleMulti) {
        this.g1maleMulti = g1maleMulti;
    }

    public Integer getG1femaleMulti() {
        return g1femaleMulti;
    }

    public void setG1femaleMulti(Integer g1femaleMulti) {
        this.g1femaleMulti = g1femaleMulti;
    }

    public Integer getG2maleMulti() {
        return g2maleMulti;
    }

    public void setG2maleMulti(Integer g2maleMulti) {
        this.g2maleMulti = g2maleMulti;
    }

    public Integer getG2femaleMulti() {
        return g2femaleMulti;
    }

    public void setG2femaleMulti(Integer g2femaleMulti) {
        this.g2femaleMulti = g2femaleMulti;
    }

    public Integer getG3maleMulti() {
        return g3maleMulti;
    }

    public void setG3maleMulti(Integer g3maleMulti) {
        this.g3maleMulti = g3maleMulti;
    }

    public Integer getG3femaleMulti() {
        return g3femaleMulti;
    }

    public void setG3femaleMulti(Integer g3femaleMulti) {
        this.g3femaleMulti = g3femaleMulti;
    }

    public Integer getG4maleMulti() {
        return g4maleMulti;
    }

    public void setG4maleMulti(Integer g4maleMulti) {
        this.g4maleMulti = g4maleMulti;
    }

    public Integer getG4femaleMulti() {
        return g4femaleMulti;
    }

    public void setG4femaleMulti(Integer g4femaleMulti) {
        this.g4femaleMulti = g4femaleMulti;
    }

    public Integer getG5maleMulti() {
        return g5maleMulti;
    }

    public void setG5maleMulti(Integer g5maleMulti) {
        this.g5maleMulti = g5maleMulti;
    }

    public Integer getG5femaleMulti() {
        return g5femaleMulti;
    }

    public void setG5femaleMulti(Integer g5femaleMulti) {
        this.g5femaleMulti = g5femaleMulti;
    }

    public Integer getG6maleMulti() {
        return g6maleMulti;
    }

    public void setG6maleMulti(Integer g6maleMulti) {
        this.g6maleMulti = g6maleMulti;
    }

    public Integer getG6femaleMulti() {
        return g6femaleMulti;
    }

    public void setG6femaleMulti(Integer g6femaleMulti) {
        this.g6femaleMulti = g6femaleMulti;
    }

    public Integer getNgmaleMulti() {
        return ngmaleMulti;
    }

    public void setNgmaleMulti(Integer ngmaleMulti) {
        this.ngmaleMulti = ngmaleMulti;
    }

    public Integer getNgfemaleMulti() {
        return ngfemaleMulti;
    }

    public void setNgfemaleMulti(Integer ngfemaleMulti) {
        this.ngfemaleMulti = ngfemaleMulti;
    }

    public Integer getKmaleRep() {
        return kmaleRep;
    }

    public void setKmaleRep(Integer kmaleRep) {
        this.kmaleRep = kmaleRep;
    }

    public Integer getKfemaleRep() {
        return kfemaleRep;
    }

    public void setKfemaleRep(Integer kfemaleRep) {
        this.kfemaleRep = kfemaleRep;
    }

    public Integer getG1maleRep() {
        return g1maleRep;
    }

    public void setG1maleRep(Integer g1maleRep) {
        this.g1maleRep = g1maleRep;
    }

    public Integer getG1femaleRep() {
        return g1femaleRep;
    }

    public void setG1femaleRep(Integer g1femaleRep) {
        this.g1femaleRep = g1femaleRep;
    }

    public Integer getG2maleRep() {
        return g2maleRep;
    }

    public void setG2maleRep(Integer g2maleRep) {
        this.g2maleRep = g2maleRep;
    }

    public Integer getG2femaleRep() {
        return g2femaleRep;
    }

    public void setG2femaleRep(Integer g2femaleRep) {
        this.g2femaleRep = g2femaleRep;
    }

    public Integer getG3maleRep() {
        return g3maleRep;
    }

    public void setG3maleRep(Integer g3maleRep) {
        this.g3maleRep = g3maleRep;
    }

    public Integer getG3femaleRep() {
        return g3femaleRep;
    }

    public void setG3femaleRep(Integer g3femaleRep) {
        this.g3femaleRep = g3femaleRep;
    }

    public Integer getG4maleRep() {
        return g4maleRep;
    }

    public void setG4maleRep(Integer g4maleRep) {
        this.g4maleRep = g4maleRep;
    }

    public Integer getG4femaleRep() {
        return g4femaleRep;
    }

    public void setG4femaleRep(Integer g4femaleRep) {
        this.g4femaleRep = g4femaleRep;
    }

    public Integer getG5maleRep() {
        return g5maleRep;
    }

    public void setG5maleRep(Integer g5maleRep) {
        this.g5maleRep = g5maleRep;
    }

    public Integer getG5femaleRep() {
        return g5femaleRep;
    }

    public void setG5femaleRep(Integer g5femaleRep) {
        this.g5femaleRep = g5femaleRep;
    }

    public Integer getG6maleRep() {
        return g6maleRep;
    }

    public void setG6maleRep(Integer g6maleRep) {
        this.g6maleRep = g6maleRep;
    }

    public Integer getG6femaleRep() {
        return g6femaleRep;
    }

    public void setG6femaleRep(Integer g6femaleRep) {
        this.g6femaleRep = g6femaleRep;
    }

    public Integer getNgmaleRep() {
        return ngmaleRep;
    }

    public void setNgmaleRep(Integer ngmaleRep) {
        this.ngmaleRep = ngmaleRep;
    }

    public Integer getNgfemaleRep() {
        return ngfemaleRep;
    }

    public void setNgfemaleRep(Integer ngfemaleRep) {
        this.ngfemaleRep = ngfemaleRep;
    }

    public Integer getKmaleBa() {
        return kmaleBa;
    }

    public void setKmaleBa(Integer kmaleBa) {
        this.kmaleBa = kmaleBa;
    }

    public Integer getKfemaleBa() {
        return kfemaleBa;
    }

    public void setKfemaleBa(Integer kfemaleBa) {
        this.kfemaleBa = kfemaleBa;
    }

    public Integer getG1maleBa() {
        return g1maleBa;
    }

    public void setG1maleBa(Integer g1maleBa) {
        this.g1maleBa = g1maleBa;
    }

    public Integer getG1femaleBa() {
        return g1femaleBa;
    }

    public void setG1femaleBa(Integer g1femaleBa) {
        this.g1femaleBa = g1femaleBa;
    }

    public Integer getG2maleBa() {
        return g2maleBa;
    }

    public void setG2maleBa(Integer g2maleBa) {
        this.g2maleBa = g2maleBa;
    }

    public Integer getG2femaleBa() {
        return g2femaleBa;
    }

    public void setG2femaleBa(Integer g2femaleBa) {
        this.g2femaleBa = g2femaleBa;
    }

    public Integer getG3maleBa() {
        return g3maleBa;
    }

    public void setG3maleBa(Integer g3maleBa) {
        this.g3maleBa = g3maleBa;
    }

    public Integer getG3femaleBa() {
        return g3femaleBa;
    }

    public void setG3femaleBa(Integer g3femaleBa) {
        this.g3femaleBa = g3femaleBa;
    }

    public Integer getG4maleBa() {
        return g4maleBa;
    }

    public void setG4maleBa(Integer g4maleBa) {
        this.g4maleBa = g4maleBa;
    }

    public Integer getG4femaleBa() {
        return g4femaleBa;
    }

    public void setG4femaleBa(Integer g4femaleBa) {
        this.g4femaleBa = g4femaleBa;
    }

    public Integer getG5maleBa() {
        return g5maleBa;
    }

    public void setG5maleBa(Integer g5maleBa) {
        this.g5maleBa = g5maleBa;
    }

    public Integer getG5femaleBa() {
        return g5femaleBa;
    }

    public void setG5femaleBa(Integer g5femaleBa) {
        this.g5femaleBa = g5femaleBa;
    }

    public Integer getG6maleBa() {
        return g6maleBa;
    }

    public void setG6maleBa(Integer g6maleBa) {
        this.g6maleBa = g6maleBa;
    }

    public Integer getG6femaleBa() {
        return g6femaleBa;
    }

    public void setG6femaleBa(Integer g6femaleBa) {
        this.g6femaleBa = g6femaleBa;
    }

    public Integer getNgmaleBa() {
        return ngmaleBa;
    }

    public void setNgmaleBa(Integer ngmaleBa) {
        this.ngmaleBa = ngmaleBa;
    }

    public Integer getNgfemaleBa() {
        return ngfemaleBa;
    }

    public void setNgfemaleBa(Integer ngfemaleBa) {
        this.ngfemaleBa = ngfemaleBa;
    }

    public Integer getKmaleAlive() {
        return kmaleAlive;
    }

    public void setKmaleAlive(Integer kmaleAlive) {
        this.kmaleAlive = kmaleAlive;
    }

    public Integer getKfemaleAlive() {
        return kfemaleAlive;
    }

    public void setKfemaleAlive(Integer kfemaleAlive) {
        this.kfemaleAlive = kfemaleAlive;
    }

    public Integer getG1maleAlive() {
        return g1maleAlive;
    }

    public void setG1maleAlive(Integer g1maleAlive) {
        this.g1maleAlive = g1maleAlive;
    }

    public Integer getG1femaleAlive() {
        return g1femaleAlive;
    }

    public void setG1femaleAlive(Integer g1femaleAlive) {
        this.g1femaleAlive = g1femaleAlive;
    }

    public Integer getG2maleAlive() {
        return g2maleAlive;
    }

    public void setG2maleAlive(Integer g2maleAlive) {
        this.g2maleAlive = g2maleAlive;
    }

    public Integer getG2femaleAlive() {
        return g2femaleAlive;
    }

    public void setG2femaleAlive(Integer g2femaleAlive) {
        this.g2femaleAlive = g2femaleAlive;
    }

    public Integer getG3maleAlive() {
        return g3maleAlive;
    }

    public void setG3maleAlive(Integer g3maleAlive) {
        this.g3maleAlive = g3maleAlive;
    }

    public Integer getG3femaleAlive() {
        return g3femaleAlive;
    }

    public void setG3femaleAlive(Integer g3femaleAlive) {
        this.g3femaleAlive = g3femaleAlive;
    }

    public Integer getG4maleAlive() {
        return g4maleAlive;
    }

    public void setG4maleAlive(Integer g4maleAlive) {
        this.g4maleAlive = g4maleAlive;
    }

    public Integer getG4femaleAlive() {
        return g4femaleAlive;
    }

    public void setG4femaleAlive(Integer g4femaleAlive) {
        this.g4femaleAlive = g4femaleAlive;
    }

    public Integer getG5maleAlive() {
        return g5maleAlive;
    }

    public void setG5maleAlive(Integer g5maleAlive) {
        this.g5maleAlive = g5maleAlive;
    }

    public Integer getG5femaleAlive() {
        return g5femaleAlive;
    }

    public void setG5femaleAlive(Integer g5femaleAlive) {
        this.g5femaleAlive = g5femaleAlive;
    }

    public Integer getG6maleAlive() {
        return g6maleAlive;
    }

    public void setG6maleAlive(Integer g6maleAlive) {
        this.g6maleAlive = g6maleAlive;
    }

    public Integer getG6femaleAlive() {
        return g6femaleAlive;
    }

    public void setG6femaleAlive(Integer g6femaleAlive) {
        this.g6femaleAlive = g6femaleAlive;
    }

    public Integer getNgmaleAlive() {
        return ngmaleAlive;
    }

    public void setNgmaleAlive(Integer ngmaleAlive) {
        this.ngmaleAlive = ngmaleAlive;
    }

    public Integer getNgfemaleAlive() {
        return ngfemaleAlive;
    }

    public void setNgfemaleAlive(Integer ngfemaleAlive) {
        this.ngfemaleAlive = ngfemaleAlive;
    }

    public Integer getKmaleCct() {
        return kmaleCct;
    }

    public void setKmaleCct(Integer kmaleCct) {
        this.kmaleCct = kmaleCct;
    }

    public Integer getKfemaleCct() {
        return kfemaleCct;
    }

    public void setKfemaleCct(Integer kfemaleCct) {
        this.kfemaleCct = kfemaleCct;
    }

    public Integer getG1maleCct() {
        return g1maleCct;
    }

    public void setG1maleCct(Integer g1maleCct) {
        this.g1maleCct = g1maleCct;
    }

    public Integer getG1femaleCct() {
        return g1femaleCct;
    }

    public void setG1femaleCct(Integer g1femaleCct) {
        this.g1femaleCct = g1femaleCct;
    }

    public Integer getG2maleCct() {
        return g2maleCct;
    }

    public void setG2maleCct(Integer g2maleCct) {
        this.g2maleCct = g2maleCct;
    }

    public Integer getG2femaleCct() {
        return g2femaleCct;
    }

    public void setG2femaleCct(Integer g2femaleCct) {
        this.g2femaleCct = g2femaleCct;
    }

    public Integer getG3maleCct() {
        return g3maleCct;
    }

    public void setG3maleCct(Integer g3maleCct) {
        this.g3maleCct = g3maleCct;
    }

    public Integer getG3femaleCct() {
        return g3femaleCct;
    }

    public void setG3femaleCct(Integer g3femaleCct) {
        this.g3femaleCct = g3femaleCct;
    }

    public Integer getG4maleCct() {
        return g4maleCct;
    }

    public void setG4maleCct(Integer g4maleCct) {
        this.g4maleCct = g4maleCct;
    }

    public Integer getG4femaleCct() {
        return g4femaleCct;
    }

    public void setG4femaleCct(Integer g4femaleCct) {
        this.g4femaleCct = g4femaleCct;
    }

    public Integer getG5maleCct() {
        return g5maleCct;
    }

    public void setG5maleCct(Integer g5maleCct) {
        this.g5maleCct = g5maleCct;
    }

    public Integer getG5femaleCct() {
        return g5femaleCct;
    }

    public void setG5femaleCct(Integer g5femaleCct) {
        this.g5femaleCct = g5femaleCct;
    }

    public Integer getG6maleCct() {
        return g6maleCct;
    }

    public void setG6maleCct(Integer g6maleCct) {
        this.g6maleCct = g6maleCct;
    }

    public Integer getG6femaleCct() {
        return g6femaleCct;
    }

    public void setG6femaleCct(Integer g6femaleCct) {
        this.g6femaleCct = g6femaleCct;
    }

    public Integer getNgmaleCct() {
        return ngmaleCct;
    }

    public void setNgmaleCct(Integer ngmaleCct) {
        this.ngmaleCct = ngmaleCct;
    }

    public Integer getNgfemaleCct() {
        return ngfemaleCct;
    }

    public void setNgfemaleCct(Integer ngfemaleCct) {
        this.ngfemaleCct = ngfemaleCct;
    }

    public Integer getKmaleMuslim() {
        return kmaleMuslim;
    }

    public void setKmaleMuslim(Integer kmaleMuslim) {
        this.kmaleMuslim = kmaleMuslim;
    }

    public Integer getKfemaleMuslim() {
        return kfemaleMuslim;
    }

    public void setKfemaleMuslim(Integer kfemaleMuslim) {
        this.kfemaleMuslim = kfemaleMuslim;
    }

    public Integer getG1maleMuslim() {
        return g1maleMuslim;
    }

    public void setG1maleMuslim(Integer g1maleMuslim) {
        this.g1maleMuslim = g1maleMuslim;
    }

    public Integer getG1femaleMuslim() {
        return g1femaleMuslim;
    }

    public void setG1femaleMuslim(Integer g1femaleMuslim) {
        this.g1femaleMuslim = g1femaleMuslim;
    }

    public Integer getG2maleMuslim() {
        return g2maleMuslim;
    }

    public void setG2maleMuslim(Integer g2maleMuslim) {
        this.g2maleMuslim = g2maleMuslim;
    }

    public Integer getG2femaleMuslim() {
        return g2femaleMuslim;
    }

    public void setG2femaleMuslim(Integer g2femaleMuslim) {
        this.g2femaleMuslim = g2femaleMuslim;
    }

    public Integer getG3maleMuslim() {
        return g3maleMuslim;
    }

    public void setG3maleMuslim(Integer g3maleMuslim) {
        this.g3maleMuslim = g3maleMuslim;
    }

    public Integer getG3femaleMuslim() {
        return g3femaleMuslim;
    }

    public void setG3femaleMuslim(Integer g3femaleMuslim) {
        this.g3femaleMuslim = g3femaleMuslim;
    }

    public Integer getG4maleMuslim() {
        return g4maleMuslim;
    }

    public void setG4maleMuslim(Integer g4maleMuslim) {
        this.g4maleMuslim = g4maleMuslim;
    }

    public Integer getG4femaleMuslim() {
        return g4femaleMuslim;
    }

    public void setG4femaleMuslim(Integer g4femaleMuslim) {
        this.g4femaleMuslim = g4femaleMuslim;
    }

    public Integer getG5maleMuslim() {
        return g5maleMuslim;
    }

    public void setG5maleMuslim(Integer g5maleMuslim) {
        this.g5maleMuslim = g5maleMuslim;
    }

    public Integer getG5femaleMuslim() {
        return g5femaleMuslim;
    }

    public void setG5femaleMuslim(Integer g5femaleMuslim) {
        this.g5femaleMuslim = g5femaleMuslim;
    }

    public Integer getG6maleMuslim() {
        return g6maleMuslim;
    }

    public void setG6maleMuslim(Integer g6maleMuslim) {
        this.g6maleMuslim = g6maleMuslim;
    }

    public Integer getG6femaleMuslim() {
        return g6femaleMuslim;
    }

    public void setG6femaleMuslim(Integer g6femaleMuslim) {
        this.g6femaleMuslim = g6femaleMuslim;
    }

    public Integer getNgmaleMuslim() {
        return ngmaleMuslim;
    }

    public void setNgmaleMuslim(Integer ngmaleMuslim) {
        this.ngmaleMuslim = ngmaleMuslim;
    }

    public Integer getNgfemaleMuslim() {
        return ngfemaleMuslim;
    }

    public void setNgfemaleMuslim(Integer ngfemaleMuslim) {
        this.ngfemaleMuslim = ngfemaleMuslim;
    }

    public Integer getKmaleIp() {
        return kmaleIp;
    }

    public void setKmaleIp(Integer kmaleIp) {
        this.kmaleIp = kmaleIp;
    }

    public Integer getKfemaleIp() {
        return kfemaleIp;
    }

    public void setKfemaleIp(Integer kfemaleIp) {
        this.kfemaleIp = kfemaleIp;
    }

    public Integer getG1maleIp() {
        return g1maleIp;
    }

    public void setG1maleIp(Integer g1maleIp) {
        this.g1maleIp = g1maleIp;
    }

    public Integer getG1femaleIp() {
        return g1femaleIp;
    }

    public void setG1femaleIp(Integer g1femaleIp) {
        this.g1femaleIp = g1femaleIp;
    }

    public Integer getG2maleIp() {
        return g2maleIp;
    }

    public void setG2maleIp(Integer g2maleIp) {
        this.g2maleIp = g2maleIp;
    }

    public Integer getG2femaleIp() {
        return g2femaleIp;
    }

    public void setG2femaleIp(Integer g2femaleIp) {
        this.g2femaleIp = g2femaleIp;
    }

    public Integer getG3maleIp() {
        return g3maleIp;
    }

    public void setG3maleIp(Integer g3maleIp) {
        this.g3maleIp = g3maleIp;
    }

    public Integer getG3femaleIp() {
        return g3femaleIp;
    }

    public void setG3femaleIp(Integer g3femaleIp) {
        this.g3femaleIp = g3femaleIp;
    }

    public Integer getG4maleIp() {
        return g4maleIp;
    }

    public void setG4maleIp(Integer g4maleIp) {
        this.g4maleIp = g4maleIp;
    }

    public Integer getG4femaleIp() {
        return g4femaleIp;
    }

    public void setG4femaleIp(Integer g4femaleIp) {
        this.g4femaleIp = g4femaleIp;
    }

    public Integer getG5maleIp() {
        return g5maleIp;
    }

    public void setG5maleIp(Integer g5maleIp) {
        this.g5maleIp = g5maleIp;
    }

    public Integer getG5femaleIp() {
        return g5femaleIp;
    }

    public void setG5femaleIp(Integer g5femaleIp) {
        this.g5femaleIp = g5femaleIp;
    }

    public Integer getG6maleIp() {
        return g6maleIp;
    }

    public void setG6maleIp(Integer g6maleIp) {
        this.g6maleIp = g6maleIp;
    }

    public Integer getG6femaleIp() {
        return g6femaleIp;
    }

    public void setG6femaleIp(Integer g6femaleIp) {
        this.g6femaleIp = g6femaleIp;
    }

    public Integer getNgmaleIp() {
        return ngmaleIp;
    }

    public void setNgmaleIp(Integer ngmaleIp) {
        this.ngmaleIp = ngmaleIp;
    }

    public Integer getNgfemaleIp() {
        return ngfemaleIp;
    }

    public void setNgfemaleIp(Integer ngfemaleIp) {
        this.ngfemaleIp = ngfemaleIp;
    }

    public Short getKmonoClass() {
        return kmonoClass;
    }

    public void setKmonoClass(Short kmonoClass) {
        this.kmonoClass = kmonoClass;
    }

    public Short getG1monoClass() {
        return g1monoClass;
    }

    public void setG1monoClass(Short g1monoClass) {
        this.g1monoClass = g1monoClass;
    }

    public Short getG2monoClass() {
        return g2monoClass;
    }

    public void setG2monoClass(Short g2monoClass) {
        this.g2monoClass = g2monoClass;
    }

    public Short getG3monoClass() {
        return g3monoClass;
    }

    public void setG3monoClass(Short g3monoClass) {
        this.g3monoClass = g3monoClass;
    }

    public Short getG4monoClass() {
        return g4monoClass;
    }

    public void setG4monoClass(Short g4monoClass) {
        this.g4monoClass = g4monoClass;
    }

    public Short getG5monoClass() {
        return g5monoClass;
    }

    public void setG5monoClass(Short g5monoClass) {
        this.g5monoClass = g5monoClass;
    }

    public Short getG6monoClass() {
        return g6monoClass;
    }

    public void setG6monoClass(Short g6monoClass) {
        this.g6monoClass = g6monoClass;
    }

    public Short getNgmonoClass() {
        return ngmonoClass;
    }

    public void setNgmonoClass(Short ngmonoClass) {
        this.ngmonoClass = ngmonoClass;
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
        if (!(object instanceof EnrolmentSummary)) {
            return false;
        }
        EnrolmentSummary other = (EnrolmentSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.EnrolmentSummary[ id=" + id + " ]";
    }
    
}
