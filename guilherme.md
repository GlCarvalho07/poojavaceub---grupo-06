```mermaid
classDiagram

class Usuario {
  -String nome
  -String email
  -String senha
  -criar() String.md
+getUsuario () : mudar senha
+getUsuario () : recuperar senha
}

class Cliente {
  -String endereco
  -String telefone

}

class Funcionário {
  -String cargo
-String Nome
-String CPF
  -Double salario
+ getFuncionario() : registra
+ getFuncionario() : id
+ getFuncionario() : Nome
+ getFuncionario() : cargo
+ getFuncionario() : CPF
+ getFuncionario() : fazer pedido
+ getFuncionario() : fazer venda
+ getFuncionario() : cancelar pedido
+ getFuncionario() : cancelar venda
}

Cliente --|> Usuario
Funcionário --|> Usuario
