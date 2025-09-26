public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario(1, "João");

        Produto guitarra = new Instrumento(101, "Guitarra", 1500.0, Categoria.CORDAS, "Cordas", "Fender");
        Produto baqueta = new Acessorio(201, "Baqueta", 50.0, Categoria.ACESSORIOS, "Madeira");

        f1.cadastrarProduto(Guitarra);
        f1.cadastrarProduto(Bateria);
        f1.cadastrarProduto(Violão);

        Venda venda1 = f1.gerarVenda(1);
        venda1.adicionarProduto(guitarra, 1);
        venda1.adicionarProduto(baqueta, 2);

        System.out.println("Itens da venda:");
        venda1.exibirItens();
        System.out.println("Valor total da venda: R$ " + venda1.getValorTotal());
    }
}
