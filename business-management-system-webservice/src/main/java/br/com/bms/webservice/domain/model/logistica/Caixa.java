package br.com.bms.webservice.domain.model.logistica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import br.com.bms.webservice.domain.model.funcionario.Funcionario;
import br.com.bms.webservice.domain.model.logistica.enuns.StatusCaixaEnum;

@Entity //Entidade
@Table(name = "caixas") //Nome da tabela
public class Caixa implements Serializable{
	
	private static final long serialVersionUID = 4825401393613991083L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_caixa")
	private Long id;
	
	@NotBlank
	@DecimalMin("0.00")
	@Column(name="saldo_inicial")
	private BigDecimal saldoInicial;
	
	@NotBlank
	@DecimalMin("0.00")
	@Column(name="saldo_final")
	private BigDecimal saldoFinal;
	
	@NotBlank
	@Column(name="data_funcionamento")
	private Date dataFuncionamento; 
	
	@NotBlank
	@Column(name="hora_abertura")
	private Calendar horaAbertura;
	
	@NotBlank
	@Column(name="hora_fechamento")
	private Calendar horaFechamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status_caixa")
	private StatusCaixaEnum statusCaixa;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "loja_id", nullable = false)
	private Loja loja;
	
	
	public Caixa() {
		super();
	}

	@Override
	public String toString() {
		return "Caixa [id=" + id + ", saldoInicial=" + saldoInicial + ", saldoFinal=" + saldoFinal + ", dataFuncionamento=" + dataFuncionamento
				+ ", horaAbertura=" + horaAbertura + ", horaFechamento=" + horaFechamento + ", statusCaixa="
				+ statusCaixa + ", funcionario=" + funcionario + ", loja=" + loja + "]";
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
		Caixa other = (Caixa) obj;
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

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public BigDecimal getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(BigDecimal saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	public Date getDataFuncionamento() {
		return dataFuncionamento;
	}

	public void setDataFuncionamento(Date dataFuncionamento) {
		this.dataFuncionamento = dataFuncionamento;
	}

	public Calendar getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(Calendar horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	public Calendar getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(Calendar horaFechamento) {
		this.horaFechamento = horaFechamento;
	}

	public StatusCaixaEnum getStatusCaixa() {
		return statusCaixa;
	}

	public void setStatusCaixa(StatusCaixaEnum statusCaixa) {
		this.statusCaixa = statusCaixa;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
}
