/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ejody
 */
@Entity
@Table(name = "Venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "Venta.findByVenFecha", query = "SELECT v FROM Venta v WHERE v.venFecha = :venFecha"),
    @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Venta.findByVenDomicilio", query = "SELECT v FROM Venta v WHERE v.venDomicilio = :venDomicilio"),
    @NamedQuery(name = "Venta.findByVenSaldo", query = "SELECT v FROM Venta v WHERE v.venSaldo = :venSaldo")})
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "idVenta")
    private Integer idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venFecha")
    @Temporal(TemporalType.DATE)
    private Date venFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "venDomicilio")
    private BigDecimal venDomicilio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venSaldo")
    private BigDecimal venSaldo;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "ventaidVenta")
    private List<Pago> pagoList;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "ventaidVenta")
    private List<TerceroVenta> terceroVentaList;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "ventaidVenta")
    private List<VentaLinea> ventaLineaList;
    @Basic(optional = true)
    @Column(name = "observacion")
    private String observacion;

    public Venta() {
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(Integer idVenta, Date venFecha, Date fecha, BigDecimal venDomicilio, BigDecimal venSaldo) {
        this.idVenta = idVenta;
        this.venFecha = venFecha;
        this.fecha = fecha;
        this.venDomicilio = venDomicilio;
        this.venSaldo = venSaldo;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getVenFecha() {
        return venFecha;
    }

    public void setVenFecha(Date venFecha) {
        this.venFecha = venFecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getVenDomicilio() {
        return venDomicilio;
    }

    public void setVenDomicilio(BigDecimal venDomicilio) {
        this.venDomicilio = venDomicilio;
    }

    public BigDecimal getVenSaldo() {
        return venSaldo;
    }

    public void setVenSaldo(BigDecimal venSaldo) {
        this.venSaldo = venSaldo;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @XmlTransient
    public List<TerceroVenta> getTerceroVentaList() {
        return terceroVentaList;
    }

    public void setTerceroVentaList(List<TerceroVenta> terceroVentaList) {
        this.terceroVentaList = terceroVentaList;
    }

    @XmlTransient
    public List<VentaLinea> getVentaLineaList() {
        return ventaLineaList;
    }

    public void setVentaLineaList(List<VentaLinea> ventaLineaList) {
        this.ventaLineaList = ventaLineaList;
    }

    
    /**
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/06/2013
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	
	/**
	 *@author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *@date 2/06/2013
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.invte.rentavoz.logica.entidades.Venta[ idVenta=" + idVenta + " ]";
    }
    
}
