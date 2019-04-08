package br.com.bms.webservice.domain.model.logistica;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.bms.webservice.domain.model.funcionario.Funcionario;
import br.com.bms.webservice.domain.model.logistica.enuns.LojaEnun;
import br.com.bms.webservice.domain.model.produto.Produto;
import br.com.bms.webservice.domain.model.util.Endereco;
import br.com.bms.webservice.domain.model.util.Telefone;

@Entity
@Table(name="lojas")
public class Loja implements Serializable {

	private static final long serialVersionUID = 6170969565721203008L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_loja")
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
	//@Verify(ParametroTipo.IE_PERNAMBUCO_PE_FORMATADO)
	@Column(name="incricao_estadual")
	private String inscricaoEstatual;
	
	@NotBlank
	@Size(max=20)
	@Column(name="inscricao_municipal")
	private String inscricaoMunicipal;
	
	@Email
	private String email;
	
	@CNPJ
	private String cnpj;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="estabelecimento")
	private LojaEnun lojaEnun;
	
	@NotBlank
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "loja", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Telefone> listaTelefones;
	
	@OneToMany(mappedBy = "loja", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Funcionario> listaFuncionarios;
	
	@OneToMany(mappedBy = "loja", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Cliente> listaClientes;
	
	@OneToMany(mappedBy = "loja", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Conta> listaContas;
	
	@OneToMany(mappedBy = "loja", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Caixa> listaCaixas;
	
	@OneToMany(mappedBy = "loja", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Venda> listaVendas;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "lojas_fornecedores",
			joinColumns = @JoinColumn(name = "id_loja"),
			inverseJoinColumns = @JoinColumn(name = "id_fornecedor")
    )
	private List<Fornecedor> listaFornecedores;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "lojas_produtos",
			joinColumns = @JoinColumn(name = "id_loja"),
			inverseJoinColumns = @JoinColumn(name = "id_produto")
    )
	private List<Produto> listaProdutos;
	
	public Loja() {
		super();
	}
	
	public void addTelefone(Telefone telefone) {
		if (listaTelefones == null) {
			listaTelefones = new ArrayList<Telefone>();
		}
		telefone.setLoja(this);
		listaTelefones.add(telefone);
	}
	
	public void delTelefone(Telefone telefone) {
		if (listaTelefones != null) {
			listaTelefones.remove(telefone);
		}
	}
	
	public void addFuncionario(Funcionario funcionario) {
		if (listaFuncionarios == null) {
			listaFuncionarios = new ArrayList<Funcionario>();
		}
		funcionario.setLoja(this);
		listaFuncionarios.add(funcionario);
	}
	
	public void delFuncionario(Funcionario funcionario) {
		if (listaFuncionarios != null) {
			listaFuncionarios.remove(funcionario);
		}
	}
	
	public void addCliente(Cliente cliente) {
		if (listaClientes == null) {
			listaClientes = new ArrayList<Cliente>();
		}
		cliente.setLoja(this);
		listaClientes.add(cliente);
	}
	
	public void delCliente(Cliente cliente) {
		if (listaClientes != null) {
			listaClientes.remove(cliente);
		}
	}
	
	public void addConta(Conta conta) {
		if (listaContas == null) {
			listaContas = new ArrayList<Conta>();
		}
		conta.setLoja(this);
		listaContas.add(conta);
	}
	
	public void delConta(Conta conta) {
		if (listaContas != null) {
			listaContas.remove(conta);
		}
	}
	
	public void addCaixa(Caixa caixa) {
		if (listaCaixas == null) {
			listaCaixas = new ArrayList<Caixa>();
		}
		caixa.setLoja(this);
		listaCaixas.add(caixa);
	}
	
	public void delCaixa(Caixa caixa) {
		if (listaCaixas != null) {
			listaCaixas.remove(caixa);
		}
	}
	
	public void addVenda(Venda venda) {
		if (listaVendas == null) {
			listaVendas = new ArrayList<Venda>();
		}
		venda.setLoja(this);
		listaVendas.add(venda);
	}
	
	public void delCaixa(Venda venda) {
		if (listaVendas != null) {
			listaVendas.remove(venda);
		}
	}

	@Override
	public String toString() {
		return "Loja [id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
				+ ", inscricaoEstatual=" + inscricaoEstatual + ", inscricaoMunicipal=" + inscricaoMunicipal + ", email="
				+ email + ", cnpj=" + cnpj + ", lojaEnun=" + lojaEnun + ", endereco=" + endereco + ", listaTelefones="
				+ listaTelefones + ", listaFuncionarios=" + listaFuncionarios + ", listaFornecedores="
				+ listaFornecedores + ", listaClientes=" + listaClientes + ", listaContas=" + listaContas
				+ ", listaCaixas=" + listaCaixas + ", listaVendas=" + listaVendas + "]";
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
		Loja other = (Loja) obj;
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

	public String getInscricaoEstatual() {
		return inscricaoEstatual;
	}

	public void setInscricaoEstatual(String inscricaoEstatual) {
		this.inscricaoEstatual = inscricaoEstatual;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public LojaEnun getLojaEnun() {
		return lojaEnun;
	}

	public void setLojaEnun(LojaEnun lojaEnun) {
		this.lojaEnun = lojaEnun;
	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public List<Funcionario> getlistaFuncionarios() {
		return listaFuncionarios;
	}

	public void setlistaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Conta> getListaContas() {
		return listaContas;
	}

	public void setlListaContas(List<Conta> listaContas) {
		this.listaContas = listaContas;
	}

	public List<Caixa> getListaCaixas() {
		return listaCaixas;
	}

	public void setListaCaixas(List<Caixa> listaCaixas) {
		this.listaCaixas = listaCaixas;
	}

	public List<Venda> getListaVendas() {
		return listaVendas;
	}

	public void setListaVendas(List<Venda> listaVendas) {
		this.listaVendas = listaVendas;
	}
}
