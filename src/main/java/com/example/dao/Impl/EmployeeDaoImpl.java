package com.example.dao.Impl;

import com.example.entities.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import com.example.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void addEmployee(Employee employee) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Employee fetchEmployee(int employeeId) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Employee e=session.get(Employee.class,employeeId);
            return e;

        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateEmployeeById(int employeeId, Double Salary) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Employee e=session.get(Employee.class,employeeId);

            if(e==null){
                System.out.println("employed with provided id does not exist");
            }
            else{
                //e.setSalary(Salary);
                session.beginTransaction();

                session.update(e);

                session.getTransaction().commit();
                System.out.println(e);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(int EmployeeId) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Employee e=session.get(Employee.class,EmployeeId);

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
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
