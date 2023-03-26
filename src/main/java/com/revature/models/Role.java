package com.revature.models;

public class Role {

    private int role_id;
    private String role_title;

    public Role() {
    }

    public Role(int role_id, String role_title) {
        this.role_id = role_id;
        this.role_title = role_title;
    }

    public Role(String role_title) {
        this.role_title = role_title;
    }

    public int getRole_id() {
        return role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_title() {
        return role_title;
    }
    public void setRole_title(String role_title) {
        this.role_title = role_title;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_title='" + role_title + '}';
    }
}