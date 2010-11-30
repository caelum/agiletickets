package br.com.caelum.agiletickets.controllers;

import java.util.List;

import br.com.caelum.agiletickets.domain.Agenda;
import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

import com.google.common.base.Strings;

@Resource
public class EspetaculosController {

	private final Agenda agenda;
	private Validator validator;
	private Result result;

	public EspetaculosController(Agenda agenda, Validator validator, Result result) {
		super();
		this.agenda = agenda;
		this.validator = validator;
		this.result = result;
	}

	@Get @Path("/espetaculos")
	public List<Espetaculo> lista() {
		return agenda.espetaculos();
	}

	@Post @Path("/espetaculos")
	public void adiciona(final Espetaculo espetaculo) {
		validator.checking(new Validations() {{
			that(!Strings.isNullOrEmpty(espetaculo.getNome()), "espetaculo.nome", "nome.nulo");
			that(!Strings.isNullOrEmpty(espetaculo.getDescricao()), "espetaculo.descricao", "descricao.nula");
		}});
		validator.onErrorRedirectTo(this).lista();

		agenda.cadastra(espetaculo);
		result.redirectTo(this).lista();
	}
}
