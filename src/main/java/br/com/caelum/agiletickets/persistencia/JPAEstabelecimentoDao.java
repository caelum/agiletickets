package br.com.caelum.agiletickets.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.agiletickets.domain.DiretorioDeEstabelecimentos;
import br.com.caelum.agiletickets.models.Estabelecimento;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class JPAEstabelecimentoDao implements DiretorioDeEstabelecimentos {

	private final EntityManager manager;
	public JPAEstabelecimentoDao(EntityManager manager) {
		this.manager = manager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estabelecimento> todos() {
		return manager.createQuery("select e from Estabelecimento e").getResultList();
	}

	@Override
	public void adiciona(Estabelecimento estabelecimento) {
		manager.persist(estabelecimento);
	}

}
