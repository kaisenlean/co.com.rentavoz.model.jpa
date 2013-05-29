/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import co.com.rentavoz.logica.jpa.entidades.Plan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ejody
 */
@Stateless
public class PlanFacade extends AbstractFacade<Plan> {

    @PersistenceContext(unitName = "com.innovate.rentavozPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanFacade() {
        super(Plan.class);
    }

    public int nextCodigo() {
        Query q = getEntityManager().createQuery("SELECT MAX(p.idPlan) FROM Plan p ");
        q.setMaxResults(1);
        int resultado = 0;
        try {
            resultado = Integer.parseInt(q.getSingleResult().toString())+1;
        } catch (Exception e) {
            resultado=1;
        }
        
        return resultado;
    }
}
