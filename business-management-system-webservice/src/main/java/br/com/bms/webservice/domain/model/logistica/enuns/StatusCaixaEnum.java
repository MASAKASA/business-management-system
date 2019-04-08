package br.com.bms.webservice.domain.model.logistica.enuns;

public enum StatusCaixaEnum {
	
	ABERTO("aberto"),
	FECHADO("fechado");
	
	private String status;
	
	StatusCaixaEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
