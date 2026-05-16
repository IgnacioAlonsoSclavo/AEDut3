package ucu.edu.aed.ejercicio16;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class ArbolGenealogicoTest extends TestCase {

    public void testCantidadTotalPersonasYAltura() {
        ArbolGenealogico arbol = Ejercicio16Main.construirEjemplo();

        assertEquals(10, arbol.cantidadTotalPersonas());
        assertEquals(2, arbol.altura());
    }

    public void testListarDescendientes() {
        ArbolGenealogico arbol = Ejercicio16Main.construirEjemplo();

        List<Persona> descendientes = arbol.listarDescendientes(new Persona("Abuela", 1940));

        assertEquals(9, descendientes.size());
        assertEquals("Ana", descendientes.get(0).getNombre());
        assertEquals("Ines", descendientes.get(descendientes.size() - 1).getNombre());
    }

    public void testObtenerGeneracion() {
        ArbolGenealogico arbol = Ejercicio16Main.construirEjemplo();

        assertEquals(Arrays.asList(
                new Persona("Abuela", 1940)
        ), arbol.obtenerGeneracion(0));

        assertEquals(Arrays.asList(
                new Persona("Ana", 1965),
                new Persona("Bruno", 1968),
                new Persona("Carla", 1970)
        ), arbol.obtenerGeneracion(1));

        assertEquals(6, arbol.obtenerGeneracion(2).size());
    }

    public void testAncestroComunMasCercano() {
        ArbolGenealogico arbol = Ejercicio16Main.construirEjemplo();

        assertEquals(new Persona("Ana", 1965), arbol.ancestroComunMasCercano(
                new Persona("Diego", 1990),
                new Persona("Elena", 1992)
        ));

        assertEquals(new Persona("Abuela", 1940), arbol.ancestroComunMasCercano(
                new Persona("Diego", 1990),
                new Persona("Ines", 1997)
        ));
    }

    public void testEsDescendiente() {
        ArbolGenealogico arbol = Ejercicio16Main.construirEjemplo();

        assertTrue(arbol.esDescendiente(new Persona("Diego", 1990), new Persona("Ana", 1965)));
        assertTrue(arbol.esDescendiente(new Persona("Diego", 1990), new Persona("Abuela", 1940)));
        assertFalse(arbol.esDescendiente(new Persona("Ana", 1965), new Persona("Diego", 1990)));
    }
}