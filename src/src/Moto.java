public class Moto extends Veiculo implements Locavel {

    private int cilindradas;

    public Moto(String placa, String marca, String modelo, double valorDiaria, StatusVeiculo statusInicial, int cilindradas) {
        super(placa, marca, modelo, valorDiaria, statusInicial);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularDiariaComDesconto() {
        double valor = getValorDiaria();
        
        
        if (cilindradas >= 200) {
            return valor * (1 - 0.05); 
        }
        return valor; 
    }
    
    @Override
    public void iniciarLocacao() {
        if (verificarDisponibilidade()) {
            setStatus(StatusVeiculo.LOCADO);
            System.out.println("Moto " + getModelo() + " locada com sucesso.");
        } else {
            System.out.println("Moto " + getModelo() + " não está disponível para locação. Status: " + getStatus());
        }
    }

    @Override
    public void encerrarLocacao() {
        setStatus(StatusVeiculo.DISPONIVEL);
        System.out.println("Moto " + getModelo() + " devolvida e status alterado para DISPONIVEL.");
    }

    @Override
    public boolean verificarDisponibilidade() {
        return getStatus() == StatusVeiculo.DISPONIVEL;
    }
    
}
