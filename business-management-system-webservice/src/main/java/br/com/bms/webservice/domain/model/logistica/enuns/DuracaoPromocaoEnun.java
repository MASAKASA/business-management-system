package br.com.bms.webservice.domain.model.logistica.enuns;

public enum DuracaoPromocaoEnun {

	ATE_ACABAR_ESTOQUE("Até o estoque acabar"),
	UM_DIA("Um dia");
	
	private String duracaoPromocao;

	private DuracaoPromocaoEnun(String duracaoPromocao) {
		this.duracaoPromocao = duracaoPromocao;
	}

	public String getDuracaoPromocao() {
		return duracaoPromocao;
	}
}
