/*
 * Classe representa patrão repository utilizando o Spring Date
 */
package br.com.bms.webservice.domain.repository.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bms.webservice.domain.model.funcionario.FormacaoEscolar;

/*
 * Classe responsavel em realizar toda operação com o banco de dados para entidade FormacaoEscolar
 * 
 * @author MARCIO
 *		marcioandredasilvaalmeida@gmail.com
 * 		Marcio Almeida
 */
public interface FormacaoEscolarRepository extends JpaRepository<FormacaoEscolar, Long> {

}
