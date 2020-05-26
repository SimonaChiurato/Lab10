package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.bar.model.Event.EventType;

public class Simulator {
	
	// parametri simulazione


	private final LocalTime oraApertura= LocalTime.of(8, 00);
	private final LocalTime oraChiusura= LocalTime.of(23, 50);
	
	
	// valori output
	private int totClienti;
	private int soddisfatti;
	private int insoddisfatti;
	
	//modello mondo
	private List<Tavolo> bar; // numero tavolo, numero posti
	
	//coda prioritaria
	PriorityQueue<Event> queue;

	public Simulator( List<Tavolo> bar) {
		this.bar = bar;
		this.queue= new PriorityQueue<Event>();
		this.totClienti=0;
		this.insoddisfatti=0;
		this.soddisfatti=0;
	}

	public int getTotClienti() {
		return totClienti;
	}

	public int getSoddisfatti() {
		return soddisfatti;
	}

	public int getInsoddisfatti() {
		return insoddisfatti;
	}

	
	
	public void run() {
		this.queue.clear();
		
		LocalTime oraArrivoCliente= this.oraApertura;
		
		do {
			Random r= new Random();
			long intervalloArrivo= r.nextInt(10)+1;
			int numPersone= r.nextInt(10)+1;
			
			long durata= r.nextInt(61)+60;
			float tolleranza= r.nextInt(90);
			
			Event e= new Event(oraArrivoCliente.plus(Duration.of(intervalloArrivo, ChronoUnit.MINUTES)), numPersone, Duration.of(durata, ChronoUnit.MINUTES) , tolleranza/100, EventType.ARRIVO_GRUPPO_CLIENTI);
			this.queue.add(e);
			oraArrivoCliente= oraArrivoCliente.plus(Duration.of(intervalloArrivo, ChronoUnit.MINUTES));
		
		}while(oraArrivoCliente.isBefore(oraChiusura) );
		
		while(!this.queue.isEmpty()) {
			Event e= this.queue.poll();
			this.processEvent(e);
		}
	}

	private void processEvent(Event e) {
		switch(e.getType()) {
		case ARRIVO_GRUPPO_CLIENTI:
			Tavolo t= this.tavoloLibero(e.getNum_persone());
			if(t!=null) {
				
				this.totClienti+=e.getNum_persone();
				this.soddisfatti+=e.getNum_persone();
			this.queue.add(new Event(e.getTime().plus(e.getDurata()),t, EventType.USCITA_GRUPPO_CLIENTI));
			
			}else {
				Random r= new Random();
				this.totClienti+=e.getNum_persone();
				float test= r.nextInt(90);
				if((test/100)<e.getTolleranza()) {
					this.soddisfatti+=e.getNum_persone();
				}else {
					this.insoddisfatti+=e.getNum_persone();
				}

				
			}
			
			
			break;
		case USCITA_GRUPPO_CLIENTI:
			e.getTavolo().setOccupato(false);

			break;
		}
		
	}

	private Tavolo tavoloLibero(int num_persone) {
		Tavolo best=null;
	for(Tavolo t: bar) {
		if(t.isOccupato()==false) {
			if(t.getNumPosti()>=num_persone) {
				if(best==null) {
					best=t;
				}else if(t.getNumPosti()<best.getNumPosti()) {
					best=t;
				}
			}
		}
		
	}
	if(best!=null) {
		if((best.getNumPosti()-num_persone)>(best.getNumPosti()/2)) {
			return null;
		}
	best.setOccupato(true);
	}
	return best;
	}
}
