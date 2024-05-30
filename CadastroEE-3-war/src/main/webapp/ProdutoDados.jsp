<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="cadastroee.model.Produto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dados do Produto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body class="container">
    <h1>Dados do Produto</h1>
    <%
        Produto produto = (Produto) request.getAttribute("produto");
        String acao = (produto == null) ? "incluir" : "alterar";
    %>
    <form action="ServletProdutoFC" method="post" class="form">
        <input type="hidden" name="acao" value="<%= acao %>">
        <% if (produto != null) { %>
            <input type="hidden" name="id" value="<%= produto.getIdproduto() %>">
        <% } %>
        <div class="mb-3">
        	<label class="form-label" for="nome">Nome:</label>
        	<input class="form-control" type="text" name="nome" id="nome" value="<%= (produto != null) ? produto.getNomeproduto() : "" %>"><br>
        </div>
        <div class="mb-3">
        	<label class="form-label" for="quantidade">Quantidade:</label>
        	<input class="form-control" type="number" name="quantidade" id="quantidade" value="<%= (produto != null) ? produto.getQuantidade() : 0 %>"><br>
        </div>
        <div class="mb-3">
        	<label class="form-label" for="preco">Preço:</label>
        	<input class="form-control" type="text" name="preco" id="preco" value="<%= (produto != null) ? produto.getPreco() : 0.0 %>"><br>
        </div>
        <div>
        	<button class="btn btn-primary" type="submit"><%= (acao.equals("incluir")) ? "Incluir Produto" : "Alterar Produto" %></button>
        </div>
    </form>
</body>
</html>
