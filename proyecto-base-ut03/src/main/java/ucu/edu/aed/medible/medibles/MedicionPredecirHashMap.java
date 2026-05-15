package ucu.edu.aed.medible.medibles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ucu.edu.aed.medible.lib.Medible;

public class MedicionPredecirHashMap extends Medible<List<String>> {

    private final Map<String, String> map;
    private final String prefijo;
    private List<String> resultado = new ArrayList<>();

    public MedicionPredecirHashMap(Map<String, String> map, String prefijo) {
        this.map = map;
        this.prefijo = prefijo;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        for (int i = 0; i < repeticiones; i++) {
            resultado = new ArrayList<>();
            for (String palabra : map.keySet()) {
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
