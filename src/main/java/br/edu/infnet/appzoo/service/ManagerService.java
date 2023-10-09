package br.edu.infnet.appzoo.service;

import br.edu.infnet.appzoo.models.Manager;
import br.edu.infnet.appzoo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
  @Autowired private ManagerRepository managerRepository;

  public void create(Manager manager) {
    managerRepository.save(manager);
  }

  public Manager getById(Integer id) {
    return managerRepository.findById(id).orElse(null);
  }

  public void delete(Integer id) {
    managerRepository.deleteById(id);
  }

  public Iterable<Manager> getAllManagers() {
    return managerRepository.findAll();
  }
}
