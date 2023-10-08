package br.edu.infnet.appzoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
  @GetMapping(value = "/")
  public String telaHome() {
    return "home";
  }

  @GetMapping(value = "/login")
  public String telaLogin() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String login(@RequestParam String email, @RequestParam String password) {
    if (email.equals("admin@admin.com") && password.equals("123456")) {
      return "redirect:/";
    }

    return "redirect:/login";
  }
}
