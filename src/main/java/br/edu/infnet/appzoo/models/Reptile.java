package br.edu.infnet.appzoo.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("REPTILE")
public class Reptile extends Animal {
  private String scaleColor;
  private Boolean isVenomous;
  private Boolean coldBlooded;

  protected Reptile() {}

  public Reptile(
      String name,
      String species,
      Integer age,
      String scaleColor,
      Boolean isVenomous,
      Boolean coldBlooded) {
    super(name, species, age);
    this.scaleColor = scaleColor;
    this.isVenomous = isVenomous;
    this.coldBlooded = coldBlooded;
  }

  public String getScaleColor() {
    return scaleColor;
  }

  public void setScaleColor(String scaleColor) {
    this.scaleColor = scaleColor;
  }

  public Boolean getIsVenomous() {
    return isVenomous;
  }

  public void setIsVenomous(Boolean isVenomous) {
    this.isVenomous = isVenomous;
  }

  public Boolean getColdBlooded() {
    return coldBlooded;
  }

  @Override
  public String toString() {
    return String.format(
        "%s;%s;%d;%s;%s;%s",
        getName(), getSpecies(), getAge(), getScaleColor(), getIsVenomous(), getColdBlooded());
  }
}
