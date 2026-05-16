package ucu.edu.aed.medible;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.medible.lib.Medicion;
import ucu.edu.aed.medible.medibles.MedicionPredecirHashMap;
import ucu.edu.aed.medible.medibles.MedicionPredecirLinkedList;
import ucu.edu.aed.medible.medibles.MedicionPredecirTrie;
import ucu.edu.aed.tda.trie.TTrie;
import ucu.edu.aed.tda.trie.TTrieHashMap;
import ucu.edu.aed.utils.FileUtils;

public class Ejercicio7PredecirMain {

    private static final int REPETICIONES = 20;
    private static final String PREFIJO = "cas";

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Map<String, String> hashMap = new HashMap<>();
        TTrie<String> trie = new TTrieHashMap<>();

        List<String> palabras = new LinkedList<>();
        FileUtils.leerLineas("./ut03/listado-general-desordenado.txt", palabras::add);

        for (String palabra : palabras) {
            linkedList.add(palabra);
            hashMap.put(palabra, palabra);
            trie.insertar(palabra, palabra);
        }

        List<Medible<List<String>>> medibles = new ArrayList<>();
        medibles.add(new MedicionPredecirLinkedList(linkedList, PREFIJO));
        medibles.add(new MedicionPredecirTrie(trie, PREFIJO));
        medibles.add(new MedicionPredecirHashMap(hashMap, PREFIJO));

        StringBuilder sb = new StringBuilder();
        sb.append("algoritmo,tiempo,memoria\n");

        for (Medible<List<String>> medible : medibles) {
            Medicion medicion = medible.medir(REPETICIONES, palabras);
            medicion.print();
            sb.append(medicion.toCSV()).append("\n");
        }

        FileUtils.escribirLineas("./salida-predecir.csv", sb.toString());
    }
}
