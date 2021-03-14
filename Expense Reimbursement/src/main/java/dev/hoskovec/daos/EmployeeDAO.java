package dev.hoskovec.daos;

import dev.hoskovec.entities.Employee;

import java.util.Set;

public interface EmployeeDAO {

    Set<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

}
