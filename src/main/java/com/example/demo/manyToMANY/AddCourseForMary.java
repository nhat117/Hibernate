package com.example.demo.manyToMANY;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseForMary {

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
            int id = 2;
           Student tmp = session.get(Student.class,id);

           //Create more course
            Course course1 = new Course("RubikCube- How to speed ball Cube");
            Course course2 = new Course("Atari 2600- go Game dev");

            //Add student to course
            course1.addStudent(tmp);
            course2.addStudent(tmp);

           //Save the course
            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        } catch (Exception ignored) {

        } finally {
            session.close();
            factory.close();
        }
    }
}
