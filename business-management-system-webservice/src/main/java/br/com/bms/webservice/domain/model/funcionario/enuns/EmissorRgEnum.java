package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum EmissorRgEnum {
	
	SSP("Secretaria de Segurança Pública"),
	PM("Polícia Militar"),
	PC("Policia Civil"),
	CNT("Carteira Nacional de Habilitação"),
	DIC("Diretoria de Identificação Civil"),
	CTPS("Carteira de Trabaho e Previdência Social"),
	FGTS("Fundo de Garantia do Tempo de Serviço"),
	IFP("Instituto Félix Pacheco"),
	IPF("Instituto Pereira Faustino"),
	IML("Instituto Médico-Legal"),
	MTE("Ministério do Trabalho e Emprego"),
	MMA("Ministério da Marinha"),
	MAE("Ministério da Aeronáutica"),
	MEX("Ministério do Exército"),
	POF("Polícia Federal"),
	POM("Polícia Militar"),
	SES("Carteira de Estrangeiro"),
	SJS("Secretaria da Justiça e Segurança"),
	SJTS("Secretaria da Justiça do Trabalho e Segurança"),
	ZZZ("Outros (inclusive exterior)");
	
	private String emissorRg;
	
	private EmissorRgEnum(String emissorRg) {
		this.emissorRg = emissorRg;
	}

	public String getEmissorRg() {
		return emissorRg;
	}
}
