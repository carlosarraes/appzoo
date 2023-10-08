package br.edu.infnet.appzoo.models;

import java.util.HashMap;
import java.util.Map;

public class User {
  private String name;
  private String email;
  private String password;

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Map<String, String> toMap() {
    Map<String, String> userMap = new HashMap<>();
    userMap.put("name", this.name);
    userMap.put("email", this.email);
    userMap.put("password", this.password);

    return userMap;
  }
}
