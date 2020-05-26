package it.polito.tdp.bar.model;

public class Tavolo {
	private int numPosti;
	private boolean occupato;
	
	public Tavolo(int numPosti, boolean occupato) {
		super();
		this.numPosti = numPosti;
		this.occupato = occupato;
	}
	
	public int getNumPosti() {
		return numPosti;
	}
	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}
	public boolean isOccupato() {
		return occupato;
	}
	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

	
}
