package br.com.caelum.agiletickets;

import javax.persistence.EntityManager;

import org.joda.time.DateTime;

import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.agiletickets.models.Estabelecimento;
import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;
import br.com.caelum.vraptor.util.jpa.EntityManagerCreator;
import br.com.caelum.vraptor.util.jpa.EntityManagerFactoryCreator;

public class PreencheBanco {

	public static void main(String[] args) {
		EntityManagerFactoryCreator creator = new EntityManagerFactoryCreator();
		creator.create();
		EntityManagerCreator managerCreator = new EntityManagerCreator(creator.getInstance());
		managerCreator.create();
		EntityManager manager = managerCreator.getInstance();

		manager.getTransaction().begin();
		manager.createQuery("delete from Sessao").executeUpdate();
		manager.createQuery("delete from Espetaculo").executeUpdate();
		manager.createQuery("delete from Estabelecimento").executeUpdate();
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setNome("Casa da mãe Joana");
		estabelecimento.setEndereco("Rua da vovó. Casa ao lado.");

		Espetaculo espetaculo = new Espetaculo();
		espetaculo.setEstabelecimento(estabelecimento);
		espetaculo.setNome("O mundo maravilhoso dos unicórnios e arco-íris");
		espetaculo.setTipo(TipoDeEspetaculo.BALLET);


		manager.persist(estabelecimento);
		manager.persist(espetaculo);

		for (int i = 0; i < 10; i++) {
			Sessao sessao = new Sessao();
			sessao.setEspetaculo(espetaculo);
			sessao.setInicio(new DateTime().plusDays(7+i));
			sessao.setDuracaoEmMinutos(60 * 3);
			sessao.setTotalIngressos(10);
			sessao.setIngressosReservados(10 - i);
			manager.persist(sessao);
		}

		manager.getTransaction().commit();
		manager.close();
	}
}
