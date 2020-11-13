/**
 * 
 */
package br.com.easy.esn.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easy.esn.entity.Nutricionista;
import br.com.easy.esn.repositories.NutricionistaRepository;
import br.com.easy.esn.services.exceptions.ObjectNotFoundException;

/**
 * @author edy
 * 	
 */
@Service
public class NutricionistaService {
	
	@Autowired
	private NutricionistaRepository repo;

	public Nutricionista obterId(Integer id) {
		Optional<Nutricionista> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + " tipo: " + Nutricionista.class.getName()));
	}
}
