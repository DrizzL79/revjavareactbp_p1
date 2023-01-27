package com.revature.daos;

import com.revature.models.Reimbursement;

public interface ReimbursementDAOInterface {

    Reimbursement submitReimbursement(Reimbursement ticket);

    public boolean updateReimbursementStatus(String status, int id);


}