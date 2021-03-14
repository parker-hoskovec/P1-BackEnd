package dev.hoskovec.servicetests;

import dev.hoskovec.daos.ManagerDAO;
import dev.hoskovec.daos.ManagerDAOHibernate;
import dev.hoskovec.entities.Manager;
import dev.hoskovec.services.ManagerService;
import dev.hoskovec.services.ManagerServiceImpl;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManagerServiceTest {

    private static ManagerService managerServ = new ManagerServiceImpl(new ManagerDAOHibernate());

    @Test
    @Order(1)
    void get_all_managers_test(){
        Set<Manager> allManagers = this.managerServ.getAllManagers();
        Assertions.assertEquals(allManagers.size(), 2);
    }

    @Test
    @Order(2)
    void get_manager_by_Id_test(){
        Manager johnny = this.managerServ.getManagerById(2);
        Assertions.assertEquals(johnny.getUserName(), "JThunder404");
    }

}
