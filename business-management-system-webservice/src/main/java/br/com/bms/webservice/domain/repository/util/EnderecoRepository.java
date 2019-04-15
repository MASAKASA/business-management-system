/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.util;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.util.Endereco;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade Endereco
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
