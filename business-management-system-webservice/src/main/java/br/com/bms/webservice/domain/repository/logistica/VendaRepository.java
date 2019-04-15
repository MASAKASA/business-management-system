/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.logistica;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.funcionario.Funcionario;
import br.com.bms.webservice.domain.model.logistica.Cliente;
import br.com.bms.webservice.domain.model.logistica.Loja;
import br.com.bms.webservice.domain.model.logistica.Venda;
import br.com.bms.webservice.domain.model.logistica.enuns.StatusVendaEnum;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Venda
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface VendaRepository extends JpaRepository<Venda, Long> {

	/**
	 * Buscar vendas conforme os parametros coincidam entre as datas de dataCompras no 
	 * campo dataCompra e ordena de forma ascesdente pela dataCompra
	 * 
	 * @param Date DataInicio para busca no banco de dados
	 * 
	 * @param Date dataFinal para busca no banco de dados
	 * 
	 * @returnn List com vendas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Venda> findByDataCompraBetweenOrderByDataCompraAsc(Date DataInicio, Date dataFinal);
	
	/**
	 * Buscar vendas conforme os parametros coincidam entre as datas de dataCompras no 
	 * campo dataCompra e loja e ordena de forma ascesdente pela dataCompra
	 * 
	 * @param Date DataInicio para busca no banco de dados
	 * 
	 * @param Date dataFinal para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @returnn List com vendas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Venda> findByDataCompraBetweenAndLojaOrderByDataCompraAsc(
			Date DataInicio, Date dataFinal, Loja loja);
	
	/**
	 * Buscar vendas conforme os parametros coincidam entre as datas de dataCompras no 
	 * campo dataCompra e vendedor e ordena de forma ascesdente pela dataCompra
	 * 
	 * @param Date DataInicio para busca no banco de dados
	 * 
	 * @param Date dataFinal para busca no banco de dados
	 * 
	 * @param Funcionario vendedor com código para busca no banco de dados
	 * 
	 * @returnn List com vendas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Venda> findByDataCompraBetweenAndVendedorOrderByDataCompraAsc(
			Date DataInicio, Date dataFinal, Funcionario vendedor);
	
	/**
	 * Buscar vendas conforme os parametros coincidam entre as datas de dataCompras no 
	 * campo dataCompra e cliente e ordena de forma ascesdente pela dataCompra
	 * 
	 * @param Date DataInicio para busca no banco de dados
	 * 
	 * @param Date dataFinal para busca no banco de dados
	 * 
	 * @param Cliente cliente com código para busca no banco de dados
	 * 
	 * @returnn List com vendas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Venda> findByDataCompraBetweenAndClienteOrderByDataCompraAsc(
			Date DataInicio, Date dataFinal, Cliente cliente);
	
	/**
	 * Buscar vendas conforme os parametros coincidam entre as datas de dataCompras no 
	 * campo dataCompra e statusVenda e ordena de forma ascesdente pela dataCompra
	 * 
	 * @param Date DataInicio para busca no banco de dados
	 * 
	 * @param Date dataFinal para busca no banco de dados
	 * 
	 * @param StatusVendaEnum StatusVenda para busca no banco de dados
	 * 
	 * @returnn List com vendas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Venda> findByDataCompraBetweenAndStatusVendaOrderByDataCompraAsc(
			Date DataInicio, Date dataFinal, StatusVendaEnum statusVenda);
	
	/**
	 * Buscar vendas conforme os parametros coincidam entre as datas de dataCompras no 
	 * campo dataCompra, statusVenda e loja e ordena de forma ascesdente pela dataCompra
	 * 
	 * @param Date DataInicio para busca no banco de dados
	 * 
	 * @param Date dataFinal para busca no banco de dados
	 * 
	 * @param StatusVendaEnum StatusVenda para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @returnn List com vendas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Venda> findByDataCompraBetweenAndStatusVendaAndLojaOrderByDataCompraAsc(
			Date DataInicio, Date dataFinal, StatusVendaEnum statusVenda, Loja loja);
	
	/**
	 * Buscar vendas conforme os parametros coincidam entre as datas de dataCompras no 
	 * campo dataCompra, statusVenda e vendedor e ordena de forma ascesdente pela dataCompra
	 * 
	 * @param Date DataInicio para busca no banco de dados
	 * 
	 * @param Date dataFinal para busca no banco de dados
	 * 
	 * @param StatusVendaEnum StatusVenda para busca no banco de dados
	 * 
	 * @param Funcionario vendedor com código para busca no banco de dados
	 * 
	 * @returnn List com vendas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Venda> findByDataCompraBetweenAndStatusVendaAndVendedorOrderByDataCompraAsc(
			Date DataInicio, Date dataFinal, StatusVendaEnum statusVenda, Funcionario vendedor);
	
	/**
	 * Buscar vendas conforme os parametros coincidam entre as datas de dataCompras no 
	 * campo dataCompra, statusVenda e cliente e ordena de forma ascesdente pela dataCompra
	 * 
	 * @param Date DataInicio para busca no banco de dados
	 * 
	 * @param Date dataFinal para busca no banco de dados
	 * 
	 * @param StatusVendaEnum StatusVenda para busca no banco de dados
	 * 
	 * @param Cliente cliente com código para busca no banco de dados
	 * 
	 * @returnn List com vendas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Venda> findByDataCompraBetweenAndStatusVendaAndClienteOrderByDataCompraAsc(
			Date DataInicio, Date dataFinal, StatusVendaEnum statusVenda, Cliente cliente);
	
	/**
	 * Buscar vendas conforme os parametros coincidam entre as data de dataCompra no 
	 * campo dataCompra, StatusVenda, loja, vendedor, cliente e ordena de forma ascesdente pela dataNascimento
	 * 
	 * @param Date DataInicio para busca no banco de dados
	 * 
	 * @param Date dataFinal para busca no banco de dados
	 * 
	 * @param StatusVendaEnum StatusVenda para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @param Funcionario vendedor com código para busca no banco de dados
	 * 
	 * @param Cliente cliente com código para busca no banco de dados
	 * 
	 * @returnn List com vendas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Venda> findByDataCompraBetweenAndStatusVendaAndLojaAndVendedorAndClienteOrderByDataCompraAsc(
			Date DataInicio, Date dataFinal, StatusVendaEnum statusVenda, Loja loja, 
			Funcionario vendedor, Cliente cliente);
}
