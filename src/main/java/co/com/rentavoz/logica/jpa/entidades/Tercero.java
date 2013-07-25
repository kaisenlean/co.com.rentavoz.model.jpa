/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import co.com.rentavoz.logica.jpa.entidades.profile.Usuario;

/**
 * 
 * @author ejody
 */
@Entity
@Table(name = "Tercero")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Tercero.findAll", query = "SELECT t FROM Tercero t"),
		@NamedQuery(name = "Tercero.findByIdTecero", query = "SELECT t FROM Tercero t WHERE t.idTecero = :idTecero"),
		@NamedQuery(name = "Tercero.findByTerNombre", query = "SELECT t FROM Tercero t WHERE t.terNombre = :terNombre"),
		@NamedQuery(name = "Tercero.findByTerApellidos", query = "SELECT t FROM Tercero t WHERE t.terApellidos = :terApellidos"),
		@NamedQuery(name = "Tercero.findByTerTelefono", query = "SELECT t FROM Tercero t WHERE t.terTelefono = :terTelefono"),
		@NamedQuery(name = "Tercero.findByTerDireccion", query = "SELECT t FROM Tercero t WHERE t.terDireccion = :terDireccion"),
		@NamedQuery(name = "Tercero.findByTerDocumento", query = "SELECT t FROM Tercero t WHERE t.terDocumento = :terDocumento")})
public class Tercero implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTecero")
	private Integer idTecero;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "terNombre")
	private String terNombre;
	@Size(max = 45)
	@Column(name = "terApellidos")
	private String terApellidos;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "terTelefono")
	private String terTelefono;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "terDireccion")
	private String terDireccion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "terDocumento")
	private int terDocumento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo")
	private TipoTerceroEnum tipo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "terceroidTecero")
	private List<TerceroVenta> terceroVentaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "terceroidTecero")
	private List<Roles> rolesList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "terceroidTecero")
	private List<SucursalTercero> sucursalTerceroList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "terceroidTecero")
	private List<Plan> planList;

	@Transient
	private String repTerClave;

	
	@JoinColumn(name="usuario",referencedColumnName="usuario")
	@ManyToOne
	private Usuario usuario;
	
	public Tercero() {
	}

	public Tercero(Integer idTecero) {
		this.idTecero = idTecero;
	}

	public Tercero(Integer idTecero, String terNombre, String terTelefono,
			String terDireccion, int terDocumento) {
		this.idTecero = idTecero;
		this.terNombre = terNombre;
		this.terTelefono = terTelefono;
		this.terDireccion = terDireccion;
		this.terDocumento = terDocumento;
		
	}

	public Integer getIdTecero() {
		return idTecero;
	}

	public void setIdTecero(Integer idTecero) {
		this.idTecero = idTecero;
	}

	public String getTerNombre() {
		return terNombre;
	}

	public void setTerNombre(String terNombre) {
		this.terNombre = terNombre;
	}

	public String getTerApellidos() {
		return terApellidos;
	}

	public void setTerApellidos(String terApellidos) {
		this.terApellidos = terApellidos;
	}

	public String getTerTelefono() {
		return terTelefono;
	}

	public void setTerTelefono(String terTelefono) {
		this.terTelefono = terTelefono;
	}

	public String getTerDireccion() {
		return terDireccion;
	}

	public void setTerDireccion(String terDireccion) {
		this.terDireccion = terDireccion;
	}

	public int getTerDocumento() {
		return terDocumento;
	}

	public void setTerDocumento(int terDocumento) {
		this.terDocumento = terDocumento;
	}



	@XmlTransient
	public List<TerceroVenta> getTerceroVentaList() {
		return terceroVentaList;
	}

	public void setTerceroVentaList(List<TerceroVenta> terceroVentaList) {
		this.terceroVentaList = terceroVentaList;
	}

	@XmlTransient
	public List<Roles> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<Roles> rolesList) {
		this.rolesList = rolesList;
	}

	@XmlTransient
	public List<SucursalTercero> getSucursalTerceroList() {
		return sucursalTerceroList;
	}

	public void setSucursalTerceroList(List<SucursalTercero> sucursalTerceroList) {
		this.sucursalTerceroList = sucursalTerceroList;
	}

	@XmlTransient
	public List<Plan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<Plan> planList) {
		this.planList = planList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idTecero != null ? idTecero.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
	
		if (!(object instanceof Tercero)) {
			return false;
		}
		Tercero other = (Tercero) object;
		if ((this.idTecero == null && other.idTecero != null)
				|| (this.idTecero != null && !this.idTecero
						.equals(other.idTecero))) {
			return false;
		}
		return true;
	}

	public String getRepTerClave() {
		return repTerClave;
	}

	public void setRepTerClave(String repTerClave) {
		this.repTerClave = repTerClave;
	}
/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 2/06/2013
 * @return the tipo
 */
public TipoTerceroEnum getTipo() {
	return tipo;
}


/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @date 2/06/2013
 * @return the usuario
 */
public Usuario getUsuario() {
	return usuario;
}


/**
 *@author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 *@date 2/06/2013
 * @param usuario the usuario to set
 */
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}



/**
 *@author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 *@date 2/06/2013
 * @param tipo the tipo to set
 */
public void setTipo(TipoTerceroEnum tipo) {
	this.tipo = tipo;
}
	@Override
	public String toString() {
		return terNombre + " " + terApellidos + " [ " + terDocumento + " ]";
	}

}
