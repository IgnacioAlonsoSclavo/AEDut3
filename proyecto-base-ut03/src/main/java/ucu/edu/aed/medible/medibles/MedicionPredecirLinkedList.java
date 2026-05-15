package ucu.edu.aed.medible.medibles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ucu.edu.aed.medible.lib.Medible;

public class MedicionPredecirLinkedList extends Medible<List<String>> {

    private final LinkedList<String> list;
    private final String prefijo;
    private List<String> resultado = new ArrayList<>();

    public MedicionPredecirLinkedList(LinkedList<String> list, String prefijo) {
        this.list = list;
        this.prefijo = prefijo;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        for (int i = 0; i < repeticiones; i++) {
            resultado = new ArrayList<>();
            for (String palabra : list) {
                if (palabra.startsWith(prefijo)) {
                    resultado.add(palabra);
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.resultado;
    }
}
