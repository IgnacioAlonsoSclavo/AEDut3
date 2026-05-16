package ucu.edu.aed.medible;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ucu.edu.aed.tda.trie.Entry;
import ucu.edu.aed.tda.trie.TTrieHashMap;
import ucu.edu.aed.utils.FileUtils;

public class TrieHashMapApp {

    public static void main(String[] args) {
        if (args.length == 0 || "autocompletar".equalsIgnoreCase(args[0])) {
            String prefijo = args.length > 1 ? args[1] : "ca";
            mostrarAutocompletar("./ut03/palabras.txt", prefijo);
        }

        if (args.length == 0 || "patrones".equalsIgnoreCase(args[0])) {
            String texto = args.length > 2 ? args[1] : "bananana";
            String patron = args.length > 2 ? args[2] : "ana";
            mostrarBusquedaPatrones(texto, patron);
        }
    }

    public static List<String> autocompletar(Collection<String> palabras, String prefijo) {
        TTrieHashMap<String> trie = new TTrieHashMap<>();
        for (String palabra : palabras) {
            trie.insertar(palabra, palabra);
        }

        List<String> sugerencias = new ArrayList<>();
        for (Entry<String> entrada : trie.predecir(prefijo)) {
            sugerencias.add(entrada.getPalabra());
        }
        return sugerencias;
    }

    public static List<Integer> buscarPatrones(String texto, String patron) {
        TTrieHashMap<String> trie = new TTrieHashMap<>();
        for (int posicion = 0; posicion < texto.length(); posicion++) {
            trie.insertarSufijo(texto.substring(posicion), posicion);
        }
        return trie.buscarPatron(patron);
    }

    private static void mostrarAutocompletar(String archivo, String prefijo) {
        List<String> palabras = new ArrayList<>();
        FileUtils.leerLineas(archivo, palabras::add);

        List<String> sugerencias = autocompletar(palabras, prefijo);
        System.out.println("Autocompletar para '" + prefijo + "':");
        for (String sugerencia : sugerencias) {
            System.out.println("- " + sugerencia);
        }
    }

    private static void mostrarBusquedaPatrones(String texto, String patron) {
        List<Integer> posiciones = buscarPatrones(texto, patron);
        System.out.println("Patron '" + patron + "' en '" + texto + "': " + posiciones);
    }
}