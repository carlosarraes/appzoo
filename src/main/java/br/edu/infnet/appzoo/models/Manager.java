package br.edu.infnet.appzoo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Manager {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private String email;
  private LocalDate birthDate;

  @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ZooKeeper> zooKeepers = new ArrayList<>();

  protected Manager() {}

  public Manager(String name, String email, LocalDate birthDate) {
    this.name = name;
    this.email = email;
    this.birthDate = birthDate;
    this.zooKeepers = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public List<ZooKeeper> getZooKeepers() {
    return zooKeepers;
  }

  public void addZooKeeper(ZooKeeper zooKeeper) {
    this.zooKeepers.add(zooKeeper);
    zooKeeper.setManager(this);
  }

  public void removeZooKeeper(ZooKeeper zooKeeper) {
    this.zooKeepers.remove(zooKeeper);
    zooKeeper.setManager(null);
  }

  public Integer getId() {
    return id;
  }

  public Map<String, String> toMap() {
    Map<String, String> map = new HashMap<>();

    map.put("name", getName());
    map.put("email", getEmail());
    map.put("birthDate", getBirthDate().toString());

    return map;
  }

  @Override
  public String toString() {
    return String.format("%s;%s;%s", getName(), getEmail(), getBirthDate());
  }
}
