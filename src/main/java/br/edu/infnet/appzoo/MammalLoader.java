package br.edu.infnet.appzoo;

import br.edu.infnet.appzoo.models.Mammal;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MammalLoader implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Mammal dog = new Mammal("Rex", "Cachorro", 3, "Marrom", true, 4);

    System.out.println("[MammalLoader] dog.toString(): " + dog.toString());
  }
}
