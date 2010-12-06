<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Lista de Estabelecimentos</title>
	</head>
	<body>
		
		<h2>Adicionar Estabelecimento</h2>
		<form id="addForm" action="" method="post">
			<label for="nome">Nome:</label>
			<input type="text" name="estabelecimento.nome" id="nome"/>
			<label for="endereco">Endereco:</label>
			<input type="text" name="estabelecimento.endereco" id="endereco"/>
			
			<input type="submit" value="Adicionar"/>
		</form>
		
		<table id="lista" cellpadding="0" cellspacing="0" width="100%">
			<caption>Lista de estabelecimentos</caption>
			<colgroup>
			  <col width="5%">
			  <col width="40%">
			  <col>
			</colgroup>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Endereço</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${estabelecimentoList}" var="estabelecimento">
					<tr>
						<td>${estabelecimento.id }</td>
						<td>${estabelecimento.nome }</td>
						<td>${estabelecimento.endereco }</td>
					</tr>				
				</c:forEach>
			</tbody>	
		</table>
	</body>
</html>