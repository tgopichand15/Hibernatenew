package com.example.dao;
import com.example.entities.Employee;


public interface EmployeeDao {

    public abstract void addEmployee(Employee employee);
    public abstract Employee fetchEmployee(int employeeId);
    public abstract void updateEmployeeById(int employeeId,Double Salary);
    public abstract void deleteEmployeeById(int EmployeeId);


}
