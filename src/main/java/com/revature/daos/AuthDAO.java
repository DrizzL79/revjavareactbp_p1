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

            String sql = "select * from employees where user_name = ? and password = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Employee e = new Employee(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        null
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



    //presumably you'd put your register method here as well, unless you just use the insert method for that
    //for P1 you can probably just stick with the insert employee method for register user

}
