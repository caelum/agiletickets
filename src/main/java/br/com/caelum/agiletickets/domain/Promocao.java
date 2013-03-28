package br.com.caelum.agiletickets.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

public class Promocao {
	private Long id;

	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime inicio;

	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime fim;

	private boolean sempre;

	public boolean isSempre() {
		return sempre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getInicio() {
		return inicio;
	}

	public void setInicio(DateTime inicio) {
		this.inicio = inicio;
	}

	public DateTime getFim() {
		return fim;
	}

	public void setFim(DateTime fim) {
		this.fim = fim;
	}

	public void setSempre(boolean sempre) {
		this.sempre = sempre;
	}

}
