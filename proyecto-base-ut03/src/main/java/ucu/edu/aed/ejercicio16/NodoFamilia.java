package ucu.edu.aed.ejercicio16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodoFamilia {

    private final Persona persona;
    private final List<NodoFamilia> hijos = new ArrayList<>();

    public NodoFamilia(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public List<NodoFamilia> getHijos() {
        return Collections.unmodifiableList(hijos);
    }

    public void agregarHijo(NodoFamilia hijo) {
        hijos.add(hijo);
    }
}