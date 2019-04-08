package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum VeiculoEnum {

	SIM("Sim"),
	NAO("Não");
	
	private String veiculo;

	VeiculoEnum(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getVeiculo() {
		return veiculo;
	}
}
