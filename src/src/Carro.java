public class Carro extends Veiculo implements Locavel {

    private int numeroPortas;

    public Carro(String placa, String marca, String modelo, double valorDiaria, StatusVeiculo statusInicial, int numeroPortas) {
        super(placa, marca, modelo, valorDiaria, statusInicial);
        this.numeroPortas = numeroPortas;
    }

    @Override
    public double calcularDiariaComDesconto() {
    
        return getValorDiaria() * (1 - 0.10); 
    }

    @Override
    public void iniciarLocacao() {
        if (verificarDisponibilidade()) {
            setStatus(StatusVeiculo.LOCADO);
            System.out.println("Carro " + getModelo() + " locado com sucesso.");
        } else {
            System.out.println("Carro " + getModelo() + " não está disponível para locação. Status: " + getStatus());
        }
    }

    @Override
    public void encerrarLocacao() {
        setStatus(StatusVeiculo.DISPONIVEL);
        System.out.println("Carro " + getModelo() + " devolvido e status alterado para DISPONIVEL.");
    }

    @Override
    public boolean verificarDisponibilidade() {
        return getStatus() == StatusVeiculo.DISPONIVEL;
    }
    
}
