package com.example.client;

import com.example.entities.Employee;
import com.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.lang.Exception;
import com.example.service.EmployeeService;
import com.example.service.Impl.EmployeeserviceImpl;
import com.example.entities.Address;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;

public class ClientTest {

    public static void main(String[] args){

            //EmployeeService employeeservice=new EmployeeserviceImpl();
            //createEmployee(employeeservice);

            //need to checking saving collections,  configuring collections in hibernate,eager and lazy loading topics in hibernate from kkjava tutorials little confusing


            //getEmployeeById();
            //getEmployeeByid();
            //updateEmployeeById(employeeservice);
            //deleteEmployeebyId(employeeservice);

           //createEmployee(getEmployee(),session);
            //getEmployeeByid(session);
            //updateEmployeeById(session);
            //deleteEmployeeById(session);

        try(Session session= HibernateUtil.getSessionFactory().openSession()) {

            Employee e = session.get(Employee.class,1);

            if (e == null) {
                System.out.println("employed with provided id does not exist");
            } else {
                System.out.println(e);
            }
        }


    }


    private static void deleteEmployeeById(Session session){
        Employee e=session.get(Employee.class,2);

        if(e==null){
            System.out.println("employed with provided id does not exist");
        }
        else{
            session.beginTransaction();

            session.delete(e);

            session.getTransaction().commit();
            //System.out.println(e);
        }
    }

    private static void getEmployeeByid(){
        try(Session session= HibernateUtil.getSessionFactory().openSession()) {

            Employee e = session.get(Employee.class, 2);

            if (e == null) {
                System.out.println("employed with provided id does not exist");
            } else {
                System.out.println(e);
            }
        }
    }

   /* private static void createEmployee(EmployeeService employeeservice){
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(getEmployee());
            session.getTransaction().commit();

        }
        catch(Exception e){
            e.printStackTrace();
        }



    }*/

    private static void updateEmployeeById(Session session){
        Employee e=session.get(Employee.class,1);

        if(e==null){
            System.out.println("employed with provided id does not exist");
        }
        else{
            e.setSalary(50000);
            session.beginTransaction();

            session.update(e);

            session.getTransaction().commit();
            System.out.println(e);
        }
    }


    private static Employee getEmployee(Address a,Address b){
        Employee employee=new Employee();
        employee.setName("Ramesh");
        employee.setSalary(40000);


        employee.getAddressList().add(a);
        employee.getAddressList().add(b);

        return employee;


    }
}
