package br.edu.infnet.appzoo.models;

public abstract class Animal {
  private String name;
  private String species;
  private Integer age;

  public Animal(String name, String species, Integer age) {
    this.name = name;
    this.species = species;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return String.format("%s;%s;%d", getName(), getSpecies(), getAge());
  }
}
