package dev.hoskovec.daos;

import dev.hoskovec.entities.Manager;

import java.util.Set;

public interface ManagerDAO {

    Set<Manager> getAllManagers();

    Manager getManagerById(int id);

}
