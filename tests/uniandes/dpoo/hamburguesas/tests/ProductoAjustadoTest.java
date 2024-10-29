package uniandes.dpoo.hamburguesas.tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;

public class ProductoAjustadoTest {

	private ProductoMenu productoBase1;
	private ProductoAjustado productoAjustado1;
	

    @BeforeEach
    void setUp( ) throws Exception
    {
        productoBase1 = new ProductoMenu("BigMac",18000);
		productoAjustado1 = new ProductoAjustado(productoBase1);
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    	
    }

    @Test
    void testGetNombre( )
    {
        assertEquals( "BigMac", productoAjustado1.getNombre( ), "El nombre del producto base no es igual al del producto ajustado" );
    }

    @Test
	void testGetPrecio() {
		assertEquals(18000,productoAjustado1.getPrecio(),"El precio del producto debería ser 18000 sin ingredientes adicionales.");
		Ingrediente queso = new Ingrediente("Queso", 3000);
		productoAjustado1.agregarIngrediente(queso);
		assertEquals(21000,productoAjustado1.getPrecio(),"El precio debería ser 21000 después de añadir ingredientes adicionales.");
	}

}
