package com.example.entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="employee_table")
@DynamicUpdate  //this annotation helps like if we are updating a particular value update on that filed is only updated not for whole recore eg:if we want to update salary =1000 for id =1 normally if we dont give it would be like whole recore is updated here update salary=1000 from employeetable where id=1 will be triggered.
public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="name",length=100,nullable=false)
    private String name;

    @Column(name="salary",unique=true)
    private int salary;


    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
    }

    @ElementCollection(fetch=FetchType.EAGER)
    private Collection<Address> addressList=new HashSet<>();

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", addressList=" + addressList +
                '}';
    }
}
