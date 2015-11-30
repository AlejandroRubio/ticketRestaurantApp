package com.example.tickets.database;

public class TamanoConfiguracion {

	private int id;
	private float tamanoTicketsGrandes;
	private float tamanoTicketsPequenos;

	public TamanoConfiguracion(){}

	public TamanoConfiguracion(float tamanoTicketsGrandes, float tamanoTicketsPequenos) {
		super();
		this.tamanoTicketsGrandes = tamanoTicketsGrandes;
		this.tamanoTicketsPequenos = tamanoTicketsPequenos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTamanoTicketsGrandes() {
		return tamanoTicketsGrandes;
	}

	public void setTamanoTicketsGrandes(float tamanoTicketsGrandes) {
		this.tamanoTicketsGrandes = tamanoTicketsGrandes;
	}

	public float getTamanoTicketsPequenos() {
		return tamanoTicketsPequenos;
	}

	public void setTamanoTicketsPequenos(float tamanoTicketsPequenos) {
		this.tamanoTicketsPequenos = tamanoTicketsPequenos;
	}


}
