package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {

    private Pedido pedido;
    private ProductoMenu producto1;
    private ProductoMenu producto2;

    @BeforeEach
    void setUp() throws Exception {
        pedido = new Pedido("Juan Manuel Rojas", "Calle 68");
        producto1 = new ProductoMenu("BigMac", 20000);
        producto2 = new ProductoMenu("McFlurry", 8000);
    }

    @AfterEach
    void tearDown() throws Exception {
        pedido = null;
        producto1 = null;
        producto2 = null;
    }
    
    @Test
	public void testGetNombreCliente() {
		assertEquals("Juan Manuel Rojas", pedido.getNombreCliente(), "El nombre no es el esperado");
	}

    @Test
	void testAgregarProducto() {
		pedido.agregarProducto(producto1);
		assertEquals(23800,pedido.getPrecioTotalPedido());
	}
    
    @Test
	public void testGetIdPedido() {
		assertEquals(7, pedido.getIdPedido(), "El id no es el esperado");
	}
    @Test
    public void testGetPrecioNetoPedido() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        int precioNetoEsperado = 28000;  // 20000 + 8000
        assertEquals(precioNetoEsperado, pedido.getPrecioNetoPedido(), "El precio neto no es el esperado");
    }
    
    @Test
    public void testGetPrecioIVAPedido() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        int ivaEsperado = 5320;  // 28000 * 0.19
        assertEquals(ivaEsperado, pedido.getPrecioIVAPedido(), "El IVA calculado no es el esperado");
    }

    @Test
    public void testGetPrecioTotalPedido() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        int precioTotalEsperado = 33320;  // 28000 + 5320
        assertEquals(precioTotalEsperado, pedido.getPrecioTotalPedido(), "El precio total no es el esperado");
    }
	
	
    @Test
    void testGenerarTextoFactura() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
        
        String facturaEsperada = "Cliente: Juan Manuel Rojas\n" +
                                 "Dirección: Calle 68\n" +
                                 "----------------\n" +
                                 "Producto: BigMac\n" +
                                 "Precio: 20000\n" +
                                 "Producto: McFlurry\n" +
                                 "Precio: 8000\n" +
                                 "----------------\n" +
                                 "Precio Neto:  28000\n" +
                                 "IVA:          5320\n" +
                                 "Precio Total: 33320\n";

        String facturaGenerada = pedido.generarTextoFactura();
        assertEquals(facturaEsperada, facturaGenerada);
    }

    
    @Test
    public void testGuardarFactura() throws IOException {
        
    	Pedido pedido = new Pedido("Juan Manuel Rojas", "Calle 68");
        ProductoMenu producto1 = new ProductoMenu("BigMac", 20000);
        ProductoMenu producto2 = new ProductoMenu("McFlurry", 8000);
        
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

 
        File archivoTemporal = File.createTempFile("factura", ".txt");

        try {
            
            pedido.guardarFactura(archivoTemporal);

             
            String contenidoArchivo = new String(Files.readAllBytes(archivoTemporal.toPath()));

            
            String textoEsperado = "Cliente: Juan Manuel Rojas\n" +
                                   "Dirección: Calle 68\n" +
                                   "----------------\n" +
                                   "Producto: BigMac\n" +
                                   "Precio: 20000\n" +
                                   "Producto: McFlurry\n" +
                                   "Precio: 8000\n" +
                                   "----------------\n" +
                                   "Precio Neto:  28000\n" +
                                   "IVA:          5320\n" +
                                   "Precio Total: 33320\n";

            
            assertEquals(textoEsperado, contenidoArchivo);

        } finally {
             
            archivoTemporal.delete();
        }
    }

}
