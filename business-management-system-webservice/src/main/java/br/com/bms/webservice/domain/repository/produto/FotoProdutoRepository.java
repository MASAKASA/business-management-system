/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.produto.FotoProduto;
import br.com.bms.webservice.domain.model.produto.Produto;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade FotoProduto
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface FotoProdutoRepository extends JpaRepository<FotoProduto, Long>{

	/**
	 * Buscar FotoProduto conforme o parametro coincida com o campo funcionario
	 * 
	 * @param FotoProduto produto para busca no banco de dados
	 * 
	 * @return FotoProduto do produto ou null senão tiver FotoProduto relacionado com 
	 * produto
	 */
	FotoProduto findByProduto(Produto produto);
}
