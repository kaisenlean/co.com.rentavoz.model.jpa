/**
 * 
 */
package co.com.rentavoz.fachadas;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project co.com.rentavoz.model.jpa
 * @class BaseFacadeTest
 * @date 14/07/2013
 * 
 */
public class BaseFacadeTest {

	private EntityManager em;

	protected EntityManager getEm() {

		if (em == null) {
			em = (EntityManager) Persistence.createEntityManagerFactory(
					"com.innovate.rentavozPU").createEntityManager();
		}
		return em;
	}
}
