package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAOs.TopicosDAO;
import modelos.Topico;
import modelos.Usuario;

@WebServlet("/adicionarTopico")
public class AdicionarTopico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Topico top = new Topico();
		TopicosDAO topDao = new TopicosDAO();
		Usuario us = (Usuario) request.getSession().getAttribute("usuario");

		top.setTitulo(request.getParameter("titulo"));
		top.setConteudo(request.getParameter("conteudo"));
		top.setLogin(us.getLogin());

		topDao.adiconarTopico(top);
		request.getRequestDispatcher("todostopicos").forward(request, response);

	}
}

