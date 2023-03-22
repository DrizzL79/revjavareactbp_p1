package com.revature.daos;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//This Class is responsible for all things ROLE data. This class will query the Role table
public class RoleDAO implements RoleDAOInterface{

    @Override
    public Role getRoleById(int id) {

        //use a try-with-resources block to open our connection and host our DB communication
        try(Connection conn = ConnectionUtil.getConnection()){

            /*
             We need a String that lays out the sql query we intend to run on the DB
             This String has a wildcard/parameter/variable for the role_id
             We have to take the user-inputted role id and put it into this statement somehow
              */
            String sql = "select * from roles where role_id = ?;";

            //we need a PreparedStatement object to fill the variable in
            //PreparedStatements "prepare" a query to get sent to the DB
            PreparedStatement ps = conn.prepareStatement(sql);

            //now, we can insert a value for the ? above
            ps.setInt(1, id); //"the first wildcard will be equal to the id variable"

            /*
            Here, we're running the SQL statement stored in the PreparedStatement
            The results of the SQL statement will get stored in the ResultSet object
             */
            ResultSet rs = ps.executeQuery();

            /*While loop to extract the resultset data
            WHILE there are results in the ResultNext (.next())...
            Make a new Role object.
             */
            if(rs.next()){

                /*We need to use the data from the ResultSet to fill in a Role all-args constructor
                    Basically, we need to make a Role object from the data */
                //This is just a CONSTRUCTOR that we opened up for the sake of cleaner code

                return new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_title")
                ); //return the Role data to the user!!
            }
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong, this will display an error message
            //VERY important for debugging, so we know what went wrong and where
        }

        return null; //null will get returned if something goes wrong
    }
}
