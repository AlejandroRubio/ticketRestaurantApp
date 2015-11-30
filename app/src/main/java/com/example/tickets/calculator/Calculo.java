package com.example.tickets.calculator;

import android.util.Log;

/**Clase Calculo*/
public class Calculo {

	public EstructuraResultados calcular(float cantidadAPagar, float tamanoTicketGrande, float tamanoTicketPequeno) {
		
		EstructuraResultados estructura= realizarCalculoTickets(cantidadAPagar,tamanoTicketGrande,tamanoTicketPequeno);

		Log.i("Operación ", "Tickets grandes: " + estructura.getNumTicketsGrandes());
		Log.i("Operación ", "Tickets pequeños: " + estructura.getNumTicketsPequenos());
		Log.i("Operación ", "Resto a pagar: " + estructura.getRestoAPagar());

		return estructura;
	}
	
	public static EstructuraResultados realizarCalculoTickets(float cantidadAPagar, float tamanoTicketGrande, float tamanoTicketPequeno) {

		int numTicketsGrandes=(int) (cantidadAPagar/tamanoTicketGrande);
		float restoDeTicketsGrandes=(cantidadAPagar%tamanoTicketGrande);
		int numTicketsPequenos=(int) (restoDeTicketsGrandes/tamanoTicketPequeno);
		float restoAPagar=(restoDeTicketsGrandes%tamanoTicketPequeno);
		
		EstructuraResultados resultados= new EstructuraResultados(numTicketsGrandes, numTicketsPequenos, restoAPagar);

		return resultados;
	}

}
