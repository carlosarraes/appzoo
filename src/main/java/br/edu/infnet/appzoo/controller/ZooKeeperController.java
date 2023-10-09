package br.edu.infnet.appzoo.controller;

import br.edu.infnet.appzoo.models.Manager;
import br.edu.infnet.appzoo.models.ZooKeeper;
import br.edu.infnet.appzoo.service.ManagerService;
import br.edu.infnet.appzoo.service.ZooKeeperService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("user")
@Controller
public class ZooKeeperController {
  @Autowired private ZooKeeperService zooKeeperService;
  @Autowired private ManagerService managerService;

  @GetMapping(value = "/zookeepers/list")
  public String telaLista(Model model, HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "redirect:/signin";
    }

    model.addAttribute("zookeepers", zooKeeperService.getAllZooKeepers());
    model.addAttribute("managers", managerService.getAllManagers());

    return "zookeeper/list";
  }

  @DeleteMapping("/zookeepers/delete/{id}")
  public String deleteManager(@PathVariable Integer id) {
    zooKeeperService.deleteById(id);
    return "redirect:/zookeepers/list";
  }

  @PostMapping("/zookeepers/create")
  public String create(ZooKeeper zooKeeper, @RequestParam("managerId") Integer managerId) {
    Manager manager = managerService.getById(managerId);
    zooKeeper.setManager(manager);
    zooKeeperService.create(zooKeeper);
    return "redirect:/zookeepers/list";
  }
}
