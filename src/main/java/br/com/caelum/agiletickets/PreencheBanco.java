package br.com.caelum.agiletickets;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.util.jpa.EntityManagerCreator;
import br.com.caelum.vraptor.util.jpa.EntityManagerFactoryCreator;

public class PreencheBanco {

	public static void main(String[] args) {
		EntityManager manager = createEntityManager();

		manager.close();


		//TODO preencher dados iniciais aqui
	}

	private static EntityManager createEntityManager() {
		EntityManagerFactoryCreator creator = new EntityManagerFactoryCreator();
		creator.create();
		EntityManagerCreator managerCreator = new EntityManagerCreator(creator.getInstance());
		managerCreator.create();
		EntityManager manager = managerCreator.getInstance();
		return manager;
	}
}
