package br.edu.infnet.appzoo;

import br.edu.infnet.appzoo.models.Manager;
import java.time.LocalDate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ManagerLoader implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) throws Exception {
    Manager manager = new Manager("João", "joao@mail.com", LocalDate.now());

    System.out.println("[ManagerLoader] manager.toString(): " + manager.toString());
  }
}
