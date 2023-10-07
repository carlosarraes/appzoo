package br.edu.infnet.appzoo;

import br.edu.infnet.appzoo.models.Bird;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BirdLoader implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Bird bird = new Bird("Piu Piu", "Canário", 2, "Amarelo", true, "Curvo");

    System.out.println("[BirdLoader] bird.toString(): " + bird.toString());
  }
}
