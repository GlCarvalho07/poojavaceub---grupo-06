# poojavaceub---grupo-06
Entregas das atividades de POO ceub

README.md
# Sistema de Gerenciamento CRUD (Java CLI)

Um sistema simples de gerenciamento de dados via Interface de Linha de Comando (CLI), implementado em Java, que utiliza repositórios em memória (ArrayList) para realizar as operações CRUD (Criar, Ler, Atualizar, Deletar) nas entidades: **Funcionário**, **Produto** e **Cliente**.

## Entidades e Funcionalidades

O sistema gerencia as seguintes entidades:

* **Funcionário:** ID, Nome, Salário, Matrícula.
* **Produto:** ID, Nome, Preço, Quantidade em Estoque.
* **Cliente:** ID, Nome, Telefone, E-mail.

Todas as entidades suportam as operações de: **Cadastrar**, **Listar**, **Buscar por ID**, **Atualizar por ID** e **Excluir por ID**.

## Como Executar

Para executar o projeto, você precisará ter o ambiente Java configurado.

### Pré-requisitos

* **Java Development Kit (JDK):** Versão 8 ou superior.

### Compilação e Execução

Assumindo que você tem todos os arquivos `.java` (Main.java, Funcionario.java, Produto.java, Cliente.java, FuncionarioRepositoryMemoria.java, ProdutoRepositoryMemoria.java, ClienteRepositoryMemoria.java) em um único diretório:

1.  **Compile os arquivos:**
    ```bash
    javac *.java
    ```

2.  **Execute o programa principal:**
    ```bash
    java Main
    ```

O sistema será iniciado, e o Menu Principal será exibido na linha de comando.

---

## Sequência de Teste Utilizada (Teste de Cobertura Funcional)

A sequência de teste abaixo foi projetada para cobrir todas as funcionalidades do CRUD (Cadastro, Listagem, Busca, Atualização, Exclusão) em todas as três entidades (Funcionário, Produto, Cliente).

### 1. Preparação (Cadastrar 1 de cada usando atalhos/submenu)

O objetivo é garantir que o cadastro e a listagem inicial funcionem.

| Passo | Ação | Entrada de Dados (Exemplo) | Resultado Esperado |
| :---: | :--- | :--- | :--- |
| **1.1** | Acessar atalho de **Cadastro de Cliente** (Opção `4`) | Nome: `Ana Silva`, Telefone: `(11) 9876-5432`, Email: `ana@exemplo.com` | Confirmação de "SUCESSO" e geração de ID (ex: ID 1). |
| **1.2** | Acessar atalho de **Cadastro de Produto** (Opção `5`) | Nome: `Notebook X`, Preço: `4500.50`, Quantidade: `10` | Confirmação de "SUCESSO" e geração de ID (ex: ID 1). |
| **1.3** | Acessar **Gerenciar Funcionários** (Opção `1`) e, em seguida, **Cadastrar** (Opção `1`) | Nome: `João Mendes`, Salário: `2500.00`, Matrícula: `1234` | Confirmação de "SUCESSO" e geração de ID (ex: ID 1). |
| **1.4** | Listar Funcionários (Opção `2` no Submenu) | - | Funcionário (ID 1) deve ser exibido. |
| **1.5** | Voltar ao Menu Principal (Opção `0` no Submenu) | - | Retorno ao Menu Principal. |

### 2. Testes de CRUD Completo (Entidade Cliente)

O objetivo é validar a funcionalidade CRUD completa para a entidade Cliente.

| Passo | Ação | Entrada de Dados (Exemplo) | Resultado Esperado |
| :---: | :--- | :--- | :--- |
| **2.1** | Acessar **Gerenciar Clientes** (Opção `3`) | - | Exibição do Submenu CLIENTES. |
| **2.2** | Buscar Cliente por ID (Opção `3`) | ID: `1` | O Cliente "Ana Silva" (ID 1) deve ser exibido. |
| **2.3** | Buscar Cliente por ID (Opção `3`) | ID: `99` | Exibição da mensagem: "ERRO: ID não encontrado.". |
| **2.4** | Atualizar Cliente (Opção `4`) | ID: `1` seguido pelas novas informações: Novo Nome: `Ana S. Nova` (e ENTER nos demais campos) | Confirmação de "SUCESSO: Cliente ID 1 atualizado." |
| **2.5** | Buscar Cliente por ID (Opção `3`) | ID: `1` | O cliente deve exibir o novo nome: "Ana S. Nova". |
| **2.6** | Excluir Cliente (Opção `5`) | ID: `1` | Confirmação de "SUCESSO: Cliente ID 1 removido.". |
| **2.7** | Listar Clientes (Opção `2`) | - | Exibição da mensagem: "Nenhum cliente cadastrado." |
| **2.8** | Voltar ao Menu Principal (Opção `0` no Submenu) | - | Retorno ao Menu Principal. |

### 3. Testes de Input Inválido e Encerramento

O objetivo é garantir a robustez do sistema e o encerramento correto.

| Passo | Ação | Entrada de Dados (Exemplo) | Resultado Esperado |
| :---: | :--- | :--- | :--- |
| **3.1** | No Menu Principal, tentar uma opção inválida. | Entrada: `7` | Exibição da mensagem: "Opção inválida. Tente novamente." |
| **3.2** | Acessar Gerenciar Produtos (Opção `2`), depois Cadastrar (Opção `1`) | Nome: `Mouse` | O sistema deve pedir o **Preço**. |
| **3.3** | Tentar inserir um valor não numérico no Preço. | Entrada: `abcd` | Exibição da mensagem: "ERRO: Preço deve ser um número." e retorno ao submenu. |
| **3.4** | Sair do Sistema (Voltar ao Menu Principal e Opção `0`) | Opção: `0` (no submenu) seguido de Opção: `0` (no menu principal) | Exibição da mensagem: "Saindo do sistema. Até logo!" e o programa encerra. |
