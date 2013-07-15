/**
 * 
 */
package co.com.rentavoz.fachadas;

import javax.ejb.embeddable.EJBContainer;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project co.com.rentavoz.model.jpa
 * @class BaseFacadeTest
 * @date 14/07/2013
 *
 */
public class BaseFacadeTest {

	
		protected Object loadBean(String beanName) throws Exception {
		EJBContainer container = EJBContainer.createEJBContainer();
		 return container.getContext().lookup("java:global/co.com.rentavoz.model.jpa/"+beanName);
		 
        
	}
}
