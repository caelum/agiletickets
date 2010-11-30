package br.com.caelum.agiletickets.domain;

import java.util.List;

import br.com.caelum.agiletickets.models.Estabelecimento;

public interface DiretorioDeEstabelecimentos {

	List<Estabelecimento> todos();

	void adiciona(Estabelecimento estabelecimento);

}
