package br.edu.infnet.appzoo.service;

import br.edu.infnet.appzoo.models.ZooKeeper;
import br.edu.infnet.appzoo.repository.ZooKeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZooKeeperService {
  @Autowired private ZooKeeperRepository zooKeeperRepository;

  public void create(ZooKeeper zooKeeper) {
    zooKeeperRepository.save(zooKeeper);
  }

  public void deleteById(Integer id) {
    zooKeeperRepository.deleteById(id);
  }

  public Iterable<ZooKeeper> getAllZooKeepers() {
    return zooKeeperRepository.findAll();
  }
}
