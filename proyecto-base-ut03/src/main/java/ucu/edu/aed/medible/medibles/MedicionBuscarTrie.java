package ucu.edu.aed.medible.medibles;

import java.util.List;

import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.tda.trie.Entry;
import ucu.edu.aed.tda.trie.TTrie;

public class MedicionBuscarTrie extends Medible<List<String>> {

    private final TTrie<String> trie;

    public MedicionBuscarTrie(TTrie<String> trie) {
        this.trie = trie;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : palabras) {
                Entry<String> e = trie.buscar(palabra);
                if (e != null) {

                    if (e.esPalabra()) {
                    }
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.trie;
    }
}
