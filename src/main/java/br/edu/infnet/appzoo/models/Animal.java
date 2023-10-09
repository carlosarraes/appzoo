package br.edu.infnet.appzoo.models;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "animal_type")
public abstract class Animal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private String species;
  private Integer age;

  @ManyToOne
  @JoinColumn(name = "zookeeper_id")
  private ZooKeeper zooKeeper;

  protected Animal() {}

  public Animal(String name, String species, Integer age) {
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

  public Integer getId() {
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
