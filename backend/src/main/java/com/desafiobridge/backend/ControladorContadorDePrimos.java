package com.desafiobridge.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
public class ControladorContadorDePrimos {

    //Algoritmo crivo de Eratóstenes, eficiente para listar todos os números primos até k
    @GetMapping("/api/countPrimos")
    public RespostaPrimos contarPrimos(@RequestParam int k) {
        long tempoInicio = System.currentTimeMillis();
        boolean[] ehPrimo = new boolean[k];
        if (k >= 2) {
            Arrays.fill(ehPrimo, true); // Marca todos os números como primos inicialmente
            ehPrimo[0] = ehPrimo[1] = false; // Marca 0 e 1 como não primos

            for (int i = 2; i * i < k; i++) {
                if (ehPrimo[i]) {
                    for (int j = i * i; j < k; j += i) {
                        ehPrimo[j] = false; // Marca os múltiplos de i como não primos
                    }
                }
            }
        }

        int contador = 0;
        for (int i = 0; i < k; i++) {
            if (ehPrimo[i]) contador++;
        }

        long tempoFim = System.currentTimeMillis();
        return new RespostaPrimos(contador, tempoFim - tempoInicio);
    }

    static class RespostaPrimos {
        private final int quantidadePrimos;
        private final long tempoDecorrido;

        public RespostaPrimos(int quantidadePrimos, long tempoDecorrido) {
            this.quantidadePrimos = quantidadePrimos;
            this.tempoDecorrido = tempoDecorrido;
        }

        // Getters
        public int getQuantidadePrimos() {
            return quantidadePrimos;
        }

        public long getTempoDecorrido() {
            return tempoDecorrido;
        }
    }
}
