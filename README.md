# Primos_Bridge

# Projeto Contador de Números Primos

## Descrição
Este projeto é uma aplicação Spring Boot que fornece uma API para calcular a quantidade de números primos menores que um número dado `k`.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para facilitar o bootstrapping e desenvolvimento de novas aplicações Spring.
- **Java**: Linguagem de programação utilizada.

## Como Executar
1. Clone o repositório.
2. Navegue até o diretório do projeto.
3. Execute o comando `./mvnw spring-boot:run` para iniciar o servidor.
4. Acesse `http://localhost:8080/api/countPrimos?k=10` para ver a aplicação em ação.

## Endpoints
- `/api/countPrimos?k=10`: Retorna a quantidade de números primos menores que 10 e a lista desses números.
