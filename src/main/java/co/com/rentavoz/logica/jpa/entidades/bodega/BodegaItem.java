package co.com.rentavoz.logica.jpa.entidades.bodega;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bodega_item database table.
 * 
 */
@Entity
@Table(name="bodega_item")
@NamedQuery(name="BodegaItem.findAll", query="SELECT b FROM BodegaItem b")
public class BodegaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=200)
	private String descripcion;

	@Column(length=255)
	private String foto;

	@Column(nullable=false, length=200)
	private String nombre;

	
	@Column(length=200 )
	private String referencia;

	//bi-directional many-to-one association to BodegaExistencia
	@OneToMany(mappedBy="bodegaItemBean")
	private List<BodegaExistencia> bodegaExistencias;

	public BodegaItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public List<BodegaExistencia> getBodegaExistencias() {
		return this.bodegaExistencias;
	}

	public void setBodegaExistencias(List<BodegaExistencia> bodegaExistencias) {
		this.bodegaExistencias = bodegaExistencias;
	}

	public BodegaExistencia addBodegaExistencia(BodegaExistencia bodegaExistencia) {
		getBodegaExistencias().add(bodegaExistencia);
		bodegaExistencia.setBodegaItemBean(this);

		return bodegaExistencia;
	}

	public BodegaExistencia removeBodegaExistencia(BodegaExistencia bodegaExistencia) {
		getBodegaExistencias().remove(bodegaExistencia);
		bodegaExistencia.setBodegaItemBean(null);

		return bodegaExistencia;
	}

}