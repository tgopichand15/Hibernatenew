package com.example.client;

import com.example.entities.Employee;
import com.example.entities.TestEmployee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;

public class NamedQueryExample {

    public static void main(String[] args){
       //getTestEmployees();
        getEmployeesBasedonSalary();
    }

    public static List<Object[]> getTestEmployees(){
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Query<Object[]> query=session.getNamedQuery("getAllEmployees");
            List<Object[]> l=(List<Object[]>)query.list();
            for(Object[] e: l){
                System.out.print((String)e[0]);
                System.out.print(" ");
                System.out.print((String)e[1]);
                System.out.print(" ");
                System.out.println((int)e[2]);
            }
            return l;
        }

        }

    public static List<Object[]> getEmployeesBasedonSalary(){
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Query<Object[]> query=session.getNamedQuery("getEmployeesSalaryGreatethan40000");
            List<Object[]> l=(List<Object[]>)query.list();
            for(Object[] e: l){
                System.out.print((String)e[0]);
                System.out.print(" ");
                System.out.print((String)e[1]);
                System.out.print(" ");
                System.out.println((int)e[2]);
            }
            return l;
        }

    }

}

