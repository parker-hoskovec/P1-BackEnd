package dev.hoskovec.daotests;

import dev.hoskovec.daos.EmployeeDAO;
import dev.hoskovec.daos.EmployeeDAOHibernate;
import dev.hoskovec.entities.Employee;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDAOTest {

    private static EmployeeDAO employeeDAO = new EmployeeDAOHibernate();

    @Test
    @Order(1)
    void get_all_employees_test(){
        Set<Employee> allEmployees = this.employeeDAO.getAllEmployees();
        Assertions.assertEquals(allEmployees.size(), 2);
    }

    @Test
    @Order(2)
    void get_employee_by_Id_test(){
        Employee mike = this.employeeDAO.getEmployeeById(2);
        Assertions.assertEquals(mike.getUserName(), "MSmith202");
    }
}
