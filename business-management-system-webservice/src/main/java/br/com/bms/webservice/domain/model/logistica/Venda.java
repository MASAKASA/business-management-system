package br.com.bms.webservice.domain.model.logistica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.bms.webservice.domain.model.funcionario.Funcionario;
import br.com.bms.webservice.domain.model.logistica.enuns.FormaPagamentoEnum;
import br.com.bms.webservice.domain.model.logistica.enuns.PrazoPagamentoEnum;
import br.com.bms.webservice.domain.model.logistica.enuns.StatusVendaEnum;
import br.com.bms.webservice.domain.model.produto.Item;

@Entity
@Table(name="vendas")
public class Venda implements Serializable {

	private static final long serialVersionUID = 4447530561191935680L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_venda")
	private Long id;
	
	@Size(max=255)
	private String observacao;
	
	@Size(max=255)
	private String titulo;
	
	@Size(max=255)
	private String subTitulo;
	
	@Size(max=255)
	private String rodape;
	
	@DecimalMin("0.000")
	private Float pesoTotal;
	
	@Size(min=0)
	private Integer volumesTotal;
	
	@DecimalMin("0.00")
	private BigDecimal frete;
	
	@DecimalMin("0.00")
	private BigDecimal total;
	
	@DecimalMin("0.00")
	private BigDecimal subTotal;
	
	@DecimalMin("0.00")
	private BigDecimal desconto;
	
	@DecimalMin("0.00")
	private BigDecimal valorRecebido;
	
	@DecimalMin("0.00")
	private BigDecimal troco;
	
	@NotBlank
	@Column(name="data_compra")
	private Calendar dataCompra;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="status_venda")
	private StatusVendaEnum statusVenda;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="forma_pagamento")
	private FormaPagamentoEnum formaPagamento;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="prazo_pagamento")
	private PrazoPagamentoEnum prazoPagamento;
	
	@NotBlank
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "loja_id", nullable = false)
	private Loja loja;
	
	@NotBlank
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "vendedor_id", nullable = false)
	private Funcionario vendedor;
	
	@NotBlank
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "venda", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Item> itensVenda;
	
	public Venda() {
		super();
	}
	
	public void addItem(Item item) {
		if (itensVenda == null) {
			itensVenda = new ArrayList<Item>();
		}
		item.setVenda(this);
		itensVenda.add(item);
	}
	
	public void delItem(Item item) {
		if (itensVenda != null) {
			itensVenda.remove(item);
		}
	}
	
	@Override
	public String toString() {
		return "Venda [id=" + id + ", observacao=" + observacao + ", titulo=" + titulo + ", subTitulo=" + subTitulo
				+ ", rodape=" + rodape + ", pesoTotal=" + pesoTotal + ", volumesTotal=" + volumesTotal + ", frete="
				+ frete + ", total=" + total + ", subTotal=" + subTotal + ", desconto=" + desconto + ", valorRecebido="
				+ valorRecebido + ", troco=" + troco + ", dataCompra=" + dataCompra + ", statusVenda=" + statusVenda
				+ ", formaPagamento=" + formaPagamento + ", prazoPagamento=" + prazoPagamento + ", loja=" + loja
				+ ", vendedor=" + vendedor + ", cliente=" + cliente + ", itensVenda=" + itensVenda + "]";
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
		Venda other = (Venda) obj;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getRodape() {
		return rodape;
	}

	public void setRodape(String rodape) {
		this.rodape = rodape;
	}

	public Float getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(Float pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public Integer getVolumesTotal() {
		return volumesTotal;
	}

	public void setVolumesTotal(Integer volumesTotal) {
		this.volumesTotal = volumesTotal;
	}

	public BigDecimal getFrete() {
		return frete;
	}

	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	public StatusVendaEnum getStatusVenda() {
		return statusVenda;
	}

	public void setStatusVenda(StatusVendaEnum statusVenda) {
		this.statusVenda = statusVenda;
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
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<Item> itensVenda) {
		this.itensVenda = itensVenda;
	}
}
