package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Reimbursement;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class ReimbursementController {

    ReimbursementDAO
            reDAO =
            new ReimbursementDAO();

    public Handler getPendingReimbursementsHandler = (ctx) -> {

        if (AuthController.ses != null) {
            int roleID = (Integer) AuthController.ses.getAttribute("role_id");
            if (roleID != 1) {
                ctx.result("You are not authorized to do this!");
                ctx.status(401);
            } else {
                ArrayList<Reimbursement> reimbursements = reDAO.getReimbursementsByStatus("Pending");
                Gson gson = new Gson();
                String JSONPendReimb = gson.toJson(reimbursements);
                ctx.result(JSONPendReimb);
                ctx.status(202);
            }
        } else {
            ctx.result("You need to log in to do this.");
            ctx.status(401);
        }
    };

    public Handler submitReimbursementHandler = (ctx) -> {

        if (AuthController.ses != null) {
            String body = ctx.body();
            Gson gson = new Gson();
            Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
            if (reDAO.submitReimbursement(reimbursement) != null) {
                ctx.status(201);
                ctx.result(body);
            } else {
                ctx.status(401);
                ctx.result("Submit Failed! Please include an amount," +
                        " a description and your username.");
            }
        } else {
            ctx.status(401);
            ctx.result("You must be logged in to do this.");
        }
    };

    public Handler getEmpReimbursementsHandler = (ctx) -> {
        if (AuthController.ses != null) {
            String user = (String) AuthController.ses.getAttribute("user_name");
            ArrayList<Reimbursement> reimbursements = reDAO.getAllReimbursementsEmp(user);
            Gson gson = new Gson();
            String JSONER = gson.toJson(reimbursements);
            ctx.result(JSONER);
            ctx.status(201);
        } else {
            ctx.status(401);
            ctx.result("Operation Failed!");
        }
    };

    public Handler updateReimbursementsHandler = (ctx) -> {
        if (AuthController.ses != null) {
            int roleID = (Integer) AuthController.ses.getAttribute("role_id");
            if (roleID != 1) {
                ctx.result("You are not authorized to do this!");
                ctx.status(401);
            } else {
                String body = ctx.body();
                Gson gson = new Gson();
                Reimbursement update = gson.fromJson(body, Reimbursement.class);
                if (reDAO.updateReimbursementStatus(update)) {
                    ctx.status(201);
                    ctx.result(body);
                } else {
                    ctx.status(401);
                    ctx.result("Update Failed!");
                }
            }
        } else {
            ctx.status(401);
            ctx.result("You must be logged in to do this.");
        }

    };
}//end of class
