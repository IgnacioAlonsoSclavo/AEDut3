package ucu.edu.aed.tda.generic_trie;

import java.util.function.Consumer;

public class ArbolGenerico implements TArbolGenerico {
    @Override
    public boolean agregarHijo(Comparable padre, Comparable hijo) {
        return false;
    }

    @Override
    public void eliminar(Comparable criterio) {

    }

    @Override
    public Comparable obtenerPadre(Comparable criterio) {
        return null;
    }

    @Override
    public Comparable buscar(Comparable criterio) {
        return null;
    }

    @Override
    public void preOrden(Consumer consumidor) {

    }

    @Override
    public void inOrden(Consumer consumidor) {

    }

    @Override
    public void postOrden(Consumer consumidor) {

    }

    @Override
    public void vaciar() {

    }

    @Override
    public int grado(Comparable nodo) {
        return 0;
    }

    @Override
    public int altura(Comparable nodo) {
        return 0;
    }
}
