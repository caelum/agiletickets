package br.com.caelum.agiletickets.domain;

import java.util.List;

import br.com.caelum.agiletickets.models.Espetaculo;

public interface Agenda {

	List<Espetaculo> espetaculos();

	void cadastra(Espetaculo espetaculo);

}
