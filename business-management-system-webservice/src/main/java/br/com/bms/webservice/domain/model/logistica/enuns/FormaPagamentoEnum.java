package br.com.bms.webservice.domain.model.logistica.enuns;

public enum FormaPagamentoEnum {
	
	A_VISTA("À vista"),
	A_PRAZO("A prazo"),
	CARNE("Carne"),
	CHEQUE("Cheque"),
	CARTAO_DE_CREDITO("Cartão de credito"),
	CARTAO_DE_DEBITO("Cartão de debito");
	
	private String formaPagamento;
	
	FormaPagamentoEnum(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}
}
