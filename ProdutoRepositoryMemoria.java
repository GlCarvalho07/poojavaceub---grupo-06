import java.util.ArrayList;
import java.util.List;

// Repositório do Produto (Produto Repository Memoria → ArrayList) [cite: 22]
public class ProdutoRepositoryMemoria {
    private List<Produto> produtos;
    private int proximoId = 1; // Próximo ID a ser usado [cite: 24]

    public ProdutoRepositoryMemoria() {
        this.produtos = new ArrayList<>();
    }

    // CRUD: adicionar
    public Produto adicionar(Produto p) {
        p.setId(proximoId++);
        produtos.add(p);
        return p;
    }

    // CRUD: listar [cite: 27]
    public List<Produto> listar() {
        return produtos;
    }

    // CRUD: buscarPorId [cite: 28]
    public Produto buscarPorId(int id) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                return produtos.get(i);
            }
        }
        return null;
    }

    // CRUD: atualizar [cite: 29]
    public boolean atualizar(int id, String novoNome, double novoPreco, int novaQuantidade) {
        Produto p = buscarPorId(id);
        if (p != null) {
            p.setNome(novoNome);
            p.setPreco(novoPreco);
            p.setQuantidadeEmEstoque(novaQuantidade);
            return true;
        }
        return false;
    }

    // CRUD: removerPorId [cite: 29]
    public boolean removerPorId(int id) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.remove(i);
                return true;
            }
        }
        return false;
    }
}