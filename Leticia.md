```mermaid
classDiagram
    class Produto {
        +id: int
        +nome: string
        +preco: float
        +quantidadeEstoque: int
        +Preco(): float
        +Estoque(quantidade: int): void
    }

    class Instrumento {
        +marca: string
        +modelo: string
        +anoFabricacao: int
        +getMarca(): string
        +getDetalhes(): string
    }
    
    class Acessorio {
        +funcao: string
        +aplicarAcessorio(): void
    }

    Produto --|> Instrumento
    Produto --|> Acessorio
    
    class Cordas {
        +cordasFriccionadas: string
        +cordasBeliscadas: string
        +cordasPercutidas: string
    }

    class Metais {
        +varaTelescópica: string
        +valvulas : string
    }

    class Percussao {
        +idiofones:: string
        +membranofones: string
        +cordofones: string
        +aerofones: string
        
   }
 Instrumento --|> Cordas
    Instrumento --|> Metais
    Instrumento --|> Percussao
 
