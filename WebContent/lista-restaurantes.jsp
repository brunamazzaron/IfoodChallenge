<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Restaurante</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
	<div class="container">
		<h1>Restaurantes</h1>
		<table class="table table-striped">
			<tr>
				<th>Nome do Restaurantes</th>
				<th>CNPJ</th>
				<th>Categoria</th>
				<th>Data de Inauguração</th>
			</tr>
			<c:forEach items="${restaurante}" var="p">
				<tr>
					<td>${p.nome}</td>
					<td>${p.cnoj}</td>
					<td>${p.categoria}</td>
					<td>
						<fmt:formatDate value="${p.dataInauguracao.time }" pattern="dd/MM/yyyy"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<%@ include file="footer.jsp" %>

</body>
</html>