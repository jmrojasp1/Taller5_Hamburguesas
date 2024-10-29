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
        productoMenu1 = new ProductoMenu( "BigMac", 18000 );
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
    void testGetCostoAdicional( )
    {
        assertEquals( 18000, productoMenu1.getPrecio( ), "El costo del producto no es el esperado." );
    }

}
