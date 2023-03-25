package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.AuthDAO;
import com.revature.models.Employee;
import com.revature.models.LoginDTO;
import io.javalin.http.Handler;
import jakarta.servlet.http.HttpSession;


public class AuthController {

    //AuthDAO so we can access its methods
    AuthDAO aDAO = new AuthDAO();

    //empty HttpSession object that will be filled upon successful login
    public static HttpSession ses;
    //to prevent functionalities from running until login, have them check whether this Session is null;

    //login will be a POST request, since the user is expected to send some data in the HTTP Request
    public Handler loginHandler = (ctx) -> {

        //ctx.body() to grab the HTTP Request data
        String body = ctx.body();

        //GSON for the JSON -> Java conversion
        Gson gson = new Gson();

        //take the incoming data, instantiate a LoginDTO class
        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class); //.class means "turn this into a LoginDTO object"

        //if the login is successful, this Employee object will be populated. otherwise, null
        Employee loggedInEmployee = aDAO.login(lDTO.getUser_name(), lDTO.getPassword());

        if(loggedInEmployee != null){

            //This is how we create sessions in Javalin 5
            ses = ctx.req().getSession();

            //we can use setAttribute() to set certain values to certain keys
            //THIS IS HOW WE CAN SAVE DATA IN A SESSION
           // ses.setAttribute("role_title", loggedInEmployee.getRole().getRole_title());
            ses.setAttribute("role_id", loggedInEmployee.getRole().getRole_id());
            ses.setAttribute("user_id", loggedInEmployee.getUser_id());
            ses.setAttribute("user_name", loggedInEmployee.getUser_name());

            //role id would be used to determine manager/employee, giving access to only certain methods
            //employee id would be used to get all reimbursements of the logged in employee
            //as well anything else that needs user id, like the employee FK of reimbursements

            /*
                FOR JAVALIN 5 - to create sessions it'll be ctx.req().getSession();
             */

            //turn the employee back into JSON, so we can send it in the HTTP Response
            String userJSON = gson.toJson(loggedInEmployee);

            ctx.result(userJSON);
            ctx.status(202); //202 "accepted"
        } else {
            ctx.status(401); //401 "unauthorized"
        }

    };

}