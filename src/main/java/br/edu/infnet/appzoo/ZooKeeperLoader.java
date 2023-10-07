package br.edu.infnet.appzoo;

import br.edu.infnet.appzoo.models.ZooKeeper;
import java.time.LocalDate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ZooKeeperLoader implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) throws Exception {
    ZooKeeper zooKeeper = new ZooKeeper("Maria", "1234567", LocalDate.now());

    System.out.println("[ZooKeeperLoader] zooKeeper.toString(): " + zooKeeper.toString());
  }
}
