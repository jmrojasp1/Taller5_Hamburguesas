package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {

	private Restaurante mcdo;

	@BeforeEach
	public void setUp() {
		
		mcdo = new Restaurante();
	}

	@AfterEach
	public void tearDown() {
		 

	}

	@Test
	public void testIniciarPedido() {
		assertDoesNotThrow(() -> mcdo.iniciarPedido("Juan Manuel Rojas", "Calle 68"));
		assertNotNull(mcdo.getPedidoEnCurso(), "No puede ser nulo después de iniciar un pedido.");
	}
	

	@Test
	public void testGetMenuBase() throws Exception {
		File archivoIngredientes = new File("data/ingredientes.txt");
		File archivoMenu = new File("data/menu.txt");
		File archivoCombos = new File("data/combos.txt");

		mcdo.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
		assertFalse(mcdo.getMenuBase().isEmpty(), "El menu no se cargo correctamente.");
	}

	@Test
	public void testGetMenuCombos() throws Exception {
		File archivoIngredientes = new File("data/ingredientes.txt");
		File archivoMenu = new File("data/menu.txt");
		File archivoCombos = new File("data/combos.txt");

		mcdo.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
		assertFalse(mcdo.getMenuCombos().isEmpty(), "Los combos no se cargaron correctamente.");
	}

	@Test
	public void testGetIngredientes() throws Exception {
		File archivoIngredientes = new File("data/ingredientes.txt");
		File archivoMenu = new File("data/menu.txt");
		File archivoCombos = new File("data/combos.txt");

		mcdo.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
		assertFalse(mcdo.getIngredientes().isEmpty(), "Los ingredientes no se cargaron correctamente.");
	} 
	@Test
	public void testCargarInformacionRestaurante() throws Exception {
		File archivoIngredientes = new File("data/ingredientes.txt");
		File archivoMenu = new File("data/menu.txt");
		File archivoCombos = new File("data/combos.txt");

		mcdo.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
		assertFalse(mcdo.getIngredientes().isEmpty(), "La lista no puede estar vacía.");
		assertFalse(mcdo.getMenuBase().isEmpty(), "El menu no puede estar vacío.");
		assertFalse(mcdo.getMenuCombos().isEmpty(), "Los combos no deberian estar vacios");
	}

}
