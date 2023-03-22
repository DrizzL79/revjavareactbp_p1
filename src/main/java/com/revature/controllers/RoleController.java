package com.revature.controllers;

import com.revature.daos.RoleDAO;
import io.javalin.http.Handler;

public class RoleController {

    //we need a RoleDAO to use RoleDAO methods
    RoleDAO rDAO = new RoleDAO();

    //This Handler will get the HTTP PATCH request to update a Role's salary
   // public Handler updateSalaryHandler = (ctx) -> {

        /*For this request, the user will include the title of Role to be changed in the path parameters
         The new salary number will be in the HTTP Request body*/

        /*To access a path parameter, we can use ctx.pathParam()
        the value that the user includes will be stored in the "title" key
        in this case, our Launcher endpoint handler calls it "title", so we need to call "title" here */
     //   String role_title = ctx.pathParam("title");

        //int to hold the new Role salary that the user will input in the HTTP Request body
       // int salary = Integer.parseInt(ctx.body()); //we need to parseInt() here since ctx.body() returns String
        //in Postman, no need to make a JSON object, we can just input the new salary int

        //if updateRoleSalary returns true...
      /*  if(rDAO.updateRoleSalary(role_title, salary)){
            ctx.status(202); //202 "accepted"
        } else {
            ctx.status(406); //406 "not acceptable"
        }

    };*/

}