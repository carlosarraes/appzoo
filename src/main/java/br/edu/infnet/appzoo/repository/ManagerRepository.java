package br.edu.infnet.appzoo.repository;

import br.edu.infnet.appzoo.models.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Integer> {}
