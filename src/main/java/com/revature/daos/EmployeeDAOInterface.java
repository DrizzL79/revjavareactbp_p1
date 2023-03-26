package com.revature.daos;

import com.revature.models.Employee;

import java.util.ArrayList;

public interface EmployeeDAOInterface {

    ArrayList<Employee> getEmployees();
    Employee insertEmployee(Employee emp);
    ArrayList<String> getUserNames();
}