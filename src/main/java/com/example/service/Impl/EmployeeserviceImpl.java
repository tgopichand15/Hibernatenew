package com.example.service.Impl;

import com.example.service.EmployeeService;

import com.example.util.HibernateUtil;
import org.hibernate.Session;
import com.example.entities.Employee;
import com.example.dao.Impl.EmployeeDaoImpl;




public class EmployeeserviceImpl implements EmployeeService {
    @Override
    public void createEmployee(Employee employee) {
        new EmployeeDaoImpl().addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return new EmployeeDaoImpl().fetchEmployee(employeeId);
    }

    @Override
    public void updateEmployeeById(int employeeId, Double Salary) {
        new EmployeeDaoImpl().updateEmployeeById(employeeId,Salary);
    }

    @Override
    public void deleteEmployeeById(int employeeid) {
        new EmployeeDaoImpl().deleteEmployeeById(employeeid);
    }
}