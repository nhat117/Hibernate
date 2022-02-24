package com.example.demo.manyToMANY;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMaryDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(InstructorMany.class)
                                                                .addAnnotatedClass(InstructorDetailMany.class)
                                                                .addAnnotatedClass(Course.class)
                                                                .addAnnotatedClass(Review.class)
                                                                .addAnnotatedClass(Student.class)
                                                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

           //Get Student Mary from db
            int id = 8;
           Student tmp = session.get(Student.class,id);
            System.out.println("------ Loaded Student -----");
            System.out.println(tmp);
            System.out.println(tmp.getCourses());
            System.out.println("------Deleting Student------");
            session.delete(tmp);

            session.getTransaction().commit();
        } catch (Exception ignored) {

        } finally {
            session.close();
            factory.close();
        }
    }
}
