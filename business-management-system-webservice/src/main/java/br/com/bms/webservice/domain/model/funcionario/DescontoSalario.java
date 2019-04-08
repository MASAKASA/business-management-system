package br.com.bms.webservice.domain.model.funcionario;

import java.io.Serializable;
import java.math.BigDecimal;

public class DescontoSalario implements Serializable {

	private static final long serialVersionUID = -3255042602569923357L;

	private Long id;
	private String discricao;
	private BigDecimal valor;
	
	public DescontoSalario() {
		super();
	}

	@Override
	public String toString() {
		return "DescontoSalario [id=" + id + ", discricao=" + discricao + ", valor=" + valor + "]";
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
		DescontoSalario other = (DescontoSalario) obj;
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

	public String getDiscricao() {
		return discricao;
	}

	public void setDiscricao(String discricao) {
		this.discricao = discricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
