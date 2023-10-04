import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		List<Produto> lista = new ArrayList<>();
		lista.add(new Produto("Tenis", 300));
		lista.add(new Produto("Camiseta",80));
		lista.add(new Produto("Cinto",50));
		
		Carrinho c = new Carrinho(lista);
		
		//c.darDesconto(20, p -> p.getValor() < 100); //20% de desconto pra produtos de valor inferior a 100
		//c.darDesconto(20, p -> p.getNome().contains("a")); //20% de desconto pra produtos que contenham a letra a
		c.darDesconto(20, Produto::caro); //20% de desconto para produtos acima de 200 (lembrando que a condićão precisa retornar um boolean)
	
		//lista.forEach(p -> System.out.println(p));
		//lista.forEach(System.out::println);
		c.getLista().forEach(System.out::println);
	}
}
