/**
 * 
 */
package br.com.easy.esn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easy.esn.entity.Telefone;
import br.com.easy.esn.repositories.TelefoneRepository;
import br.com.easy.esn.services.exceptions.ObjectNotFoundException;

/**
 * @author edy
 *
 */
@Service
public class TelefoneService {
	@Autowired
	private TelefoneRepository repo;
	
	public List<Telefone> obter(){		
		return repo.findAll();
	}
	
	public Telefone obterId (Integer id) {
		Optional<Telefone> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + " tipo: " + Telefone.class.getName()));
	}
	
	

}
