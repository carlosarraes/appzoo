package br.edu.infnet.appzoo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Manager {
  private UUID id;
  private String name;
  private String email;
  private LocalDate birthDate;
  private List<ZooKeeper> zooKeepers;

  public Manager(String name, String email, LocalDate birthDate) {
    this.name = name;
    this.email = email;
    this.birthDate = birthDate;
    this.zooKeepers = new ArrayList<>();
    this.id = UUID.randomUUID();
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

  public UUID getId() {
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
