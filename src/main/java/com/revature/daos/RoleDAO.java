package com.revature.daos;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO implements RoleDAOInterface{

    @Override
    public Role getRoleById(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from user_roles where role_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_title")
                );
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}