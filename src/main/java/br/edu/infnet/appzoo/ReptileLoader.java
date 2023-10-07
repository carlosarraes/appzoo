package br.edu.infnet.appzoo;

import br.edu.infnet.appzoo.models.Reptile;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ReptileLoader implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) throws Exception {
    Reptile snake = new Reptile("Kaa", "Cobra", 5, "Verde", true, true);

    System.out.println("[ReptileLoader] snake.toString(): " + snake.toString());
  }
}
