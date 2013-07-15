/**
 * 
 */
package co.com.rentavoz.fachadas.venta;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import co.com.rentavoz.fachadas.BaseFacadeTest;
import co.com.rentavoz.logica.jpa.fachadas.VentaLineaFacade;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project co.com.rentavoz.model.jpa
 * @class VentalineaFacadeTest
 * @date 14/07/2013
 *
 */

public class VentalineaFacadeTest extends  BaseFacadeTest {

	@EJB
	private VentaLineaFacade ventaLineaFacade;
	
	protected EntityManager em;
	/**
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 14/07/2013
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		  if (em == null) {
			  
	            em = (EntityManager) Persistence.createEntityManagerFactory("com.innovate.rentavozPU").createEntityManager();
	        }
		System.out.println(em);
        
	}

	/**
	 * Test method for {@link co.com.rentavoz.logica.jpa.fachadas.VentaLineaFacade#buscarLineasPorRenovar(java.util.Date, java.util.Date)}.
	 */
	@Test
	public  void testBuscarLineasPorRenovar() {
		System.out.println(ventaLineaFacade);
	}

}
