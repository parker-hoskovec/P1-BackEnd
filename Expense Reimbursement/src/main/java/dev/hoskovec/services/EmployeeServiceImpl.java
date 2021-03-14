package dev.hoskovec.services;

import dev.hoskovec.daos.EmployeeDAO;
import dev.hoskovec.entities.Employee;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return this.employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {

        return this.employeeDAO.getEmployeeById(id);
    }

}
