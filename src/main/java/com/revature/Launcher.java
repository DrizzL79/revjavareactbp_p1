package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.RoleController;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {

    public static void main(String[] args) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTION SUCCESSFUL :)");
        } catch (SQLException e) {
            System.out.println("connection failed :(");
        }

        Javalin app = Javalin.create(config -> {
                          //  config.plugins.enableCors(cors -> {
                                //replacement for enableCorsForAllOrigins()
                         //       cors.add(CorsPluginConfig::anyHost);
                         //   });

                        }).start(3000);

        EmployeeController ec = new EmployeeController();
        //RoleController rc = new RoleController();
        AuthController ac = new AuthController();
        ReimbursementController rc = new ReimbursementController();

        app.get("/users", ec.getEmployeesHandler);
        app.post("/users", ec.insertEmployee);
        app.get("/reimbursements/pending", rc.getPendingReimbursementsHandler);
        app.post("/reimbursements/pending", rc.submitReimbursementHandler);
        app.get("/reimbursements/employees/{user_name}", rc.getEmpReimbursementsHandler);
        app.patch("/reimbursements/processed",rc.updateReimbursementsHandler);
        app.post("/login", ac.loginHandler);
        app.get("/reimbursements/",rc.getReimbursementsMgmtHandler);
    }

}