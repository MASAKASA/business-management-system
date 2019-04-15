/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.funcionario.Depentente;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Depentente
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface DepententeRepository extends JpaRepository<Depentente, Long> {

	/**
	 * Buscar depententes conforme o parametro coincida com qualquer parte do campo nome
	 * e ordena de forma ascesdente pelo campo nome de forma ascendente
	 * 
	 * @param String nome para busca no banco de dados
	 * 
	 * @return List com depententes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Depentente> findByNomeContainingOrderByNomeAsc(String nome);
}
