package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface{

    @Override
    public ArrayList<Employee> getEmployees() {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from users;";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<Employee> employeeList = new ArrayList<>();

            while(rs.next()){

                Employee e = new Employee(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        null,
                        rs.getInt("role_id_fk")
                );

                int roleFK = rs.getInt("role_id_fk");

                RoleDAO rDAO = new RoleDAO();
                Role r = rDAO.getRoleById(roleFK);

                e.setRole(r);
                employeeList.add(e);

            }

            return employeeList;

        } catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee insertEmployee(Employee emp) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into users (user_name, user_password, first_name, last_name, role_id_fk) values (?, " +
                    "?, ?," +
                    " ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, emp.getUser_name());
            ps.setString(2, emp.getPassword());
            ps.setString(3, emp.getFirst_name());
            ps.setString(4, emp.getLast_name());
            ps.setInt(5, emp.getRole_id_fk());

            ps.executeUpdate();

            return emp;

        } catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<String> getUserNames() {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "select user_name from users;";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            ArrayList<String> userNames = new ArrayList<>();

            while(rs.next()){
               String e = rs.getString("user_name");
               userNames.add(e);
            }

            return userNames;

        } catch(SQLException e){
            e.printStackTrace();
    }

        return null;
    }
}