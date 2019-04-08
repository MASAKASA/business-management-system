package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum StatusLogin {

	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String status;
	
	private StatusLogin(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
