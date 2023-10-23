
public class Diferenca {
	
	private String propriedade; //nome do método
	private Object valorNovo;
	private Object valorVelho;
	
	public Diferenca(String propriedade, Object valorNovo, Object valorVelho) {
		super();
		this.propriedade = propriedade;
		this.valorNovo = valorNovo;
		this.valorVelho = valorVelho;
	}

	@Override
	public String toString() {
		return "Diferenca [propriedade=" + propriedade + ", valorNovo=" + valorNovo + ", valorVelho=" + valorVelho
				+ "]";
	}
	

}
