/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.rentavoz.fachadas.venta;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.com.rentavoz.fachadas.BaseFacadeTest;
import co.com.rentavoz.logica.jpa.entidades.almacen.VentaLinea;
import co.com.rentavoz.logica.jpa.fachadas.VentaLineaFacade;
/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project co.com.rentavoz.model.jpa
 * @class NewEmptyJUnitTest
 * @date 17/07/2013
 * 
 */

public class VentaLineaFacadeTest extends BaseFacadeTest  {

	


	private   VentaLineaFacade ventaLineaFacade;


	/**
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 17/07/2013
	 */
	public VentaLineaFacadeTest() {
		
	}
	/**
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 17/07/2013
	 */
	@Test
	public void buscarVentasDeLineasporRangosDeFecha() {

		ventaLineaFacade = new VentaLineaFacade();
		ventaLineaFacade.setEm(getEm());
		
		Calendar calendario= Calendar.getInstance();
		calendario.set(Calendar.MONTH, 06);
		calendario.set(Calendar.DAY_OF_MONTH, 01);
		List<VentaLinea> ventaLineas=ventaLineaFacade.buscarLineasPorRenovar(calendario.getTime(), new Date()
		);
		assertNotNull(ventaLineas);
		
	}
	
}
