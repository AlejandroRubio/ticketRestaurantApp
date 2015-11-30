package com.example.tickets.calculator;

public class EstructuraResultados {

	
	private int numTicketsGrandes;
	private int numTicketsPequenos;
	private float restoAPagar;
	
	public EstructuraResultados(){}
	
	public EstructuraResultados(int numTicketsGrandes, int numTicketsPequenos, float restoAPagar) {
		this.numTicketsGrandes = numTicketsGrandes;
		this.numTicketsPequenos = numTicketsPequenos;
		this.restoAPagar = restoAPagar;
	}
	
	public int getNumTicketsGrandes() {
		return numTicketsGrandes;
	}
	public void setNumTicketsGrandes(int numTicketsGrandes) {
		this.numTicketsGrandes = numTicketsGrandes;
	}
	public int getNumTicketsPequenos() {
		return numTicketsPequenos;
	}
	public void setNumTicketsPequenos(int numTicketsPequenos) {
		this.numTicketsPequenos = numTicketsPequenos;
	}
	public float getRestoAPagar() {
		return restoAPagar;
	}
	public void setRestoAPagar(float restoAPagar) {
		this.restoAPagar = restoAPagar;
	}
	
	
}
