/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.logistica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.logistica.Loja;
import br.com.bms.webservice.domain.model.logistica.enuns.LojaEnun;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Loja
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface LojaRepository extends JpaRepository<Loja, Long> {

	/**
	 * Buscar Loja conforme os parametros coincida com o campo inscricaoEstadual
	 * 
	 * @param String inscricaoEstadual para busca no banco de dados
	 * 
	 * @return Loja encontrados ou null se não tiver nenhum dado
	 * 		for encontrado
	 */
	Loja findByInscricaoEstadual(String inscricaoEstadual);
	
	/**
	 * Buscar Loja conforme os parametros coincida com o campo inscricaoMunicipal
	 * 
	 * @param String inscricaoMunicipal para busca no banco de dados
	 * 
	 * @return Loja encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	Loja findByInscricaoMunicipal(String inscricaoMunicipal);
	
	/**
	 * Buscar Loja conforme os parametros coincida com o campo cnpj
	 * 
	 * @param String cnpj para busca no banco de dados
	 * 
	 * @return Loja encontrados ou null se não tiver nenhum dado
	 * 		for encontrado
	 */
	Loja findByCnpj(String cnpj);
	
	/**
	 * Buscar Lojas conforme os parametros coincida com quaisquer das partes dos campos razaoSocial
	 * e nomeFAntasia
	 * Obs.: Deve ser utilizado a classe Sort para oganização
	 * 
	 * @param String RazaoSocial para busca no banco de dados
	 * 
	 * @param String nomeFantasia para busca no banco de dados
	 * 
	 * @return List com Lojas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Loja> findByRazaoSocialContainingOrNomeFantasiaContaining(
			String RazaoSocial, String nomeFantasia);
	/**
	 * Buscar Lojas conforme os parametros coincida com quaisquer das partes dos campos razaoSocial,
	 * nomeFAntasia e lojaEnun
	 * Obs.: Deve ser utilizado a classe Sort para oganização
	 * 
	 * @param String RazaoSocial para busca no banco de dados
	 * 
	 * @param String nomeFantasia para busca no banco de dados
	 * 
	 * @param LojaEnun lojaEnun para busca no banco de dados
	 * 
	 * @return List com Lojas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Loja> findByRazaoSocialContainingOrNomeFantasiaContainingAndLojaEnun(
			String RazaoSocial, String nomeFantasia, LojaEnun lojaEnun);
	
	/**
	 * Buscar Lojas conforme os parametros coincida com quaisquer das partes dos campo logradouro
	 * do endereço da loja
	 * Obs.: Deve ser utilizado a classe Sort para oganização
	 * 
	 * @param String logradouro para busca no banco de dados
	 * 
	 * @return List com Lojas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Loja> findByEnderecoLogradouroContaining(String logradouro);
	
	/**
	 * Buscar Lojas conforme os parametros coincida com quaisquer das partes dos campo logradouro
	 * do endereço da loja e lojaEnun
	 * Obs.: Deve ser utilizado a classe Sort para oganização
	 * 
	 * @param String logradouro para busca no banco de dados
	 * 
	 * @param LojaEnun lojaEnun para busca no banco de dados
	 * 
	 * @return List com Lojas encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Loja> findByEnderecoLogradouroContainingAndLojaEnun(String logradouro, LojaEnun lojaEnun);
}
