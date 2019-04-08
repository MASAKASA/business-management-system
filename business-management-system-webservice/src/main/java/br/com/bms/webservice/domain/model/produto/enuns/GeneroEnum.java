package br.com.bms.webservice.domain.model.produto.enuns;

public enum GeneroEnum {
	
	FEMININO("Feminino"),
	MASCULINO("Masculino"),
	UNISSEX("unissex");
	
	private String genero;
	
	GeneroEnum(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}
}
