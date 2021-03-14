package dev.hoskovec.servicetests;


import dev.hoskovec.daos.EmployeeDAOHibernate;
import dev.hoskovec.entities.Employee;
import dev.hoskovec.services.EmployeeService;
import dev.hoskovec.services.EmployeeServiceImpl;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTest {

    private static EmployeeService employeeServ = new EmployeeServiceImpl(new EmployeeDAOHibernate());

    @Test
    @Order(1)
    void get_all_employees_test(){
        Set<Employee> allEmployees = this.employeeServ.getAllEmployees();
        Assertions.assertEquals(allEmployees.size(), 2);
    }

    @Test
    @Order(2)
    void get_employee_by_Id_test(){
        Employee mike = this.employeeServ.getEmployeeById(2);
        Assertions.assertEquals(mike.getUserName(), "MSmith202");
    }
}
