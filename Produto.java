// Entidade Produto
public class Produto {
    private int id; // int id (gerado no repositório) [cite: 10]
    private String nome; // String nome [cite: 11]
    private double preco; // double preco [cite: 12]
    private int quantidadeEmEstoque; // int quantidade EmEstoque [cite: 13]

    // Construtor
    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Preço: R$ " + String.format("%.2f", preco) +
               " | Estoque: " + quantidadeEmEstoque;
    }
}