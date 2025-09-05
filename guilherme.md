```mermaid
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
