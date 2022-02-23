package com.example.demo.manyToMANY;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacManCourse {

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
            Course tmp = session.get(Course.class,22);
            System.out.println("----Deleting Course ----");
            session.delete(tmp);

//            System.out.println("----Retriving Student----");
//            Student stud1 = session.get(Student.class,1);
//            System.out.println(stud1);
//            System.out.println(stud1.getCourses());
//            System.out.println("-------Done-------");
            session.getTransaction().commit();
        } catch (Exception ignored) {

        } finally {
            session.close();
            factory.close();
        }
    }
}
