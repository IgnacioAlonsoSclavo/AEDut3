package ucu.edu.aed.ejercicio16;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

    private final String nombre;
    private final int añoNacimiento;

    public Persona(String nombre, int añoNacimiento) {
        this.nombre = nombre;
        this.añoNacimiento = añoNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    @Override
    public int compareTo(Persona otra) {
        int comparacionNombre = nombre.compareToIgnoreCase(otra.nombre);
        if (comparacionNombre != 0) {
            return comparacionNombre;
        }
        return Integer.compare(añoNacimiento, otra.añoNacimiento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Persona otra = (Persona) obj;
        return añoNacimiento == otra.añoNacimiento && nombre.equalsIgnoreCase(otra.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), añoNacimiento);
    }

    @Override
    public String toString() {
        return nombre + " (" + añoNacimiento + ")";
    }
}