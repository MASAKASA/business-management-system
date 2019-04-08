package br.com.bms.webservice.domain.model.funcionario;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.bms.webservice.domain.model.funcionario.enuns.StatusLogin;

@Entity
@Table(name="logins")
public class Login implements Serializable {
	
	private static final long serialVersionUID = -3886531119225207365L;
 
	@Id //Id da tabela
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Estrategia de auto incremento
	@Column(name="id_login") //Nome da coluna
	private Long id;
	
	@NotBlank //Informando que nao pode ter valor nulo nem vazio
	@Size(min = 3) //Tamanho minimo
	@Column(name="login_usuario", nullable = false, unique = true) //Nome da coluna e informando que nao pode ser vazio com o false
	private String login;
	
	@NotBlank //Informando que nao pode ter valor nulo nem vazio
	@Size(min = 3, max = 8) //Tamanho minimo e maximo
	@Column(name="senha_usuario", nullable=false) //Nome da coluna e informando que nao pode ser vazio com o false
	private String senha;
	
	@NotBlank
	@Column(name = "status_login", nullable=false)
	@Enumerated(EnumType.STRING)
	private StatusLogin statusLogin;
	
	@NotBlank
	@JoinColumn(name = "funcionario_id", nullable = false)
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Funcionario funcionario;

	public Login() {
		super();
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", senha=" + senha + ", statusLogin=" + statusLogin
				+ ", funcionario=" + funcionario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public StatusLogin getStatusLogin() {
		return statusLogin;
	}

	public void setStatusLogin(StatusLogin statusLogin) {
		this.statusLogin = statusLogin;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
