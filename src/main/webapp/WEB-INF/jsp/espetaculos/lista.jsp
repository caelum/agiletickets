<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Lista de Espetáculos</title>
	</head>
	<body>
		
		<a href="#addForm">Adicionar Espetaculo</a>
		<form id="addForm" action="" method="post">
			<label for="nome">Nome:</label>
			<input type="text" name="espetaculo.nome" id="nome"/>
			<label for="descricao">Descrição:</label>
			<input type="text" name="espetaculo.descricao" id="descricao"/>
			<label for="tipo">Tipo:</label>
			<select id="tipo" name="espetaculo.tipo">
				<option value="CINEMA">Cinema</option>
				<option value="SHOW">Show</option>
				<option value="TEATRO">Teatro</option>
				<option value="BALLET">Balé</option>
				<option value="ORQUESTRA">Orquestra</option>
			</select>
			<label for="tipo">Local:</label>
			<select id="tipo" name="espetaculo.estabelecimento.id">
				<c:forEach items="${estabelecimentos}" var="estabelecimento">
					<option value="${estabelecimento.id}">${estabelecimento.nome }</option>
				</c:forEach>
			</select>
			
			<input type="submit" value="Adicionar"/>
		</form>
		
		<table border="1">
			<caption>Lista de espetáculos</caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Tipo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${espetaculoList}" var="espetaculo">
					<tr>
						<td>${espetaculo.id }</td>
						<td>${espetaculo.nome }</td>
						<td>${espetaculo.descricao }</td>
						<td>${espetaculo.tipo }</td>
						<td><a href="/espetaculo/${espetaculo.id }/sessoes">Criar sessões</a></td>
					</tr>				
				</c:forEach>
			</tbody>	
		</table>
	</body>
</html>