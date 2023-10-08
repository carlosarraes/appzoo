package br.edu.infnet.appzoo.controller;

import br.edu.infnet.appzoo.models.Manager;
import br.edu.infnet.appzoo.service.ManagerService;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagerController {
  @Autowired private ManagerService managerService;

  @GetMapping(value = "/managers/list")
  public String telaLista(Model model) {
    model.addAttribute("managers", managerService.getAllManagers());
    model.addAttribute("headers", Arrays.asList("Name", "Email", "Birth Date", "Actions"));
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
  public String createManager(
      @RequestParam String name,
      @RequestParam String email,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate) {

    managerService.create(new Manager(name, email, birthDate));
    return "redirect:/managers/list";
  }
}
