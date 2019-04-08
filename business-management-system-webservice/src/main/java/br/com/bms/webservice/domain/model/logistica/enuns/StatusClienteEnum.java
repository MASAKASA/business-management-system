package br.com.bms.webservice.domain.model.logistica.enuns;

public enum StatusClienteEnum {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String status;
	
	StatusClienteEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
