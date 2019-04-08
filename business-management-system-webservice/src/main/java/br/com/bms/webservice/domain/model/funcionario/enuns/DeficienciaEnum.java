package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum DeficienciaEnum {

	SEM_DEFICIENCIA("Sem deficiência"),
	FISICA("Fisica"),
	AUDITIVA("Auditiva"),
	VISUAL("Visual"),
	MENTAL("Mental"),
	MULTIPLA("Múltipla"),
	REABILITADO("Reabilitado");
	
	private String deficiencia;

	private DeficienciaEnum(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getDeficiencia() {
		return deficiencia;
	}
}
