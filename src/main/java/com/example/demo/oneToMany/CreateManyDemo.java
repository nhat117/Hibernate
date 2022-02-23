package com.example.demo.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateManyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(InstructorMany.class)
                                                                .addAnnotatedClass(InstructorDetailMany.class)
                                                                .addAnnotatedClass(Course.class)
                                                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

            //Get the Instructor from db
            int id = 1;
            InstructorMany tmp = session.get(InstructorMany.class, id);
            System.out.println(tmp.toString());
            System.out.println(tmp.getCourses().toString());
//            //Create some courses
//            Course tmp = session.get(Course.class, id);
//            Course course1 = new Course("AirGuitar");
//            Course course2 = new Course("The Pinball master class");
//            //Add courses to instructor
//            tmp.add(course1);
//            tmp.add(course2);
//            //Save Course
//            session.save(course1);
//            session.save(course2);
//Detete int this zone
//            session.delete(tmp);
            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception ignored) {

        } finally {
            session.close();
            factory.close();
        }
    }
}
