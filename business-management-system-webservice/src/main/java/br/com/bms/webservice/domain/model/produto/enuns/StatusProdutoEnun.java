package br.com.bms.webservice.domain.model.produto.enuns;

public enum StatusProdutoEnun {

	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String status;

	private StatusProdutoEnun(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
