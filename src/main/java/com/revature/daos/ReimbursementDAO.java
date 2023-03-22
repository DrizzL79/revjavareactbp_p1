package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReimbursementDAO implements ReimbursementDAOInterface{
    @Override
    public Reimbursement submitReimbursement(Reimbursement ticket) {

        try (Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into reimbursement (reimb_amount, reimb_description," +
                    " user_name_fk, reimb_status_id_fk) values (?, ?, ?, 1);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, ticket.getReimb_amount());
            ps.setString(2, ticket.getReimb_description());
            ps.setString(3, ticket.getUser_name_fk());

            ps.executeUpdate();

            return ticket;


        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateReimbursementStatus(int reimb_status_id_fk, int id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "update reimbursement set reimb_status_id_fk = ? where reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimb_status_id_fk);
            ps.setInt(2, id);
            ps.executeUpdate();

            return true;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<Reimbursement> getAllReimbursementsEmp(String user_name_fk) {

        try (Connection conn = ConnectionUtil.getConnection()) {

            String  sql = "select * from reimbursement where user_name_fk =?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_name_fk);
            ResultSet rs = ps.executeQuery();
            ArrayList<Reimbursement>  reimbursements = new ArrayList<>();
            while (rs.next()){
               Reimbursement r = new Reimbursement(
                       rs.getInt("reimb_id"),
                       rs.getDouble("reimb_amount"),
                       rs.getString("reimb_description"),
                       rs.getInt("reimb_status_id_fk"),
                       rs.getString("user_name_fk"),
                       null
               );

                ReimbursementStatusDAO rsDAO = new ReimbursementStatusDAO();
                int statusIdFk =
                        rs.getInt("reimb_status_id_fk");
                ReimbursementStatus status = rsDAO.getReimbursementStatusbyID(statusIdFk);
                r.setReimb_status(status);

               reimbursements.add(r);
            }
            return reimbursements;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Reimbursement> getReimbursementsByStatus(String status) {

        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM reimbursement WHERE reimb_status_id_fk = " +
                        "(SELECT reimb_status_id FROM reimbursement_status WHERE reimb_status = ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            ArrayList<Reimbursement> reimbursements = new ArrayList<>();
            while (rs.next()){
                Reimbursement r = new Reimbursement(
                        rs.getInt("reimb_id"),
                        rs.getDouble("reimb_amount"),
                        rs.getString("reimb_description"),
                        rs.getInt("reimb_status_id_fk"),
                        rs.getString("user_name_fk"),
                        null
                );
                ReimbursementStatusDAO rsDAO = new ReimbursementStatusDAO();
                int statusIdFk =
                        rs.getInt("reimb_status_id_fk");
                ReimbursementStatus rStatus = rsDAO.getReimbursementStatusbyID(statusIdFk);
                r.setReimb_status(rStatus);
                reimbursements.add(r);
            }

            return reimbursements;

            } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;
    }
}