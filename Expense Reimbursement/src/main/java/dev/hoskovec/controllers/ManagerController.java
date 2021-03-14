package dev.hoskovec.controllers;

import com.google.gson.Gson;
import dev.hoskovec.daos.ManagerDAOHibernate;
import dev.hoskovec.entities.Manager;
import dev.hoskovec.services.ManagerService;
import dev.hoskovec.services.ManagerServiceImpl;
import io.javalin.http.Handler;

import java.util.Set;

public class ManagerController {

    private ManagerService managerService = new ManagerServiceImpl(new ManagerDAOHibernate());


    public Handler getAllManagersHandler = (ctx) -> {
        Set<Manager> allManagers = this.managerService.getAllManagers();
        Gson gson = new Gson();
        String managerJSON = gson.toJson(allManagers);
        ctx.result(managerJSON);
    };

    public Handler getManagerByIdHandler = (ctx) -> {
        int id  = Integer.parseInt(ctx.pathParam("id"));
        Manager manager = this.managerService.getManagerById(id);

        if (manager== null){
            ctx.result("Employee not found");
            ctx.status(404);
        }else{
            Gson gson = new Gson();
            String managerJSON = gson.toJson(manager);
            ctx.result(managerJSON);
            ctx.status(200);
        }
    };
}
