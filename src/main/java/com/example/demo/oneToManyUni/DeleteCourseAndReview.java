package com.example.demo.oneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReview {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(InstructorMany.class)
                                                                .addAnnotatedClass(InstructorDetailMany.class)
                                                                .addAnnotatedClass(Course.class)
                                                                .addAnnotatedClass(Review.class)
                                                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

            //Get the course
            int theId= 10;
            Course tmp = session.get(Course.class, theId);
            System.out.println("-----Deleting the course----");
            //Print the course
            System.out.println(tmp);
            //Print the course Review
            System.out.println(tmp.getReviews());
            //Delete
            session.delete(tmp);
            session.getTransaction().commit();
            System.out.println("----------Done----------");
        } catch (Exception ignored) {

        } finally {
            session.close();
            factory.close();
        }
    }
}
