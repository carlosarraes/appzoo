package br.edu.infnet.appzoo.models;

import java.time.LocalDate;

public class Manager {
  private String name;
  private String email;
  private LocalDate birthDate;

  public Manager(String name, String email, LocalDate birthDate) {
    this.name = name;
    this.email = email;
    this.birthDate = birthDate;
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

  @Override
  public String toString() {
    return String.format("%s;%s;%s", getName(), getEmail(), getBirthDate());
  }
}
