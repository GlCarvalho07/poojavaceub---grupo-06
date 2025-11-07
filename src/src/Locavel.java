public interface Locavel {

    double TAXA_SEGURO = 5.0; 

    void iniciarLocacao(); 
    void encerrarLocacao(); 
    boolean verificarDisponibilidade();
}
