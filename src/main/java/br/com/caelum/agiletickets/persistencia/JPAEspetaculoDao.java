package br.com.caelum.agiletickets.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.agiletickets.domain.Agenda;
import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class JPAEspetaculoDao implements Agenda {

	private final EntityManager manager;

	public JPAEspetaculoDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Espetaculo> espetaculos() {
		return manager.createQuery("select e from Espetaculo e").getResultList();
	}

	@Override
	public void cadastra(Espetaculo espetaculo) {
		manager.persist(espetaculo);
	}
}
