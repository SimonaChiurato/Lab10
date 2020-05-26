package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;

public class Event implements Comparable<Event>{
	
	public enum EventType{
		ARRIVO_GRUPPO_CLIENTI,USCITA_GRUPPO_CLIENTI
	}
	private LocalTime time; // minuti tra 1 e 10
	private int num_persone; // persone tra 1 e 10
	private Duration durata; // tempo dentro bar tra 60 e 120
	private float tolleranza; // 0.0 no tolleranti, 0.9--> 90% probabilità di andare al bancone
	private EventType type;
	private Tavolo tavolo;
	
	public Event(LocalTime time, int num_persone, Duration durata, float tolleranza, EventType type) {
		super();
		this.time = time;
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.type=type;
	}
	
	public Event(LocalTime time, Tavolo t, EventType type) {
		this.time=time;
		this.tavolo=t;
		this.type=type;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public int getNum_persone() {
		return num_persone;
	}

	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}

	public Duration getDurata() {
		return durata;
	}

	public void setDurata(Duration durata) {
		this.durata = durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	@Override
	public int compareTo(Event o) {
	return this.time.compareTo(o.time);
	}

	@Override
	public String toString() {
		return "Event [time=" + time + ", num_persone=" + num_persone + ", durata=" + durata + ", tolleranza="
				+ tolleranza ;
	}

	public EventType getType() {
	
		return this.type;
	}
	
	

}
