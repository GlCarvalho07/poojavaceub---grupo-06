// Entidade Funcionario
public class Funcionario {
    private int id; // int id (gerado no repositório) [cite: 5]
    private String nome; // String nome [cite: 6]
    private double salario; // double salario [cite: 7]
    private String matricula; // String matricula [cite: 8]

    // Construtor usado no cadastro (id será setado no repositório)
    public Funcionario(String nome, double salario, String matricula) {
        this.nome = nome;
        this.salario = salario;
        this.matricula = matricula;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public String getMatricula() {
        return matricula;
    }

    // Setters (necessários para o Repositório e a Atualização)
    public void setId(int id) { // Setter para o Repositório gerar o ID [cite: 24]
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Salário: R$ " + String.format("%.2f", salario) +
               " | Matrícula: " + matricula;
    }
}