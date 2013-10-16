/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas.bodega;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.rentavoz.logica.jpa.entidades.bodega.BodegaItem;
import co.com.rentavoz.logica.jpa.fachadas.AbstractFacade;

/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project co.com.rentavoz.model.jpa
* @class BodegaItemFacade
* @date 7/10/2013
*
 */
@Stateless
public class BodegaItemFacade extends AbstractFacade<BodegaItem> {
	@PersistenceContext(unitName = "com.innovate.rentavozPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public BodegaItemFacade() {
		super(BodegaItem.class);
	}

	
	public boolean existReferencia(String ref){
	Query query= getEntityManager().createQuery("SELECT i FROM BodegaItem i WHERE i.referencia = :ref");
		query.setParameter("ref", new StringBuilder(ref).toString());
		query.setMaxResults(1);
		if (query.getResultList().isEmpty()) {
			return false;
		}else{
			
			return true;
		}
	}
}
