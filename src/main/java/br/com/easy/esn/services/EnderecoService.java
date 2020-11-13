/**
 * 
 */
package br.com.easy.esn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.easy.esn.entity.Endereco;
import br.com.easy.esn.entity.Telefone;
import br.com.easy.esn.repositories.EnderecoRepository;
import br.com.easy.esn.services.exceptions.ObjectNotFoundException;

/**
 * @author edy
 *
 */
@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repo;
	
	public List<Endereco> obter(){
		return repo.findAll();
	}

	public Endereco obterId(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow( ()-> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + " tipo: " + Telefone.class.getName()));
		
	}
}
