package dev.hoskovec.controllers;

import com.google.gson.Gson;
import dev.hoskovec.daos.EmployeeDAOHibernate;
import dev.hoskovec.daos.ManagerDAOHibernate;
import dev.hoskovec.entities.Employee;
import dev.hoskovec.entities.Manager;
import dev.hoskovec.services.EmployeeService;
import dev.hoskovec.services.EmployeeServiceImpl;
import dev.hoskovec.services.ManagerService;
import dev.hoskovec.services.ManagerServiceImpl;
import dev.hoskovec.utils.JwtUtil;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

public class LoginController {

    private EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDAOHibernate());
    private ManagerService managerService = new ManagerServiceImpl(new ManagerDAOHibernate());
    private Logger logger = Logger.getLogger(LoginController.class.getName());

    public Handler loginHandler = (ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        String loginJSON = gson.toJson(body);
        System.out.println(loginJSON);
        ArrayList<Manager> allManagers = new ArrayList<Manager>();
        allManagers.addAll( this.managerService.getAllManagers());
        ArrayList<Employee> allEmployees = new ArrayList<Employee>();
        allEmployees.addAll(this.employeeService.getAllEmployees());
        for(int i = 0; i < allEmployees.size(); i++){
            if (loginJSON.contains(allEmployees.get(i).getUserName()) && loginJSON.contains(allEmployees.get(i).getPassword())){
                String jwt = JwtUtil.generate("Employee", allEmployees.get(i).getName());
                logger.info("Employee with id "+ allEmployees.get(i).getEmployeeId()+ "was successfully logged in");
                ctx.result(jwt);
            }
        }
        for(int i = 0; i < allManagers.size(); i++){
            if (loginJSON.contains(allManagers.get(i).getUserName()) && loginJSON.contains(allManagers.get(i).getPassword())){
                String jwt = JwtUtil.generate("Manager", allManagers.get(i).getName());
                logger.info("Manager with id "+ allManagers.get(i).getManagerId()+ "was successfully logged in");
                ctx.result(jwt);
            }
        }

    };
}
