package dev.hoskovec.services;

import dev.hoskovec.daos.ManagerDAO;
import dev.hoskovec.entities.Manager;

import java.util.Set;

public class ManagerServiceImpl implements ManagerService {

    private ManagerDAO managerDAO;

    public ManagerServiceImpl(ManagerDAO managerDAO){
        this.managerDAO= managerDAO;
    }

    @Override
    public Set<Manager> getAllManagers() {
        return this.managerDAO.getAllManagers();
    }

    @Override
    public Manager getManagerById(int id) {
        return this.managerDAO.getManagerById(id);
    }

}
