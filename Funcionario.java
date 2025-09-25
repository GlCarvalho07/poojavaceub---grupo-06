import java.util.*;

public class Funcionario {
  
    private int id;
    private String nome;
    private int codigo;
    private List<Produto> produtos;
    private List<Venda> vendas;

    public Funcionario(int id, String nome){
    this.id = id;
    this.nome = nome;    
    this.produtos = new ArrayList<>();
    produtos.add("Violão");
    produtos.add("Guitara");
    produtos.add("Bateria");
    }
    public void cadastrarProduto(Produto P){
        produto.add(P);    
    }
    public Produto consultarProduto(int codigo) {
       
        for (Produto p : produtos){
            if (p.getCodigo() == codigo) return p;
        }
        return null;
       System.out.println("Funcionário Consulta"+this.codigo+ "o codigo do produto");
    }
    public Venda gerarVenda(int idVenda){
        System.out.println("O Funcionário está "+this.id+"consultando a venda com o ID do produto");
       
        return null;
    }
    public Venda consultarVenda(int idVenda){
        for (Venda v : vendas) {
            if (v.getId() == idVenda) return v;
    }
    return null;
}
