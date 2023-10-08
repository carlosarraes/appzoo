package br.edu.infnet.appzoo.models;

import java.util.UUID;

public abstract class Animal {
  private UUID id;
  private String name;
  private String species;
  private Integer age;
  private ZooKeeper zooKeeper;

  public Animal(String name, String species, Integer age) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.species = species;
    this.age = age;
    this.zooKeeper = null;
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

  public UUID getId() {
    return id;
  }

  public ZooKeeper getZooKeeper() {
    return zooKeeper;
  }

  public void setZooKeeper(ZooKeeper zooKeeper) {
    this.zooKeeper = zooKeeper;
  }

  @Override
  public String toString() {
    return String.format("%s;%s;%d", getName(), getSpecies(), getAge());
  }
}
