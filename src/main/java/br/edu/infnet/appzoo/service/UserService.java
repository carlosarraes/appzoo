package br.edu.infnet.appzoo.service;

import br.edu.infnet.appzoo.models.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final Map<String, User> users = new HashMap<>();

  public void create(String name, String email, String password) {
    User user = new User(name, email, password);
    users.put(user.getEmail(), user);
  }

  public User getByEmail(String email) {
    return users.get(email);
  }

  public void deleteByEmail(String email) {
    users.remove(email);
  }

  public void update(String email, String password) {
    User user = getByEmail(email);
    user.setPassword(password);
  }

  public Collection<User> getAllUsers() {
    return users.values();
  }

  public List<Map<String, String>> convertUsersToMaps(Collection<User> users) {
    return users.stream().map(User::toMap).collect(Collectors.toList());
  }

  public List<Map<String, String>> getUserMaps() {
    Collection<User> usersList = getAllUsers();
    return convertUsersToMaps(new ArrayList<>(usersList));
  }
}
