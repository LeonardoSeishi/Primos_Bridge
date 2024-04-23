package com.desafiobridge.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// Ajudar com o requisito bonus (Defina limites e validacoes para que a aplicacao nao apresente erros)
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ControladorContadorDePrimos {

    // algoritmo crivo de Eratostenes, eficiente para listar todos os numeros primos ate k
    @GetMapping("/api/countPrimos")
    public RespostaPrimos contarPrimos(@RequestParam("k") Integer k) {  // assegurar que o número k é inteiro
        long tempo_inicio = System.currentTimeMillis();     // começar a contar o tempo de execução
        boolean[] primo = new boolean[k];                   // lista de boleanos para verificar se e ou nao primo
        List<Integer> lista_primos = new ArrayList<>();     // lista dos numero primos para mostrar o resultado

        if (k == null || k < 1 || k > 99999) {              // Gerar Exception caso k seja um numero invalido
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor de k inválido.");
        }

        // listar todos os numeros como primos
        Arrays.fill(primo, true);
        // marcar 0 e 1 como não primos
        primo[0] = false;
        primo[1] = false;

        for (int i = 2; i < k; i++) {
            if (primo[i]) {                 // verificar se o numero nao foi desclassificado para primo
                lista_primos.add(i);        // adicionar numero na lista de primos
                for (int j = i * i; j < k; j += i) {    // desclassificar os numeros multiplos de i (mod(sqrt(k) >= i >= 2)
                    primo[j] = false;
                }
            }
        }

        long tempo_final = System.currentTimeMillis();
        long tempo_total = tempo_final - tempo_inicio;
        return new RespostaPrimos(lista_primos.size(), lista_primos, tempo_total);
    }

    // dados da resposta que será enviada e mostrada na interface
    static class RespostaPrimos {
        private final int quantidade_primos;
        private final List<Integer> primos;
        private final long tempo_total;

        public RespostaPrimos(int quantidade_primos, List<Integer> primos, long tempo_total) {
            this.quantidade_primos = quantidade_primos;
            this.primos = primos;
            this.tempo_total = tempo_total;
        }

        public int getQuantidadePrimos() {
            return quantidade_primos;
        }

        public List<Integer> getPrimos() {
            return primos;
        }

        public long getTempoTotal() {
            return tempo_total;
        }
    }
}
