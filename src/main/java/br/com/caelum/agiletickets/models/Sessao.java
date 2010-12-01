package br.com.caelum.agiletickets.models;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Entity
public class Sessao {

	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormat.shortDate().withLocale(new Locale("pt", "BR"));
	private static final DateTimeFormatter FORMATO_HORA = DateTimeFormat.shortTime().withLocale(new Locale("pt", "BR"));

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Espetaculo espetaculo;

	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime inicio;

	private Integer duracaoEmMinutos;

	private Integer totalLugares;

	private Integer lugaresReservados = 0;

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
		return inicio.toString(FORMATO_DIA);
	}

	public String getHora() {
		return inicio.toString(FORMATO_HORA);
	}

	public Integer getTotalLugares() {
		return totalLugares;
	}

	public void setTotalLugares(Integer totalLugares) {
		this.totalLugares = totalLugares;
	}

	public Integer getLugaresReservados() {
		return lugaresReservados;
	}

	public void setLugaresReservados(Integer lugaresReservados) {
		this.lugaresReservados = lugaresReservados;
	}

	public Integer getLugaresDisponiveis() {
		return totalLugares - lugaresReservados;
	}

	public void reserva(Integer lugares) {
		this.lugaresReservados += lugares;
	}

	public boolean podeReservar(Integer quantidade) {
		return getLugaresDisponiveis() > quantidade;
	}
}
