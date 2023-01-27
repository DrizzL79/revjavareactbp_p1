package com.revature.models;

public class Employee {

    private int user_id;
    private String user_name;
    private String password;
    private String first_name;
    private String last_name;

    /*Employees in Java will contain entire Role objects instead of just an int foreign key
    an int FK is less useful to us than an entire Role object
    useful? If we have the entire Role object, we have access to all of that Role's DATA as well. more data :)
     */
    private Role user_role;

    private int role_id_fk; //we're creating this variable to make inserts in Postman easier.
    //paired with a constructor, we can make it so that we only need to supply the FK in POST requests
    //as opposed to an entire role object

    //boilerplate code----------------------

    //no-args constructor
    public Employee() {
    }

    //all-args
    public Employee(int user_id, String user_name, String password, String first_name, String last_name, Role user_role, int role_id_fk) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_role = user_role;
        this.role_id_fk = role_id_fk;
    }

    //all-args minus password and minus role_id_fk
    public Employee(int user_id, String user_name, String first_name, String last_name, Role user_role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_role = user_role;
    }

    //all-args minus employee_id, password, and role_id_fk
    public Employee(String user_name, String first_name, String last_name) {
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    //constructor with no id, and int FK. To help with POST requests that insert an Employee
    //This gives us the flexibility to create a new employee without specifying and entire Role object
    public Employee(String user_name, String password, String first_name, String last_name, int role_id_fk) {
        this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role_id_fk = role_id_fk;
    }

    public Employee(String user_name, String first_name, String last_name, int role_id_fk) {
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role_id_fk = role_id_fk;
    }

    public int getRole_id_fk() {
        return role_id_fk;
    }

    public void setRole_id_fk(int role_id_fk) {
        this.role_id_fk = role_id_fk;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() { return user_name; }

    public void setUser_name(String user_name) { this.user_name = user_name; }

    public String getPassword() {return password; }

    public void setPassword(String password) { this.password = password; }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Role getRole() {
        return user_role;
    }

    public void setRole(Role user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + user_id +
                "user_name ='" + user_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", role=" + user_role +
                '}';
    }
}