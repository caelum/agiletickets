package br.com.caelum.agiletickets.legado;

import javax.servlet.http.HttpServletRequest;

public class Extratora {
	private final HttpServletRequest req;

	public Extratora(HttpServletRequest req) {
		this.req = req;
	}

	public double executaProduto() {
		String valorUnitarioTexto = req.getParameter("valorUnitario");
		String quantidadeTexto = req.getParameter("quantidade");
		
		double valorUnitario = Double.parseDouble(valorUnitarioTexto);
		int quantidade = Integer.parseInt(quantidadeTexto);
		
		Calculadora calc = new Calculadora();
		
		return calc.multiplica(valorUnitario, quantidade);
	}

}
