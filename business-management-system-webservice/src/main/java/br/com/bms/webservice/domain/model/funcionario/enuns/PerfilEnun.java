package br.com.bms.webservice.domain.model.funcionario.enuns;

public enum PerfilEnun {

	ROLE_NAO_USUARIO("Não usuario do sistema"),
	ROLE_VENDEDOR_INTERNO("Vendedor interno"),
	ROLE_ADMIN("Administrador"),
	ROLE_ADMIN_MASTER("Administrador master");
	
	private String perfil;

	private PerfilEnun(String perfil) {
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}
}
