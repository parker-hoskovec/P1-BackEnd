package dev.hoskovec.daotests;

import dev.hoskovec.daos.ManagerDAO;
import dev.hoskovec.daos.ManagerDAOHibernate;
import dev.hoskovec.entities.Manager;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManagerDAOTest {

    private static ManagerDAO managerDAO = new ManagerDAOHibernate();

    @Test
    @Order(1)
    void get_all_managers_test(){
        Set<Manager> allManagers = this.managerDAO.getAllManagers();
        Assertions.assertEquals(allManagers.size(), 2);
    }

    @Test
    @Order(2)
    void get_manager_by_Id_test(){
        Manager johnny = this.managerDAO.getManagerById(2);
        Assertions.assertEquals(johnny.getUserName(), "JThunder404");
    }

}
