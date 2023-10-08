package br.edu.infnet.appzoo.controller;

import br.edu.infnet.appzoo.models.User;
import br.edu.infnet.appzoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
  @Autowired private UserService userService;

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

  @PostMapping(value = "/signin")
  public String login(@RequestParam String email, @RequestParam String password) {
    User user = userService.getByEmail(email);
    if (user != null && user.getPassword().equals(password)) {
      return "redirect:/";
    }

    return "redirect:/signin";
  }

  @PostMapping(value = "/signup")
  public String signup(
      @RequestParam String name, @RequestParam String email, @RequestParam String password) {
    userService.create(name, email, password);

    return "redirect:/";
  }
}
