package ucu.edu.aed.medible.medibles;

import java.util.ArrayList;
import java.util.List;

import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.tda.trie.Entry;
import ucu.edu.aed.tda.trie.TTrie;

public class MedicionPredecirTrie extends Medible<List<String>> {

    private final TTrie<String> trie;
    private final String prefijo;
    private List<String> resultado = new ArrayList<>();

    public MedicionPredecirTrie(TTrie<String> trie, String prefijo) {
        this.trie = trie;
        this.prefijo = prefijo;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        for (int i = 0; i < repeticiones; i++) {
            resultado = new ArrayList<>();
            for (Entry<String> entrada : trie.predecir(prefijo)) {
                resultado.add(entrada.getPalabra());
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.resultado;
    }
}
