package br.com.bms.webservice.domain.model.funcionario;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.br.CPF;

import br.com.bms.webservice.domain.model.funcionario.enuns.CargoEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.DeficienciaEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.EscolaridadeEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.EstadoCivilEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.PensaoEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.PerfilEnun;
import br.com.bms.webservice.domain.model.funcionario.enuns.SetorEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.SexoEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.StatusFuncionarioEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.VeiculoEnum;
import br.com.bms.webservice.domain.model.logistica.Cliente;
import br.com.bms.webservice.domain.model.logistica.Loja;
import br.com.bms.webservice.domain.model.logistica.Venda;
import br.com.bms.webservice.domain.model.util.Endereco;
import br.com.bms.webservice.domain.model.util.Telefone;

@Entity 
@Table(name="funcionarios")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = -6041900479510878116L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="id_funcionario") 
	private Long id;
	
	@NotBlank
	@Column(name="data_nascimento") 
	private Date dataNascimento;
	
	@NotBlank
	@Column(name="data_admissao") 
	private Date dataAdmissao;
	
	@Column(name="data_demissao") 
	private Date dataDemissao = null;
	
	@Column(name="valor_pensao")
	private BigDecimal valorPensao = null;
	
	@NotBlank
	@Size(min = 2, max = 255) 
	@Column(name="nome_usuario", nullable=false) 
	private String nome;
	
	@NotBlank
	@Size(max=255)
	private String naturalidade;
	
	@Email
	private String email;
	
	@CPF
	private String cpf;
	
	@NotBlank
	@Size(max=255)
	@Column(name="carteira_trabalho")
	private String carteiraTrabalho;
	
	@Size(max=255)
	@Column(name="nome_conjuge")
	private String nomeConjuge;
	
	@Size(max=255)
	@Column(name="nome_pai")
	private String nomePai;
	
	@Size(max=255)
	@Column(name="nome_mae")
	private String nomeMae;
	
	@Size(max=255)
	@Column(name="profissao_conjuge")
	private String profissaoConjuge;
	
	@Size(max=255)
	@Column(name="profissao_pai")
	private String profissaoPai;
	
	@Size(max=255)
	@Column(name="profissao_mae")
	private String profissaoMae;
	
	@Enumerated(EnumType.STRING)
	@Column(name="paga_pensao")
	private PensaoEnum pagaPensao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="possiu_veiculo")
	private VeiculoEnum veiculo;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private EscolaridadeEnum escolaridade;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="estado_civil")
	private EstadoCivilEnum estadoCivil;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private PerfilEnun perfil;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private SetorEnum setor;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private CargoEnum cargo;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private DeficienciaEnum deficiencia;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="status_funcionario")
	private StatusFuncionarioEnum statusFuncionario;
	
	@NotBlank
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "lider", nullable = false)
	private Funcionario lider;
	
	@NotBlank
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "loja_id", nullable = false)
	private Loja loja;
	
	@OneToMany(mappedBy = "lider", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Funcionario> listaSubordinados = null;
	
	@OneToMany(mappedBy = "vendedor", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Venda> listaVendasRelizadas = null;
	
	@OneToMany(mappedBy = "vendedor", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Cliente> listaClientes = null;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<FormacaoEscolar> listaFormacaoEscolar;
	
	@OneToMany(mappedBy = "funcionario", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ContaCheque> listaContraCheques;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Telefone> listaTelefones;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Depentente> listaDepententes;
	
	public Funcionario() {
		super();
	}
	
	public void addSubordinado(Funcionario subordinado) {
		if (listaSubordinados == null) {
			listaSubordinados = new ArrayList<Funcionario>();
		}
		subordinado.setLider(this);
		listaSubordinados.add(subordinado);
	}
	
	public void delSubordinado(Funcionario subordinado) {
		if (listaSubordinados != null) {
			listaSubordinados.remove(subordinado);
		}
	}
	
	public void addVenda(Venda venda) {
		if (listaVendasRelizadas == null) {
			listaVendasRelizadas = new ArrayList<Venda>();
		}
		venda.setVendedor(this);
		listaVendasRelizadas.add(venda);
	}
	
	public void delVenda(Venda venda) {
		if (listaVendasRelizadas != null) {
			listaVendasRelizadas.remove(venda);
		}
	}

	public void addCliente(Cliente cliente) {
		if (listaClientes == null) {
			listaClientes = new ArrayList<Cliente>();
		}
		cliente.setVendedor(this);
		listaClientes.add(cliente);
	}
	
	public void delCliente(Cliente cliente) {
		if (listaClientes != null) {
			listaClientes.remove(cliente);
		}
	}
	
	public void addFormacaoEscolar(FormacaoEscolar formacaoEscolar) {
		if (listaFormacaoEscolar == null) {
			listaFormacaoEscolar = new ArrayList<FormacaoEscolar>();
		}
		formacaoEscolar.setFuncionario(this);
		listaFormacaoEscolar.add(formacaoEscolar);
	}
	
	public void delFormacaoEscolar(FormacaoEscolar formacaoEscolar) {
		if (listaFormacaoEscolar != null) {
			listaFormacaoEscolar.remove(formacaoEscolar);
		}
	}
	
	public void addContaCheque(ContaCheque contaCheque) {
		if (listaContraCheques == null) {
			listaContraCheques = new ArrayList<ContaCheque>();
		}
		contaCheque.setFuncionario(this);
		listaContraCheques.add(contaCheque);
	}
	
	public void delContaCheque(ContaCheque contaCheque) {
		if (listaContraCheques != null) {
			listaContraCheques.remove(contaCheque);
		}
	}
	
	public void addTelefone(Telefone telefone) {
		if (listaTelefones == null) {
			listaTelefones = new ArrayList<Telefone>();
		}
		telefone.setFuncionario(this);
		listaTelefones.add(telefone);
	}
	
	public void delTelefone(Telefone telefone) {
		if (listaTelefones != null) {
			listaTelefones.remove(telefone);
		}
	}
	
	public void addDepentente(Depentente depentente) {
		if (listaDepententes == null) {
			listaDepententes = new ArrayList<Depentente>();
		}
		depentente.setFuncionario(this);
		listaDepententes.add(depentente);
	}
	
	public void delDepentente(Depentente depentente) {
		if (listaDepententes != null) {
			listaDepententes.remove(depentente);
		}
	}

	//Metodo criado por boa pratica de programacao. So para o id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	//Metodo criado por boa pratica de programacao. So para o id
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public BigDecimal getValorPensao() {
		return valorPensao;
	}

	public void setValorPensao(BigDecimal valorPensao) {
		this.valorPensao = valorPensao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getProfissaoConjuge() {
		return profissaoConjuge;
	}

	public void setProfissaoConjuge(String profissaoConjuge) {
		this.profissaoConjuge = profissaoConjuge;
	}

	public String getProfissaoPai() {
		return profissaoPai;
	}

	public void setProfissaoPai(String profissaoPai) {
		this.profissaoPai = profissaoPai;
	}

	public String getProfissaoMae() {
		return profissaoMae;
	}

	public void setProfissaoMae(String profissaoMae) {
		this.profissaoMae = profissaoMae;
	}

	public PensaoEnum getPagaPensao() {
		return pagaPensao;
	}

	public void setPagaPensao(PensaoEnum pagaPensao) {
		this.pagaPensao = pagaPensao;
	}

	public VeiculoEnum getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoEnum veiculo) {
		this.veiculo = veiculo;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public EscolaridadeEnum getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EscolaridadeEnum escolaridade) {
		this.escolaridade = escolaridade;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public PerfilEnun getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnun perfil) {
		this.perfil = perfil;
	}

	public SetorEnum getSetor() {
		return setor;
	}

	public void setSetor(SetorEnum setor) {
		this.setor = setor;
	}

	public CargoEnum getCargo() {
		return cargo;
	}

	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}

	public DeficienciaEnum getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(DeficienciaEnum deficiencia) {
		this.deficiencia = deficiencia;
	}

	public StatusFuncionarioEnum getStatusFuncionario() {
		return statusFuncionario;
	}

	public void setStatusFuncionario(StatusFuncionarioEnum statusFuncionario) {
		this.statusFuncionario = statusFuncionario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario getLider() {
		return lider;
	}

	public void setLider(Funcionario lider) {
		this.lider = lider;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public List<Funcionario> getListaSubordinados() {
		return listaSubordinados;
	}

	public void setListaSubordinados(List<Funcionario> listaSubordinados) {
		this.listaSubordinados = listaSubordinados;
	}

	public List<Venda> getListaVendasRelizadas() {
		return listaVendasRelizadas;
	}

	public void setListaVendasRelizadas(List<Venda> listaVendasRelizadas) {
		this.listaVendasRelizadas = listaVendasRelizadas;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<FormacaoEscolar> getListaFormacaoEscolar() {
		return listaFormacaoEscolar;
	}

	public void setListaFormacaoEscolar(List<FormacaoEscolar> listaFormacaoEscolar) {
		this.listaFormacaoEscolar = listaFormacaoEscolar;
	}

	public List<ContaCheque> getListaContraCheques() {
		return listaContraCheques;
	}

	public void setListaContraCheques(List<ContaCheque> listaContraCheques) {
		this.listaContraCheques = listaContraCheques;
	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public List<Depentente> getListaDepententes() {
		return listaDepententes;
	}

	public void setListaDepententes(List<Depentente> listaDepententes) {
		this.listaDepententes = listaDepententes;
	}
}