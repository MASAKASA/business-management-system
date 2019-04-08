package br.com.bms.webservice.domain.model.logistica;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.bms.webservice.domain.model.logistica.enuns.DuracaoPromocaoEnun;
import br.com.bms.webservice.domain.model.produto.Produto;

@Entity
@Table(name="promocoes")
public class Promocao  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_promocao")
	private Long id;
	
	@NotBlank
	@Size(max=255)
	private String nome;
	
	@Size(max=1000)
	private String observacao;
	
	@NotBlank
	@Column(name="data_inicio")
	private Calendar dataInicio;
	
	@NotBlank
	@Column(name="data_termino")
	private Calendar dataTermino;
	
	@Enumerated(EnumType.STRING) //Informando que no banco os dados da classe Enun seram em String:[ABERTO ou FECHADO]
	@Column(name="status_caixa")
	private DuracaoPromocaoEnun duracaoPromocaoEnun; 
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
			name = "produtos_promocoes",
			joinColumns = @JoinColumn(name = "id_promocao"),
			inverseJoinColumns = @JoinColumn(name = "id_produto")
    )
	private List<Produto> produtos;
	
	public Promocao() {
		super();
	}

	@Override
	public String toString() {
		return "Promocao [id=" + id + ", nome=" + nome + ", observacao=" + observacao + ", dataInicio=" + dataInicio
				+ ", dataTermino=" + dataTermino + ", duracaoPromocaoEnun=" + duracaoPromocaoEnun + ", produtos="
				+ produtos + "]";
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
		Promocao other = (Promocao) obj;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	public DuracaoPromocaoEnun getDuracaoPromocaoEnun() {
		return duracaoPromocaoEnun;
	}

	public void setDuracaoPromocaoEnun(DuracaoPromocaoEnun duracaoPromocaoEnun) {
		this.duracaoPromocaoEnun = duracaoPromocaoEnun;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
