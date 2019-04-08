package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum PeriodoMetaEnum {

	SEM_META("Sem meta"),
	DIARIA("Diária"),
	SEMANAL("Semanal"),
	QUIZENAL("Quinzenal"),
	MENSAL("Mensal"),
	BIMESTDAL("Bimestral"),
	TRIMESTRAL("Trimestral"),
	QUAMESTRAL("Quamestral"),
	SEMESTRAL("Semestral"),
	ANUAL("Anual");
	
	private String meta;
	
	private PeriodoMetaEnum(String meta) {
		this.meta = meta;
	}

	public String getMeta() {
		return meta;
	}
}
