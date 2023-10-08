package br.edu.infnet.appzoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("user")
@Controller
public class AppController {
  @GetMapping(value = "/")
  public String telaHome() {
    return "home";
  }

  @GetMapping(value = "/signin")
  public String telaLogin() {
    return "signin";
  }

  @GetMapping(value = "/signup")
  public String telaCadastro() {
    return "signup";
  }
}
