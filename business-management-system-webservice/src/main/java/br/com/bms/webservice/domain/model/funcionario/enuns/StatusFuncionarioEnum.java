package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum StatusFuncionarioEnum {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String status;
	
	StatusFuncionarioEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
