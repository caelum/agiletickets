<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>${sessao.espetaculo.nome }</title>
	</head>

	<body>
		<h1>${sessao.espetaculo.nome }</h1>
		<h2>${sessao.dia } às ${sessao.hora}</h2>
		<p><span class="label">Local:</span> ${sessao.espetaculo.estabelecimento.nome }</p>
		<p><span class="label">Endereço:</span> ${sessao.espetaculo.estabelecimento.endereco }</p>
		<p><span class="label">Descrição:</span> ${sessao.espetaculo.descricao }</p>
		<p><span class="label">Duração:</span> ${sessao.duracaoEmMinutos } minutos</p>
		<p><span class="label">Preco:</span> <fmt:formatNumber type="currency" value="${sessao.preco}" /></p>
		<p><span class="label">Ingressos disponíveis:</span> ${sessao.ingressosDisponiveis }</p>
		<c:if test="${sessao.ingressosDisponiveis gt 0}">
			<form action="/sessao/${sessao.id}/reserva" method="post">
				<h3>Reservar ingresso</h3>
				<label for="qtde">Quantidade</label>
				<input id="qtde" name="quantidade"/>
				
				<input type="submit" value="Reservar"/>
			</form>
		</c:if>
	</body>

</html>