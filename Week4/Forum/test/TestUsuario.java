import static org.junit.Assert.*;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import DAOs.UsuarioDAO;
import modelos.Usuario;

public class TestUsuario {

	JdbcDatabaseTester jdt;
	
	@Before
	public void setUp() throws Exception {
                jdt = new JdbcDatabaseTester ("org.postgresql.Driver",
                        "jdbc:postgresql://localhost/forum", "postgres", "chege");
                FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}

	@Test
	public void login() throws Exception {
		UsuarioDAO usDao = new UsuarioDAO();
		assertEquals(true, usDao.login("renato", "coxinha123"));
	}

        @Test
	public void recuperarUsuario() throws Exception{
		Usuario us = new UsuarioDAO().getUsuario("renato");
		assertEquals("Ze Renato", us.getNome());
	}
	
        @Test
	public void recuperarTodosUsuarios() throws Exception{
		List<Usuario> lista = new UsuarioDAO().getTodosUsuarios();
		assertEquals(2, lista.size());
	}
	
	@Test
	public void adicionarUsuario() throws Exception{
		Usuario us = new Usuario();
		UsuarioDAO usDAO = new UsuarioDAO();
		us.setLogin("fulano");
		us.setSenha("2345");
		us.setEmail("fulano@email.com");
		us.setNome("Fulano da Silva");
		
		usDAO.adicionarUsuario(us);
		
		IDataSet currentDataSet = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("USUARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("/verifica.xml");
		ITable expectedTable = expectedDataSet.getTable("USUARIO");
		Assertion.assertEquals(expectedTable, currentTable);
	}

}
