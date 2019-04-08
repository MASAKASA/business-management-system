package br.com.bms.webservice.domain.model.produto.enuns;

public enum UnidadeEnum {

	PC("PC"),
	SC("SC"),
	FR("FR"),
	GD("GD"),
	CX("CX"),
	MPC("MPC"),
	MSC("MSC"),
	MFR("MFR"),
	MGD("MGD"),
	MCX("MCX"),
	LT("LT"),
	CT("CT"),
	UND("UND");
	
	private String unidade;

	private UnidadeEnum(String unidade) {
		this.unidade = unidade;
	}

	public String getUnidade() {
		return unidade;
	}
}
