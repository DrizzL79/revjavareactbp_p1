package com.revature.models;

public class Employee {

    private int user_id;
    private String user_name;
    private String password;
    private String first_name;
    private String last_name;

    private Role user_role;

    private int role_id_fk;
    public Employee() {
    }

    public Employee(int user_id, String user_name, String password, String first_name, String last_name, Role user_role, int role_id_fk) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_role = user_role;
        this.role_id_fk = role_id_fk;
    }

    public Employee(int user_id, String user_name, String first_name, String last_name, Role user_role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_role = user_role;
    }

    public Employee(String user_name, String first_name, String last_name) {
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
    }

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

    public Employee(String user_name) {
        this.user_name = user_name;
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

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {return password; }
    public void setPassword(String password) {
        this.password = password;
    }

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
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", user_role=" + user_role +
                ", role_id_fk=" + role_id_fk +
                '}';
    }
}