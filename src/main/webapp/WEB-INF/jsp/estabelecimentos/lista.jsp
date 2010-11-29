<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Lista de Estabelecimentos</title>
	</head>
	<body>
		
		<table border="1">
			<caption>Lista de estabelecimentos</caption>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Endereço</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${estabelecimentoList}" var="estabelecimento">
					<tr>
						<td>${estabelecimento.nome }</td>
						<td>${estabelecimento.endereco }</td>
					</tr>				
				</c:forEach>
			</tbody>	
		</table>
	</body>
</html>