package br.com.bms.webservice.domain.model.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.bms.webservice.domain.model.logistica.Fornecedor;
import br.com.bms.webservice.domain.model.logistica.Loja;
import br.com.bms.webservice.domain.model.logistica.Promocao;
import br.com.bms.webservice.domain.model.produto.enuns.GeneroEnum;
import br.com.bms.webservice.domain.model.produto.enuns.StatusProdutoEnun;
import br.com.bms.webservice.domain.model.produto.enuns.UnidadeEnum;

@Entity
@Table(name="produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = -525327752206571464L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produto")
	private Long id;
	
	@NotBlank
	@Size(min=0)
	private Long estoque;
	
	@Column(name="codigo_de_barras")
	@Size(max=255)
	private String codigoDeBarras;
	
	@NotBlank
	@Size(max=50)
	private String nome;
	
	@NotBlank
	@Size(max=50)
	private String descricao;
	
	@Size(max=255)
	@Column(name="foto_url")
	private String fotoUrl;
	
	@NotBlank
	@DecimalMin("0.000")
	private Float peso;
	
	@Size(min=0)
	@Column(name="quant_min_estoque")
	private Integer quantidadeMinimaEstoque;
	
	@Column(name="estoque_alto")
	private Integer estoqueAlta;
	
	@Column(name="giro_do_produto")
	private Date giroDoProduto;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="status_produto")
	private StatusProdutoEnun statusProduto;
	
	@Enumerated(EnumType.STRING)
	private GeneroEnum genero;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private UnidadeEnum unidade;
	
	@NotNull
	@JoinColumn(nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private TabelaDePreco tabelaDePreco;
	
	@JoinColumn(name= "marca_id", nullable = false)
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Marca marca;
	
	@OneToMany(mappedBy = "produto", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<DataValidade> listaDatasDeValidade;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "produtos_categorias",
			joinColumns = @JoinColumn(name = "id_produto"),
			inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
	private List<Categoria> listaCategoria;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "lojas_produtos",
			joinColumns = @JoinColumn(name = "id_produto"),
			inverseJoinColumns = @JoinColumn(name = "id_loja")
    )
	private List<Loja> listaLoja;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "produtos_promocoes",
			joinColumns = @JoinColumn(name = "id_produto"),
			inverseJoinColumns = @JoinColumn(name = "id_promocao")
    )
	private List<Promocao> listaPromocoes;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "produtos_fonecedores",
			joinColumns = @JoinColumn(name = "id_produto"),
			inverseJoinColumns = @JoinColumn(name = "id_fornecedor")
    )
	private List<Fornecedor> listaFornecedores;
	
	public Produto() {
		super();
	}
	
	public void addDataValidade(DataValidade dataValidade) {
		if (listaDatasDeValidade == null) {
			listaDatasDeValidade = new ArrayList<DataValidade>();
		}
		dataValidade.setProduto(this);
		listaDatasDeValidade.add(dataValidade);
	}
	
	public void delDataValidade(DataValidade dataValidade) {
		if (listaDatasDeValidade != null) {
			listaDatasDeValidade.remove(dataValidade);
		}
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", estoque=" + estoque + ", codigoDeBarras=" + codigoDeBarras + ", nome=" + nome
				+ ", descricao=" + descricao + ", fotoUrl=" + fotoUrl + ", peso=" + peso + ", quantidadeMinimaEstoque="
				+ quantidadeMinimaEstoque + ", estoqueAlta=" + estoqueAlta + ", giroDoProduto=" + giroDoProduto
				+ ", statusProduto=" + statusProduto + ", genero=" + genero + ", unidade=" + unidade
				+ ", tabelaDePreco=" + tabelaDePreco + ", marca=" + marca + ", listaDatasDeValidade="
				+ listaDatasDeValidade + ", listaCategoria=" + listaCategoria + ", listaLoja=" + listaLoja
				+ ", listaPromocoes=" + listaPromocoes + ", listaFornecedores=" + listaFornecedores + "]";
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
		Produto other = (Produto) obj;
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

	public Long getEstoque() {
		return estoque;
	}

	public void setEstoque(Long estoque) {
		this.estoque = estoque;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Integer getQuantidadeMinimaEstoque() {
		return quantidadeMinimaEstoque;
	}

	public void setQuantidadeMinimaEstoque(Integer quantidadeMinimaEstoque) {
		this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
	}

	public Integer getEstoqueAlta() {
		return estoqueAlta;
	}

	public void setEstoqueAlta(Integer estoqueAlta) {
		this.estoqueAlta = estoqueAlta;
	}

	public Date getGiroDoProduto() {
		return giroDoProduto;
	}

	public void setGiroDoProduto(Date giroDoProduto) {
		this.giroDoProduto = giroDoProduto;
	}

	public StatusProdutoEnun getStatusProduto() {
		return statusProduto;
	}

	public void setStatusProduto(StatusProdutoEnun statusProduto) {
		this.statusProduto = statusProduto;
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	public UnidadeEnum getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeEnum unidade) {
		this.unidade = unidade;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<DataValidade> getListaDatasDeValidade() {
		return listaDatasDeValidade;
	}

	public void setListaDatasDeValidade(List<DataValidade> listaDatasDeValidade) {
		this.listaDatasDeValidade = listaDatasDeValidade;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public List<Loja> getListaLoja() {
		return listaLoja;
	}

	public void setListaLoja(List<Loja> listaLoja) {
		this.listaLoja = listaLoja;
	}

	public List<Promocao> getListaPromocoes() {
		return listaPromocoes;
	}

	public void setListaPromocoes(List<Promocao> listaPromocoes) {
		this.listaPromocoes = listaPromocoes;
	}

	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}
}
