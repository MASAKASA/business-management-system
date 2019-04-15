/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.logistica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.funcionario.Funcionario;
import br.com.bms.webservice.domain.model.logistica.Cliente;
import br.com.bms.webservice.domain.model.logistica.Loja;
import br.com.bms.webservice.domain.model.logistica.enuns.StatusClienteEnum;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Cliente
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

	/**
	 * Buscar cliente conforme os parametros coincida com o campo inscricaoEstadual
	 * 
	 * @param String inscricaoEstadual para busca no banco de dados
	 * 
	 * @return Cliente encontrados ou null se não tiver nenhum dado for encontrado
	 */
	Cliente findByInscricaoEstadual(String inscricaoEstadual);
	
	/**
	 * Buscar cliente conforme os parametros coincida com o campo inscricaoMunicipal
	 * 
	 * @param String inscricaoMunicipal para busca no banco de dados
	 * 
	 * @return Cliente encontrados ou null se não tiver nenhum dado for encontrado
	 */
	Cliente findByInscricaoMunicipal(String inscricaoMunicipal);
	
	/**
	 * Buscar cliente conforme os parametros coincida com o campo cnpj
	 * 
	 * @param String cnpj para busca no banco de dados
	 * 
	 * @return Cliente encontrados ou null se não tiver nenhum dado
	 * 		for encontrado
	 */
	Cliente findByCnpj(String cnpj);	
	
	/**
	 * Buscar cliente conforme os parametros coincida com o campo cpf
	 * 
	 * @param String cpf para busca no banco de dados
	 * 
	 * @return Cliente encontrados ou null se não tiver nenhum dado
	 * 		for encontrado
	 */
	Cliente findByCpf(String cpf);
	
	/**
	 * Buscar clientes conforme os parametros coincida com quaisquer das partes dos campos razaoSocial
	 * e nomeFAntasia
	 * Obs.: Deve ser utilizado a classe Sort para organização
	 * 
	 * @param String RazaoSocial para busca no banco de dados
	 * 
	 * @param String nomeFantasia para busca no banco de dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByRazaoSocialContainingOrNomeFantasiaContaining(
			String RazaoSocial, String nomeFantasia);
	
	/**
	 * Buscar clientes conforme os parametros coincida com quaisquer das partes dos campos razaoSocial,
	 * nomeFAntasia e loja
	 * Obs.: Deve ser utilizado a classe Sort para organização
	 * 
	 * @param String RazaoSocial para busca no banco de dados
	 * 
	 * @param String nomeFantasia para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByRazaoSocialContainingOrNomeFantasiaContainingAndLoja(
			String RazaoSocial, String nomeFantasia, Loja loja);
	
	/**
	 * Buscar clientes conforme os parametros coincida com o campo statusCliente
	 * Obs.: Deve ser utilizado a classe Sort para organização
	 * 
	 * @param StatusClienteEnum statusCliente para busca no banco de dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByStatusCliente(StatusClienteEnum statusCliente);
	
	/**
	 * Buscar clientes conforme os parametros coincida com o campo statusCliente e loja
	 * Obs.: Deve ser utilizado a classe Sort para organização
	 * 
	 * @param StatusClienteEnum statusCliente para busca no banco de dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByStatusClienteAndLoja(StatusClienteEnum statusCliente, Loja loja);
	
	/**
	 * Buscar clientes conforme os parametros coincida com o campo statusCliente e vendedor
	 * Obs.: Deve ser utilizado a classe Sort para organização
	 * 
	 * @param StatusClienteEnum statusCliente para busca no banco de dados
	 * 
	 * @param Funcionario vendedor com o código do vendedor para busca no banc ode dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByStatusClienteAndVendedor(StatusClienteEnum statusCliente, 
			Funcionario vendedor);
	
	/**
	 * Buscar clientes conforme os parametros coincida com o campo statusCliente,
	 * vendedor e loja
	 * Obs.: Deve ser utilizado a classe Sort para organização
	 * 
	 * @param StatusClienteEnum statusCliente para busca no banco de dados
	 * 
	 * @param Funcionario vendedor com o código do vendedor para busca no banc ode dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByStatusClienteAndVendedorAndLoja(StatusClienteEnum statusCliente, 
			Funcionario vendedor, Loja loja);
	
	/**
	 * Buscar clientes conforme os parametros coincida com o campo statusCliente,
	 * vendedor e loja e ordena pelo código do vendedor
	 * 
	 * @param StatusClienteEnum statusCliente para busca no banco de dados
	 * 
	 * @param Funcionario vendedor com o código do vendedor para busca no banc ode dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByStatusClienteAndVendedorAndLojaOrderByVendedorAsc(
			StatusClienteEnum statusCliente, Funcionario vendedor, Loja loja);

	/**
	 * Buscar clientes conforme os parametros coincida com o campo statusCliente,
	 * vendedor e loja e ordena pelo código da loja
	 * 
	 * @param StatusClienteEnum statusCliente para busca no banco de dados
	 * 
	 * @param Funcionario vendedor com o código do vendedor para busca no banc ode dados
	 * 
	 * @param Loja loja com código para busca no banco de dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByStatusClienteAndVendedorAndLojaOrderByLojaAsc(
			StatusClienteEnum statusCliente, Funcionario vendedor, Loja loja);
	
	/**
	 * Buscar clientes conforme os parametros coincida com o campo loja e ordena
	 * por código da loja e ordena pelo código da loja
	 * 
	 * @param Loja Loja com o código da loja para busca no bancode dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByLojaOrderByLojaAsc(Loja loja);
	
	/**
	 * Buscar clientes conforme os parametros coincida com o campo código do Vendedor e oedena
	 * por código do vendedor
	 * 
	 * @param Funcionario vendedor com o código do vendedor para busca no banc ode dados
	 * 
	 * @return List com clientes encontrados ou um List vazio se não tiver nenhum dado
	 * 		for encontrado
	 */
	List<Cliente> findByVendedorOrderByVendedorAsc(Funcionario vendedor);
}
