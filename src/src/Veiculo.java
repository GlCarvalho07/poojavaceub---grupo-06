public abstract class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private double valorDiaria;
    private StatusVeiculo status;

    public Veiculo(String placa, String marca, String modelo, double valorDiaria, StatusVeiculo statusInicial) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
        this.status = statusInicial; 
    }

    public abstract double calcularDiariaComDesconto();

    public void exibirResumo() {
        System.out.println("--- Resumo do Veículo ---");
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Valor Diária Base: R$ " + String.format("%.2f", valorDiaria));
        System.out.println("Status: " + status);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }
}
