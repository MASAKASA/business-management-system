/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.logistica;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.funcionario.Funcionario;
import br.com.bms.webservice.domain.model.logistica.Caixa;
import br.com.bms.webservice.domain.model.logistica.Loja;
import br.com.bms.webservice.domain.model.logistica.enuns.StatusCaixaEnum;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Caixa
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface CaixaRepository  extends JpaRepository<Caixa, Long> {

	/**
	 * Buscar caixas conforme os parametros coincidam entre as datas de funcionamento no 
	 * campo dataFuncionamento e ordena de forma ascesdente pela dataFuncionamneto
	 * 
	 * @param Date dataInicial com a data inicial para busca no banco de dados
	 * 
	 * @param Date dataFinal com a data final para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados 
	 * 
	 * @return List com caixas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Caixa> findByDataFuncionamentoBetweenAndLojaOrderByDataFuncionamentoAsc(
			Date dataInicial, Date dataFinal, Loja loja);
	
	/**
	 * Buscar caixas conforme os parametros coincidam entre as datas de funcionamento no 
	 * campo dataFuncionamento, loja e statusCaixa e ordena de forma ascesdente pela dataFuncionamneto
	 * 
	 * @param Date dataInicial com a data inicial para busca no banco de dados
	 * 
	 * @param Date dataFinal com a data final para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados 
	 * 
	 * @param StatusCaixaEnum statusCaixa para busca no banco de dados
	 * 
	 * @return List com caixas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Caixa> findByDataFuncionamentoBetweenAndLojaAndStatusCaixaOrderByDataFuncionamentoAsc(
			Date dataInicial, Date dataFinal, Loja loja, StatusCaixaEnum statusCaixa);
	
	/**
	 * Buscar caixas conforme o parametro coincidam com os campo statusCaixa, campo loja 
	 * e ordena de forma ascesdente pelo campo id da loja
	 * 
	 * @param StatusCaixaEnum statusCaixa para busca no banco de dados
	 * 
	 * @return List com caixas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Caixa> findByStatusCaixaOrderByLojaIdAsc(StatusCaixaEnum statusCaixa);
	
	/**
	 * Buscar caixas conforme o parametro coincidam com os campo statusCaixa, campo loja 
	 * e ordena de forma ascesdente pelo campo id
	 * 
	 * @param StatusCaixaEnum statusCaixa para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com caixas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Caixa> findByStatusCaixaAndLojaOrderByLojaIdAsc(
			StatusCaixaEnum statusCaixa, Loja loja);
	
	/**
	 * Buscar caixas conforme o parametro coincidam com os campo funcionario, campo loja 
	 * e ordena de forma ascesdente pelo campo id da loja
	 * 
	 * @param Funcionario funcionario para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com caixas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Caixa> findByFuncionarioAndLojaOrderByLojaIdAsc(Funcionario funcionario, Loja loja);
	
	/**
	 * Buscar caixas conforme o parametro coincidam com campo loja e ordena de forma ascesdente 
	 * pelo campo id da loja
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com caixas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Caixa> findByLojaIdOrderByLojaIdAsc(Loja loja);
}
