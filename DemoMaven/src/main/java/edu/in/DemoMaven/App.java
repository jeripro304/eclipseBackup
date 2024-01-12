package edu.in.DemoMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {
        Employee e=new Employee(101,"ABC",10000);
        
        Configuration c=new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf=c.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(e);
        tx.commit();
        
    }
}
