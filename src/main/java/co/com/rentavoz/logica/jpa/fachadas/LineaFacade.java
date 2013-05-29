/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import co.com.rentavoz.logica.jpa.entidades.Linea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ejody
 */
@Stateless
public class LineaFacade extends AbstractFacade<Linea> {
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
        Query q = getEntityManager().createQuery("SELECT MAX(l.idLinea) FROM Linea l ");
        q.setMaxResults(1);
        Integer resultado=Integer.valueOf("0");
        
        try {
            resultado=Integer.valueOf(q.getSingleResult().toString())+1;
        } catch (Exception e) {
            resultado=Integer.valueOf("1");
        }
        return  resultado;
    }

    public boolean findBNumero(String linNumero) {
       Query q = getEntityManager().createQuery("SELECT l FROM Linea l WHERE l.linNumero = :numero");
       q.setParameter("numero", linNumero);
       q.setMaxResults(1);
        if (q.getResultList().isEmpty()) {
            return true;
        }else
        if (q.getSingleResult()==null) {
            return true;
        }else{
        return false;
        }
       
    }

    public boolean findBNumero2(String linNumero) {
           Query q = getEntityManager().createQuery("SELECT l FROM Linea l WHERE l.linNumero = :numero");
       q.setParameter("numero", linNumero);
      
        if (q.getResultList().size()==1) {
            return true;
        }else
       return false;
        }
       
    }

    

