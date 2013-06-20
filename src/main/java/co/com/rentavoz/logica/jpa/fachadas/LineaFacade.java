/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.rentavoz.logica.jpa.entidades.Linea;

/**
 * 
 * @author ejody
 */
@Stateless
public class LineaFacade extends AbstractFacade<Linea> {
	private static final Integer ESTADO_LINEA_ACTIVO = 1;
	@PersistenceContext(unitName = "com.innovate.rentavozPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public LineaFacade() {
		super(Linea.class);
	}

	public Integer nextCodigo() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(l.idLinea) FROM Linea l ");
		q.setMaxResults(1);
		Integer resultado = Integer.valueOf("0");

		try {
			resultado = Integer.valueOf(q.getSingleResult().toString()) + 1;
		} catch (Exception e) {
			resultado = Integer.valueOf("1");
		}
		return resultado;
	}

	public boolean findBNumero(String linNumero) {
		Query q = getEntityManager().createQuery(
				"SELECT l FROM Linea l WHERE l.linNumero = :numero");
		q.setParameter("numero", linNumero);
		q.setMaxResults(1);
		if (q.getResultList().isEmpty()) {
			return true;
		} else if (q.getSingleResult() == null) {
			return true;
		} else {
			return false;
		}

	}
        	public Linea findBNumeroObjeto(String linNumero) {
		Query q = getEntityManager().createQuery(
				"SELECT l FROM Linea l WHERE l.linNumero = :numero");
		q.setParameter("numero", linNumero);
		q.setMaxResults(1);
		if (q.getResultList().isEmpty()) {
			return null;
		} else if (q.getSingleResult() == null) {
			return (Linea) q.getSingleResult();
		} else {
			return null;
		}

	}

	public boolean findBNumero2(String linNumero) {
		Query q = getEntityManager().createQuery(
				"SELECT l FROM Linea l WHERE l.linNumero = :numero");
		q.setParameter("numero", linNumero);

		if (q.getResultList().size() == 1) {
			return true;
		} else
			return false;
	}

	public List<Linea> findDisponibles() {
		// buscar las lineas en estado disponibles
		Query q = getEntityManager()
				.createQuery(
						"SELECT l FROM Linea l WHERE l.estadoLineaidEstadoLinea.idEstadoLinea = :estado");
		q.setParameter("estado", ESTADO_LINEA_ACTIVO);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Linea> findPlayers(int startingAt, int maxPerPage) {

		// regular query that will search for players in the db
		Query query = getEntityManager()
				.createQuery(
						"SELECT l FROM Linea l WHERE l.estadoLineaidEstadoLinea.idEstadoLinea = :estado");
		query.setParameter("estado", ESTADO_LINEA_ACTIVO);
		query.setFirstResult(startingAt);
		query.setMaxResults(maxPerPage);

		return query.getResultList();
	}

	public int countPlayersTotal() {

		Query query = getEntityManager()
				.createQuery(
						"select COUNT(p) from Linea p WHERE p.estadoLineaidEstadoLinea.idEstadoLinea = :estado");

		query.setParameter("estado", ESTADO_LINEA_ACTIVO);

		Number result = (Number) query.getSingleResult();

		return result.intValue();

	}

}
