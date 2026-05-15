package ucu.edu.aed.medible.medibles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import ucu.edu.aed.tda.trie.TTrie;
import ucu.edu.aed.tda.trie.TTrieHashMap;

public class MedicionPredecirTest extends TestCase {

    public void testMedicionesDePrediccionSeEjecutanSinErrores() {
        List<String> palabras = Arrays.asList("casa", "casada", "cazar", "perro", "casamiento");
        String prefijo = "cas";

        LinkedList<String> linkedList = new LinkedList<>(palabras);
        Map<String, String> hashMap = new HashMap<>();
        TTrie<String> trie = new TTrieHashMap<>();

        for (String palabra : palabras) {
            hashMap.put(palabra, palabra);
            trie.insertar(palabra, palabra);
        }

        MedicionPredecirLinkedList medicionLinkedList = new MedicionPredecirLinkedList(linkedList, prefijo);
        MedicionPredecirHashMap medicionHashMap = new MedicionPredecirHashMap(hashMap, prefijo);
        MedicionPredecirTrie medicionTrie = new MedicionPredecirTrie(trie, prefijo);

        assertNotNull(medicionLinkedList.medir(3, palabras));
        assertNotNull(medicionHashMap.medir(3, palabras));
        assertNotNull(medicionTrie.medir(3, palabras));
    }
}
