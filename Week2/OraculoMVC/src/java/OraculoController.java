import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/oraculoController")
public class OraculoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //pegar o parametro
        String tipoProduto = request.getParameter("produto");
        //chamar a regra de negocios no model
        Oraculo oraculo = new Oraculo();
        List<String> produtos = oraculo.melhoresProdutos(tipoProduto);
        request.setAttribute("produtos", produtos);
        //passar o controle para um view
        request.getRequestDispatcher("resposta.jsp").forward(request, response);
    }

}
