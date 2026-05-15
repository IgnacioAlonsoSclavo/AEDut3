package ucu.edu.aed.tda.trie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class TNodoTrieHashMap<T> implements TNodoTrie<T>, Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<Character, TNodoTrieHashMap<T>> hijos = new HashMap<>();
    private boolean esPalabra = false;
    private T dato = null;
    private final List<Integer> posiciones = new ArrayList<>();

    @Override
    public void recorrer(Consumer<Entry<T>> consumer) {
        recorrerInterno(new StringBuilder(), consumer);
    }

    private void recorrerInterno(StringBuilder prefijo, Consumer<Entry<T>> consumer) {
        if (esPalabra) {
            consumer.accept(new Entry<>(dato, true, prefijo.toString()));
        }

        List<Character> claves = new ArrayList<>(hijos.keySet());
        Collections.sort(claves);
        for (Character clave : claves) {
            prefijo.append(clave);
            hijos.get(clave).recorrerInterno(prefijo, consumer);
            prefijo.deleteCharAt(prefijo.length() - 1);
        }
    }

    @Override
    public Entry<T> buscar(String palabra) {
        TNodoTrieHashMap<T> actual = this;
        for (char caracter : palabra.toCharArray()) {
            actual = actual.hijos.get(caracter);
            if (actual == null) {
                return null;
            }
        }
        return new Entry<>(actual.dato, actual.esPalabra, palabra);
    }

    @Override
    public boolean insertar(String palabra, T dato) {
        TNodoTrieHashMap<T> actual = this;
        for (char caracter : palabra.toCharArray()) {
            actual = actual.hijos.computeIfAbsent(caracter, clave -> new TNodoTrieHashMap<>());
        }

        boolean eraNuevaPalabra = !actual.esPalabra;
        actual.esPalabra = true;
        actual.dato = dato;
        return eraNuevaPalabra;
    }

    @Override
    public List<Entry<T>> predecir(String prefijo) {
        TNodoTrieHashMap<T> actual = this;
        for (char caracter : prefijo.toCharArray()) {
            actual = actual.hijos.get(caracter);
            if (actual == null) {
                return Collections.emptyList();
            }
        }

        List<Entry<T>> resultado = new ArrayList<>();
        actual.recolectar(prefijo, resultado);
        return resultado;
    }

    private void recolectar(String prefijo, List<Entry<T>> resultado) {
        if (esPalabra) {
            resultado.add(new Entry<>(dato, true, prefijo));
        }

        List<Character> claves = new ArrayList<>(hijos.keySet());
        Collections.sort(claves);
        for (Character clave : claves) {
            hijos.get(clave).recolectar(prefijo + clave, resultado);
        }
    }

    public void insertarSufijo(String sufijo, int posicion) {
        TNodoTrieHashMap<T> actual = this;
        for (char caracter : sufijo.toCharArray()) {
            actual = actual.hijos.computeIfAbsent(caracter, clave -> new TNodoTrieHashMap<>());
            actual.posiciones.add(posicion);
        }
    }

    public List<Integer> buscarPatron(String patron) {
        TNodoTrieHashMap<T> actual = this;
        for (char caracter : patron.toCharArray()) {
            actual = actual.hijos.get(caracter);
            if (actual == null) {
                return Collections.emptyList();
            }
        }
        return new ArrayList<>(actual.posiciones);
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public boolean esPalabra() {
        return esPalabra;
    }
}