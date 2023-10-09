package br.edu.infnet.appzoo.service;

import br.edu.infnet.appzoo.models.Animal;
import br.edu.infnet.appzoo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
  @Autowired private AnimalRepository animalRepository;

  public Animal create(Animal animal) {
    return animalRepository.save(animal);
  }

  public Animal getById(Integer id) {
    return animalRepository.findById(id).orElse(null);
  }

  public void deleteById(Integer id) {
    animalRepository.deleteById(id);
  }

  public Iterable<Animal> getAllAnimals() {
    return animalRepository.findAll();
  }

  public Iterable<Animal> getBySpecies(String species) {
    return animalRepository.findBySpecies(species);
  }
}
