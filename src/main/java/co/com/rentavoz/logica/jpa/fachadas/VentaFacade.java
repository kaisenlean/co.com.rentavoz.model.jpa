/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import co.com.rentavoz.logica.jpa.entidades.Venta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ejody
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> {
    @PersistenceContext(unitName = "com.innovate.rentavozPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }
    
    @SuppressWarnings("unused")
	public Integer findSgteNumero(){
    	Query query = getEntityManager().createQuery("SELECT MAX(v.idVenta) FROM Venta v");
    	query.setMaxResults(1);
    	
    	if (query.getSingleResult()==null) {
			return Integer.valueOf("1");
		}else{
			return Integer.valueOf(query.getSingleResult().toString())+1;
			
		}
    	
    }
    
}
