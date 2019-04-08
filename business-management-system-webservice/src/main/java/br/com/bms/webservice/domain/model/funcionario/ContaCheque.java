package br.com.bms.webservice.domain.model.funcionario;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

@Entity
@Table(name = "contra_cheques")
public class ContaCheque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5059368956773632373L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@DecimalMin("0.01") //Menos valor coluna
//	@Column(name="valor_salario") //Nome da coluna
//	private BigDecimal valor;
//	private BigDecimal abonoFamilia = null;
//	private BigDecimal quebraDeCaixa = null;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
//	private List<DescontoSalario> descontos;
//	private List<HoraExtra>  HorasExtras;

	public ContaCheque() {
		super();
	}

	@Override
	public String toString() {
		return "ContaCheque [id=" + id + ", funcionario=" + funcionario + "]";
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
		ContaCheque other = (ContaCheque) obj;
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

//	public BigDecimal getValor() {
//		return valor;
//	}
//
//	public void setValor(BigDecimal valor) {
//		this.valor = valor;
//	}
//
//	public BigDecimal getAbonoFamilia() {
//		return abonoFamilia;
//	}
//
//	public void setAbonoFamilia(BigDecimal abonoFamilia) {
//		this.abonoFamilia = abonoFamilia;
//	}
//
//	public BigDecimal getQuebraDeCaixa() {
//		return quebraDeCaixa;
//	}
//
//	public void setQuebraDeCaixa(BigDecimal quebraDeCaixa) {
//		this.quebraDeCaixa = quebraDeCaixa;
//	}
//
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
//
//	public List<DescontoSalario> getDescontos() {
//		return descontos;
//	}
//
//	public void setDescontos(List<DescontoSalario> descontos) {
//		this.descontos = descontos;
//	}
//
//	public List<HoraExtra> getHorasExtras() {
//		return HorasExtras;
//	}
//
//	public void setHorasExtras(List<HoraExtra> horasExtras) {
//		HorasExtras = horasExtras;
//	}
}
