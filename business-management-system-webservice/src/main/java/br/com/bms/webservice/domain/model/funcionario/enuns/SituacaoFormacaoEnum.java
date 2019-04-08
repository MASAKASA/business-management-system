package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum SituacaoFormacaoEnum {

	 CONCLUIDO("Concluído"),
	 EM_ANDAMENTO("Em andamento"),
	 INCOMPLETA("Incometa");
	
	private String situacaoFormacao;

	private SituacaoFormacaoEnum(String situacaoFormacao) {
		this.situacaoFormacao = situacaoFormacao;
	}

	public String getSituacaoFormacao() {
		return situacaoFormacao;
	}
}
