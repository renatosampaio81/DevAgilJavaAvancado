package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAOs.UsuarioDAO;
import modelos.Usuario;

@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario us = new Usuario();
		UsuarioDAO usDao = new UsuarioDAO();

		us.setEmail(request.getParameter("email"));
		us.setLogin(request.getParameter("login"));
		us.setNome(request.getParameter("nome"));
		us.setSenha(request.getParameter("senha"));
		us.setPontos(0);
		usDao.adicionarUsuario(us);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}