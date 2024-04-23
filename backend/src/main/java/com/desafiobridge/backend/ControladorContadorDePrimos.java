package com.desafiobridge.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//Ajudar com o requisito bônus (Defina limites e validações para que a aplicação não apresente erros)
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ControladorContadorDePrimos {

    //Algoritmo crivo de Eratóstenes, eficiente para listar todos os números primos até k
    @GetMapping("/api/countPrimos")
    public RespostaPrimos contarPrimos(@RequestParam("k") Integer k) {  //assegurar que o número k é inteiro
        long tempoInicio = System.currentTimeMillis();
        boolean[] ehPrimo = new boolean[k];         //lista de boleanos para verificar se é ou não primo
        List<Integer> primos = new ArrayList<>();   //lista dos número primos para mostrar o resultado

        if (k == null || k < 1 || k > 10000) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor de k inválido.");
        }

        Arrays.fill(ehPrimo, true);         //listar todos os números como primos
        ehPrimo[0] = ehPrimo[1] = false;    //Marcar 0 e 1 como não primos

        for (int i = 2; i < k; i++) {
            if (ehPrimo[i]) {               //verificar se o número não foi desclassificado para primo
                primos.add(i);              //adicionar número na lista de primos
                for (int j = i * i; j < k; j += i) {    //desclassificar os números multiplos de i (mod(sqrt(k) >= i >= 2)
                    ehPrimo[j] = false;
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
