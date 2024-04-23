# Contador Primos Bridge

candidato: Leonardo Seishi Yamazaki

Este projeto é uma aplicação web simples que calcula e exibe todos os números primos menores que um número \( k \) fornecido pelo usuário.

## Funcionalidades

- Cálculo eficiente de números primos usando o algoritmo Crivo de Eratóstenes.
- Interface de usuário intuitiva e responsiva.
- Histórico de cálculos realizados pelo usuário.

## Tecnologias Utilizadas

- **Front-end**: React
- **Back-end**: Java com Spring Boot
- **Estilização**: CSS3

## Pré-requisitos

Para executar este projeto, você precisará ter o seguinte instalado:

- Node.js e npm (para o front-end React)
- Java JDK 17(para o back-end Spring Boot)
- Maven (para gerenciamento de dependências e construção do projeto Java)

## Configuração Local

Siga as etapas abaixo para configurar o projeto localmente.

### Configuração do Back-end

1. Navegue até o diretório `backend` do projeto.
2. Inicie o servidor Spring Boot com `mvn spring-boot:run`.

### Configuração do Front-end

1. Navegue até o diretório `frontend` do projeto.
2. Inicie a aplicação React com `npm start`.

O aplicativo front-end agora estará acessível em `http://localhost:3000`.

## Uso

Para usar o aplicativo, siga estas etapas:

1. Insira um número inteiro positivo \( k \) no campo de entrada.
2. Clique em `Calcular` para ver a quantidade e a lista de números primos menores que \( k \).
3. O histórico de cálculos anteriores é mostrado à esquerda da tela.

obs. Acesse `http://localhost:8080/api/countPrimos?k=10` para ver a api em ação.

