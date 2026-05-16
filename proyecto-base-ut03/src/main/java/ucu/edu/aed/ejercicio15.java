package ucu.edu.aed;
import java.util.HashSet;
import java.util.Objects;

public class ejercicio15 {

    static class Libro {
        private String isbn;
        private String titulo;
        private String autor;
        private int anio;

        public Libro(String isbn, String titulo, String autor, int anio) {
            this.isbn = isbn;
            this.titulo = titulo;
            this.autor = autor;
            this.anio = anio;
        }


        /*
        1. Se usa el ISBN porque es único para cada libro.
        2.
        */
        @Override
        public boolean equals (Object obj){
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Libro otro = (Libro) obj;
            return Objects.equals(this.isbn, otro.isbn);
        }

        @Override
        public int hashCode () {
            return Objects.hash(isbn);
        }

        @Override
        public String toString () {
            return "Libro{isbn='" + isbn + "', titulo='" + titulo + "'}";
        }

        public String getIsbn () {
            return isbn;
        }

        public String getTitulo () {
            return titulo;
        }
        /* 3. El problema es que se evaluan distintas coasas,es decir dos libros con mismo ISBN pero distinto
         titulo tendrían hashCodes diferentes y no los podrias identificar como duplicados, ademas se rompe el contrato.
         */
    }


    /* 4. */
    public static void main(String[] args) {
        Libro libro1 = new Libro("777", "los picapiedras", "juan", 2026);
        Libro libro2 = new Libro("777", "los picapiedras", "juan", 2026);

        HashSet<Libro> set = new HashSet<>();
        set.add(libro1);
        set.add(libro2); // no debería agregarse si equals/hashCode están bien

        System.out.println(set.size()); //deberia ser 1
        System.out.println(set); //contenido del set

/*
5. Con el hashcode correceto:
- libro1.hashCode() == libro2.hashCode() Se cumple
- libro1.equals(libro2) == true
entonces el hashset detecta que hay 2 libros iguales y no lo agrega
- se cumple que set.size() == 1
*/
        System.out.println(libro1.equals(libro2));
        System.out.println(libro1.hashCode() == libro2.hashCode());

/*
6. casos de prueba:
*/
        System.out.println("un libro es igual a sí mismo " + libro1.equals(libro1));

        System.out.println("si a.equals(b) entonces b.equals(a) " + libro2.equals(libro1));

        Libro libro3 = new Libro("1930", "Uruguay campeon del mundo", "Fifa", 1930);
        System.out.println("Libros diferentes (distinto ISBN) " + libro1.equals(libro3));

        System.out.println("comparar con null " + libro1.equals(null));

        HashSet<Libro> set2 = new HashSet<>();
        set2.add(libro1);
        set2.add(libro2);
        set2.add(libro3);
        System.out.println("hashSet rechaza duplicado, set con 2 iguales y 1 distinto, size (deberia ser 2): " + set2.size());

        Libro libro4 = new Libro("978-0-13-468599-1", "titulo distinto", "autor distinto", 2020);
        System.out.println("mismo ISBN que libro 1 y 2, diferente titulo. Debe ser true porque la identidad es por ISBN " + libro1.equals(libro4));

    }
}