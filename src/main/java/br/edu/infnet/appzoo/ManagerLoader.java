package br.edu.infnet.appzoo;

import br.edu.infnet.appzoo.models.Manager;
import br.edu.infnet.appzoo.service.ManagerService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ManagerLoader implements ApplicationRunner {
  @Autowired private ManagerService managerService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    FileReader file = new FileReader("manager.txt");
    BufferedReader reader = new BufferedReader(file);

    while (reader.ready()) {
      String[] fields = reader.readLine().split(";");
      Manager manager = new Manager(fields[0], fields[1], LocalDate.parse(fields[2]));

      System.out.println(manager);
      managerService.addManager(manager);
    }

    reader.close();
  }
}
