package com.example.client;

import com.example.entities.TestEmployee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public class CriteriaQueryExample {

    //without sql or HQl we can get the required data from Criteria API which is from JPA
    // Package

    public List<TestEmployee> getAllTestEmployees(){
        Session session= HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<TestEmployee> cr=cb.createQuery(TestEmployee.class);
        Root<TestEmployee> root=cr.from(TestEmployee.class);
        cr.select(root);

        Query query=session.createQuery(cr);
        List<TestEmployee> results=query.getResultList();
        for(TestEmployee t:results){
            System.out.println(t);
        }
        return results;
    }

    public TestEmployee useCriteriaExpressions(){
        Session session= HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<TestEmployee> cr=cb.createQuery(TestEmployee.class);
        Root<TestEmployee> root=cr.from(TestEmployee.class);
        //using where we can write conditions to get required data
        //this is to get members whose salary is greater than 50000
        //Query query=session.createQuery(cr.select(root).where(cb.gt(root.get("salary"),40000)));

        //get Employee details whose department is like %CE

        //Query query=session.createQuery(cr.select(root).where(cb.like(root.get("department"),"%CE")));

        //get employee details whose salary is between 20000 and 40000

        //Query query=session.createQuery(cr.select(root).where(cb.between(root.get("salary"),20000,40000)));

        //select records where name in gopi,rajesh or tarun

        // Query query=session.createQuery(cr.select(root).where((root.get("name").in("Gopi","Rajesj","tarun"))));

        //check if value is not null

        //Query query=session.createQuery(cr.select(root).where(cb.isNotNull(root.get("salary"))));

        //we can even combine 2 or 3 above conditions and chain the condition into one single condition usign Predicate eg

        //Predicate[] predicates=new Predicate[2];
        //predicates[0]=cb.isNotNull(root.get("name"));
        //predicates[1]=cb.like(root.get("description"),"%CE");
        //cr.select(root).where(predicates);

        //we can also sorrt using Criteria APi

        //cr.orderby(cb.asc(root.get("name")));


        //we can also use aggreagte functions like sum,avg,min,max,count in this also

        //like

        //cr.select(cb.count(root));
        //cr.select(cb.avg(root));
        //cr.select(cb.min(root));




       // TestEmployee t=(TestEmployee)((org.hibernate.query.Query) query).uniqueResult();
            System.out.println(t);
        return t;

    }

    public static void main(String[] args){
        CriteriaQueryExample c=new CriteriaQueryExample();
        c.useCriteriaExpressions();

    }


}
