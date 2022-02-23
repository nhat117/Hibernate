package com.example.demo.bidirectional;

import com.example.demo.hb.Instructor;
import com.example.demo.hb.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(InstructorBi.class)
                                                                .addAnnotatedClass(InstructorDetailBi.class)
                                                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();
            int id =3;
            InstructorDetailBi tmp =  session.get(InstructorDetailBi.class,id);
            //Print the associated Instructor
            System.out.println(tmp.getInstructor());
            System.out.println("Delete ");
            //Break the bi link
            tmp.getInstructor().setInstructorDetail(null);
            session.delete(tmp);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            //Handle connection leak
            session.close();
            factory.close();
        }
    }
}
