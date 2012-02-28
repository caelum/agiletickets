package br.com.caelum.agiletickets.models;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

@Entity
public class Sessao {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Espetaculo espetaculo;

	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime inicio;

	private Integer duracaoEmMinutos;

	private Integer totalIngressos = 0;

	private Integer ingressosReservados = 0;

	public Long getId() {
		return id;
	}

	public void setEspetaculo(Espetaculo espetaculo) {
		this.espetaculo = espetaculo;
	}

	public DateTime getInicio() {
		return inicio;
	}

	public void setInicio(DateTime inicio) {
		this.inicio = inicio;
	}

	public Espetaculo getEspetaculo() {
		return espetaculo;
	}

	public Integer getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	public String getDia() {
		return inicio.toString(DateTimeFormat.shortDate().withLocale(new Locale("pt", "BR")));
	}

	public String getHora() {
		return inicio.toString(DateTimeFormat.shortTime().withLocale(new Locale("pt", "BR")));
	}

	public Integer getTotalIngressos() {
		return totalIngressos;
	}

	public void setTotalIngressos(Integer totalIngressos) {
		this.totalIngressos = totalIngressos;
	}

	public Integer getIngressosReservados() {
		return ingressosReservados;
	}

	public void setIngressosReservados(Integer ingressosReservados) {
		this.ingressosReservados = ingressosReservados;
	}

	public Integer getIngressosDisponiveis() {
		return totalIngressos - ingressosReservados;
	}

	public void reserva(Integer numeroDeIngressos) {
		this.ingressosReservados += numeroDeIngressos;
	}

	public boolean podeReservar(Integer numeroDeIngressos) {
		return getIngressosDisponiveis() > numeroDeIngressos;
	}
}
