<%@page pageEncoding="UTF-8" %>
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
		<p>Lugares disponíveis: ${sessao.lugaresDisponiveis }</p>
		<h3>Reservar ingresso</h3>
		<form action="/sessao/${sessao.id}/reserva" method="post">
			<label for="qtde">Quantidade</label>
			<input id="qtde" name="quantidade"/>
			
			<input type="submit" value="Reservar"/>
		</form>
	</body>

</html>