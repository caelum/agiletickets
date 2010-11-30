package br.com.caelum.agiletickets.controllers;

import br.com.caelum.agiletickets.domain.Agenda;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {

	private final Agenda agenda;
	private final Result result;

	public IndexController(Agenda agenda, Result result) {
		this.agenda = agenda;
		this.result = result;
	}

	@Path("/")
	public void index() {
		result.include("sessoes", agenda.proximasSessoes(10));
	}
}
