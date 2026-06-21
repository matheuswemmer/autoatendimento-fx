# AutoAtendimento FX

## Descrição

O AutoAtendimento FX é um sistema de autoatendimento desenvolvido em JavaFX para simular o fluxo de pedidos de um restaurante. A aplicação permite visualizar um cardápio digital, adicionar e remover produtos do carrinho, finalizar pedidos e acompanhar o processo de preparação dos pedidos na cozinha.

O sistema foi desenvolvido aplicando conceitos de Programação Orientada a Objetos (POO), arquitetura MVC (Model-View-Controller) e desenvolvimento de interfaces gráficas com JavaFX e FXML.

---

## Objetivos

- Organizar um cardápio contendo comidas e bebidas.
- Permitir que o cliente monte um carrinho de compras.
- Registrar um pedido ao finalizar o carrinho.
- Enviar o pedido para a tela da cozinha.
- Controlar os status do pedido durante o preparo.
- Manter o histórico de pedidos entregues visível.
- Permitir iniciar um novo atendimento após a conclusão de um pedido.

---

## Tecnologias Utilizadas

- Java 21
- JavaFX 21
- Maven
- FXML
- CSS
- Programação Orientada a Objetos (POO)
- Arquitetura MVC (Model-View-Controller)

---

## Requisitos do Ambiente

Antes de executar o projeto, certifique-se de possuir:

- JDK 21 ou superior
- Maven 3.9 ou superior
- JavaFX 21
- Sistema Operacional Windows, Linux ou macOS
- IDE compatível com Java (VS Code, IntelliJ IDEA ou Eclipse)

---

## Estrutura Principal do Projeto

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

---

## Componentes Principais

### Produto

Classe abstrata que representa um item do cardápio. Possui atributos comuns como nome, descrição e valor.

### Comida

Especialização da classe Produto destinada aos alimentos disponíveis no cardápio.

### Bebida

Especialização da classe Produto destinada às bebidas disponíveis no cardápio.

### Cardápio

Responsável por armazenar e disponibilizar os produtos para visualização dos clientes.

### Carrinho

Gerencia os produtos selecionados pelo cliente, suas quantidades e o cálculo do valor total do pedido.

### Pedido

Representa um pedido finalizado, contendo seus produtos, quantidades, valor total, identificador e status.

### Cozinha

Responsável por armazenar os pedidos recebidos, controlar seu andamento e manter o histórico dos pedidos entregues.

### Controllers JavaFX

Realizam a comunicação entre as telas FXML e as regras de negócio do sistema.

- CardapioController
- ProdutoCardController
- CarrinhoController
- CarrinhoItemController
- CozinhaController
- PedidoCardController

---

## Fluxo do Sistema

1. O usuário visualiza o cardápio.
2. Os produtos são adicionados ao carrinho.
3. O carrinho calcula automaticamente o valor total.
4. O usuário finaliza o pedido.
5. O pedido é enviado para a cozinha.
6. A cozinha acompanha e atualiza o status do pedido.
7. O pedido passa pelos estados:
   - EM_PREPARO
   - PRONTO
   - ENTREGUE
8. Após a entrega, o pedido permanece visível no histórico.
9. O botão "Novo Pedido" inicia um novo atendimento com o carrinho vazio.

---

## Como Executar

### Clonar o Repositório

```bash
git clone https://github.com/matheuswemmer/autoatendimento-fx.git
```

### Acessar a Pasta do Projeto

```bash
cd autoatendimento-fx
```

### Executar o Sistema

```bash
mvn clean javafx:run
```

### Gerar o Pacote da Aplicação

```bash
mvn clean package
```

Os arquivos gerados serão disponibilizados na pasta:

```text
target/
```

---

## Testes Funcionais

### Teste 1 – Exibição do Cardápio

**Objetivo:** Verificar se os produtos cadastrados são exibidos corretamente.

**Passos:**
1. Executar o sistema.
2. Abrir a tela principal.

**Resultado Esperado:** Todos os produtos cadastrados devem ser exibidos no cardápio.

**Resultado Obtido:** Sucesso.

---

### Teste 2 – Adição de Produtos ao Carrinho

**Objetivo:** Validar a inclusão de produtos no carrinho.

**Passos:**
1. Selecionar um produto.
2. Clicar em "Adicionar".

**Resultado Esperado:** O produto deve aparecer no carrinho com quantidade igual a 1.

**Resultado Obtido:** Sucesso.

---

### Teste 3 – Alteração de Quantidade

**Objetivo:** Verificar o aumento e redução das quantidades dos produtos.

**Passos:**
1. Adicionar um produto ao carrinho.
2. Utilizar os controles de incremento e decremento.

**Resultado Esperado:** A quantidade deve ser atualizada corretamente.

**Resultado Obtido:** Sucesso.

---

### Teste 4 – Remoção de Produto

**Objetivo:** Validar a remoção de produtos do carrinho.

**Passos:**
1. Adicionar um produto.
2. Removê-lo do carrinho.

**Resultado Esperado:** O produto deve desaparecer da lista de itens.

**Resultado Obtido:** Sucesso.

---

### Teste 5 – Cálculo do Valor Total

**Objetivo:** Verificar o cálculo automático do valor do pedido.

**Passos:**
1. Adicionar diferentes produtos.
2. Conferir o valor total apresentado.

**Resultado Esperado:** A soma deve corresponder à soma dos valores dos produtos multiplicados pelas respectivas quantidades.

**Resultado Obtido:** Sucesso.

---

### Teste 6 – Finalização do Pedido

**Objetivo:** Verificar a criação de um pedido.

**Passos:**
1. Adicionar produtos ao carrinho.
2. Finalizar o pedido.

**Resultado Esperado:** O pedido deve ser enviado para a cozinha e removido do carrinho.

**Resultado Obtido:** Sucesso.

---

### Teste 7 – Atualização de Status

**Objetivo:** Validar a mudança de status dos pedidos.

**Passos:**
1. Acessar a tela da cozinha.
2. Alterar o status de um pedido.

**Resultado Esperado:** O pedido deve seguir a sequência:

EM_PREPARO → PRONTO → ENTREGUE

**Resultado Obtido:** Sucesso.

---

### Teste 8 – Histórico de Pedidos Entregues

**Objetivo:** Verificar a manutenção do histórico.

**Passos:**
1. Entregar um pedido.
2. Verificar a lista de pedidos concluídos.

**Resultado Esperado:** O pedido deve permanecer visível na área de histórico.

**Resultado Obtido:** Sucesso.

---

### Teste 9 – Novo Pedido

**Objetivo:** Validar o reinício do atendimento.

**Passos:**
1. Finalizar um pedido.
2. Clicar em "Novo Pedido".

**Resultado Esperado:** O sistema deve retornar ao cardápio com o carrinho vazio.

**Resultado Obtido:** Sucesso.

---

## Decisões de Modelagem

- A classe Produto foi definida como abstrata para centralizar atributos e comportamentos comuns.
- As classes Comida e Bebida utilizam herança para especialização dos produtos.
- O Carrinho utiliza uma estrutura `Map<Produto, Integer>` para armazenar produtos e quantidades.
- Os itens do carrinho são copiados para o Pedido antes da limpeza do carrinho, garantindo a integridade dos dados.
- O Pedido utiliza uma enumeração `Status` para controlar os estados possíveis.
- A Cozinha mantém listas separadas para pedidos ativos e pedidos entregues.
- A arquitetura MVC foi adotada para promover desacoplamento e facilitar a manutenção do sistema.

---

## Autores

- Matheus Wemmer
- Jonas Silveira de Avila
