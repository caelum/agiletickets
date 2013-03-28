package br.com.caelum.agiletickets.util;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.agiletickets.domain.Promocao;
import br.com.caelum.agiletickets.models.Sessao;

public class UtilTest {

	@Test
	public void verificaPromocaoValida() {
		Sessao sessao = new Sessao();
		sessao.setInicio(new DateTime());

		Promocao promocao = new Promocao();
		promocao.setInicio(new DateTime().minusHours(1));
		promocao.setFim(new DateTime().plusHours(1));

		Util util = new Util();
		Assert.assertTrue(util.dentroDoIntervalo(sessao, promocao));
	}

	@Test
	public void verificaPromocaoPassadaInvalida() {
		Sessao sessao = new Sessao();
		sessao.setInicio(new DateTime());

		Promocao promocao = new Promocao();
		promocao.setInicio(new DateTime().minusHours(1));
		promocao.setFim(new DateTime().minusMinutes(1));

		Util util = new Util();
		Assert.assertFalse(util.dentroDoIntervalo(sessao, promocao));
	}

	@Test
	public void verificaPromocaoFuturaInvalida() {
		Sessao sessao = new Sessao();
		sessao.setInicio(new DateTime());

		Promocao promocao = new Promocao();
		promocao.setInicio(new DateTime().plusMinutes(1));
		promocao.setFim(new DateTime().plusHours(1));

		Util util = new Util();
		Assert.assertFalse(util.dentroDoIntervalo(sessao, promocao));
	}

	@Test
	public void transformaPalavraEmTitulo() {
		Util util = new Util();
		util.setLimiteCaracteresTitulo(12);
		String titulo = util.transformaEmTitulo("um titulo qualquer");

		Assert.assertEquals("Um Titulo Qu", titulo);
	}

}
