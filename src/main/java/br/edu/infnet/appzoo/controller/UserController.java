package br.edu.infnet.appzoo.controller;

import br.edu.infnet.appzoo.models.User;
import br.edu.infnet.appzoo.service.UserService;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("user")
@Controller
public class UserController {
  @Autowired private UserService userService;

  @GetMapping(value = "/users/list")
  public String telaLista(Model model, HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "redirect:/signin";
    }

    model.addAttribute("users", userService.getAllUsers());
    model.addAttribute("headers", Arrays.asList("Nome", "E-mail", "Ação"));
    model.addAttribute("fields", Arrays.asList("name", "email", "delete:id"));
    model.addAttribute("route", "users");

    return "user/list";
  }

  @PostMapping(value = "/signin")
  public String login(
      HttpSession session, @RequestParam String email, @RequestParam String password) {
    User user = userService.getByEmail(email);
    if (user != null && user.getPassword().equals(password)) {
      session.setAttribute("user", user);

      return "redirect:/";
    }

    return "redirect:/signin";
  }

  @PostMapping(value = "/signout")
  public String logout(SessionStatus status) {
    status.setComplete();
    return "redirect:/";
  }

  @PostMapping(value = "/signup")
  public String signup(User user, HttpSession session) {
    userService.create(user);
    session.setAttribute("user", user);

    return "redirect:/";
  }

  @DeleteMapping("/users/delete/{id}")
  public String deleteUser(@PathVariable Integer id) {
    userService.deleteById(id);
    return "redirect:/users/list";
  }
}
