package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    //for THIS method in particular, since we don't have username/password, we'll use first_name/last_name
    //change it accordingly for your own application. Users should have username/password in YOUR p1

    public Employee login(String user_name, String password){

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from employees where user_name = ? and password = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            //ps.setString(1, user_name);
            ps.setString(1, user_name);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            //since we're only expecting one record, we can just use an if with rs.next() instead of while
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

                //for comments on everything we're doing above, you can check getEmployees in EmployeeDAO

                return e; //returning the Employee with the matching first_name/last_name

            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;

    }



    //presumably you'd put your register method here as well, unless you just use the insert method for that
    //for P1 you can probably just stick with the insert employee method for register user

}
