package br.com.caelum.agiletickets.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Estabelecimento {

	// atributo id
	@Id
	@GeneratedValue
	private Long id;

	// atributo nome
	private String nome;

	// atributo endereco
	private String endereco;

<<<<<<< HEAD
	// todos os getters e setters
=======
	private Boolean temEstacionamento = false;

>>>>>>> origin/estacionamento
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTemEstacionamento(boolean temEstacionamento) {
		this.temEstacionamento = temEstacionamento;
	}

	public boolean isTemEstacionamento() {
		return temEstacionamento != null && temEstacionamento;
	}

}
