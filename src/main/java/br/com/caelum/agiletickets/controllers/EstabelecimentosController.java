package br.com.caelum.agiletickets.controllers;

import java.util.List;

import br.com.caelum.agiletickets.domain.DiretorioDeEstabelecimentos;
import br.com.caelum.agiletickets.models.Estabelecimento;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class EstabelecimentosController {

	private final Result result;
	private final DiretorioDeEstabelecimentos diretorio;
	private final Validator validator;

	public EstabelecimentosController(DiretorioDeEstabelecimentos diretorio, Result result, Validator validator) {
		this.result = result;
		this.diretorio = diretorio;
		this.validator = validator;
	}

	@Get @Path("/estabelecimentos")
	public List<Estabelecimento> lista() {
		return diretorio.todos();
	}

	@Post @Path("/estabelecimentos")
	public void adiciona(Estabelecimento estabelecimento) {

	}

}
