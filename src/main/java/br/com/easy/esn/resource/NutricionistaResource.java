package br.com.easy.esn.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.easy.esn.entity.Nutricionista;
import br.com.easy.esn.services.NutricionistaService;

@RestController
@RequestMapping(value = "/nutricionistas")
public class NutricionistaResource {
	@Autowired
	private NutricionistaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Nutricionista> obterId(@PathVariable Integer id) {
		Nutricionista obj = service.obterId(id);
		return ResponseEntity.ok().body(obj);
	}
}
