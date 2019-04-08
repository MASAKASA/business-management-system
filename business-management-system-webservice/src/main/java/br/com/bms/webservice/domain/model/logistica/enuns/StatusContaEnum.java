package br.com.bms.webservice.domain.model.logistica.enuns;

public enum StatusContaEnum {

	PAGA("Paga"),
	VENCIDA("Vencida"),
	AGUARDANDO_PAGAMENTO("Aguardando pagamento");
	
	private String statusConta;

	private StatusContaEnum(String statusConta) {
		this.statusConta = statusConta;
	}

	public String getStatusConta() {
		return statusConta;
	}
}
