package br.edu.infnet.appzoo.service;

import br.edu.infnet.appzoo.models.User;
import br.edu.infnet.appzoo.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired private UserRepository userRepository;

  public void create(User user) {
    userRepository.save(user);
  }

  public User getById(Integer id) {
    return userRepository.findById(id).orElse(null);
  }

  public void deleteById(Integer id) {
    userRepository.deleteById(id);
  }

  public User getByEmail(String email) {
    Optional<User> user = userRepository.findByEmail(email);

    if (user == null) {
      return null;
    }

    return user.get();
  }

  public Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
