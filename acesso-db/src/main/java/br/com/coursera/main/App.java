package br.com.coursera.main;

import java.util.List;

import br.com.coursera.dao.UsuarioDAO;
import br.com.coursera.modelo.Usuario;

public class App {

	public static void main(String[] args) {
		Usuario novoUsuario = new Usuario();
		
		imprimeTodosUsuarios();
		
		novoUsuario.setNome("Maria Eduarda");
		novoUsuario.setLogin("duda");
		novoUsuario.setEmail("duda@gmail.com");

		//executaInserir(novoUsuario);
		//imprimeTodosUsuarios();
		
	}

	@SuppressWarnings("unused")
	private static void executaInserir(Usuario novoUsuario) {
		UsuarioDAO.inserirUsuario(novoUsuario);
	}

	private static void imprimeTodosUsuarios() {
		List<Usuario> todosUsuarios = UsuarioDAO.todosUsuarios();
		todosUsuarios.forEach(System.out::println);
	}
}
