package test;

import static org.junit.Assert.*;

import java.util.List;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import main.Usuario;
import main.UsuarioDAOImpl;

public class TestUsuarioDAOImpl {
	
	JdbcDatabaseTester jdt;

	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester ("org.postgresql.Driver", "jdbc:postgresql://localhost/coursera","postgres","chege");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader(); //substitui os dados da tabela por dados contidos no xml
		jdt.setDataSet(loader.load("/test/resources/inicio.xml"));
		jdt.onSetup();
	}
	
	@Test
    public void testaInserir() {
        UsuarioDAOImpl dao = new UsuarioDAOImpl();

        // Crie um novo usuário para inserir no banco de dados
        Usuario usuario = new Usuario();
        usuario.setLogin("novo_usuario");
        usuario.setEmail("novo_usuario@test.com");
        usuario.setNome("Novo Usuário");
        usuario.setSenha("senha123");
        usuario.setPontos(0);

        // Insira o novo usuário
        dao.inserir(usuario);

        // Recupere o usuário recém-inserido
        Usuario usuarioRecuperado = dao.recuperar("novo_usuario");

        // Verifique se o usuário recuperado é o mesmo que foi inserido
        assertEquals("novo_usuario", usuarioRecuperado.getLogin());
        assertEquals("novo_usuario@test.com", usuarioRecuperado.getEmail());
        assertEquals("Novo Usuário", usuarioRecuperado.getNome());
        assertEquals("senha123", usuarioRecuperado.getSenha());
        assertEquals(0, usuarioRecuperado.getPontos());
    }
	
	@Test
	public void testaRecuperaPorLogin() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
        
        // Teste com um usuário existente
        Usuario usuarioExistente = dao.recuperar("joao");
        assertEquals("joao", usuarioExistente.getLogin());
        assertEquals("joao@email.com.br", usuarioExistente.getEmail());
        assertEquals("Joao Pedro", usuarioExistente.getNome());
        assertEquals("empadinha456", usuarioExistente.getSenha());
        assertEquals(5, usuarioExistente.getPontos());

        // Teste com um usuário inexistente
        Usuario usuarioInexistente = dao.recuperar("usuarioInexistente");
        assertNull(usuarioInexistente);
	}
	
	@Test
	public void testaAdicionarPontos() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		String login = "maria";
		int pontosIniciais = 100;
		int pontosAdicionados = 50;
		
		// Verifica os pontos iniciais antes de adicionar pontos
		Usuario usuarioAntes = dao.recuperar(login);
		assertEquals(pontosIniciais, usuarioAntes.getPontos());
		
		// Adiciona os pontos
		dao.adicionarPontos(login, pontosAdicionados);
		
		// Verifica os pontos depois de adicionar
		Usuario usuarioDepois = dao.recuperar(login);
		assertEquals(pontosIniciais + pontosAdicionados, usuarioDepois.getPontos());
	}
	
	@Test
    public void testRanking() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
        List<Usuario> usuarios = dao.ranking();
        assertEquals(2, usuarios.size());

        // Verifique se os usuários estão classificados em ordem decrescente de pontos
        assertEquals("maria", usuarios.get(0).getLogin());
        assertEquals("joao", usuarios.get(1).getLogin());
    }

}
