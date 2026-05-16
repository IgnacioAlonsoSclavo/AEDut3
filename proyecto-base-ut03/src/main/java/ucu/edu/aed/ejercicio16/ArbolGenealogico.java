package ucu.edu.aed.ejercicio16;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ArbolGenealogico {

    private final NodoFamilia raiz;

    public ArbolGenealogico(Persona ancestroComun) {
        this.raiz = new NodoFamilia(ancestroComun);
    }

    public Persona getRaiz() {
        return raiz.getPersona();
    }

    public boolean agregarHijo(Persona padre, Persona hijo) {
        NodoFamilia nodoPadre = buscarNodo(raiz, padre);
        if (nodoPadre == null) {
            return false;
        }
        if (buscarNodo(raiz, hijo) != null) {
            return false;
        }
        nodoPadre.agregarHijo(new NodoFamilia(hijo));
        return true;
    }

    public List<Persona> listarDescendientes(Persona persona) {
        NodoFamilia nodo = buscarNodo(raiz, persona);
        List<Persona> resultado = new ArrayList<>();
        if (nodo == null) {
            return resultado;
        }
        for (NodoFamilia hijo : nodo.getHijos()) {
            recolectarDescendientes(hijo, resultado);
        }
        return resultado;
    }

    public int altura() {
        return altura(raiz);
    }

    public int cantidadTotalPersonas() {
        return contarNodos(raiz);
    }

    public List<Persona> obtenerGeneracion(int generacion) {
        List<Persona> resultado = new ArrayList<>();
        if (generacion < 0) {
            return resultado;
        }

        Deque<NodoNivel> cola = new ArrayDeque<>();
        cola.addLast(new NodoNivel(raiz, 0));

        while (!cola.isEmpty()) {
            NodoNivel actual = cola.removeFirst();
            if (actual.nivel == generacion) {
                resultado.add(actual.nodo.getPersona());
            }
            if (actual.nivel > generacion) {
                break;
            }
            for (NodoFamilia hijo : actual.nodo.getHijos()) {
                cola.addLast(new NodoNivel(hijo, actual.nivel + 1));
            }
        }

        return resultado;
    }

    public Persona ancestroComunMasCercano(Persona una, Persona otra) {
        List<Persona> caminoUna = caminoHasta(raiz, una, new LinkedList<>());
        List<Persona> caminoOtra = caminoHasta(raiz, otra, new LinkedList<>());
        if (caminoUna == null || caminoOtra == null) {
            return null;
        }

        int limite = Math.min(caminoUna.size(), caminoOtra.size());
        Persona ultimoComun = null;
        for (int i = 0; i < limite; i++) {
            if (caminoUna.get(i).equals(caminoOtra.get(i))) {
                ultimoComun = caminoUna.get(i);
            } else {
                break;
            }
        }
        return ultimoComun;
    }

    public boolean esDescendiente(Persona descendiente, Persona ancestro) {
        NodoFamilia nodoAncestro = buscarNodo(raiz, ancestro);
        if (nodoAncestro == null) {
            return false;
        }
        if (ancestro.equals(descendiente)) {
            return false;
        }
        return buscarNodo(nodoAncestro, descendiente) != null;
    }

    private NodoFamilia buscarNodo(NodoFamilia actual, Persona buscada) {
        if (actual.getPersona().equals(buscada)) {
            return actual;
        }
        for (NodoFamilia hijo : actual.getHijos()) {
            NodoFamilia encontrado = buscarNodo(hijo, buscada);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }

    private void recolectarDescendientes(NodoFamilia actual, List<Persona> resultado) {
        resultado.add(actual.getPersona());
        for (NodoFamilia hijo : actual.getHijos()) {
            recolectarDescendientes(hijo, resultado);
        }
    }

    private int altura(NodoFamilia actual) {
        if (actual.getHijos().isEmpty()) {
            return 0;
        }
        int maximo = 0;
        for (NodoFamilia hijo : actual.getHijos()) {
            maximo = Math.max(maximo, 1 + altura(hijo));
        }
        return maximo;
    }

    private int contarNodos(NodoFamilia actual) {
        int total = 1;
        for (NodoFamilia hijo : actual.getHijos()) {
            total += contarNodos(hijo);
        }
        return total;
    }

    private List<Persona> caminoHasta(NodoFamilia actual, Persona buscada, List<Persona> camino) {
        camino.add(actual.getPersona());
        if (actual.getPersona().equals(buscada)) {
            return new ArrayList<>(camino);
        }

        for (NodoFamilia hijo : actual.getHijos()) {
            List<Persona> encontrado = caminoHasta(hijo, buscada, camino);
            if (encontrado != null) {
                return encontrado;
            }
        }

        camino.remove(camino.size() - 1);
        return null;
    }

    private static class NodoNivel {
        private final NodoFamilia nodo;
        private final int nivel;

        private NodoNivel(NodoFamilia nodo, int nivel) {
            this.nodo = nodo;
            this.nivel = nivel;
        }
    }
}