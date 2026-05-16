package ucu.edu.aed.ejercicio13;

public class parte2 {
    public static void main(String[] args) {
        int capacity = 16;
        String[] strings = { "Hola", "HolaMundo", "HashMap", "Colecciones" };

        for (String s : strings) {
            int hash  = s.hashCode();
            int index = hash & (capacity - 1); // le formule
            System.out.println("- " + s + ": hashCode() = " + hash + " | índice = " + index);
        }
    }
}
