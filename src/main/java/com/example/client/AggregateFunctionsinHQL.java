package com.example.client;

import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AggregateFunctionsinHQL {

    public static void main(String args[]){

        AggregateFunction();
    }

     public static void AggregateFunction(){

        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            String HQl="select COUNT(*),AVG(e.salary),SUM(e.salary),Min(e.salary),MAX(e.salary) from Employee e";
            Query<Object[]> query=session.createQuery(HQl);

            List<Object[]> l=query.list();

            for(Object[] object:l) {
                Long empcount = (Long) object[0];
                Double avgsal = (Double) object[1];
               // Double sumsal = (Double) object[2];
//                Double minsal = (Double) object[3];
              //  Double maxsal = (Double) object[4];


                System.out.println("empcount is " + empcount);
                System.out.println("avgsal is " + avgsal);
               // System.out.println("sumsal is " + sumsal);
               // System.out.println("minsal is " + minsal);
                //System.out.println("maxsal is " + maxsal);
            }



        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
