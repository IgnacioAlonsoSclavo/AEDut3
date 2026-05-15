package ucu.edu.aed.tda.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import ucu.edu.aed.medible.TrieHashMapApp;

public class TTrieHashMapTest extends TestCase {

    public void testInsertarBuscarYPrefijo() {
        TTrieHashMap<String> trie = new TTrieHashMap<>();

        assertTrue(trie.insertar("casa", "casa"));
        assertTrue(trie.insertar("casada", "casada"));
        assertTrue(trie.insertar("cazar", "cazar"));
        assertFalse(trie.insertar("casa", "otra"));

        Entry<String> casa = trie.buscar("casa");
        Entry<String> prefijo = trie.buscar("cas");

        assertNotNull(casa);
        assertTrue(casa.esPalabra());
        assertEquals("otra", casa.getDato());
        assertNotNull(prefijo);
        assertFalse(prefijo.esPalabra());

        List<String> sugerencias = toPalabras(trie.predecir("ca"));
        assertEquals(Arrays.asList("casa", "casada", "cazar"), sugerencias);
    }

    public void testPredecirSinCoincidenciasDevuelveListaVacia() {
        TTrieHashMap<String> trie = new TTrieHashMap<>();
        trie.insertar("perro", "perro");

        assertTrue(trie.predecir("zzz").isEmpty());
    }

    public void testBusquedaDePatronesIndicaPosiciones() {
        List<Integer> posiciones = TrieHashMapApp.buscarPatrones("bananana", "ana");

        assertEquals(Arrays.asList(1, 3, 5), posiciones);
    }

    public void testAutocompletarDevuelveSugerencias() {
        List<String> sugerencias = TrieHashMapApp.autocompletar(Arrays.asList("ala", "alimania", "alabastro", "perro"), "ala");

        assertEquals(Arrays.asList("ala", "alabastro"), sugerencias);
    }

    private List<String> toPalabras(List<Entry<String>> entradas) {
        List<String> palabras = new ArrayList<>();
        for (Entry<String> entrada : entradas) {
            palabras.add(entrada.getPalabra());
        }
        return palabras;
    }
}