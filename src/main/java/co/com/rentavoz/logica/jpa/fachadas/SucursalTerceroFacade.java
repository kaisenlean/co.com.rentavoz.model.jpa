/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import co.com.rentavoz.logica.jpa.entidades.SucursalTercero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ejody
 */
@Stateless
public class SucursalTerceroFacade extends AbstractFacade<SucursalTercero> {
    @PersistenceContext(unitName = "com.innovate.rentavozPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalTerceroFacade() {
        super(SucursalTercero.class);
    }
    
}
