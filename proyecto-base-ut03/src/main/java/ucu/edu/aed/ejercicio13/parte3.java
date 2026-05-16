package ucu.edu.aed.ejercicio13;

import java.util.HashSet;

public class parte3 {
    static class Alumno {
        private int id;
        private String fullName;
        private String email;


        public Alumno(int id, String fullName, String email) {
            this.id= id;
            this.fullName = fullName;
            this.email = email;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;                          // nunca igual a null
            if (this == obj) return true;                           // mismo objeto en memoria
            if (this.getClass() != obj.getClass()) return false;    // disntinto tipo
            Alumno otro = (Alumno) obj;                             // casteo el tipo 
            return this.id == otro.id;                              // comapra solo por id
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(this.id);   // igual al equals
        }
    }

    public static void main(String[] args) {
        
        Alumno a1 = new Alumno(1, "Juan Pérez",   "juan@ucu.edu.uy");
        Alumno a2 = new Alumno(1, "Juan Pérez",   "otro@ucu.edu.uy"); // mismo id, email distinto
        Alumno a3 = new Alumno(2, "María García", "maria@ucu.edu.uy");

        System.out.println("- equals: ");
        System.out.println(a1.equals(a2)); // true -> mismo id
        System.out.println(a1.equals(a3));   // false -> distinto id
        System.out.println(a1.equals(null)); // false (duh)

        System.out.println("\n- hashCode (deberia ser igual que equals): ");
        System.out.println(a1.hashCode() == a2.hashCode()); // true -> obligatorio por contrato
        System.out.println(a1.hashCode() == a3.hashCode()); // flase
 
    }

}

/* 
# Indica qué características deben tener las implementaciones de los métodos solicitados para
mantener el contrato general para el método hashCode.

1. Consistencia con equals.
2. para un mismo objeto, hashCode() debe devolver siempre el mismo valor durante su ejecución, 
siempre que los campos usados en el cálculo no cambien. (Por eso usamos id). 
3. Dos objetos pueden tener el mismo hashCode y ser diferentes. (están colisionando).

*/
