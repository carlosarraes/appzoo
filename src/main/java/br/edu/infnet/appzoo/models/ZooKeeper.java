package br.edu.infnet.appzoo.models;

import java.time.LocalDate;

public class ZooKeeper {
  private String name;
  private String phoneNumber;
  private LocalDate hireDate;

  public ZooKeeper(String name, String phoneNumber, LocalDate hireDate) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.hireDate = hireDate;
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

  @Override
  public String toString() {
    return String.format("%s;%s;%s", getName(), getPhoneNumber(), getHireDate());
  }
}
