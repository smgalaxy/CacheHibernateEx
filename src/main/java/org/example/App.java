package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("META-INF/hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class);

        SessionFactory factory = cfg.buildSessionFactory();
        //creating session object
        Session session1 = factory.openSession();
        //creating transaction object
        Transaction transaction1 = session1.beginTransaction();
//
//        Employee emp1 = new Employee();
//        emp1.setId(111);
//        emp1.setName("Vamsi");
//        emp1.setAddress("12,First St,Chennai");
//        emp1.setSalary(10000000);
//
//        Employee emp2 = new Employee();
//        emp2.setId(112);
//        emp2.setName("Vimal");
//        emp2.setAddress("11,Tenth St,Chennai");
//        emp2.setSalary(2000000);
//
//        Employee emp3 = new Employee();
//        emp3.setId(113);
//        emp3.setName("Priya");
//        emp3.setAddress("112,Third St,Chennai");
//        emp3.setSalary(3000000);

//        Query query = session.createQuery("from Employee");
//           query.setFirstResult(1);
//        query.setMaxResults(2);
//        List list = query.list();
//        System.out.println(list);

//        Query query = session.createQuery("update Employee set salary=:i where id=:n");
//        query.setParameter("n",111);
//        query.setParameter("i",1500000L);
//
//       int status = query.executeUpdate();
//        System.out.println("status : "+status);
////        session.save(emp1);
//        session.save(emp2);
//        session.save(emp3);

//        //Hibernate Named Query -- practice
//        TypedQuery query = session.getNamedQuery("findEmployeeByName");
//        query.setParameter("name","Priya");
        //
//        List<Employee> employees=query.getResultList();
//
//        Iterator<Employee> itr=employees.iterator();
//        while(itr.hasNext()){
//            Employee e=itr.next();
//            System.out.println("Employee name : "+e.getName()+" ,Salary :  "+e.getSalary());
//        }

        //Employee result = (Employee)session1.get(Employee.class,111);
        //using query to fetch the result
        Query query = session1.createQuery("from Employee where id = :i");

        query.setParameter("i",111);
        Employee result = (Employee) query.uniqueResult();
        System.out.println(result);

        transaction1.commit();
        session1.close();

        //session object2
        Session session2 = factory.openSession();
        //creating transaction object
        Transaction transaction2 = session2.beginTransaction();

        Employee result1 = (Employee)session2.get(Employee.class,111);
        System.out.println(result1);

        transaction2.commit();
        session1.close();
        System.out.println("success");

    }
}