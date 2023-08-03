import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ConversorServlet")
public class ConversorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        double resultado;

        if (opcao.equals("celsiusToFahrenheit")) {
            resultado = (valor * 9 / 5) + 32;
        } else {
            resultado = (valor - 32) * 5 / 9;
        }

        int resultadoInteiro = (int) resultado;

        // Configurar a resposta para gerar uma página HTML
        response.setContentType("text/html");

        // Obter o objeto PrintWriter para escrever na resposta
        PrintWriter out = response.getWriter();

        // Escrever a página HTML de resposta
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Resultado da Conversão</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Resultado da Conversão</h1>");
        out.println("<p>O resultado da conversão é: " + resultadoInteiro + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

}
