/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.logistica.Venda;
import br.com.bms.webservice.domain.model.produto.Item;
import br.com.bms.webservice.domain.model.produto.Produto;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Item
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface ItemRetository extends JpaRepository<Item, Long> {

	/**
	 * Buscar Itens conforme os parametros coincida com o campo id do produto
	 * 
	 * @param Produto produto para busca no banco de dados
	 * 
	 * @return List com itens encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Item> findByProduto(Produto produto);
	
	/**
	 * Buscar Itens conforme os parametros coincida com o campo id da venda
	 * 
	 * @param Venda venda para busca no banco de dados
	 * 
	 * @return List com Itens encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Item> findByVenda(Venda venda);
	
	/**
	 * Buscar Itens conforme os parametros coincida com o campo id do produto e id da venda
	 * 
	 * @param Produto produto para busca no banco de dados
	 * 
	 * @param Venda venda para busca no banco de dados
	 * 
	 * @return List com Itens encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Item> findByProdutoAndVenda(Produto produto, Venda venda);
}
