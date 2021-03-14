package dev.hoskovec.app;

import dev.hoskovec.controllers.EmployeeController;
import dev.hoskovec.controllers.LoginController;
import dev.hoskovec.controllers.ManagerController;
import dev.hoskovec.controllers.ReimbursementController;
import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(
                config -> {
                    config.enableCorsForAllOrigins();
                }

        );

        EmployeeController employeeController = new EmployeeController();
        ManagerController managerController = new ManagerController();
        ReimbursementController reimbursementController = new ReimbursementController();
        LoginController loginController = new LoginController();

        app.get("/employees", employeeController.getAllEmployeesHandler);
        app.get("/employees/:id", employeeController.getEmployeeByIdHandler);
        app.get("/managers", managerController.getAllManagersHandler);
        app.get("/managers/:id", managerController.getManagerByIdHandler);
        app.get("/reimbursement", reimbursementController.getAllReimbursementsHandler);
        app.get("/reimbursement/:id", reimbursementController.getReimbursementByIdHandler);
        app.post("/reimbursement", reimbursementController.createReimbursementHandler);
        app.delete("/reimbursement/:id", reimbursementController.deleteReimbursementHandler);
        app.put("/reimbursement/:id", reimbursementController.updateReimbursementHandler);
        app.post("/login", loginController.loginHandler);
        app.start();
    }
}
