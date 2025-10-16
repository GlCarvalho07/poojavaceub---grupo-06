import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

    private static FuncionarioRepositoryMemoria funcRepo = new FuncionarioRepositoryMemoria();
    private static ProdutoRepositoryMemoria prodRepo = new ProdutoRepositoryMemoria();
    private static ClienteRepositoryMemoria cliRepo = new ClienteRepositoryMemoria();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    gerenciarFuncionarios(); // 1) Gerenciar Funcionários [cite: 32]
                    break;
                case 2:
                    gerenciarProdutos(); // 2) Gerenciar Produtos [cite: 33]
                    break;
                case 3:
                    gerenciarClientes(); // 3) Gerenciar Clientes [cite: 34]
                    break;
                case 4:
                    cadastrarCliente(); // 4) Cadastrar Cliente (atalho) [cite: 37]
                    break;
                case 5:
                    cadastrarProduto(); // 5) Cadastrar Produto (atalho) [cite: 38]
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!"); // 0) Sair [cite: 39]
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== MENU PRINCIPAL ====="); // Menu Principal [cite: 31]
        System.out.println("1) Gerenciar Funcionários");
        System.out.println("2) Gerenciar Produtos");
        System.out.println("3) Gerenciar Clientes");
        System.out.println("4) Cadastrar Cliente (atalho)");
        System.out.println("5) Cadastrar Produto (atalho)");
        System.out.println("0) Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void exibirSubmenu(String entidade) {
        System.out.println("\n===== SUBMENU: " + entidade + " ====="); // Submenu [cite: 40]
        System.out.println("1) Cadastrar"); // 1) Cadastrar [cite: 41]
        System.out.println("2) Listar"); // 2) Listar [cite: 42]
        System.out.println("3) Buscar por ID"); // 3) Buscar por ID [cite: 43]
        System.out.println("4) Atualizar por ID"); // 4) Atualizar por ID [cite: 46]
        System.out.println("5) Excluir por ID"); // 5) Excluir por ID [cite: 47]
        System.out.println("0) Voltar"); // 0) Voltar [cite: 48]
        System.out.print("Escolha uma opção: ");
    }

    // --- FUNÇÕES DE LEITURA E VALIDAÇÃO ---

    private static int lerOpcao() {
        try {
            // Garante que a linha atual do scanner seja consumida após a leitura
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpa o buffer
            return -1; // Retorna um valor inválido
        } finally {
            scanner.nextLine(); // Consome o resto da linha para a próxima leitura
        }
    }

    private static int lerId() {
        System.out.print("Digite o ID: ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consome o resto da linha
            return id;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpa o buffer
            System.out.println("ERRO: O ID deve ser um número inteiro.");
            return -1;
        }
    }

    // --- GERENCIAMENTO DE FUNCIONÁRIOS ---

    private static void gerenciarFuncionarios() {
        int opcao;
        do {
            exibirSubmenu("FUNCIONÁRIOS");
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    buscarFuncionarioPorId();
                    break;
                case 4:
                    atualizarFuncionario();
                    break;
                case 5:
                    excluirFuncionario();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n--- CADASTRO DE FUNCIONÁRIO ---");
        // Todos os campos, exceto o id, são digitados pelo usuário via Scanner. [cite: 19, 50]
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Salário: ");
        double salario = 0;
        try {
            salario = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Salário deve ser um número.");
            scanner.nextLine(); // Limpa o buffer
            return;
        }
        scanner.nextLine(); // Consome o resto da linha
        
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        Funcionario novoFunc = new Funcionario(nome, salario, matricula);
        funcRepo.adicionar(novoFunc);
        System.out.println("SUCESSO: Funcionário cadastrado! ID gerado: " + novoFunc.getId()); // Exibir mensagens claras de sucesso/erro [cite: 51]
    }

    private static void listarFuncionarios() {
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
        List<Funcionario> lista = funcRepo.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    private static void buscarFuncionarioPorId() {
        int id = lerId();
        if (id <= 0) return;
        
        Funcionario f = funcRepo.buscarPorId(id);
        if (f != null) {
            System.out.println("\n--- FUNCIONÁRIO ENCONTRADO ---");
            System.out.println(f);
        } else {
            System.out.println("ERRO: ID não encontrado."); // Exibir mensagens claras de sucesso/erro (ex.: "ID não encontrado") [cite: 51]
        }
    }

    private static void atualizarFuncionario() {
        System.out.println("\n--- ATUALIZAR FUNCIONÁRIO ---");
        int id = lerId();
        if (id <= 0) return;

        Funcionario f = funcRepo.buscarPorId(id);
        if (f == null) {
            System.out.println("ERRO: ID não encontrado.");
            return;
        }

        System.out.println("Funcionário atual: " + f);
        System.out.println("Digite os NOVOS dados (ou pressione ENTER para manter o atual):");

        System.out.print("Novo Nome (" + f.getNome() + "): ");
        String novoNome = scanner.nextLine().trim();
        if (novoNome.isEmpty()) novoNome = f.getNome();

        System.out.print("Novo Salário (" + String.format("%.2f", f.getSalario()) + "): ");
        String salarioStr = scanner.nextLine().trim();
        double novoSalario = f.getSalario();
        if (!salarioStr.isEmpty()) {
            try {
                novoSalario = Double.parseDouble(salarioStr);
            } catch (NumberFormatException e) {
                System.out.println("AVISO: Salário inválido. Mantendo o valor anterior.");
            }
        }
        
        System.out.print("Nova Matrícula (" + f.getMatricula() + "): ");
        String novaMatricula = scanner.nextLine().trim();
        if (novaMatricula.isEmpty()) novaMatricula = f.getMatricula();

        if (funcRepo.atualizar(id, novoNome, novoSalario, novaMatricula)) {
            System.out.println("SUCESSO: Funcionário ID " + id + " atualizado."); // Atualizar 1 registro de cada tipo [cite: 54]
        } else {
            System.out.println("ERRO na atualização.");
        }
    }

    private static void excluirFuncionario() {
        System.out.println("\n--- EXCLUIR FUNCIONÁRIO ---");
        int id = lerId();
        if (id <= 0) return;

        if (funcRepo.removerPorId(id)) {
            System.out.println("SUCESSO: Funcionário ID " + id + " removido."); // Excluir 1 registro de cada tipo [cite: 55]
        } else {
            System.out.println("ERRO: ID não encontrado.");
        }
    }

    // --- GERENCIAMENTO DE PRODUTOS ---

    private static void gerenciarProdutos() {
        int opcao;
        do {
            exibirSubmenu("PRODUTOS");
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProdutoPorId();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    excluirProduto();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    private static void cadastrarProduto() { // Usado no Submenu e no Atalho [cite: 38]
        System.out.println("\n--- CADASTRO DE PRODUTO ---");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Preço: ");
        double preco = 0;
        try {
            preco = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Preço deve ser um número.");
            scanner.nextLine();
            return;
        }
        
        System.out.print("Quantidade em Estoque: ");
        int quantidade = 0;
        try {
            quantidade = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Quantidade deve ser um número inteiro.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        Produto novoProduto = new Produto(nome, preco, quantidade);
        prodRepo.adicionar(novoProduto);
        System.out.println("SUCESSO: Produto cadastrado! ID gerado: " + novoProduto.getId());
    }

    private static void listarProdutos() {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        List<Produto> lista = prodRepo.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    private static void buscarProdutoPorId() {
        int id = lerId();
        if (id <= 0) return;
        
        Produto p = prodRepo.buscarPorId(id);
        if (p != null) {
            System.out.println("\n--- PRODUTO ENCONTRADO ---");
            System.out.println(p);
        } else {
            System.out.println("ERRO: ID não encontrado.");
        }
    }

    private static void atualizarProduto() {
        System.out.println("\n--- ATUALIZAR PRODUTO ---");
        int id = lerId();
        if (id <= 0) return;

        Produto p = prodRepo.buscarPorId(id);
        if (p == null) {
            System.out.println("ERRO: ID não encontrado.");
            return;
        }

        System.out.println("Produto atual: " + p);
        System.out.println("Digite os NOVOS dados (ou pressione ENTER para manter o atual):");

        System.out.print("Novo Nome (" + p.getNome() + "): ");
        String novoNome = scanner.nextLine().trim();
        if (novoNome.isEmpty()) novoNome = p.getNome();

        System.out.print("Novo Preço (" + String.format("%.2f", p.getPreco()) + "): ");
        String precoStr = scanner.nextLine().trim();
        double novoPreco = p.getPreco();
        if (!precoStr.isEmpty()) {
            try {
                novoPreco = Double.parseDouble(precoStr);
            } catch (NumberFormatException e) {
                System.out.println("AVISO: Preço inválido. Mantendo o valor anterior.");
            }
        }
        
        System.out.print("Nova Quantidade em Estoque (" + p.getQuantidadeEmEstoque() + "): ");
        String qtdStr = scanner.nextLine().trim();
        int novaQuantidade = p.getQuantidadeEmEstoque();
        if (!qtdStr.isEmpty()) {
            try {
                novaQuantidade = Integer.parseInt(qtdStr);
            } catch (NumberFormatException e) {
                System.out.println("AVISO: Quantidade inválida. Mantendo o valor anterior.");
            }
        }

        if (prodRepo.atualizar(id, novoNome, novoPreco, novaQuantidade)) {
            System.out.println("SUCESSO: Produto ID " + id + " atualizado.");
        } else {
            System.out.println("ERRO na atualização.");
        }
    }

    private static void excluirProduto() {
        System.out.println("\n--- EXCLUIR PRODUTO ---");
        int id = lerId();
        if (id <= 0) return;

        if (prodRepo.removerPorId(id)) {
            System.out.println("SUCESSO: Produto ID " + id + " removido.");
        } else {
            System.out.println("ERRO: ID não encontrado.");
        }
    }

    // --- GERENCIAMENTO DE CLIENTES ---

    private static void gerenciarClientes() {
        int opcao;
        do {
            exibirSubmenu("CLIENTES");
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarClientePorId();
                    break;
                case 4:
                    atualizarCliente();
                    break;
                case 5:
                    excluirCliente();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    private static void cadastrarCliente() { // Usado no Submenu e no Atalho [cite: 37]
        System.out.println("\n--- CADASTRO DE CLIENTE ---");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, telefone, email);
        cliRepo.adicionar(novoCliente);
        System.out.println("SUCESSO: Cliente cadastrado! ID gerado: " + novoCliente.getId());
    }

    private static void listarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        List<Cliente> lista = cliRepo.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    private static void buscarClientePorId() {
        int id = lerId();
        if (id <= 0) return;
        
        Cliente c = cliRepo.buscarPorId(id);
        if (c != null) {
            System.out.println("\n--- CLIENTE ENCONTRADO ---");
            System.out.println(c);
        } else {
            System.out.println("ERRO: ID não encontrado.");
        }
    }

    private static void atualizarCliente() {
        System.out.println("\n--- ATUALIZAR CLIENTE ---");
        int id = lerId();
        if (id <= 0) return;

        Cliente c = cliRepo.buscarPorId(id);
        if (c == null) {
            System.out.println("ERRO: ID não encontrado.");
            return;
        }

        System.out.println("Cliente atual: " + c);
        System.out.println("Digite os NOVOS dados (ou pressione ENTER para manter o atual):");

        System.out.print("Novo Nome (" + c.getNome() + "): ");
        String novoNome = scanner.nextLine().trim();
        if (novoNome.isEmpty()) novoNome = c.getNome();

        System.out.print("Novo Telefone (" + c.getTelefone() + "): ");
        String novoTelefone = scanner.nextLine().trim();
        if (novoTelefone.isEmpty()) novoTelefone = c.getTelefone();
        
        System.out.print("Novo E-mail (" + c.getEmail() + "): ");
        String novoEmail = scanner.nextLine().trim();
        if (novoEmail.isEmpty()) novoEmail = c.getEmail();

        if (cliRepo.atualizar(id, novoNome, novoTelefone, novoEmail)) {
            System.out.println("SUCESSO: Cliente ID " + id + " atualizado.");
        } else {
            System.out.println("ERRO na atualização.");
        }
    }

    private static void excluirCliente() {
        System.out.println("\n--- EXCLUIR CLIENTE ---");
        int id = lerId();
        if (id <= 0) return;

        if (cliRepo.removerPorId(id)) {
            System.out.println("SUCESSO: Cliente ID " + id + " removido.");
        } else {
            System.out.println("ERRO: ID não encontrado.");
        }
    }
}