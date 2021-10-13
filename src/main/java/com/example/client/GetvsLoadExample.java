package com.example.client;

import com.example.entities.TestEmployee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;

public class GetvsLoadExample {


    //get will return null if object does not exist in Db this will always hoit DB
    //load will throw Objectnotfoundexception load method uses proxy object from db and returns it,it uses lazy loading it will use proxy to hit db
    public static void main(String[] args){
        getExample();
        loadExample();
    }

    public static void getExample(){
            try(Session session= HibernateUtil.getSessionFactory().openSession()){
            TestEmployee t=session.get(TestEmployee.class,10);
            System.out.println(t);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void loadExample(){
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            TestEmployee t=session.load(TestEmployee.class,10);
            System.out.println(t);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
