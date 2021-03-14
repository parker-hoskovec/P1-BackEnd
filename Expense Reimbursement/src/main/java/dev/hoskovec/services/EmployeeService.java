package dev.hoskovec.services;

import dev.hoskovec.entities.Employee;

import java.util.Set;

public interface EmployeeService {

    Set<Employee> getAllEmployees();

    Employee getEmployeeById(int id);


}
