package com.example.practicanoguiada.response;

public class EventoResponseRest extends ResponseRest{
	private EventoResponse eventoResponse = new EventoResponse();

	public EventoResponse getEventoResponse() {
		return eventoResponse;
	}

	public void setEventoResponse(EventoResponse eventoResponse) {
		this.eventoResponse = eventoResponse;
	}
	
}
