
public class PrincipalInsert {

	public static void main(String[] args) {
		Usuario u = new Usuario();
		u.setLogin("duda");
		u.setNome("Maria Eduarda");
		u.setEmail("duda@gmail.com");
		
		UsuarioDAO.inserirUsuario(u);
	}

}
