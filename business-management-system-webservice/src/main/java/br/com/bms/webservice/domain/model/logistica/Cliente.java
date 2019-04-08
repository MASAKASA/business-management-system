package br.com.bms.webservice.domain.model.logistica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.bms.webservice.domain.model.funcionario.Funcionario;
import br.com.bms.webservice.domain.model.logistica.enuns.FormaPagamentoEnum;
import br.com.bms.webservice.domain.model.logistica.enuns.PrazoPagamentoEnum;
import br.com.bms.webservice.domain.model.logistica.enuns.StatusClienteEnum;
import br.com.bms.webservice.domain.model.util.Endereco;
import br.com.bms.webservice.domain.model.util.Telefone;
import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.types.ParametroTipo;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 4911043858029910677L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long id;
	
	@NotBlank
	@Size(max=255)
	@Column(name="razao_social")
	private String razaoSocial;
	
	@NotBlank
	@Size(max=255)
	@Column(name="nome_fantasia")
	private String nomeFantasia;
	
	@NotBlank
	@Verify(ParametroTipo.IE_PERNAMBUCO_PE_FORMATADO)
	@Column(name="incricao_estadual")
	private String inscricaoEstadual;
	
	@NotBlank
	@Size(max=20)
	@Column(name="inscricao_municipal")
	private String inscricaoMunicipal;
	
	@Email
	private String email;
	
	@CNPJ
	private String cnpj;
	
	@CPF
	private String cpf;
	
	@Size(max=255)
	@Column(name="ponto_de_referencia")
	private String pontoDeReferencia; 
	
	@NotBlank
	@DecimalMin("0.00")
	@Column(name="limite_de_compra")
	private BigDecimal limiteDeCompra;
	
	@Column(name="saldo_devedor")
	private BigDecimal saldoDevedor;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="forma_pagamento")
	private FormaPagamentoEnum formaPagamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="prazo_pagamento")
	private PrazoPagamentoEnum prazoPagamento = null;	
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="status_cliente")
	private StatusClienteEnum statusCliente;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "loja_id")
	private Loja loja;
	
	@NotBlank
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "funcionario_id")
	private Funcionario vendedor;

	@OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER) 
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Venda> listaCompras;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Telefone> listaTelefones;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "clientes_enderecos",
			joinColumns = @JoinColumn(name = "id_cliente"),
			inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
	private List<Endereco> listaEnderecos;
	
	public Cliente() {
		super();
	}
	
	public void addVenda(Venda venda) {
		if (listaCompras == null) {
			listaCompras = new ArrayList<Venda>();
		}
		venda.setCliente(this);
		listaCompras.add(venda);
	}
	
	public void delVenda(Venda venda) {
		if (listaCompras != null) {
			listaCompras.remove(venda);
		}
	}
	
	public void addTelefone(Telefone telefone) {
		if (listaTelefones == null) {
			listaTelefones = new ArrayList<Telefone>();
		}
		telefone.setCliente(this);
		listaTelefones.add(telefone);
	}
	
	public void delTelefone(Telefone telefone) {
		if (listaTelefones != null) {
			listaTelefones.remove(telefone);
		}
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
				+ ", inscricaoEstadual=" + inscricaoEstadual + ", inscricaoMunicipal=" + inscricaoMunicipal + ", email="
				+ email + ", cnpj=" + cnpj + ", cpf=" + cpf + ", pontoDeReferencia=" + pontoDeReferencia
				+ ", limiteDeCompra=" + limiteDeCompra + ", saldoDevedor=" + saldoDevedor + ", formaPagamento="
				+ formaPagamento + ", prazoPagamento=" + prazoPagamento + ", statusCliente=" + statusCliente + ", loja="
				+ loja + ", vendedor=" + vendedor + ", listaCompras=" + listaCompras + ", listaTelefones=" + listaTelefones + ", listaEnderecos="
				+ listaEnderecos + "]";
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
		Cliente other = (Cliente) obj;
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPontoDeReferencia() {
		return pontoDeReferencia;
	}

	public void setPontoDeReferencia(String pontoDeReferencia) {
		this.pontoDeReferencia = pontoDeReferencia;
	}

	public BigDecimal getLimiteDeCompra() {
		return limiteDeCompra;
	}

	public void setLimiteDeCompra(BigDecimal limiteDeCompra) {
		this.limiteDeCompra = limiteDeCompra;
	}

	public BigDecimal getSaldoDevedor() {
		return saldoDevedor;
	}

	public void setSaldoDevedor(BigDecimal saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}

	public FormaPagamentoEnum getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public PrazoPagamentoEnum getPrazoPagamento() {
		return prazoPagamento;
	}

	public void setPrazoPagamento(PrazoPagamentoEnum prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public StatusClienteEnum getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(StatusClienteEnum statusCliente) {
		this.statusCliente = statusCliente;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public List<Venda> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(List<Venda> listaCompras) {
		this.listaCompras = listaCompras;
	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
}
