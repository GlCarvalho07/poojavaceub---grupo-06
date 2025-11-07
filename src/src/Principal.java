public class Principal {

    public static void main(String[] args) {

        Carro meuCarro = new Carro("ABC-1234", "Fiat", "Uno", 100.00, StatusVeiculo.DISPONIVEL, 4);
        Moto minhaMoto = new Moto("DEF-5678", "Honda", "CB 300", 80.00, StatusVeiculo.MANUTENCAO, 300); 
        Caminhao meuCaminhao = new Caminhao("GHI-9012", "Volvo", "FH 540", 500.00, StatusVeiculo.DISPONIVEL, 25);

        System.out.println("====================================================");
        System.out.println("               Teste de Veículos                  ");
        System.out.println("====================================================");

        System.out.println("\n--- Status Inicial ---");
        System.out.println(meuCarro.getModelo() + " Status: " + meuCarro.getStatus());
        System.out.println(minhaMoto.getModelo() + " Status: " + minhaMoto.getStatus());
        System.out.println(meuCaminhao.getModelo() + " Status: " + meuCaminhao.getStatus());

        System.out.println("\n--- Teste de Locação (Interface Locavel) ---");
        
        meuCarro.iniciarLocacao();
        System.out.println("Novo Status Carro: " + meuCarro.getStatus());
        meuCarro.encerrarLocacao();
        System.out.println("Novo Status Carro: " + meuCarro.getStatus());
        
        minhaMoto.iniciarLocacao(); 
        System.out.println("Novo Status Moto: " + minhaMoto.getStatus()); 

        System.out.println("\n--- Cálculo da Diária com Desconto/Acréscimo (Polimorfismo) ---");
        
        double diariaCarro = meuCarro.calcularDiariaComDesconto();
        System.out.println("Diária Original Carro (" + meuCarro.getModelo() + "): R$ " + String.format("%.2f", meuCarro.getValorDiaria()));
        System.out.println("Diária com Desconto (10%): R$ " + String.format("%.2f", diariaCarro));
        
        double diariaMoto = minhaMoto.calcularDiariaComDesconto();
        System.out.println("Diária Original Moto (" + minhaMoto.getModelo() + "): R$ " + String.format("%.2f", minhaMoto.getValorDiaria()));
        System.out.println("Diária com Desconto (5%): R$ " + String.format("%.2f", diariaMoto));
        
        double diariaCaminhao = meuCaminhao.calcularDiariaComDesconto();
        System.out.println("Diária Original Caminhão (" + meuCaminhao.getModelo() + "): R$ " + String.format("%.2f", meuCaminhao.getValorDiaria()));
        System.out.println("Diária com Acréscimo (15%): R$ " + String.format("%.2f", diariaCaminhao));
        
        System.out.println("====================================================");
    }
}
