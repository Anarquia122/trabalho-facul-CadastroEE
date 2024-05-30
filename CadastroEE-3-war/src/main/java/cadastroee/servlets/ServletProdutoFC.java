package cadastroee.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cadastroee.model.Produto;
import cadastroee.controller.ProdutoFacadeLocal;

//http://localhost:8080/CadastroEE-3-war/ServletProdutoFC?acao=listar

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private ProdutoFacadeLocal facade;

    private static final Logger logger = Logger.getLogger(ServletProdutoFC.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "";

        if (acao != null) {
            switch (acao) {
                case "listar": {
                    List<Produto> produtos = facade.findAll();
                    logger.log(Level.INFO, "Número de produtos encontrados: {0}", produtos.size());
                    request.setAttribute("produtos", produtos);
                    destino = "ProdutoLista.jsp";
                    break;
                }
                case "formAlterar": {
                    Long idAlterar = Long.parseLong(request.getParameter("id"));
                    Produto produtoAlterar = facade.find(idAlterar);
                    request.setAttribute("produto", produtoAlterar);
                    destino = "ProdutoDados.jsp";
                    break;
                }
                case "excluir": {
                    Long idExcluir = Long.parseLong(request.getParameter("id"));
                    Produto produtoExcluir = facade.find(idExcluir);
                    facade.remove(produtoExcluir);
                    request.setAttribute("produtos", facade.findAll());
                    destino = "ProdutoLista.jsp";
                    break;
                }
                case "alterar": {
                    Long id = Long.parseLong(request.getParameter("id"));
                    Produto produto = facade.find(id);
                    produto.setNomeproduto(request.getParameter("nome"));
                    produto.setPreco(Float.parseFloat(request.getParameter("preco")));
                    produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                    facade.edit(produto);
                    request.setAttribute("produtos", facade.findAll());
                    destino = "ProdutoLista.jsp";
                    break;
                }
                case "formIncluir": {
                    destino = "ProdutoDados.jsp";
                    break;
                }
                case "incluir": {
                    Produto novoProduto = new Produto();
                    novoProduto.setNomeproduto(request.getParameter("nome"));
                    novoProduto.setPreco(Float.parseFloat(request.getParameter("preco")));
                    novoProduto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                    facade.create(novoProduto);
                    request.setAttribute("produtos", facade.findAll());
                    destino = "ProdutoLista.jsp";
                    break;
                }
                default: {
                    destino = "erro.jsp";
                    break;
                }
            }
        } else {
            destino = "erro.jsp";
        }

        request.getRequestDispatcher(destino).forward(request, response);
    }

    public ServletProdutoFC() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}