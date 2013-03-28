package br.com.caelum.agiletickets.util;

import br.com.caelum.agiletickets.domain.Promocao;
import br.com.caelum.agiletickets.models.Sessao;

public class Util {

	private int limiteCaracteresTitulo=7;

	public boolean dentroDoIntervalo(Sessao s, Promocao promocao) {
		return s.getInicio().isAfter(promocao.getInicio())
				&& s.getInicio().isBefore(promocao.getFim());
	}

	public void setLimiteCaracteresTitulo(int limiteCaracteresTitulo) {
		this.limiteCaracteresTitulo = limiteCaracteresTitulo;
	}

	public String transformaEmTitulo(String titulo) {
		String[] palavras = titulo.split("\\s");
		StringBuilder temp = new StringBuilder();

		for (String p : palavras) {
			String primeiraLetra = p.substring(0, 1);
			String restoDaPalavra = p.substring(1);
			temp.append(primeiraLetra.toUpperCase() + restoDaPalavra.toLowerCase() + " ");
		}

		String capitalizado = temp.toString();
		return capitalizado.substring(0, limiteCaracteresTitulo);
	}

}
