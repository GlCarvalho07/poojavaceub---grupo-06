import java.util.ArrayList;
import java.util.List;

// Repositório do Cliente (Cliente Repository Memoria → ArrayList) [cite: 23]
public class ClienteRepositoryMemoria {
    private List<Cliente> clientes;
    private int proximoId = 1; // Próximo ID a ser usado [cite: 24]

    public ClienteRepositoryMemoria() {
        this.clientes = new ArrayList<>();
    }

    // CRUD: adicionar
    public Cliente adicionar(Cliente c) {
        c.setId(proximoId++);
        clientes.add(c);
        return c;
    }

    // CRUD: listar [cite: 27]
    public List<Cliente> listar() {
        return clientes;
    }

    // CRUD: buscarPorId [cite: 28]
    public Cliente buscarPorId(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                return clientes.get(i);
            }
        }
        return null;
    }

    // CRUD: atualizar [cite: 29]
    public boolean atualizar(int id, String novoNome, String novoTelefone, String novoEmail) {
        Cliente c = buscarPorId(id);
        if (c != null) {
            c.setNome(novoNome);
            c.setTelefone(novoTelefone);
            c.setEmail(novoEmail);
            return true;
        }
        return false;
    }

    // CRUD: removerPorId [cite: 29]
    public boolean removerPorId(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }
}