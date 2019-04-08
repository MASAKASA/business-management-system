package br.com.bms.webservice.domain.model.logistica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.bms.webservice.domain.model.produto.Produto;
import br.com.bms.webservice.domain.model.util.Endereco;
import br.com.bms.webservice.domain.model.util.Telefone;
import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.types.ParametroTipo;

@Entity
@Table(name="fornecedores")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = -366984413454417412L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fornecedor")
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
	private String inscricaoEstatual;
	
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
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "lojas_fornecedores",
			joinColumns = @JoinColumn(name = "id_fornecedor"),
			inverseJoinColumns = @JoinColumn(name = "id_loja")
    )
	private List<Loja> listaLojas;
	
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	private List<Telefone> listaTelefones;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "fornecedores_enderecos",
			joinColumns = @JoinColumn(name = "id_fornecedor"),
			inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
	private List<Endereco> listaEnderecos;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "produtos_fonecedores",
			joinColumns = @JoinColumn(name = "id_fornecedor"),
			inverseJoinColumns = @JoinColumn(name = "id_produto")
    )
	private List<Produto> lisraProdutos;
	
	public Fornecedor() {
		super();
	}
	
	public void addTelefone(Telefone telefone) {
		if (listaTelefones == null) {
			listaTelefones = new ArrayList<Telefone>();
		}
		telefone.setFornecedor(this);
		listaTelefones.add(telefone);
	}
	
	public void delTelefone(Telefone telefone) {
		if (listaTelefones != null) {
			listaTelefones.remove(telefone);
		}
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
				+ ", inscricaoEstatual=" + inscricaoEstatual + ", inscricaoMunicipal=" + inscricaoMunicipal + ", email="
				+ email + ", cnpj=" + cnpj + ", cpf=" + cpf + ", listaLojas=" + listaLojas + ", listaTelefones="
				+ listaTelefones + ", listaEnderecos=" + listaEnderecos + ", lisraProdutos=" + lisraProdutos + "]";
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
		Fornecedor other = (Fornecedor) obj;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Loja> getListaLojas() {
		return listaLojas;
	}

	public void setListaLojas(List<Loja> listaLojas) {
		this.listaLojas = listaLojas;
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

	public List<Produto> getLisraProdutos() {
		return lisraProdutos;
	}

	public void setLisraProdutos(List<Produto> lisraProdutos) {
		this.lisraProdutos = lisraProdutos;
	}
}
