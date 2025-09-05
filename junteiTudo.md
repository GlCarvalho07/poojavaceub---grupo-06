
```mermaid
classDiagram
    class Produto {
        -id: int
        -nome: string
        -preco: float
        -quantidadeEstoque: int
        +Preco(): float
        +Estoque(quantidade: int): void
    }

    class Instrumento {
        -marca: string
        -modelo: string
        -anoFabricacao: int
        +getMarca(): string
        +getDetalhes(): string
    }
    
    class Acessorio {
        -funcao: string
        +aplicarAcessorio(): void
    }

    Produto --|> Instrumento
    Produto --|> Acessorio
    
    class Cordas {
        -cordasFriccionadas: string
        -cordasBeliscadas: string
        -cordasPercutidas: string
    }

    class Metais {
        -varaTelescópica: string
        -valvulas : string
    }

    class Percussao {
        -idiofones:: string
        -membranofones: string
        -cordofones: string
        -aerofones: string
        
   }
 Instrumento --|> Cordas
    Instrumento --|> Metais
    Instrumento --|> Percussao


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


classDiagram

class Usuario {
  -String nome
  -String email
  -String senha
  +criar() Usuario.md
}

class Cliente {
  -String endereco
  -String telefone
}

class Funcionário {
  +String cargo
  -Double salario
}

Cliente --|> Usuario
Funcionário --|> Usuario
