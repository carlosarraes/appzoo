package br.edu.infnet.appzoo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ZooKeeper {
  private String name;
  private String phoneNumber;
  private LocalDate hireDate;
  private List<Animal> animals;
  private Manager manager;

  public ZooKeeper(String name, String phoneNumber, LocalDate hireDate) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.hireDate = hireDate;
    this.animals = new ArrayList<>();
    this.manager = null;
  }

  public String getName() {
    return name;
  }

  public LocalDate getHireDate() {
    return hireDate;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setHireDate(LocalDate hireDate) {
    this.hireDate = hireDate;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<Animal> getAnimals() {
    return animals;
  }

  public void addAnimal(Animal animal) {
    animal.setZooKeeper(this);
    this.animals.add(animal);
  }

  public void removeAnimal(Animal animal) {
    animal.setZooKeeper(null);
    this.animals.remove(animal);
  }

  public Manager getManager() {
    return manager;
  }

  public void setManager(Manager manager) {
    this.manager = manager;
  }

  @Override
  public String toString() {
    return String.format(
        "%s;%s;%s;%d", getName(), getPhoneNumber(), getHireDate(), getAnimals().size());
  }
}
