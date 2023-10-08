package br.edu.infnet.appzoo;

import br.edu.infnet.appzoo.models.Mammal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MammalLoader implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Map<UUID, Mammal> mammals = new HashMap<>();
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

      mammals.put(mammal.getId(), mammal);
    }
    reader.close();
  }
}
