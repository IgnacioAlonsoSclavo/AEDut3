package ucu.edu.aed.ejercicio16;

public class Ejercicio16Main {

    public static void main(String[] args) {
        ArbolGenealogico arbol = construirEjemplo();

        System.out.println("Total personas: " + arbol.cantidadTotalPersonas());
        System.out.println("Altura: " + arbol.altura());
        System.out.println("Descendientes de Abuela: " + arbol.listarDescendientes(new Persona("Abuela", 1940)));
        System.out.println("Generacion 1: " + arbol.obtenerGeneracion(1));
        System.out.println("Generacion 2: " + arbol.obtenerGeneracion(2));
        System.out.println("Ancestro comun de Diego e Ines: " + arbol.ancestroComunMasCercano(new Persona("Diego", 1990), new Persona("Ines", 1997)));
        System.out.println("Diego es descendiente de Ana: " + arbol.esDescendiente(new Persona("Diego", 1990), new Persona("Ana", 1965)));
    }

    public static ArbolGenealogico construirEjemplo() {
        Persona abuela = new Persona("Abuela", 1940);
        Persona ana = new Persona("Ana", 1965);
        Persona bruno = new Persona("Bruno", 1968);
        Persona carla = new Persona("Carla", 1970);
        Persona diego = new Persona("Diego", 1990);
        Persona elena = new Persona("Elena", 1992);
        Persona fabio = new Persona("Fabio", 1991);
        Persona gisela = new Persona("Gisela", 1993);
        Persona hugo = new Persona("Hugo", 1995);
        Persona ines = new Persona("Ines", 1997);

        ArbolGenealogico arbol = new ArbolGenealogico(abuela);
        arbol.agregarHijo(abuela, ana);
        arbol.agregarHijo(abuela, bruno);
        arbol.agregarHijo(abuela, carla);
        arbol.agregarHijo(ana, diego);
        arbol.agregarHijo(ana, elena);
        arbol.agregarHijo(bruno, fabio);
        arbol.agregarHijo(bruno, gisela);
        arbol.agregarHijo(carla, hugo);
        arbol.agregarHijo(carla, ines);
        return arbol;
    }
}