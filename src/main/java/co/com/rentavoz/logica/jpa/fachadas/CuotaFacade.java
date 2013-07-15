/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.rentavoz.logica.jpa.entidades.almacen.Cuota;
import co.com.rentavoz.logica.jpa.entidades.almacen.EstadoCuotaEnum;
import co.com.rentavoz.logica.jpa.entidades.almacen.Venta;

/**
 * 
 * @author ejody
 */
@Stateless
public class CuotaFacade extends AbstractFacade<Cuota> {
	@PersistenceContext(unitName = "com.innovate.rentavozPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CuotaFacade() {
		super(Cuota.class);
	}

/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @date 15/07/2013
* @param venta
* @return
 */
	public boolean cuotasActivas(Venta venta) {
		Query query = getEntityManager()
				.createQuery(
						"SELECT c FROM Cuota c WHERE c.venta = :venta AND c.estadoCuota = :estado");
		query.setParameter("venta", venta);
		query.setParameter("estado", EstadoCuotaEnum.PENDIENTE);

		if (!query.getResultList().isEmpty()) {
			return true;
		} else {
			return false;

		}

	}

}
