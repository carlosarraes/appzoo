package br.edu.infnet.appzoo.repository;

import br.edu.infnet.appzoo.models.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {
  Iterable<Animal> findBySpecies(String species);
}
