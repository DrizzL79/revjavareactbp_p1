package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    public Employee login(String user_name, String password){

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from users where user_name = ? and user_password = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Employee e = new Employee(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        null,
                        rs.getInt("role_id_fk")
                );

                int roleFk = rs.getInt("role_id_fk");
                RoleDAO rDAO = new RoleDAO();
                Role r = rDAO.getRoleById(roleFk);
                e.setRole(r);

                return e;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}