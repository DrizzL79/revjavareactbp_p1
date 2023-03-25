package com.revature.daos;

import com.revature.models.Reimbursement;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReimbursementDAOInterface {

    Reimbursement submitReimbursement(Reimbursement ticket);
    boolean updateReimbursementStatus(Reimbursement reimbursement);
    ArrayList<Reimbursement> getAllReimbursementsEmp(String user_name_fk);
    ArrayList<Reimbursement> getReimbursementsByStatus(String status);
}