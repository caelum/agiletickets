package br.com.caelum.agiletickets.legado;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class CalculadoraServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Extratora extratora = new Extratora(req);
		
		double resultado = extratora.executaProduto();
		
		req.setAttribute("resultado", resultado);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("calculaPreco.jsp");
		dispatcher.forward(req, res);
	}
     
}
