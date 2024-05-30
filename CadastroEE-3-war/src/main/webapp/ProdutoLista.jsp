<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="cadastroee.model.Produto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body class="container">
    <h1>Listagem de Produtos</h1>
    <a href="ServletProdutoFC?acao=formIncluir" class="btn btn-primary m-2">Incluir Novo Produto</a>
    <br><br>
    <table border="1" class="table table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Quantidade</th>
                <th>Preço</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
                if (produtos != null) {
                    if (!produtos.isEmpty()) {
                        for (Produto produto : produtos) {
            %>
            <tr>
                <td><%= produto.getIdproduto() %></td>
                <td><%= produto.getNomeproduto() %></td>
                <td><%= produto.getQuantidade() %></td>
                <td><%= produto.getPreco() %></td>
                <td>
                    <a class="btn btn-primary btn-sm" href="ServletProdutoFC?acao=formAlterar&id=<%= produto.getIdproduto() %>">Alterar</a>
                    <a class="btn btn-danger btn-sm" href="ServletProdutoFC?acao=excluir&id=<%= produto.getIdproduto() %>">Excluir</a>
                </td>
            </tr>
            <%
                        }
                    } else {
            %>
            <tr>
                <td colspan="5">Nenhum produto encontrado.</td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">Nenhum produto encontrado.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
