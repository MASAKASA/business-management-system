package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum SetorEnum {

	FINANCEIRO("Financeiro"),
	ESCRITORIO("Escritório"),
	VENDAS("Vendas"),
	EXTERNO("Externo"),
	ESTOQUE("Estoque"),
	FRENTE_DE_LOJA("Frente de loja"),
	ATENDIMENTO("Atendimento"),
	RH("RH");
	
	private String setor;
	
	private SetorEnum(String setor) {
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}
}
