public class Caminhao extends Veiculo implements Locavel {

    private int capacidadeCargaTon;

    public Caminhao(String placa, String marca, String modelo, double valorDiaria, StatusVeiculo statusInicial, int capacidadeCargaTon) {
        super(placa, marca, modelo, valorDiaria, statusInicial);
        this.capacidadeCargaTon = capacidadeCargaTon;
    }

    @Override
    public double calcularDiariaComDesconto() {
    
        return getValorDiaria() * (1 + 0.15);
    }
    
    @Override
    public void iniciarLocacao() {
        if (verificarDisponibilidade()) {
            setStatus(StatusVeiculo.LOCADO);
            System.out.println("Caminhão " + getModelo() + " locado com sucesso.");
        } else {
            System.out.println("Caminhão " + getModelo() + " não está disponível para locação. Status: " + getStatus());
        }
    }

    @Override
    public void encerrarLocacao() {
        setStatus(StatusVeiculo.DISPONIVEL);
        System.out.println("Caminhão " + getModelo() + " devolvido e status alterado para DISPONIVEL.");
    }

    @Override
    public boolean verificarDisponibilidade() {
        return getStatus() == StatusVeiculo.DISPONIVEL;
    }
    
}
