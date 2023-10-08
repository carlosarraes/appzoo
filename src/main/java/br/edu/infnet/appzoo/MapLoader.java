package br.edu.infnet.appzoo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Integer.MAX_VALUE)
@Component
public class MapLoader implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) throws Exception {}
}
