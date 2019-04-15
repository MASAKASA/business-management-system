/*
 * Classe representa patrão repository utilizando framework Spring Data JPA
 */
package br.com.bms.webservice.domain.repository.funcionario;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.funcionario.Funcionario;
import br.com.bms.webservice.domain.model.funcionario.enuns.DeficienciaEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.PerfilEnun;
import br.com.bms.webservice.domain.model.funcionario.enuns.SetorEnum;
import br.com.bms.webservice.domain.model.funcionario.enuns.StatusFuncionarioEnum;
import br.com.bms.webservice.domain.model.logistica.Loja;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Funcionario
 * 
 * @author MARCIO
 * 		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 *
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	/**
	 * Buscar funcionarios conforme o parametro coincida com qualquer parte do campo nome
	 * e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param String nome para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByNomeContainingOrderByNomeAsc(String nome);
	
	/**
	 * Buscar funcionarios conforme os parametros coincidam com qualquer parte do campo nome,
	 * com status indicado e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param String nome para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 *  
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByNomeContainingAndStatusFuncionarioOrderByNomeAsc(
			String nome, StatusFuncionarioEnum statusFuncionario);
	
	/**
	 * Buscar funcionarios conforme os parametros coincidam com qualquer parte do campo nome,
	 * com status indicado, loja e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param String nome para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByNomeContainingAndStatusFuncionarioAndLojaIdOrderByNomeAsc(
			String nome, StatusFuncionarioEnum statusFuncionario, Loja loja);

	/**
	 * Buscar funcionarios conforme os parametros coincidam entre as data de nascimentos no 
	 * campo dataNascimento e ordena de forma ascesdente pela dataNascimento
	 * 
	 * @param Date datasNascimentosInicio com a data inicial para busca no banco de dados
	 * 
	 * @param Date datasNascimentosFim com a data final para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByDataNascimentoBetweenOrderByDataNascimentoAsc(
			Date datasNascimentosInicio, Date datasNascimentosFim);
	
	/**
	 * Buscar funcionarios conforme os parametros coincidam entre as data de nascimentos no 
	 * campo dataNascimento, com status indicado e ordena de forma ascesdente pelo dataNascimento
	 * 
	 * @param Date datasNascimentosInicio com a data inicial para busca no banco de dados
	 * 
	 * @param Date datasNascimentosFim com a data final para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByDataNascimentoBetweenAndStatusFuncionarioOrderByDataNascimentoAsc(
			Date datasNascimentosInicio, Date datasNascimentosFim, StatusFuncionarioEnum statusFuncionario);

	/**
	 * Buscar funcionarios conforme os parametros coincidam entre as data de nascimentos no 
	 * campo dataNascimento, com status indicado, loja e ordena de forma ascesdente pelo dataNascimento
	 * 
	 * @param Date datasNascimentosInicio com a data inicial para busca no banco de dados
	 * 
	 * @param Date datasNascimentosFim com a data final para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByDataNascimentoBetweenAndStatusFuncionarioAndLojaIdOrderByDataNascimentoAsc(
			Date datasNascimentosInicio, Date datasNascimentosFim, StatusFuncionarioEnum statusFuncionario, 
			Loja loja);
	
	/**
	 * Buscar funcionarios conforme o parametro coincida com campo statusFuncionario
	 * e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados 
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByStatusFuncionarioOrderByNomeAsc(
			StatusFuncionarioEnum statusFuncionario);
	
	/**
	 * Buscar funcionarios conforme o parametro coincida com campo statusFuncionario, 
	 * loja e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByStatusFuncionarioAndLojaIdOrderByNomeAsc(
			StatusFuncionarioEnum statusFuncionario, Loja loja);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo perfil e ordena de forma 
	 * ascesdente pelo campo nome
	 * 
	 * @param PerfilEnun perfil para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByPerfilOrderByNomeAsc(PerfilEnun perfil);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo perfil, campo statusFuncionario 
	 * e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param PerfilEnun perfil para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByPerfilAndStatusFuncionarioOrderByNomeAsc(
			PerfilEnun perfil, StatusFuncionarioEnum statusFuncionario);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo perfil, campo statusFuncionario, 
	 * loja e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param PerfilEnun perfil para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByPerfilAndStatusFuncionarioAndLojaOrderByNomeAsc(
			PerfilEnun perfil, StatusFuncionarioEnum statusFuncionario, Loja loja);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo setor e ordena de forma 
	 * ascesdente pelo campo nome
	 * 
	 * @param SetorEnum setor para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findBySetorOrderByNomeAsc(SetorEnum setor);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo setor, campo statusFuncionario 
	 * e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param SetorEnum setor para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findBySetorAndStatusFuncionarioOrderByNomeAsc(
			SetorEnum setor, StatusFuncionarioEnum statusFuncionario);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo setor, campo statusFuncionario,
	 * loja e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param SetorEnum setor para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findBySetorAndStatusFuncionarioAndLojaOrderByNomeAsc(
			SetorEnum setor, StatusFuncionarioEnum statusFuncionario, Loja loja);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo deficiencia e ordena de 
	 * forma ascesdente pelo campo nome
	 * 
	 * @param DeficienciaEnum deficiencia para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByDeficienciaOrderByNomeAsc(DeficienciaEnum deficiencia);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo deficiencia, campo statusFuncionario
	 * e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param DeficienciaEnum deficiencia para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByDeficienciaAndStatusFuncionarioOrderByNomeAsc(
			DeficienciaEnum deficiencia, StatusFuncionarioEnum statusFuncionario);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo deficiencia, campo statusFuncionario,
	 * loja e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param DeficienciaEnum deficiencia para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByDeficienciaAndStatusFuncionarioAndLojaOrderByNomeAsc(
			DeficienciaEnum deficiencia, StatusFuncionarioEnum statusFuncionario, Loja loja);

	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo logradouro da entidade 
	 * Endereco e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param String logradouro para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByEnderecoLogradouroContainingOrderByNomeAsc(String logradouro);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo logradouro, campo statusFuncionario
	 * e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param String logradouro para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByEnderecoLogradouroContainingAndStatusFuncionarioOrderByNomeAsc(
			String logradouro, StatusFuncionarioEnum statusFuncionario);
	
	/**
	 * Buscar funcionarios conforme o parametro coincidam com campo logradouro, campo statusFuncionario, 
	 * loja e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param String logradouro para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByEnderecoLogradouroContainingAndStatusFuncionarioAndLojaOrderByNomeAsc(
			String logradouro, StatusFuncionarioEnum statusFuncionario, Loja loja);
	
	/**
	 * Buscar funcionarios conforme o parametro coincida com Funcionario lider no campo lider
	 * e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param Funcionario lider para busca no banco de dados 
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByLiderOrderByNomeAsc(Funcionario lider);
	
	/**
	 * Buscar funcionarios conforme o parametro coincida com Funcionario lider no campo lider,
	 * com status indicado e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param Funcionario lider para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByLiderAndStatusFuncionarioOrderByNomeAsc(
			Funcionario lider, StatusFuncionarioEnum statusFuncionario);
	
	/**
	 * Buscar funcionarios conforme o parametro coincida com Funcionario lider no campo lider,
	 * com status indicado, loja e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param Funcionario lider para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByLiderAndStatusFuncionarioAndLojaIdOrderByNomeAsc(
			Funcionario lider, StatusFuncionarioEnum statusFuncionario, Loja loja);
	
	/**
	 * Buscar funcionarios conforme o parametro coincida com a Loja loja no campo loja
	 * e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByLojaIdOrderByNomeAsc(Loja loja);
	
	/**
	 * Buscar funcionarios conforme o parametro coincida com a Loja loja no campo loja, 
	 * e ordena de forma ascesdente pelo campo nome
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @param StatusFuncionarioEnum statusFuncionario para busca no banco de dados
	 * 
	 * @return List com funcionarios encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Funcionario> findByLojaIdAndStatusFuncionarioOrderByNomeAsc(
			Loja loja, StatusFuncionarioEnum statusFuncionario);
}