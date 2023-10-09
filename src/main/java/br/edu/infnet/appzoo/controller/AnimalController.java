package br.edu.infnet.appzoo.controller;

import br.edu.infnet.appzoo.service.AnimalService;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("user")
@Controller
public class AnimalController {
  @Autowired private AnimalService animalService;

  @GetMapping(value = "/animals/list")
  public String telaLista(Model model, HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "redirect:/signin";
    }

    model.addAttribute("animals", animalService.getAllAnimals());
    model.addAttribute("headers", Arrays.asList("Nome", "Espécie", "Idade", "Ação"));
    model.addAttribute("fields", Arrays.asList("name", "species", "age", "delete:id"));
    model.addAttribute("route", "animals");

    return "animal/list";
  }

  @GetMapping(value = "/mammals/list")
  public String telaListaMammals(Model model, HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "redirect:/signin";
    }

    model.addAttribute("mammals", animalService.getBySpecies("mamifero"));
    model.addAttribute(
        "headers",
        Arrays.asList("Nome", "Espécie", "Idade", "Cor", "Pet Friendly", "Qntd Patas", "Ação"));
    model.addAttribute(
        "fields",
        Arrays.asList(
            "name", "species", "age", "furColor", "petFriendly", "numberOfLegs", "delete:id"));
    model.addAttribute("route", "animals");

    return "mammal/list";
  }

  @GetMapping(value = "/birds/list")
  public String telaListaBirds(Model model, HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "redirect:/signin";
    }

    model.addAttribute("birds", animalService.getBySpecies("ave"));
    model.addAttribute(
        "headers",
        Arrays.asList("Nome", "Espécie", "Idade", "Cor", "Voador", "Tipo de bico", "Ação"));
    model.addAttribute(
        "fields",
        Arrays.asList("name", "species", "age", "featherColor", "canFly", "beakType", "delete:id"));
    model.addAttribute("route", "animals");

    return "bird/list";
  }

  @GetMapping(value = "/reptiles/list")
  public String telaListaReptiles(Model model, HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "redirect:/signin";
    }

    model.addAttribute("reptiles", animalService.getBySpecies("reptil"));
    model.addAttribute(
        "headers",
        Arrays.asList("Nome", "Espécie", "Idade", "Cor", "Venenoso", "Sangue Frio", "Ação"));
    model.addAttribute(
        "fields",
        Arrays.asList(
            "name", "species", "age", "scaleColor", "isVenomous", "coldBlooded", "delete:id"));
    model.addAttribute("route", "animals");

    return "reptile/list";
  }

  @DeleteMapping(value = "/animals/delete/{id}")
  public String delete(@PathVariable Integer id) {
    animalService.deleteById(id);
    return "redirect:/animals/list";
  }
}
