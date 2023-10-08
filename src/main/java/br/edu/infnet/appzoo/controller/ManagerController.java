package br.edu.infnet.appzoo.controller;

import br.edu.infnet.appzoo.models.Manager;
import br.edu.infnet.appzoo.service.ManagerService;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("user")
@Controller
public class ManagerController {
  @Autowired private ManagerService managerService;

  @GetMapping(value = "/managers/list")
  public String telaLista(Model model, HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "redirect:/signin";
    }

    model.addAttribute("managers", managerService.getAllManagers());
    model.addAttribute("headers", Arrays.asList("Nome", "Email", "Data de Nascimento", "Ação"));
    model.addAttribute("fields", Arrays.asList("name", "email", "birthDate", "delete:id"));
    model.addAttribute("route", "managers");

    return "manager/list";
  }

  @DeleteMapping("/managers/delete/{id}")
  public String deleteManager(@PathVariable UUID id) {
    managerService.delete(id);
    return "redirect:/managers/list";
  }

  @PostMapping("/managers/create")
  public String createManager(Manager manager) {
    managerService.create(manager);
    return "redirect:/managers/list";
  }
}
