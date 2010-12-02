<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>${sessao.espetaculo.nome }</title>
	</head>

	<body>
		<h1>${sessao.espetaculo.nome }</h1>
		<h2>${sessao.dia } às ${sessao.hora}</h2>
		<p>Local: ${sessao.espetaculo.estabelecimento.nome }</p>
		<p>Endereço: ${sessao.espetaculo.estabelecimento.endereco }</p>
		<p>Descrição: ${sessao.espetaculo.descricao }</p>
		<p>Duração: ${sessao.duracaoEmMinutos } minutos</p>
		<p>Ingressos disponíveis: ${sessao.ingressosDisponiveis }</p>
		<c:if test="${sessao.ingressosDisponiveis gt 0}">
			<h3>Reservar ingresso</h3>
			<form action="/sessao/${sessao.id}/reserva" method="post">
				<label for="qtde">Quantidade</label>
				<input id="qtde" name="quantidade"/>
				
				<input type="submit" value="Reservar"/>
			</form>
		</c:if>
	</body>

</html>