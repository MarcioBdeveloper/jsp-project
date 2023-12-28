<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.ContactBens"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<ContactBens> lista = (ArrayList<ContactBens>) request.getAttribute("contacts");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="new.jsp" class="Botao1">Novo contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>
				<th>Endereco</th>
				<th>CEP</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getName()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getAdress()%></td>
				<td><%=lista.get(i).getZipCode()%></td>
				<td>
					<a href="select?id=<%=lista.get(i).getId()%>"
					class="Botao1">Editar</a>
					<a href="javascript: confirme(<%=lista.get(i).getId()%>)"
					class="Botao2">Excluir</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmAction.js"></script>
</body>
</html>