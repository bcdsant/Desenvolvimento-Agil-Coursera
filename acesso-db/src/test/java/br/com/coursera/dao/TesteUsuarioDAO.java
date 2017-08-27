package br.com.coursera.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import br.com.coursera.modelo.Usuario;

public class TesteUsuarioDAO {

	private JdbcDatabaseTester jdt;
	private static final String db_connection = ConnectionConfig.getDbConnection();
	private static final String db_user = ConnectionConfig.getDbUser();
	private static final String db_password = ConnectionConfig.getDbPassword();

	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", db_connection, db_user, db_password);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}

	@Test
	public void recuperaTodos() {
		List<Usuario> todosUsuarios = UsuarioDAO.todosUsuarios();
		assertEquals(2, todosUsuarios.size());
		assertEquals("joao", todosUsuarios.get(0).getLogin());
	}

	@Test
	public void insereNovo() throws SQLException, Exception {

		Usuario novoUsuario = new Usuario();

		novoUsuario.setNome("Maria Eduarda");
		novoUsuario.setLogin("duda");
		novoUsuario.setEmail("duda@gmail.com");
		
		UsuarioDAO.inserirUsuario(novoUsuario);

		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable  currentTable = currentDataset.getTable("USUARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/verifica.xml");
		ITable expectedTable = expectedDataset.getTable("USUARIO");
		Assertion.assertEquals(expectedTable, currentTable);
	}

}
