
package br.com.coursera.control;

import br.com.coursera.model.TranslateModel;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TranslateServlet")
public class TranslateServlet extends HttpServlet {
    private TranslateModel translateModel;

    @Override
    public void init() throws ServletException {
        super.init();
        translateModel = new TranslateModel();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém a palavra digitada pelo usuário.
        String portugueseWord = request.getParameter("palavra");

        // Usa o TranslateModel para obter a tradução.
        String englishTranslation = translateModel.translate(portugueseWord);

        // Define o resultado como atributo de solicitação para a página JSP.
        request.setAttribute("traducao", englishTranslation);

        // Encaminha a solicitação para a página JSP de resultado.
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
