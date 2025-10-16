// Entidade Cliente
public class Cliente {
    private int id; // int id (gerado no repositório) [cite: 15]
    private String nome; // String nome [cite: 16]
    private String telefone; // String telefone [cite: 17]
    private String email; // String email [cite: 18]

    // Construtor
    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Telefone: " + telefone +
               " | E-mail: " + email;
    }
}