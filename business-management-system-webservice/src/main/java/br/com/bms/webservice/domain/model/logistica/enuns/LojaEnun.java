package br.com.bms.webservice.domain.model.logistica.enuns;

public enum LojaEnun {

	MATRIZ("Matriz"),
	FILIAL("Filial");
	
	private String loja;

	private LojaEnun(String loja) {
		this.loja = loja;
	}

	public String getLoja() {
		return loja;
	}
}
