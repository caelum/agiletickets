package br.com.caelum.agiletickets.domain;

import java.util.List;

import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.agiletickets.models.Sessao;

public interface Agenda {

	List<Espetaculo> espetaculos();

	void cadastra(Espetaculo espetaculo);

	List<Sessao> proximasSessoes(int maximo);

}
