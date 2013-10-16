package co.com.rentavoz.logica.jpa.entidades.bodega;

import java.io.Serializable;

import javax.persistence.*;

import co.com.rentavoz.logica.jpa.entidades.Sucursal;

import java.util.List;


/**
 * The persistent class for the bodega_existencia database table.
 * 
 */
@Entity
@Table(name="bodega_existencia")
public class BodegaExistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idEXistencia;

	@Column(name="bar_code", length=255)
	private String barCode;

	//bi-directional many-to-one association to BodegaItem
	@ManyToOne
	@JoinColumn(name="bodega_item")
	private BodegaItem bodegaItemBean;

	//bi-directional many-to-one association to BodegaIngreso
	@ManyToOne
	@JoinColumn(name="id_ingreso")
	private BodegaIngreso bodegaIngreso;

	//bi-directional many-to-one association to BodegaSalidaReferencia
	@OneToMany(mappedBy="bodegaExistencia")
	private List<BodegaSalidaReferencia> bodegaSalidaReferencias;

	@Enumerated(EnumType.STRING)
	private EstadoExistenciaEnum estado;
	
	@JoinColumn(name="sucursal")
	private Sucursal sucursal;
	@Transient
	private int idItem;
	
	
	public BodegaExistencia() {
	}

	public int getIdEXistencia() {
		return this.idEXistencia;
	}

	public void setIdEXistencia(int idEXistencia) {
		this.idEXistencia = idEXistencia;
	}

	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public BodegaItem getBodegaItemBean() {
		return this.bodegaItemBean;
	}

	public void setBodegaItemBean(BodegaItem bodegaItemBean) {
		this.bodegaItemBean = bodegaItemBean;
	}

	public BodegaIngreso getBodegaIngreso() {
		return this.bodegaIngreso;
	}

	public void setBodegaIngreso(BodegaIngreso bodegaIngreso) {
		this.bodegaIngreso = bodegaIngreso;
	}

	public List<BodegaSalidaReferencia> getBodegaSalidaReferencias() {
		return this.bodegaSalidaReferencias;
	}

	public void setBodegaSalidaReferencias(List<BodegaSalidaReferencia> bodegaSalidaReferencias) {
		this.bodegaSalidaReferencias = bodegaSalidaReferencias;
	}

	public BodegaSalidaReferencia addBodegaSalidaReferencia(BodegaSalidaReferencia bodegaSalidaReferencia) {
		getBodegaSalidaReferencias().add(bodegaSalidaReferencia);
		bodegaSalidaReferencia.setBodegaExistencia(this);

		return bodegaSalidaReferencia;
	}

	public BodegaSalidaReferencia removeBodegaSalidaReferencia(BodegaSalidaReferencia bodegaSalidaReferencia) {
		getBodegaSalidaReferencias().remove(bodegaSalidaReferencia);
		bodegaSalidaReferencia.setBodegaExistencia(null);

		return bodegaSalidaReferencia;
	}
	
	/**
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/06/2013
	 * @return the estado
	 */
	public EstadoExistenciaEnum getEstado() {
		return estado;
	}
	/**
	 *@author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *@date 2/06/2013
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoExistenciaEnum estado) {
		this.estado = estado;
	}
	
	
	/**
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 2/06/2013
	 * @return the idItem
	 */
	public int getIdItem() {
		return idItem;
	}
	
	/**
	 *@author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *@date 2/06/2013
	 * @param idItem the idItem to set
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BodegaExistencia other = (BodegaExistencia) obj;
		if (barCode == null) {
			if (other.barCode != null)
				return false;
		} else if (!barCode.equals(other.barCode))
			return false;
		return true;
	}

		 /**
		 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
		 * @date 2/06/2013
		 * @return the sucursal
		 */
	public Sucursal getSucursal() {
		return sucursal;
	}

	
	/**
	 *@author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *@date 2/06/2013
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}