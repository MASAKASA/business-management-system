package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum PensaoEnum {

	SIM("Sim"),
	NAO("Não");
	
	private String pensao;

	private PensaoEnum(String pensao) {
		this.pensao = pensao;
	}

	public String getPensao() {
		return pensao;
	}
}
