package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum TipoFormacaoEnum {

	TECNICO("Técnico"),
	GRADUACAO("Graduação"),
	ESPECIALIZACAO("Especialização"),
	MESTRADO("Mestrado"),
	DOUTORADO("Doutorado"),
	POS_DOUTORDO("Pós-doutorado");
	
	private String tipoFormacao;

	private TipoFormacaoEnum(String tipoFormacao) {
		this.tipoFormacao = tipoFormacao;
	}

	public String getTipoFormacao() {
		return tipoFormacao;
	}
}
