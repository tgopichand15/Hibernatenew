package com.example.client;

import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.example.entities.TestEmployee;

import java.util.List;

public class GroupByexample {
    public static void main(String[] args){
        //getTestEmployeeGroupBYExample();
        getTestEmployeeHavingExample();

    }


    public static void getTestEmployeeGroupBYExample(){
        int emp=1;
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            String HQl="select t.department,sum(t.salary) FROM TestEmployee t group by t.department";

            Query<Object[]> query=session.createQuery(HQl);
            session.beginTransaction();
            List<Object[]> a=(List<Object[]>)query.list();
            for(Object[] l : a){
                System.out.print((String) l[0]);
                System.out.print(" ");
                System.out.println((Long) l[1]);
            }
            session.getTransaction().commit();
        }
    }

    public static void getTestEmployeeHavingExample(){
        int emp=1;
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            String HQl="select t.department,sum(t.salary) FROM TestEmployee t group by t.department having sum(t.salary) > 40000";

            Query<Object[]> query=session.createQuery(HQl);
            session.beginTransaction();
            List<Object[]> a=(List<Object[]>)query.list();
            for(Object[] l : a){
                System.out.print((String) l[0]);
                System.out.print(" ");
                System.out.println((Long) l[1]);
            }
            session.getTransaction().commit();
        }
    }
}
