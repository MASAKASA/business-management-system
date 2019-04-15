/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.produto.Marca;
import br.com.bms.webservice.domain.model.produto.Produto;
import br.com.bms.webservice.domain.model.produto.TabelaDePreco;
import br.com.bms.webservice.domain.model.produto.enuns.StatusProdutoEnun;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Produto
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface ProdutoRetository extends JpaRepository<Produto, Long> {

	/**
	 * Buscar produtos conforme os parametros coincida com valor do campo codigoDeBarras
	 * 
	 * @param String codigoDeBarras para busca no dados de dados
	 * 
	 * @return Produto encontrado ou um null se não tiver nenhum dado for encontrado
	 */
	Produto findBycodigoDeBarras(String codigoDeBarras);
	
	/**
	 * Buscar produtos conforme os parametros coincida com valor do campo estoque
	 * e ordena por nome de forma ascendente
	 * 
	 * @param Long estoque para busca no dados de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByEstoqueOrderByNomeAsc(Long estoque);
	
	/**
	 * Buscar produtos conforme os parametros coincida com valor do campo estoque 
	 * e statusProduto e ordena por nome de forma ascendente
	 * 
	 * @param Long estoque para busca no dados de dados
	 * 
	 * @param StatusProdutoEnun statusProduto para busca no dados de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByEstoqueAndStatusProdutoOrderByNomeAsc(Long estoque, 
			StatusProdutoEnun statusProduto);
	
	/**
	 * Buscar produtos conforme os parametros coincida com quaisquer das partes do campo estoque
	 * e ordena por nome de forma ascendente
	 * 
	 * @param Long estoqueMinimo para busca no dados de dados
	 * 
	 * @param Long estoqueMaximo para busca no dados de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByEstoqueBetweenOrderByNomeAsc(Long estoqueMinimo, Long estoqueMaximo);
	
	/**
	 * Buscar produtos conforme os parametros coincida com quaisquer das partes do campo estoque
	 * e statusProduto e ordena por nome de forma ascendente
	 * 
	 * @param Long estoqueMinimo para busca no dados de dados
	 * 
	 * @param Long estestoqueMaximooque para busca no dados de dados
	 * 
	 * @param StatusProdutoEnun statusProduto para busca no dados de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByEstoqueBetweenAndStatusProdutoOrderByNomeAsc(
			Long estoqueMinimo, Long estoqueMaximo, StatusProdutoEnun statusProduto);
	
	/**
	 * Buscar produtos conforme os parametros coincida com quaisquer das partes dos campo nome
	 * e ordena por nome de forma ascendente
	 * 
	 * @param String nome para busca no banco de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByNomeContainingOrderByNomeAsc(String nome);
	
	/**
	 * Buscar produtos conforme os parametros coincida com quaisquer das partes dos campo nome
	 * e ordena por nome de forma ascendente
	 * 
	 * @param String nome para busca no banco de dados
	 * 
	 * @param StatusProdutoEnun statusProduto para busca no dados de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByNomeContainingAndStatusProdutoOrderByNome(
			String nome, StatusProdutoEnun statusProduto);
	
	/**
	 * Buscar produtos conforme os parametros coincida com campo tabelaDePreco 
	 * e ordena por nome de forma ascendente
	 * 
	 * @param TabelaDePreco tabelaDePreco para busca no banco de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByTabelaDePrecoOrderByNomeAsc(TabelaDePreco tabelaDePreco);
	
	/**
	 * Buscar produtos conforme os parametros coincida com campo tabelaDePreco e statusProduto
	 * e ordena por nome de forma ascendente
	 * 
	 * @param TabelaDePreco tabelaDePreco para busca no banco de dados
	 * 
	 * @param StatusProdutoEnun statusProduto para busca no dados de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByTabelaDePrecoAndStatusProdutoOrderByNomeAsc(
			TabelaDePreco tabelaDePreco, StatusProdutoEnun statusProduto);
	
	/**
	 * Buscar produtos conforme os parametros coincida com campo marca 
	 * e ordena por nome de forma ascendente
	 * 
	 * @param Marca marca para busca no banco de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByMarcaOrderByNomeAsc(Marca marca);
	
	/**
	 * Buscar produtos conforme os parametros coincida com campo marca e statusProduto
	 * e ordena por nome de forma ascendente
	 * 
	 * @param Marca marca para busca no banco de dados
	 * 
	 * @param StatusProdutoEnun statusProduto para busca no dados de dados
	 * 
	 * @return List com produtos encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Produto> findByMarcaAndStatusProdutoOrderByNomeAsc(
			Marca marca, StatusProdutoEnun statusProduto);
}
