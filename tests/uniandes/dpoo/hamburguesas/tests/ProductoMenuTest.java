package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;


public class ProductoMenuTest {
	
	private ProductoMenu productoMenu1;

    @BeforeEach
    void setUp( ) throws Exception
    {
        productoMenu1 = new ProductoMenu( "BigMac", 20000 );
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    }

    @Test
    void testGetNombre( )
    {
        assertEquals( "BigMac", productoMenu1.getNombre( ), "El nombre del producto no es el esperado." );
    }

    @Test
    void testPrecio( )
    {
        assertEquals( 20000, productoMenu1.getPrecio( ), "El costo del producto no es el esperado." );
    }
    
    @Test
    void testGenerarTextoFactura() {
        String textoEsperado = "BigMac\n" +
                               "            20000\n";
        assertEquals(textoEsperado, productoMenu1.generarTextoFactura(), "El texto de la factura no es el esperado.");
    }

}
