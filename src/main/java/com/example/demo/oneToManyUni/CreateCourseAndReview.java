package com.example.demo.oneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReview {

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
            Course tmp = new Course("Pacman -How to Score One Million Point");
            tmp.addReview(new Review("Great course Okay"));
            tmp.addReview(new Review("Amazing Course"));
            tmp.addReview(new Review("Fuck You"));
            System.out.println("Saving the course");
            System.out.println(tmp);
            System.out.println(tmp.getReviews());
            session.save(tmp);
            session.getTransaction().commit();
        } catch (Exception ignored) {

        } finally {
            session.close();
            factory.close();
        }
    }
}
