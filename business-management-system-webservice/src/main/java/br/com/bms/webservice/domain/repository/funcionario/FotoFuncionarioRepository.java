/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.funcionario.FotoFuncionario;
import br.com.bms.webservice.domain.model.funcionario.Funcionario;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade FotoFuncionario
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface FotoFuncionarioRepository extends JpaRepository<FotoFuncionario, Long>{

	/**
	 * Buscar FotoFuncionario conforme o parametro coincida com o campo funcionario
	 * 
	 * @param Funcionario funcionario para busca no banco de dados
	 * 
	 * @return FotoFuncionario do funcionario ou null senão tiver FotoFuncionario relacionado com 
	 * funcionario
	 */
	FotoFuncionario findByFuncionario(Funcionario funcionario);
}
