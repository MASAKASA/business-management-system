package br.com.bms.webservice.domain.model.logistica.enuns;

public enum PrazoPagamentoEnum {
	
	UM_DIA("1 dia"),
	SETE_DIAS("7 dias"),
	QUINZE_DIAS("15 dias"),
	VINTE_UM_DIAS("21 dias"),
	UM_MES("1 mês"),
	DOIS_MESES("2 meses");
	
	private String prazoPagamento;
	
	PrazoPagamentoEnum(String prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public String getPrazoPagamento() {
		return prazoPagamento;
	}
}
