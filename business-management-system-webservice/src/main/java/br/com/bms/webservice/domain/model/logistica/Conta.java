package br.com.bms.webservice.domain.model.logistica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.bms.webservice.domain.model.logistica.enuns.StatusContaEnum;

@Entity
@Table(name="contas")
public class Conta implements Serializable {

	private static final long serialVersionUID = -4691589962008697276L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conta")
	private Long id;
	
	@NotBlank
	@Size(max=255)
	private String descricao;
	
	@NotBlank
	@DecimalMin("0.00")
	private BigDecimal valor;
	
	@NotBlank
	@DecimalMin("0.00")
	private BigDecimal juros;
	
	@NotBlank
	private Date vencimento;	
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="status_conta")
	private StatusContaEnum statusConta;

	@NotBlank
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "cliente_id", nullable = false)
	private Loja loja;
	
	public Conta() {
		super();
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", juros=" + juros
				+ ", vencimento=" + vencimento + ", statusConta=" + statusConta + ", loja=" + loja + "]";
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
		Conta other = (Conta) obj;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public StatusContaEnum getStatusConta() {
		return statusConta;
	}

	public void setStatusConta(StatusContaEnum statusConta) {
		this.statusConta = statusConta;
	}
	
	public Loja getLoja() {
		return loja;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
}
