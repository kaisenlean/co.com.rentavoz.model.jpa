/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ejody
 */
@Entity
@Table(name = "Simcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Simcard.findAll", query = "SELECT s FROM Simcard s"),
    @NamedQuery(name = "Simcard.findByIdSimcard", query = "SELECT s FROM Simcard s WHERE s.idSimcard = :idSimcard"),
    @NamedQuery(name = "Simcard.findBySimIccid", query = "SELECT s FROM Simcard s WHERE s.simIccid = :simIccid"),
    @NamedQuery(name = "Simcard.findBySimEstado", query = "SELECT s FROM Simcard s WHERE s.simEstado = :simEstado"),
    @NamedQuery(name = "Simcard.findByFecha", query = "SELECT s FROM Simcard s WHERE s.fecha = :fecha")})
public class Simcard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSimcard")
    private Integer idSimcard;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "simIccid")
    private String simIccid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "simEstado")
    private int simEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "simcardidSimcard")
    private List<SucursalSimcard> sucursalSimcardList;
    @JoinColumn(name = "Linea_idLinea", referencedColumnName = "idLinea")
    @ManyToOne(optional = false)
    private Linea lineaidLinea;

    public Simcard() {
    }

    public Simcard(Integer idSimcard) {
        this.idSimcard = idSimcard;
    }

    public Simcard(Integer idSimcard, String simIccid, int simEstado, Date fecha) {
        this.idSimcard = idSimcard;
        this.simIccid = simIccid;
        this.simEstado = simEstado;
        this.fecha = fecha;
    }

    public Integer getIdSimcard() {
        return idSimcard;
    }

    public void setIdSimcard(Integer idSimcard) {
        this.idSimcard = idSimcard;
    }

    public String getSimIccid() {
        return simIccid;
    }

    public void setSimIccid(String simIccid) {
        this.simIccid = simIccid;
    }

    public int getSimEstado() {
        return simEstado;
    }

    public void setSimEstado(int simEstado) {
        this.simEstado = simEstado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<SucursalSimcard> getSucursalSimcardList() {
        return sucursalSimcardList;
    }

    public void setSucursalSimcardList(List<SucursalSimcard> sucursalSimcardList) {
        this.sucursalSimcardList = sucursalSimcardList;
    }

    public Linea getLineaidLinea() {
        return lineaidLinea;
    }

    public void setLineaidLinea(Linea lineaidLinea) {
        this.lineaidLinea = lineaidLinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSimcard != null ? idSimcard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Simcard)) {
            return false;
        }
        Simcard other = (Simcard) object;
        if ((this.idSimcard == null && other.idSimcard != null) || (this.idSimcard != null && !this.idSimcard.equals(other.idSimcard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.invte.rentavoz.logica.entidades.Simcard[ idSimcard=" + idSimcard + " ]";
    }
    
}
