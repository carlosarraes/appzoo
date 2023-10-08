package br.edu.infnet.appzoo.service;

import br.edu.infnet.appzoo.models.Manager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
  private final Map<UUID, Manager> managers = new HashMap<>();

  public void create(Manager manager) {
    managers.put(manager.getId(), manager);
  }

  public Manager getById(UUID id) {
    return managers.get(id);
  }

  public void update(Manager manager) {
    managers.put(manager.getId(), manager);
  }

  public void delete(UUID id) {
    managers.remove(id);
  }

  public Collection<Manager> getAllManagers() {
    return managers.values();
  }

  public List<Map<String, String>> convertManagersToMaps(Collection<Manager> managers) {
    return managers.stream().map(Manager::toMap).collect(Collectors.toList());
  }

  public List<Map<String, String>> getManagerMaps() {
    Collection<Manager> managersList = getAllManagers();
    return convertManagersToMaps(new ArrayList<>(managersList));
  }
}
