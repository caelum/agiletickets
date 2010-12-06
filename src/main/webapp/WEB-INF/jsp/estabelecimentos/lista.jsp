<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Lista de Estabelecimentos</title>
	</head>
	<body>
		
		<a href="#addForm">Adicionar Estabelecimento</a>
		<form id="addForm" action="" method="post">
			<label for="nome">Nome:</label>
			<input type="text" name="estabelecimento.nome" id="nome"/>
			<label for="endereco">Endereco:</label>
			<input type="text" name="estabelecimento.endereco" id="endereco"/>
			
			<input type="submit" value="Adicionar"/>
		</form>
		
		<table id="lista" border="1">
			<caption>Lista de estabelecimentos</caption>
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