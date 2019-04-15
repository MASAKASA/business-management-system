/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.funcionario.Funcionario;
import br.com.bms.webservice.domain.model.funcionario.Login;
import br.com.bms.webservice.domain.model.funcionario.enuns.StatusLogin;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Login
 * 
 * @author MARCIO
 * 		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 *
 */
public interface LoginRepository extends JpaRepository<Login, Long> {

	/**
	 * Buscar login de Funcionario conforme o parametro coincida com as parte dos campo login,
	 * senha e com status indicado
	 * 
	 * @param String login para busca no banco de dados
	 * 
	 * @param String senha para busca no banco de dados
	 * 
	 * @param StatusLogin statusLogin para busca no banco de dados
	 * 
	 * @return Funcionario encontrado ou Funcionario null
	 */
	Funcionario findByLoginAndSenhaAndStatusLogin(
			String login, String senha, StatusLogin statusLogin);
}