
import java.util.ArrayList;
import java.util.List;


public class Oraculo {
    
    public List<String> melhoresProdutos(String tipo) {
        List<String> lista = new ArrayList<>();
        if(tipo.equals("doce de leite")) {
            lista.add("Vicosa");
            lista.add("Boreal");
        }else if(tipo.equals("queijo mireiro")) {
            lista.add("Candido Tostes");
            lista.add("Humaita");
            lista.add("O da minha tia josefa");
        }
        return lista;
    }
    
}
