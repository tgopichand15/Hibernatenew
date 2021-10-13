package com.example.client;

import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CreateNativeQuery {

    public static void main(String[] args) {
        getTestEmployees();
        //getEmployeesBasedonSalary();
    }

    public static List<Object[]> getTestEmployees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Object[]> query = session.createNativeQuery("Select * from TestEmployee");
            List<Object[]> l = (List<Object[]>) query.list();
            for (Object[] e : l) {

                System.out.print((int) e[0]);
                System.out.print(" ");
                System.out.print((String) e[1]);
                System.out.print(" ");
                System.out.print((String) e[2]);
                System.out.print(" ");
                System.out.println((int) e[3]);
            }
            return l;
        }

    }
}
