package br.com.caelum.agiletickets.models;

public enum Periodicidade {
	DIARIA(1), SEMANAL(7);
	private int dias;
	
	Periodicidade(int dias){
		this.dias = dias;
	}
	
	public int getDias(){
		return dias;
	}
}
