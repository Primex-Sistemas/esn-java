package br.com.easy.esn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easy.esn.entity.Nutricionista;
/**
 * @author edy
 *
 */

@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Integer> {

}
