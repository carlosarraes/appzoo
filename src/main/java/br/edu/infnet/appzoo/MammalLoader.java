package br.edu.infnet.appzoo;

import br.edu.infnet.appzoo.models.Mammal;
import br.edu.infnet.appzoo.service.AnimalService;
import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MammalLoader implements ApplicationRunner {
  @Autowired private AnimalService animalService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    FileReader file = new FileReader("dog.txt");
    BufferedReader reader = new BufferedReader(file);

    while (reader.ready()) {
      String[] fields = reader.readLine().split(";");
      Mammal mammal =
          new Mammal(
              fields[0],
              fields[1],
              Integer.parseInt(fields[2]),
              fields[3],
              Boolean.parseBoolean(fields[4]),
              Integer.parseInt(fields[5]));

      animalService.create(mammal);
    }
    reader.close();
  }
}
