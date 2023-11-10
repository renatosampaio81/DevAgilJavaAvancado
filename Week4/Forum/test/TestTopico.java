import static org.junit.Assert.*;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import DAOs.TopicosDAO;
import modelos.Topico;

public class TestTopico {

	JdbcDatabaseTester jdt;
	
	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver",
				"jdbc:postgresql://localhost/forum", "postgres", "chege");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}

	@Test
	public void recuperarUmTopico(){
		Topico top = new TopicosDAO().getTopico(1);
		assertEquals("Como criar um Web Service com Java", top.getTitulo());
	}
	
	@Test
	public void recuperarTodosTopicos() {
		List<Topico> lista = new TopicosDAO().getTodosTopicos();
		assertEquals(1, lista.size());
	}
	
	@Test
	public void adicionarTopico() throws Exception{
		Topico top = new Topico();
		TopicosDAO topDao = new TopicosDAO();
		top.setLogin("sonia");
		top.setTitulo("Segundo topico");
		top.setConteudo("segundo topico do forum");
		top.setId(2);
		topDao.adiconarTopico(top);
		
		IDataSet currentDataSet = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("topico");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("/verifica.xml");
		ITable expectedTable = expectedDataSet.getTable("topico");
		Assertion.assertEquals(expectedTable, currentTable);
	}
	
}
