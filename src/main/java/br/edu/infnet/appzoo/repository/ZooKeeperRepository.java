package br.edu.infnet.appzoo.repository;

import br.edu.infnet.appzoo.models.ZooKeeper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooKeeperRepository extends CrudRepository<ZooKeeper, Integer> {}
