package br.edu.infnet.appzoo.controller;

import br.edu.infnet.appzoo.service.ManagerService;
import java.util.Arrays;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ManagerController {
  @Autowired private ManagerService managerService;

  @GetMapping(value = "/managers/list")
  public String telaLista(Model model) {
    model.addAttribute("managers", managerService.getAllManagers());
    model.addAttribute("headers", Arrays.asList("Name", "Email", "Birth Date", "Actions"));
    model.addAttribute("fields", Arrays.asList("name", "email", "birthDate", "id"));

    return "manager/list";
  }

  @DeleteMapping("/managers/delete/{id}")
  public String deleteManager(@PathVariable UUID id) {
    managerService.delete(id);
    return "redirect:/managers/list";
  }
}
