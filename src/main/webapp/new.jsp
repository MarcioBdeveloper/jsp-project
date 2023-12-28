<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos - Novo</title>
<link rel="stylesheet" href="style.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head
<body>
	<h1>Criar novo contato</h1>
    <form id="frmContact" name="frmContact" action="insert">
        <table>
			<tr>
				<td><input type="text" name="name" id="name" placeholder="Nome"
					class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" id="fone" placeholder="Fone" class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" placeholder="E-mail"
					class="Caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="zipCode" id="zipCode" placeholder="CEP" class="Caixa1" onblur="findCep()"></td>
			</tr>
			<tr>
				<td><input type="text" name="adress" id="adress" placeholder="Endereço" class="Caixa1"></td>
			</tr>
		</table>
		<input type="button" value="Adicionar" class="Botao1" onclick="validateVields()">
    </form>
    
    <script src="scripts/validator.js">
	</script>
	
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
