package com.example.client;

import com.example.entities.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

//hql example

import java.util.*;

public class HQLClientTest {

    public static void main(String[] args){
        SessionFactory sf= HibernateUtil.getSessionFactory();
        //getAllEmployees(sf);
        //getEmployeebyId(sf);
        //getEmployeebyIdandSalary(sf);
        //getnameFromEmployee(sf);
        insertRecordsintoDB(sf);
    }

    public static void getAllEmployees(SessionFactory sf){

        try(Session session =sf.openSession()){
            String HQl="From Employee";
            Query<Employee> query=session.createQuery(HQl,Employee.class);
            List<Employee> l=query.list();
            l.forEach(System.out::println);

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static Employee getEmployeebyId(SessionFactory sf){
        try(Session session =sf.openSession()){
            String HQl="From Employee where id = ?0";
            Query<Employee> query=session.createQuery(HQl,Employee.class);
            //values in query.setParamanet(position,value)
            query.setParameter(0,0);

            Employee e=query.uniqueResult();
            System.out.println(e);
            return e;


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void getEmployeebyIdandSalary(SessionFactory sf){
        try(Session session =sf.openSession()){
            String HQl="From Employee where id = :empid and salary=:salary";
            Query<Employee> query=session.createQuery(HQl,Employee.class);
            //values in query.setParamanet(position,value)
            query.setParameter("empid",0);
            query.setParameter("salary",50000);
            Employee e=query.uniqueResult();
            System.out.println(e);
            //return e;


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void getnameFromEmployee(SessionFactory sf){
        try(Session session =sf.openSession()){
            String HQl="select name from Employee";
            Query<String> query=session.createQuery(HQl);
            List<String> l=query.list();
            l.forEach(System.out::println);


            //return e;


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void insertRecordsintoDB(SessionFactory sf){
        //insertionn we can't use insert into in hql we can copy from other table and insert into this table provided both shoudl have same table structure
        try(Session session=sf.openSession()){
            String HQl="Insert into Employee(id,name,salary,addressList" +"select id,name,salary,addressList from backupEmployee";

            Query query=session.createQuery(HQl);
            session.beginTransaction();
            int executeupdate=query.executeUpdate();

            if(executeupdate>0){
                System.out.println(executeupdate+"insertion succeded")
            }

            session.getTransaction().commit();
        }
    }
}
