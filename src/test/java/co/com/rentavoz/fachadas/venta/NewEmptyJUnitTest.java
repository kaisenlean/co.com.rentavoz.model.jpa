/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.fachadas.venta;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import junit.framework.TestCase;
import junit.framework.TestResult;
import co.com.rentavoz.logica.jpa.fachadas.VentaLineaFacade;

/**
 *
 * @author ejody
 */
public class NewEmptyJUnitTest extends TestCase {
    
    public NewEmptyJUnitTest(String testName) {
        super(testName);
    }
    @EJB
	private VentaLineaFacade ventaLineaFacade;
	
	protected EntityManager em;
	/**
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 14/07/2013
	 * @throws java.lang.Exception
	 */


    
    @Override
    protected void setUp() throws Exception {
  		  if (em == null) {
	            em = (EntityManager) Persistence.createEntityManagerFactory("com.innovate.rentavozPU").createEntityManager();
	        }
		System.out.println(em);
                
                ventaLineaFacade=new VentaLineaFacade();
                ventaLineaFacade.setEm(em);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    @Override
    public TestResult run() {System.out.println(ventaLineaFacade);
        
        return super.run(); //To change body of generated methods, choose Tools | Templates.
        
    }
    

    public void testHello() {
        System.out.println(ventaLineaFacade);
    }
}
