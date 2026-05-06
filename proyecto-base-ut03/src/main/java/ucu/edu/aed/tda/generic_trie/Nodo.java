package ucu.edu.aed.tda.generic_trie;

import java.util.List;
import java.util.function.Consumer;

public class Nodo<T extends Comparable<T>> implements TNodoGenerico {
    // atributos (pizzarrón):
    Nodo<T>[] hijos;
    boolean esFinPalabra;
    T dato;

    // constructor (con lo del pizzarrón)
    public Nodo(Nodo<T>[] hijos, boolean esFinPalabra, T dato) {
        this.hijos = hijos;
        this.esFinPalabra = esFinPalabra;
        this.dato = dato;
    }

    @Override
    public Comparable getDato() {
        return null;
    }

    @Override
    public boolean agregarHijo(Comparable padre, Comparable hijo) {
        return false;
    }

    @Override
    public TNodoGenerico eliminar(Comparable criterio) {
        return null;
    }

    @Override
    public TNodoGenerico buscar(Comparable criterio) {
        return null;
    }

    @Override
    public TNodoGenerico obtenerPadre(Comparable criterio) {
        return null;
    }

    @Override
    public int altura() {
        return 0;
    }

    @Override
    public int grado() {
        return 0;
    }

    @Override
    public void vaciar() {

    }

    @Override
    public List obtenerHijos() {
        return List.of();
    }

    @Override
    public void postOrden(Consumer consumidor) {

    }

    @Override
    public void inOrden(Consumer consumidor) {

    }

    @Override
    public void preOrden(Consumer consumidor) {

    }
}
