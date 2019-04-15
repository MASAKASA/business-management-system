/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.logistica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.logistica.Fornecedor;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Fornecedor
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	/**
	 * Buscar fornecedore conforme os parametros coincida com o campo inscricaoEstadual
	 * 
	 * @param String inscricaoEstadual para busca no banco de dados
	 * 
	 * @return Fornecedore encontrados ou null se não tiver nenhum dado for encontrado
	 */
	Fornecedor findByInscricaoEstadual(String inscricaoEstadual);
	
	/**
	 * Buscar Fornecedor conforme os parametros coincida com o campo inscricaoMunicipal
	 * 
	 * @param String inscricaoMunicipal para busca no banco de dados
	 * 
	 * @return Fornecedor encontrados ou null se não tiver nenhum dado
	 * 		for encontrado
	 */
	Fornecedor findByInscricaoMunicipal(String inscricaoMunicipal);
	
	/**
	 * Buscar Fornecedor conforme os parametros coincida com o campo cnpj
	 * 
	 * @param String cnpj para busca no banco de dados
	 * 
	 * @return Fornecedore encontrados ou null se não tiver nenhum dado
	 * 		for encontrado
	 */
	Fornecedor findByCnpj(String cnpj);	
	
	/**
	 * Buscar Fornecedor conforme os parametros coincida com o campo cpf
	 * 
	 * @param String cpf para busca no banco de dados
	 * 
	 * @return Fornecedor encontrados ou null se não tiver nenhum dado
	 * 		for encontrado
	 */
	Fornecedor findByCpf(String cpf);
	
	/**
	 * Buscar fornecedores conforme os parametros coincida com quaisquer das partes dos campos razaoSocial
	 * e nomeFAntasia
	 * Obs.: Deve ser utilizado a classe Sort para oganização
	 * 
	 * @param String RazaoSocial para busca no banco de dados
	 * 
	 * @param String nomeFantasia para busca no banco de dados
	 * 
	 * @return List com fornecedores encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Fornecedor> findByRazaoSocialContainingOrNomeFantasiaContaining(
			String RazaoSocial, String nomeFantasia);
}
