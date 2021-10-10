package com.example.client;

import com.example.entities.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;

public class NamedNativeQueryExample {

    public static void main(String[] args){
       getEmployees();
    }

    public static List<Employee> getEmployees(){
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Query<List<Employee>> query=session.getNamedNativeQuery("getALLEmployees");
            List<Employee> l=(List<List<Employee>>)query.list();
            for(Employee e: l){
                System.out.println(e);
            }
        }

        }

}

