package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum SexoEnum {

	FEMININO("Feminino"),
	MASCULINO("Masculino");
	
	private String sexo;
	
	private SexoEnum(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}
}
