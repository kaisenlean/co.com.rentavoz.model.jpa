/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ejody
 */
@Entity
@Table(name = "VentaLinea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaLinea.findAll", query = "SELECT v FROM VentaLinea v"),
    @NamedQuery(name = "VentaLinea.findByIdVentaLinea", query = "SELECT v FROM VentaLinea v WHERE v.idVentaLinea = :idVentaLinea"),
    @NamedQuery(name = "VentaLinea.findByVentLinPrecio", query = "SELECT v FROM VentaLinea v WHERE v.ventLinPrecio = :ventLinPrecio"),
    @NamedQuery(name = "VentaLinea.findByVentLinTipo", query = "SELECT v FROM VentaLinea v WHERE v.ventLinTipo = :ventLinTipo"),
    @NamedQuery(name = "VentaLinea.findByVentLinDeposito", query = "SELECT v FROM VentaLinea v WHERE v.ventLinDeposito = :ventLinDeposito")})
public class VentaLinea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "idVentaLinea")
    private Integer idVentaLinea;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ventLinPrecio")
    private BigDecimal ventLinPrecio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ventLinTipo")
    private int ventLinTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ventLinDeposito")
    private BigDecimal ventLinDeposito;
    @JoinColumn(name = "Linea_idLinea", referencedColumnName = "idLinea")
    @ManyToOne(optional = false)
    private Linea lineaidLinea;
    @JoinColumn(name = "Venta_idVenta", referencedColumnName = "idVenta")
    @ManyToOne(optional = false)
    private Venta ventaidVenta;

    public VentaLinea() {
    }

    public VentaLinea(Integer idVentaLinea) {
        this.idVentaLinea = idVentaLinea;
    }

    public VentaLinea(Integer idVentaLinea, BigDecimal ventLinPrecio, int ventLinTipo, BigDecimal ventLinDeposito) {
        this.idVentaLinea = idVentaLinea;
        this.ventLinPrecio = ventLinPrecio;
        this.ventLinTipo = ventLinTipo;
        this.ventLinDeposito = ventLinDeposito;
    }

    public Integer getIdVentaLinea() {
        return idVentaLinea;
    }

    public void setIdVentaLinea(Integer idVentaLinea) {
        this.idVentaLinea = idVentaLinea;
    }

    public BigDecimal getVentLinPrecio() {
        return ventLinPrecio;
    }

    public void setVentLinPrecio(BigDecimal ventLinPrecio) {
        this.ventLinPrecio = ventLinPrecio;
    }

    public int getVentLinTipo() {
        return ventLinTipo;
    }

    public void setVentLinTipo(int ventLinTipo) {
        this.ventLinTipo = ventLinTipo;
    }

    public BigDecimal getVentLinDeposito() {
        return ventLinDeposito;
    }

    public void setVentLinDeposito(BigDecimal ventLinDeposito) {
        this.ventLinDeposito = ventLinDeposito;
    }

    public Linea getLineaidLinea() {
        return lineaidLinea;
    }

    public void setLineaidLinea(Linea lineaidLinea) {
        this.lineaidLinea = lineaidLinea;
    }

    public Venta getVentaidVenta() {
        return ventaidVenta;
    }

    public void setVentaidVenta(Venta ventaidVenta) {
        this.ventaidVenta = ventaidVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaLinea != null ? idVentaLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaLinea)) {
            return false;
        }
        VentaLinea other = (VentaLinea) object;
        if ((this.idVentaLinea == null && other.idVentaLinea != null) || (this.idVentaLinea != null && !this.idVentaLinea.equals(other.idVentaLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.invte.rentavoz.logica.entidades.VentaLinea[ idVentaLinea=" + idVentaLinea + " ]";
    }
    
}
