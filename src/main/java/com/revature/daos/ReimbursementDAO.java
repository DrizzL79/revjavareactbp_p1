package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReimbursementDAO implements ReimbursementDAOInterface{


    @Override
    public Reimbursement submitReimbursement(Reimbursement ticket) {
        return null;
    }

    @Override
    public boolean updateReimbursementStatus(String status, int id) {

    //As usual, we need to open a connection
        /*Try with resources refresher
            In this try block, we open a Connection object within parenthesis
            By doing this, our Connection closes right after the try completes
            this is good for code cleanup and preventing memory leaks
          */
        try(Connection conn = ConnectionUtil.getConnection()){

            //create our SQL String (to be filled with values from the method arguments)
            String sql = "update reimbursement_status set reimb_status = ? where reimb_status_id = ?;";

            //Prepared statement so that we can fill appropriate values
            PreparedStatement ps = conn.prepareStatement(sql);

            //using ps.setXZY we can fill the wildcards (?) in our SQL statement
            ps.setString(1, status);
            ps.setInt(2, id);

            //execute the update!
            ps.executeUpdate();

            //if we get this far in the try block, we can assume nothing went wrong. return true.
            return true;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
