package br.edu.infnet.appzoo.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BIRD")
public class Bird extends Animal {
  private String featherColor;
  private Boolean canFly;
  private String beakType;

  protected Bird() {}

  public Bird(
      String name,
      String species,
      Integer age,
      String featherColor,
      Boolean canFly,
      String beakType) {
    super(name, species, age);
    this.featherColor = featherColor;
    this.canFly = canFly;
    this.beakType = beakType;
  }

  public String getFeatherColor() {
    return featherColor;
  }

  public void setFeatherColor(String featherColor) {
    this.featherColor = featherColor;
  }

  public Boolean getCanFly() {
    return canFly;
  }

  public void setCanFly(Boolean canFly) {
    this.canFly = canFly;
  }

  public String getBeakType() {
    return beakType;
  }

  public void setBeakType(String beakType) {
    this.beakType = beakType;
  }

  @Override
  public String toString() {
    return String.format(
        "%s;%s;%d;%s;%s;%s",
        getName(), getSpecies(), getAge(), getFeatherColor(), getCanFly(), getBeakType());
  }
}
