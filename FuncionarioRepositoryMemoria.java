import java.util.ArrayList;
import java.util.List;

// Repositório do Funcionario (Funcionario Repository Memoria → ArrayList) [cite: 21]
public class FuncionarioRepositoryMemoria {
    private List<Funcionario> funcionarios; // Lista para armazenar em memória
    private int proximoId = 1; // Próximo ID a ser usado [cite: 24]

    public FuncionarioRepositoryMemoria() {
        this.funcionarios = new ArrayList<>();
    }

    // adicionar(...): gera id, salva e retorna o objeto [cite: 26]
    public Funcionario adicionar(Funcionario f) {
        f.setId(proximoId++); // Definir obj.setId(proximoId++) [cite: 24]
        funcionarios.add(f); // inserir na lista [cite: 24]
        return f;
    }

    // listar(): retorna a lista [cite: 27]
    public List<Funcionario> listar() {
        return funcionarios;
    }

    // buscarPorId(int id): retorna o objeto ou null [cite: 28]
    public Funcionario buscarPorId(int id) {
        for (int i = 0; i < funcionarios.size(); i++) { // Não usar Streams 
            if (funcionarios.get(i).getId() == id) {
                return funcionarios.get(i);
            }
        }
        return null; // ID não encontrado
    }

    // atualizar(int id, ...campos...): retorna boolean [cite: 29]
    public boolean atualizar(int id, String novoNome, double novoSalario, String novaMatricula) {
        Funcionario f = buscarPorId(id);
        if (f != null) {
            f.setNome(novoNome);
            f.setSalario(novoSalario);
            f.setMatricula(novaMatricula);
            return true;
        }
        return false;
    }

    // removerPorId(int id): retorna boolean [cite: 29]
    public boolean removerPorId(int id) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == id) {
                funcionarios.remove(i);
                return true;
            }
        }
        return false;
    }
}