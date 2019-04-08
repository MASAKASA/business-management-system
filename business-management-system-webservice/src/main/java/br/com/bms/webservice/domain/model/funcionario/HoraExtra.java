package br.com.bms.webservice.domain.model.funcionario;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.bms.webservice.domain.model.logistica.Loja;

public class HoraExtra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4315531223795437093L;

	private Long id;
	private Date data;
	private BigDecimal valor;
	private Loja loja;
	private Funcionario funcionario;

	public HoraExtra() {
		super();
	}

	@Override
	public String toString() {
		return "HoraExtra [id=" + id + ", data=" + data + ", valor=" + valor + ", loja=" + loja + ", funcionario="
				+ funcionario + "]";
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
		HoraExtra other = (HoraExtra) obj;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
