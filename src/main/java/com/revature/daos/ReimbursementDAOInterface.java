package com.revature.daos;

import com.revature.models.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDAOInterface {

    Reimbursement submitReimbursement(Reimbursement ticket);
    boolean updateReimbursementStatus(Reimbursement reimbursement);
    ArrayList<Reimbursement> getAllReimbursementsEmp(String user_name_fk);
    ArrayList<Reimbursement> getReimbursementsByStatus(int status);
    ArrayList<Reimbursement> getAllReimbursementsMgmt();
}