package com.example.service;
import com.example.entities.Employee;


public interface EmployeeService {

    public abstract void createEmployee(Employee employee);
    public abstract Employee getEmployeeById(int employeeId);
    public abstract void updateEmployeeById(int employeeId,Double Salary);
    public abstract void deleteEmployeeById(int employeeid);
}
