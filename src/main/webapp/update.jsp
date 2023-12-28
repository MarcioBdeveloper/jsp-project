<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de contatos - Editar</title>
<link rel="stylesheet" href="style.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmContact" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="caixa3" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><label for="name">Nome:</label></td>
			</tr>
			<tr>
				<td><input type="text" name="name" id="name" class="Caixa1"
					value="<%out.print(request.getAttribute("name"));%>"></td>
			</tr>
			<tr>
				<td><label for="fone">Telefone:</label></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" id="fone" class="Caixa2"
					value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><label for="email">Email:</label></td>
			</tr>
			<tr>
				<td><input type="text" name="email" id="email" class="Caixa1"
					value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><label for="zipCode">CEP:</label></td>
			</tr>
			<tr>
				<td><input type="text" name="zipCode" id="zipCode" class="Caixa1" onblur="findCep()"
					value="<%out.print(request.getAttribute("zipCode"));%>"></td>
			</tr>
			<tr>
				<td><label for="adress">Endereço:</label></td>
			</tr>
			<tr>
				<td><input type="text" name="adress" id="adress" class="Caixa1"
					value="<%out.print(request.getAttribute("adress"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validateVields()">
	</form>
	<script src="scripts/validator.js"></script>
	<script>
        function findCep() {
            var cep = $("#zipCode").val();
            $.ajax({
                type: "GET",
                url: "cep?zipCode=" + cep,
                success: function (response) {
                    document.getElementById("adress").value = response;
                }
            });
        }
    </script>
</body>
</html>