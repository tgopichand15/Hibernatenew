package com.example.client;

import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupByexample {
    public static void main(String[] args){

    }


    public static void groupbyExample(){
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            String HQl="select COUNT(*),AVG(e.salary),SUM(e.salary),Min(e.salary),MAX(e.salary) from Employee e";
            Query<Object[]> query=session.createQuery(HQl);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
