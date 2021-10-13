package com.example.entities;

import javax.persistence.*;


//this is modified employee class for testing Group by feature in hinernate
@Entity
@NamedQueries(value= {
        @NamedQuery(name = "getAllEmployees", query = "select name,department,salary from TestEmployee"),
        @NamedQuery(name = "getEmployeesSalaryGreatethan40000", query = "select name,department,salary from TestEmployee where salary>40000")})
public class TestEmployee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    String name;

    String department;

    int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "TestEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
