package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
	private Simulator sim;
	private List<Tavolo> bar;
	
	public Model() {
		 bar= new ArrayList<>();
		bar.add(new Tavolo(10,false));
		bar.add(new Tavolo(10,false));
		bar.add(new Tavolo(8,false));
		bar.add(new Tavolo(8,false));
		bar.add(new Tavolo(8,false));
		bar.add(new Tavolo(8,false));
		bar.add(new Tavolo(6,false));
		bar.add(new Tavolo(6,false));
		bar.add(new Tavolo(6,false));
		bar.add(new Tavolo(6,false));
		bar.add(new Tavolo(4,false));
		bar.add(new Tavolo(4,false));
		bar.add(new Tavolo(4,false));
		bar.add(new Tavolo(4,false));
		bar.add(new Tavolo(4,false));
	
	}
	
	public void simulazione() {
			sim= new Simulator(bar);
			sim.run();		
	}
	
	public int getNumtot() {
		return sim.getTotClienti();
	}
	public int getSodd() {
		return sim.getSoddisfatti();
	}
	public int getInsodd() {
		return sim.getInsoddisfatti();
	}

}
