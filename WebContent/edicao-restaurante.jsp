<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Restaurante</title>
<%@ include file="header.jsp" %>
</head>
<body>
<div class="container">
	<h1>Edição de Produto</h1>
	<form action="restaurante" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${produto.codigo}" name="codigo">
		<div class="form-group">
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="id-nome" class="form-control" value="${restaurante.nome}" >
		</div>
		<div class="form-group">
			<label for="id-valor">CNPJ</label>
			<input type="text" name="cnpj" id="id-cnpj" class="form-control" value="${restaurante.cnpj}">
		</div>
		<div class="form-group">
			<label for="id-quantidade">Categoria</label>
			<input type="text" name="categoria" id="id-categoria" class="form-control" value="${restaurante.categoria}">
		</div>
		<div class="form-group">
			<label for="id-fabricacao">Data de Inauguração</label>
			<input type="text" name="inauguracao" id="id-inauguracao" class="form-control">
				value='<fmt:formatDate value="${restaurante.dataInauguracao.time }" pattern="dd/MM/yyyy"/>'>
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
		<a href="restaurante?acao=listar" class="btn btn-danger">Cancelar</a>
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>