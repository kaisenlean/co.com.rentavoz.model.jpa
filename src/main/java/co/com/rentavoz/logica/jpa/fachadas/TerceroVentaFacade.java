/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import co.com.rentavoz.logica.jpa.entidades.TerceroVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ejody
 */
@Stateless
public class TerceroVentaFacade extends AbstractFacade<TerceroVenta> {
    @PersistenceContext(unitName = "com.innovate.rentavozPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerceroVentaFacade() {
        super(TerceroVenta.class);
    }
    
}
