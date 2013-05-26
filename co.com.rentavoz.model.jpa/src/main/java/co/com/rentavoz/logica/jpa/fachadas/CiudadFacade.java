/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import co.com.rentavoz.logica.jpa.entidades.Ciudad;
import co.com.rentavoz.logica.jpa.entidades.Departamento;
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
public class CiudadFacade extends AbstractFacade<Ciudad> {
    @PersistenceContext(unitName = "com.innovate.rentavozPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadFacade() {
        super(Ciudad.class);
    }
       @Override
    public List<Ciudad> findAll() {
        Query q = getEntityManager().createQuery("SELECT c FROM Ciudad c ORDER BY c.departamentoidDepartamento.depNombre ASC");
        return q.getResultList();
    }
       
    public List<Ciudad> findByCriterio(String criterio , Departamento departamento) {
        Query q = getEntityManager().createQuery("SELECT c FROM Ciudad c WHERE c.ciuNombre LIKE :criterio AND c.departamentoidDepartamento = :departamento  ORDER BY c.departamentoidDepartamento.depNombre ASC");
        q.setParameter("criterio", "%"+criterio+"%");
        q.setParameter("departamento", departamento);
        return q.getResultList();
    }
    
    
}
