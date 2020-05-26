package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSimulator {

	public static void main(String args[]) {
		List<Tavolo> bar;
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
		Simulator sim = new Simulator(bar);
		sim.run();
		
		System.out.println(sim.getTotClienti()+"   soddd: "+sim.getSoddisfatti()+"   insodd: "+sim.getInsoddisfatti()+
				" percentuale inso: "+ ((float) sim.getInsoddisfatti()/ (float)sim.getTotClienti())+
				" percentuale so: "+ (float) sim.getSoddisfatti()/(float) sim.getTotClienti()+ 
				" percentuale ins/sodd: "+ (float) sim.getInsoddisfatti()/(float) sim.getSoddisfatti() );
		
		
	}
		

}
