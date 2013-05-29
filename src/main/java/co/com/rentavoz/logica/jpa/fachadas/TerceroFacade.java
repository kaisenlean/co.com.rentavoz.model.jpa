/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import co.com.rentavoz.logica.jpa.entidades.Tercero;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ejody
 */
@Stateless
public class TerceroFacade extends AbstractFacade<Tercero> implements Serializable{
    @PersistenceContext(unitName = "com.innovate.rentavozPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerceroFacade() {
        super(Tercero.class);
    }

    public List<Tercero> findByCriterio(String criterio) {
        Query q = getEntityManager().createQuery("SELECT t FROM Tercero t WHERE t.terApellidos LIKE :criterio OR t.terNombre LIKE :criterio ");
        q.setParameter("criterio", "%"+criterio+"%");
        return q.getResultList();
    }

 
}
