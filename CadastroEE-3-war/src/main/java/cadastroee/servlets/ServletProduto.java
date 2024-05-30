package cadastroee.servlets;

import java.io.IOException;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;

/**
 * Servlet implementation class ServletProduto
 */
public class ServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB
    private ProdutoFacadeLocal facade;
	
    public ServletProduto() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produto> produtos = facade.findAll();
		response.setContentType("text/html");
		response.getWriter().append("<html><body><h1>Lista de Produtos</h1><ul>");
		for (Produto produto : produtos) {
			response.getWriter().append("<li>").append(produto.getNomeproduto() + " - " + produto.getPreco()).append("</li>");
		}
		response.getWriter().append("</ul></body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
