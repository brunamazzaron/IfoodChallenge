<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Restaurante</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
	<h1>Cadastro de Restaurante</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	
	<form action="restaurante" method="post">
	
		<div class="form-group">
			<label for="id-nome">Nome do Restaurante</label>
			<input type="text" name="nome" id="id-nome" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-valor">CNPJ</label>
			<input type="text" name="cnpj" id="id-cnpj" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-quantidade">Categoria</label>
			<input type="text" name="categoria" id="id-categoria" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-fabricacao">Data de Inauguração</label>
			<input type="text" name="inauguracao" id="id-inauguracao" class="form-control">
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>