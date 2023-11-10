package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAOs.UsuarioDAO;
import modelos.Usuario;

@WebServlet("/fazerlogin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean tentativa = false;
		try {
			tentativa = new UsuarioDAO().login(request.getParameter("login"), request.getParameter("senha"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (tentativa) {

			try {
				HttpSession session = request.getSession();
				Usuario usuario = null;
				usuario = new UsuarioDAO().getUsuario(request.getParameter("login"));
				session.setAttribute("usuario", usuario);
				request.getRequestDispatcher("todostopicos").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("erro", "Login ou senha incorretos. Tente novamente.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}