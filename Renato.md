```mermaid
classDiagram
  class Venda {
    - id: int
    - data: Date
    - valorTotal: float
    + calcularTotal(): float
    + gerarNotaFiscal(): String
  }

  class Pedido {
    - id: int
    - data: Date
    - status: String
    - cliente : String
    - listaDeProdutos: String
    + confirmarPedido(): void
    + getStatus(): String
  }

  class Fornecedor {
    - id: int
    - nome: String
    - contato: String
    + enviarProduto(): void
    + getNome(): String
  }
  Cliente "1" o-- "*" Venda : realiza
  Venda "1" o-- "*" Produto : inclui
  Funcionario "1" o-- "*" Venda : registra
  Pedido "1" o-- "*" Produto : contém
  Pedido "1" o-- "1" Fornecedor : feito_para
  Venda o-- Pedido
