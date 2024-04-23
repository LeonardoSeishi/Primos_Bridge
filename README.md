# Contador Primos Bridge

candidato: Leonardo Seishi Yamazaki

Este projeto é uma aplicação web simples que calcula e exibe todos os números primos menores que um número \( k \) fornecido pelo usuário.

## Funcionalidades

- Cálculo de números primos usando o algoritmo Crivo de Eratóstenes.
- Interface de usuário.
- Histórico de cálculos.

## Tecnologias Utilizadas

- **Front-end**: React
- **Back-end**: Java com Spring Boot 3.2.5 (Spring Inializr)
- **Estilização**: CSS3

## Pré-requisitos

Para executar este projeto, você precisará ter o seguinte instalado:

- Node.js e npm (para o front-end React)
- Java JDK 17(para o back-end Spring Boot)
- Maven (para construção do projeto Java)

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

## Referências 

1. https://pt.wikipedia.org/wiki/Crivo_de_Erat%C3%B3stenes#:~:text=O%20Crivo%20de%20Erat%C3%B3stenes%20%C3%A9,Biblioteca%20de%20Alexandria%20desde%20247.
2. https://www.w3schools.com/css/
3. https://spring.io/projects/spring-boot
4. https://css-tricks.com/snippets/css/a-guide-to-flexbox/
5. https://spring.io/guides/gs/serving-web-content
6. https://spring.io/guides/gs/spring-boot

Diversos vídeos foram assistidos, para me ajudar com tecnologias que eu não conhecia anteriormente.
Como por exemplo, criar um projeto usando spring boot e a integração do front e o back-end em um projeto full-stack.



