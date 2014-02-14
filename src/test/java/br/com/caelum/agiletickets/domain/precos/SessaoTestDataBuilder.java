package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Espetaculo;
import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class SessaoTestDataBuilder {

	private Espetaculo espetaculo;
	private BigDecimal preco;
	private int totalIngressos;
	private int ingressosReservados;
	private Integer duracaoEmMinutos;

	public static SessaoTestDataBuilder umaSessao() {
		return new SessaoTestDataBuilder();
	}
	
	public SessaoTestDataBuilder deUmEspetaculoDoTipo(TipoDeEspetaculo tipo){
		this.espetaculo = new Espetaculo();
		this.espetaculo.setTipo(tipo);
		return this;
	}

	public SessaoTestDataBuilder comOPreco(double preco) {
		this.preco = BigDecimal.valueOf(preco);
		return this;
	}

	public SessaoTestDataBuilder comTotalIngressos(int totalIngressos) {
		this.totalIngressos = totalIngressos;
		return this;
	}

	public SessaoTestDataBuilder comIngressoReservados(int ingressosReservados) {
		this.ingressosReservados = ingressosReservados;
		return this;
	}

	public SessaoTestDataBuilder comDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
		return this;
	}

	public Sessao build() {
		Sessao sessao = new Sessao();
		sessao.setEspetaculo(espetaculo);
		sessao.setPreco(preco);
		sessao.setTotalIngressos(totalIngressos);
		sessao.setIngressosReservados(ingressosReservados);
		sessao.setDuracaoEmMinutos(duracaoEmMinutos);
		return sessao;
	}

}
