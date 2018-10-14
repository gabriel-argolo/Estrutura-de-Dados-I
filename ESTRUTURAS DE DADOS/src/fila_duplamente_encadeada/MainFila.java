package fila_duplamente_encadeada;
	
public class MainFila {
    public static void main(String[] args) {
        Fila<String> fila = new Fila<>();
        
        fila.enfileirar("Jose");
        fila.enfileirar("Maria");
        fila.enfileirar("Cleiton Rasta");
        
        for (String elemento : fila) {
            System.out.println(elemento);
        }
        System.out.println("\n");
        
        System.out.println(fila.primeiro());
    }
}
