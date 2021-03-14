package dev.hoskovec.controllers;

import com.google.gson.Gson;
import dev.hoskovec.daos.EmployeeDAO;
import dev.hoskovec.daos.EmployeeDAOHibernate;
import dev.hoskovec.entities.Employee;
import dev.hoskovec.services.EmployeeService;
import dev.hoskovec.services.EmployeeServiceImpl;
import io.javalin.http.Handler;

import java.util.Set;

public class EmployeeController {

    private EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDAOHibernate());

    public Handler getAllEmployeesHandler = (ctx) -> {
        Set<Employee> allEmployees = this.employeeService.getAllEmployees();
        Gson gson = new Gson();
        String employeeJSON = gson.toJson(allEmployees);
        ctx.result(employeeJSON);
    };

    public Handler getEmployeeByIdHandler = (ctx) -> {
        int id  = Integer.parseInt(ctx.pathParam("id"));
        Employee employee = this.employeeService.getEmployeeById(id);

        if (employee== null){
            ctx.result("Employee not found");
            ctx.status(404);
        }else{
            Gson gson = new Gson();
            String employeeJSON = gson.toJson(employee);
            ctx.result(employeeJSON);
            ctx.status(200);
        }
    };

}
