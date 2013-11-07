/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.logica.jpa.fachadas;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.rentavoz.logica.jpa.entidades.caja.Caja;
import co.com.rentavoz.logica.jpa.entidades.caja.EstadoCaja;
import co.com.rentavoz.logica.jpa.entidades.profile.Usuario;

@Stateless
public class CajaFacade extends AbstractFacade<Caja> {
	@PersistenceContext(unitName = "com.innovate.rentavozPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CajaFacade() {
		super(Caja.class);
	}
	
	@SuppressWarnings("unchecked")
	public void abrirCaja(Usuario usuario){
		Calendar inicio =Calendar.getInstance();
		inicio.setTime(new Date());
		Calendar fin =Calendar.getInstance();
		fin.setTime(new Date());
		inicio.set(Calendar.HOUR, 0);
		inicio.set(Calendar.HOUR_OF_DAY, 0);
		inicio.set(Calendar.MINUTE, 0);
		inicio.set(Calendar.SECOND, 0);
		inicio.set(Calendar.MILLISECOND, 0);
		
		fin.set(Calendar.HOUR, 23);
		fin.set(Calendar.HOUR_OF_DAY, 23);
		fin.set(Calendar.MINUTE, 59);
		fin.set(Calendar.SECOND, 59);
		fin.set(Calendar.MILLISECOND, 59);
		
		
		Query query = getEntityManager().createQuery("SELECT c FROM Caja c WHERE c.fecha BETWEEN :start AND :end ");
		query.setParameter("start", inicio.getTime());
		query.setParameter("end", fin.getTime());
		
		query.setMaxResults(1);
		List<Caja> lista= query.getResultList();
		
		if (lista.isEmpty()) {
			Caja caja= new Caja();
			caja.setEstado(EstadoCaja.ABIERTA);
			caja.setFecha(new Date());
			caja.setUsuario(usuario);
			create(caja);
		}
		else{
			
			Caja caja= lista.get(0);
			caja.setUsuario(usuario);
			edit(caja);
		}
	}

}
