package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class EmployeeController {

    EmployeeDAO eDAO = new EmployeeDAO();

    public Handler getEmployeesHandler = (ctx) -> {

        if(AuthController.ses != null) {

            ArrayList<Employee> employees = eDAO.getEmployees();

            Gson gson = new Gson();
            String JSONEmployees = gson.toJson(employees);

            ctx.result(JSONEmployees);
            ctx.status(202);

        } else {
            ctx.result("YOU MUST LOG IN TO DO THIS");
            ctx.status(401); //401 "unauthorized"
        }

    };

    public Handler insertEmployee = (ctx) -> {

        String body = ctx.body();
        Gson gson = new Gson();

        Employee newEmp = gson.fromJson(body, Employee.class);
        String userName = newEmp.getUser_name();
        ArrayList<String> registeredNames = eDAO.getUserNames();
        if (registeredNames.contains(userName)){
            ctx.status(406);
            ctx.result("User name is in use.  Choose a different user name.");
        } else if(eDAO.insertEmployee(newEmp) != null) {
            ctx.status(201); //201 "created"
            ctx.result(body); //send back the employee
        } else {
            ctx.status(406); //406 "not acceptable"
            ctx.result("Insert employee failed!");
        }

    };
}