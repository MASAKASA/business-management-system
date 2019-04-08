package br.com.bms.webservice.domain.model.funcionario;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.com.bms.webservice.domain.model.funcionario.enuns.AreaFormacaoEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.SituacaoFormacaoEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.TipoFormacaoEnum;

@Entity
@Table(name = "formacoes_escolares")
public class FormacaoEscolar implements Serializable {
	
	private static final long serialVersionUID = -5773060176738612077L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String curso;
	private String instituicaoEnsino;
	private AreaFormacaoEnum areaFormacao;
	private TipoFormacaoEnum tipoFormacao;
	private SituacaoFormacaoEnum situacaoFormacao;
	
	@NotBlank
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "endereco_id", nullable = false)
	private Funcionario funcionario;

	public FormacaoEscolar() {
		super();
	}

	@Override
	public String toString() {
		return "FormacaoEscolar [id=" + id + ", curso=" + curso + ", instituicaoEnsino=" + instituicaoEnsino
				+ ", areaFormacao=" + areaFormacao + ", tipoFormacao=" + tipoFormacao + ", situacaoFormacao="
				+ situacaoFormacao + ", funcionario=" + funcionario + "]";
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
		FormacaoEscolar other = (FormacaoEscolar) obj;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public AreaFormacaoEnum getAreaFormacao() {
		return areaFormacao;
	}

	public void setAreaFormacao(AreaFormacaoEnum areaFormacao) {
		this.areaFormacao = areaFormacao;
	}

	public TipoFormacaoEnum getTipoFormacao() {
		return tipoFormacao;
	}

	public void setTipoFormacao(TipoFormacaoEnum tipoFormacao) {
		this.tipoFormacao = tipoFormacao;
	}

	public SituacaoFormacaoEnum getSituacaoFormacao() {
		return situacaoFormacao;
	}

	public void setSituacaoFormacao(SituacaoFormacaoEnum situacaoFormacao) {
		this.situacaoFormacao = situacaoFormacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
