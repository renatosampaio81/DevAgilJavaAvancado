import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Comparador {
	
	public static <E> List<Diferenca> comparar(E velho, E novo) throws Exception { //posso passar qualquer objeto, mas de mesma classe
		List<Diferenca> difs = new ArrayList<>();
		
		Class<?> clazz = velho.getClass(); //o tipo de clazz é um objeto genérico
		
		//recupera todos os métodos get de clazz, que tenham zero parametros e sejam diferente de void
		for(Method m : clazz.getMethods()) {
			if(m.getName().startsWith("get") &&
					m.getParameterCount() == 0 &&
					m.getReturnType() != void.class) {
				
				//invoca por reflexao o método buscado do objeto velho e do objeto novo
				Object valorVelho = m.invoke(velho);
				Object valorNovo = m.invoke(novo);
				
				//verifica se os métodos sao diferentes e inclui ela na lista de diferencas
				if(!valorNovo.equals(valorVelho)) {
					Diferenca d = new Diferenca(m.getName(), valorNovo, valorVelho);
					difs.add(d);
				}
				
			}
		}
		
		return difs;
	}

}
