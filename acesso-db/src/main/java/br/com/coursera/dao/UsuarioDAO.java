package br.com.coursera.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.coursera.modelo.Usuario;

public class UsuarioDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void inserirUsuario(Usuario novoUsuario) {
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/usuarios", "postgres",
				"admin")) {

			String sql = "INSERT INTO public.usuario (login, nome, email) VALUES (?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, novoUsuario.getLogin());
			stm.setString(2, novoUsuario.getNome());
			stm.setString(3, novoUsuario.getEmail());

			stm.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException("Não foi possível executar o acesso.", e);
		}
	}

	public static List<Usuario> todosUsuarios() {
		List<Usuario> todos = new ArrayList<>();

		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/usuarios", "postgres",
				"master%Pass2017")) {

			String sql = "SELECT login, nome, email FROM usuario";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				todos.add(usuario);
			}

		} catch (Exception e) {
			throw new RuntimeException("Não foi possível executar o acesso.", e);
		}

		return todos;
	}
}
