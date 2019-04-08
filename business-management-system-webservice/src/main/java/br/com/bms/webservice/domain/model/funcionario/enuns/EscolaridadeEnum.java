package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum EscolaridadeEnum {

	ANALFABETO("Analfabeto, inclusiveo que, embora tenha recebido instrução, não se alfabetizou"),
	ATE_5_ANO_INCOMPLETO("Até o 5º ano do Ensino Fundamental incompleto (antiga 4ª série) ou que se tenha alfabetizado sem ter frequentado escola regular"),
	ANO_5_COMPLETO("5º ano do Ensino Fundamental completo"),
	DO_6_9_INCOMPLETO("Do 6º ao 9º ano do Ensino Fundamental incompleto (antiga 5ª à 8ª série"),
	FUNDAMENTAL_COMPLETO("Ensino Fundamental completo"),
	MEDIO_INCOMPLETO("Ensino Médio incompleto"),
	MEDIO_COMPLETO("Ensino Médio completo"),
	TECNICO_INCOMPLETA("Educação Técnico incompleta"),
	TECNICO_COMPLETA("Educação Técnico completa"),
	SUPERIOR_INCOMPLETA("Educação Superior incompleta"),
	SUPERIOR_COMPLETA("Educação Superior completa"),
	ESPECIALIZACAO_INCOMPLETA("Especialização incompleta"),
	ESPECIALIZACAO_COMPLETA("Especialização completa"),
	MESTRADO("Mestrado completo"),
	DOUTORADO("Doutorado completo");
	
	private String escolaridade;
	
	private EscolaridadeEnum(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getEscolaridade() {
		return escolaridade;
	}
}
