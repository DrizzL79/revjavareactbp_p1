package com.revature.daos;

import com.revature.models.ReimbursementStatus;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementStatusDAO implements ReimbursementStatusDAOInterface{


    @Override
    public ReimbursementStatus getReimbursementStatusbyID(int reimb_status_id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * reimbursement_status where reimb_status_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimb_status_id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ReimbursementStatus status = new ReimbursementStatus(
                        rs.getString("reimb_status"));

                return status;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
