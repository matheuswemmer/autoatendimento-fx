# Auto Atendimento JavaFX

Sistema de autoatendimento desenvolvido em JavaFX para simular o fluxo de pedidos de um restaurante. A aplicacao permite visualizar o cardapio, adicionar e remover produtos do carrinho, finalizar o pedido, acompanhar o preparo na cozinha e iniciar um novo atendimento depois da entrega.

## Objetivos

- Organizar um cardapio com comidas e bebidas.
- Permitir que o cliente monte um carrinho de compras.
- Registrar o pedido ao finalizar o carrinho.
- Enviar o pedido para a tela da cozinha.
- Controlar o status do pedido: em preparo, pronto e entregue.
- Manter os pedidos entregues visiveis no final da tela da cozinha.
- Permitir iniciar um novo pedido com o cardapio zerado.

## Tecnologias

- Java 21
- JavaFX 21
- Maven
- FXML para as telas

## Como executar

Com Java 21 e Maven instalados, execute na pasta do projeto:

```bash
mvn clean javafx:run
```

## Estrutura principal

```text
src/main/java/com/example
├── App.java
├── controller
│   ├── CardapioController.java
│   ├── CarrinhoController.java
│   ├── CarrinhoItemController.java
│   ├── CozinhaController.java
│   ├── PedidoCardController.java
│   └── ProdutoCardController.java
└── model
    ├── Bebida.java
    ├── Cardapio.java
    ├── Carrinho.java
    ├── Comida.java
    ├── Cozinha.java
    ├── Pedido.java
    └── Produto.java
```

## Componentes principais

- `Produto`: classe base para os itens do cardapio.
- `Comida` e `Bebida`: especializacoes de `Produto`, com atributos especificos.
- `Cardapio`: mantem a lista de produtos disponiveis.
- `Carrinho`: controla os produtos escolhidos e finaliza o pedido.
- `Pedido`: representa um pedido com itens, valor total, identificador e status.
- `Cozinha`: armazena pedidos em andamento e pedidos entregues.
- Controllers JavaFX: conectam as telas FXML ao comportamento da aplicacao.

## Fluxo do sistema

1. O usuario visualiza o cardapio.
2. Os produtos sao adicionados ao carrinho.
3. Ao finalizar, o carrinho cria um pedido e envia para a cozinha.
4. A tela da cozinha permite avancar o status do pedido.
5. Quando o pedido e entregue, ele aparece na lista de pedidos entregues.
6. O botao "Novo Pedido" retorna ao cardapio com o carrinho zerado.

## Decisoes de modelagem

- `Produto` foi definido como classe abstrata para concentrar dados comuns, como nome, valor e descricao.
- `Comida` e `Bebida` herdam de `Produto` para representar tipos diferentes de itens do cardapio.
- `Carrinho` usa uma estrutura `Map<Produto, Integer>` para associar cada produto a sua quantidade.
- Ao finalizar o carrinho, os itens sao copiados antes da limpeza para preservar os dados do pedido.
- `Pedido` possui um enum `Status` para controlar os estados possiveis.
- `Cozinha` separa pedidos ativos dos pedidos entregues, mantendo o historico visivel na tela.
