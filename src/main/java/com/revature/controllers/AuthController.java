package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.AuthDAO;
import com.revature.models.Employee;
import com.revature.models.LoginDTO;
import io.javalin.http.Handler;
import jakarta.servlet.http.HttpSession;


public class AuthController {

    AuthDAO aDAO = new AuthDAO();
    public static HttpSession ses;
    public Handler loginHandler = (ctx) -> {

        String body = ctx.body();
        Gson gson = new Gson();

        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
        Employee loggedInEmployee = aDAO.login(lDTO.getUser_name(), lDTO.getPassword());

        if(loggedInEmployee != null){

            ses = ctx.req().getSession();
            ses.setAttribute("role_id", loggedInEmployee.getRole().getRole_id());
            ses.setAttribute("user_id", loggedInEmployee.getUser_id());
            ses.setAttribute("user_name", loggedInEmployee.getUser_name());

            String userJSON = gson.toJson(loggedInEmployee);

            ctx.result(userJSON);
            ctx.status(202); //202 "accepted"

        } else {
            ctx.status(401); //401 "unauthorized"
        }
    };
}