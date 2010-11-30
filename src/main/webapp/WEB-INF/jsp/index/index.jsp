<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>Próximas sessões</h2>
	<ul>
	<c:forEach items="${sessoes}" var="sessao">
		<li>${sessao.dia} - ${sessao.espetaculo.nome }</li>
	</c:forEach>
	</ul>
</body>
</html>