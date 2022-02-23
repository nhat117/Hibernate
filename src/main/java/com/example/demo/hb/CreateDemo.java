package com.example.demo.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
                                                                .addAnnotatedClass(InstructorDetail.class)
                                                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();
            Instructor temp = new Instructor("Tommy", "Nhat", "testyoutube.com");

            InstructorDetail tmpInstructorDetail = new InstructorDetail("testyoutube.com", "Code or Sthg");

            //Get Instructor by primary key
//            int id =1;
//            Instructor tmp = session.get(Instructor.class, id);
//            System.out.println(tmp);
//            //Delete instructor
//            if(tmp != null) {
//                System.out.println("Delete" + tmp);
//                //Also delete instructor detail bc cascade type all
//                session.delete(tmp);
//            }
            //Will also save all the details object bcz cascade type all

            //bREAK BI LINK
            System.out.println("Saving Instructor:  " + tmpInstructorDetail);
            temp.setInstructorDetail(tmpInstructorDetail);
            session.save(temp);

            session.getTransaction().commit();
        } catch (Exception ignored) {

        } finally {
            session.close();
        }
    }
}
