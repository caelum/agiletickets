package br.com.caelum.agiletickets.models;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.agiletickets.exceptions.DataInicioSuperiorDataFimException;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.vagas(5, 3));
	}

	@Test
	public void deveCriarUmaSessaoDiaria() {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2013, 10, 26);
		LocalDate fim = new LocalDate(2013, 10, 26);
		LocalTime horario = new LocalTime(16, 10);
		Periodicidade diaria = Periodicidade.DIARIA;
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, diaria);
		
		Assert.assertEquals(1, sessoes.size());
		Sessao sessao = sessoes.get(0);
		Assert.assertEquals("26/10/13", sessao.getDia());
		Assert.assertEquals("16:10", sessao.getHora());
	}
	
	@Test
	public void deveCriarDuasSessoesDiarias() {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2013, 10, 26);
		LocalDate fim = new LocalDate(2013, 10, 27);
		LocalTime horario = new LocalTime(16, 10);
		Periodicidade diaria = Periodicidade.DIARIA;
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, diaria);
		
		Assert.assertEquals(2, sessoes.size());
		
		Sessao sessao = sessoes.get(0);
		Assert.assertEquals("26/10/13", sessao.getDia());
		Assert.assertEquals("16:10", sessao.getHora());
		
		sessao = sessoes.get(1);
		Assert.assertEquals("27/10/13", sessao.getDia());
		Assert.assertEquals("16:10", sessao.getHora());
	}
	
	@Test(expected = DataInicioSuperiorDataFimException.class)
	public void naoDeveCriarSessoesSeInicioDepoisDoFim() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2013, 10, 26);
		LocalDate fim = new LocalDate(2013, 10, 25);
		LocalTime horario = new LocalTime(16, 10);
		Periodicidade diaria = Periodicidade.DIARIA;
		espetaculo.criaSessoes(inicio, fim, horario, diaria);
	}
	
	@Test
	public void deveCriarUmaSessaoSemanal() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2013, 10, 26);
		LocalDate fim = new LocalDate(2013, 11, 1);
		LocalTime horario = new LocalTime(16, 10);
		Periodicidade diaria = Periodicidade.SEMANAL;
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, diaria);
		
		Assert.assertEquals(1, sessoes.size());
		Sessao sessao = sessoes.get(0);
		Assert.assertEquals("26/10/13", sessao.getDia());
		Assert.assertEquals("16:10", sessao.getHora());
	}
	
	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
}
