package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAOs.UsuarioDAO;
import modelos.Usuario;

@WebServlet("/ranking")
public class Ranking extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Usuario> lista = new UsuarioDAO().getTodosUsuarios();
			req.setAttribute("usuarios", lista);
			req.getRequestDispatcher("ranking.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}