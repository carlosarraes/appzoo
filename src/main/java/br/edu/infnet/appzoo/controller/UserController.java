package br.edu.infnet.appzoo.controller;

import br.edu.infnet.appzoo.service.UserService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
  @Autowired private UserService userService;

  @GetMapping(value = "/users/list")
  public String telaLista(Model model) {
    model.addAttribute("users", userService.getAllUsers());
    model.addAttribute("headers", Arrays.asList("Name", "Email", "Actions"));
    model.addAttribute("fields", Arrays.asList("name", "email", "delete:email"));
    model.addAttribute("route", "users");

    return "user/list";
  }

  @DeleteMapping("/users/delete/{email}")
  public String deleteUser(@PathVariable String email) {
    userService.deleteByEmail(email);
    return "redirect:/users/list";
  }
}
