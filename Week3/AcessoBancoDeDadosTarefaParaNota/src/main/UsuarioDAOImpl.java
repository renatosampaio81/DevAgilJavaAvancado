package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void inserir(Usuario u) {
		try(Connection c = DriverManager.getConnection(
				"jdbc:postgresql://localhost/coursera","postgres","chege")){	
			String sql = "INSERT INTO public.usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1,  u.getLogin());
			stm.setString(2,  u.getEmail());
			stm.setString(3,  u.getNome());
			stm.setString(4,  u.getSenha());
			stm.setInt(5, u.getPontos());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o acesso", e);
		}
	}
	   
	@Override
	public Usuario recuperar(String login) {
	    Usuario usuario = null;
	    try(Connection c = DriverManager.getConnection(
	            "jdbc:postgresql://localhost/coursera","postgres","chege")){
	        String sql = "SELECT * FROM usuario WHERE login = ?";
	        PreparedStatement stm = c.prepareStatement(sql);
	        stm.setString(1, login);
	        ResultSet rs = stm.executeQuery();
	        if (rs.next()) {
	            usuario = new Usuario();
	            usuario.setLogin(rs.getString("login"));
	            usuario.setEmail(rs.getString("email"));
	            usuario.setNome(rs.getString("nome"));
	            usuario.setSenha(rs.getString("senha"));
	            usuario.setPontos(rs.getInt("pontos"));  
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Não foi possível executar o acesso", e);
	    }
	    return usuario;
	}
	   
	@Override
	public void adicionarPontos(String login, int pontos) {
	    try (Connection c = DriverManager.getConnection(
	            "jdbc:postgresql://localhost/coursera", "postgres", "chege")) {
	        String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
	        PreparedStatement stm = c.prepareStatement(sql);
	        stm.setInt(1, pontos);
	        stm.setString(2, login);
	        stm.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException("Não foi possível executar o acesso", e);
	    }
	}
	   
	@Override
	public List<Usuario> ranking() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost/coursera", "postgres", "chege")) {
            String sql = "SELECT login, email, nome, senha, pontos FROM usuario ORDER BY pontos DESC";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setEmail(rs.getString("email"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setPontos(rs.getInt("pontos"));
                usuarios.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível executar o acesso", e);
        }
        return usuarios;
    }

}
