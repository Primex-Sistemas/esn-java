/**
 * 
 */
package br.com.easy.esn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easy.esn.entity.TipoPessoa;
import br.com.easy.esn.repositories.TipoPessoaRepository;
import br.com.easy.esn.services.exceptions.ObjectNotFoundException;

/**
 * @author edy
 *
 */
@Service
public class TipoPessoaService {
	@Autowired
	private TipoPessoaRepository repo;
	
	public List<TipoPessoa> obter(){
		return repo.findAll();
	}
	
	public TipoPessoa obterId (Short id) {
		Optional<TipoPessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + " tipo: " + TipoPessoa.class.getName()));
	}
}
