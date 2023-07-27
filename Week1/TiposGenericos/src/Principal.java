import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		Cesta<Fruta> frutas = new Cesta<>();
		frutas.adiciona(new Fruta("Maca"));
		frutas.adiciona(new Fruta("Banana"));
		frutas.adiciona(new Fruta("Mamao"));
		frutas.adiciona(new Fruta("Pera"));
		frutas.adiciona(new Fruta("Uva"));
		frutas.adiciona(new FrutaVermelha("Morango")); // O adiciona espera um E, mas como FrutaVermelha é uma Fruta ele aceita
		
		// Como a Cesta espera um tipo Fruta, ele não aceita uma string (Acai)
		// frutas.adiciona("Acai");
		
		List<FrutaVermelha> vermelhas = new ArrayList<>();
		vermelhas.add(new FrutaVermelha("Amora"));
		vermelhas.add(new FrutaVermelha("Cereja"));
		
		// O AdicionaTodos não aceita essa lista pq ele espera uma lista de Fruta e não de FutaVermelha. Para contornar esse problema eu devo colocar na assinatura <? extends E> 
		frutas.adicionaTodos(vermelhas);
	
		while(frutas.temItens()) {
			System.out.println(frutas.retira());
		}
	}

}
