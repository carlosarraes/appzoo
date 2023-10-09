package br.edu.infnet.appzoo.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MAMMAL")
public class Mammal extends Animal {
  private String furColor;
  private Boolean petFriendly;
  private Integer numberOfLegs;

  protected Mammal() {}

  public Mammal(
      String name,
      String species,
      Integer age,
      String furColor,
      Boolean petFriendly,
      Integer numberOfLegs) {
    super(name, species, age);
    this.furColor = furColor;
    this.petFriendly = petFriendly;
    this.numberOfLegs = numberOfLegs;
  }

  public String getFurColor() {
    return furColor;
  }

  public void setFurColor(String furColor) {
    this.furColor = furColor;
  }

  public Boolean getPetFriendly() {
    return petFriendly;
  }

  public void setPetFriendly(Boolean petFriendly) {
    this.petFriendly = petFriendly;
  }

  public Integer getNumberOfLegs() {
    return numberOfLegs;
  }

  public void setNumberOfLegs(Integer numberOfLegs) {
    this.numberOfLegs = numberOfLegs;
  }

  @Override
  public String toString() {
    return String.format(
        "%s;%s;%d;%s;%s;%d",
        getName(), getSpecies(), getAge(), getFurColor(), getPetFriendly(), getNumberOfLegs());
  }
}
