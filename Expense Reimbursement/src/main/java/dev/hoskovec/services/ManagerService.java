package dev.hoskovec.services;

import dev.hoskovec.entities.Manager;

import java.util.Set;

public interface ManagerService {

    Set<Manager> getAllManagers();

    Manager getManagerById(int id);

}
