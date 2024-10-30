package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import java.util.ArrayList;

public class ComboTest {

    private Combo combo;
    private ProductoMenu producto1;
    private ProductoMenu producto2;

    @BeforeEach
    void setUp() throws Exception {
        producto1 = new ProductoMenu("Papas", 5000);
        producto2 = new ProductoMenu("Gaseosa", 3000);
        ArrayList<ProductoMenu> items = new ArrayList<>();
        items.add(producto1);
        items.add(producto2);
        combo = new Combo("Combo BigMac", 0.07, items); 
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testGetNombre() {
        assertEquals("Combo BigMac", combo.getNombre(), "El nombre del combo no es el esperado.");
    }

    @Test
    void testGetPrecio() {
        int precioEsperado = (int) ((5000 + 3000) * (1 - 0.07));  
        assertEquals(precioEsperado, combo.getPrecio(), "El precio del combo con descuento no es el esperado.");
    }
    
    @Test
    void testGenerarTextoFactura() {
        String textoEsperado = "Combo Combo BigMac\n" +
                               " Descuento: 0.07\n" +
                               "            " + combo.getPrecio() + "\n";

        assertEquals(textoEsperado, combo.generarTextoFactura(), "El texto de la factura no es el esperado.");
    }
}
