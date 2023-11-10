package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAOs.TopicosDAO;
import modelos.Topico;

@WebServlet("/todostopicos")
public class Topicos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Topico> lista = new ArrayList<>();
		try {
			lista = new TopicosDAO().getTodosTopicos();
			request.getSession().setAttribute("topicos", lista);
			request.getRequestDispatcher("topicos.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Erro ao recuperar tópicos");
		}
	}
}
