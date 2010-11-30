package br.com.caelum.agiletickets.domain;

import org.joda.time.DateTime;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class RelogioDoSistema implements Relogio {

	@Override
	public DateTime agora() {
		return new DateTime();
	}

}
