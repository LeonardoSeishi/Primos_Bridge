package com.desafiobridge.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ControladorContadorDePrimos {

    //Algoritmo crivo de Eratóstenes, eficiente para listar todos os números primos até k
    @GetMapping("/api/countPrimos")
    public RespostaPrimos contarPrimos(@RequestParam int k) {
        long tempoInicio = System.currentTimeMillis();
        boolean[] ehPrimo = new boolean[k];
        List<Integer> primos = new ArrayList<>();

        if (k >= 2) {
            Arrays.fill(ehPrimo, true);
            ehPrimo[0] = ehPrimo[1] = false;

            for (int i = 2; i < k; i++) {
                if (ehPrimo[i]) {
                    primos.add(i);
                    for (int j = i * i; j < k; j += i) {
                        ehPrimo[j] = false;
                    }
                }
            }
        }

        long tempoFim = System.currentTimeMillis();
        return new RespostaPrimos(primos.size(), primos, tempoFim - tempoInicio);
    }

    static class RespostaPrimos {
        private final int quantidadePrimos;
        private final List<Integer> primos;
        private final long tempoDecorrido;

        public RespostaPrimos(int quantidadePrimos, List<Integer> primos, long tempoDecorrido) {
            this.quantidadePrimos = quantidadePrimos;
            this.primos = primos;
            this.tempoDecorrido = tempoDecorrido;
        }

        public int getQuantidadePrimos() {
            return quantidadePrimos;
        }

        public List<Integer> getPrimos() {
            return primos;
        }

        public long getTempoDecorrido() {
            return tempoDecorrido;
        }
    }
}
