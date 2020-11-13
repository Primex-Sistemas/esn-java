/**
 * 
 */
package br.com.easy.esn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.easy.esn.dto.EspecialidadeDTO;
import br.com.easy.esn.entity.Especialidade;
import br.com.easy.esn.repositories.EspecialidadeRespository;
import br.com.easy.esn.services.exceptions.DataIntegrityException;
import br.com.easy.esn.services.exceptions.ObjectNotFoundException;

/**
 * @author edy
 *
 */
@Service
public class EspecialidadeService {	
	
	@Autowired
	private EspecialidadeRespository repo;
	
	public Especialidade find(Integer id) {
	  Optional<Especialidade> obj =  repo.findById(id);
	  return obj.orElseThrow(()-> new ObjectNotFoundException(
			  "Objeto não encontrado Id: " + id + " tipo: " + Especialidade.class.getName()
			  ));
	}
	
	public List <Especialidade> findAll() {
        return repo.findAll();
    }
	
	public Especialidade insert(Especialidade obj) {
		obj.setIdEspecialidade(null);
		return repo.save(obj);
	}

	public Especialidade update(Especialidade obj) {
		Especialidade newObj = find(obj.getIdEspecialidade());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
		
	private void updateData(Especialidade newObj, Especialidade obj) {
		newObj.setNomeEspecialidade(obj.getNomeEspecialidade());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma especialidade que está sendo usada pelo nuticionista");
		}
		
    }
	
	public Page<Especialidade> obterPorPagina(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}	
	
	//Metodo auxiliar para converte DTO
	public Especialidade fromDTO(EspecialidadeDTO objDTO) {
		return new Especialidade( 
				objDTO.getIdEspecialidade(), 
				objDTO.getNomeEspecialidade())
				;
	}
	
}
