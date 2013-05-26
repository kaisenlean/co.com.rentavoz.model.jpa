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
@Table(name = "Linea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linea.findAll", query = "SELECT l FROM Linea l"),
    @NamedQuery(name = "Linea.findByIdLinea", query = "SELECT l FROM Linea l WHERE l.idLinea = :idLinea"),
    @NamedQuery(name = "Linea.findByLinNumero", query = "SELECT l FROM Linea l WHERE l.linNumero = :linNumero"),
    @NamedQuery(name = "Linea.findByLinCorte", query = "SELECT l FROM Linea l WHERE l.linCorte = :linCorte"),
    @NamedQuery(name = "Linea.findByFecha", query = "SELECT l FROM Linea l WHERE l.fecha = :fecha")})
public class Linea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLinea")
    private Integer idLinea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "linNumero")
    private String linNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "linCorte")
    private int linCorte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaidLinea")
    private List<SucursalLinea> sucursalLineaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaidLinea")
    private List<PlanLinea> planLineaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaidLinea")
    private List<Simcard> simcardList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaidLinea")
    private List<VentaLinea> ventaLineaList;
    @JoinColumn(name = "EstadoLinea_idEstadoLinea", referencedColumnName = "idEstadoLinea")
    @ManyToOne(optional = false)
    private EstadoLinea estadoLineaidEstadoLinea;
    @JoinColumn(name = "Empresa_idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne(optional = false)
    private Empresa empresaidEmpresa;

    public Linea() {
    }

    public Linea(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public Linea(Integer idLinea, String linNumero, int linCorte, Date fecha) {
        this.idLinea = idLinea;
        this.linNumero = linNumero;
        this.linCorte = linCorte;
        this.fecha = fecha;
    }

    public Integer getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public String getLinNumero() {
        return linNumero;
    }

    public void setLinNumero(String linNumero) {
        this.linNumero = linNumero;
    }

    public int getLinCorte() {
        return linCorte;
    }

    public void setLinCorte(int linCorte) {
        this.linCorte = linCorte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<SucursalLinea> getSucursalLineaList() {
        return sucursalLineaList;
    }

    public void setSucursalLineaList(List<SucursalLinea> sucursalLineaList) {
        this.sucursalLineaList = sucursalLineaList;
    }

    @XmlTransient
    public List<PlanLinea> getPlanLineaList() {
        return planLineaList;
    }

    public void setPlanLineaList(List<PlanLinea> planLineaList) {
        this.planLineaList = planLineaList;
    }

    @XmlTransient
    public List<Simcard> getSimcardList() {
        return simcardList;
    }

    public void setSimcardList(List<Simcard> simcardList) {
        this.simcardList = simcardList;
    }

    @XmlTransient
    public List<VentaLinea> getVentaLineaList() {
        return ventaLineaList;
    }

    public void setVentaLineaList(List<VentaLinea> ventaLineaList) {
        this.ventaLineaList = ventaLineaList;
    }

    public EstadoLinea getEstadoLineaidEstadoLinea() {
        return estadoLineaidEstadoLinea;
    }

    public void setEstadoLineaidEstadoLinea(EstadoLinea estadoLineaidEstadoLinea) {
        this.estadoLineaidEstadoLinea = estadoLineaidEstadoLinea;
    }

    public Empresa getEmpresaidEmpresa() {
        return empresaidEmpresa;
    }

    public void setEmpresaidEmpresa(Empresa empresaidEmpresa) {
        this.empresaidEmpresa = empresaidEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLinea != null ? idLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linea)) {
            return false;
        }
        Linea other = (Linea) object;
        if ((this.idLinea == null && other.idLinea != null) || (this.idLinea != null && !this.idLinea.equals(other.idLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.invte.rentavoz.logica.entidades.Linea[ idLinea=" + idLinea + " ]";
    }
    
}
