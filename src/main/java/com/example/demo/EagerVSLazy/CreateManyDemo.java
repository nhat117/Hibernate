package com.example.demo.EagerVSLazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
            int theid = 1;
//            InstructorMany tmp = session.get(InstructorMany.class, id);
//            Query<InstructorMany> query = session.createQuery("select i from Instructor i "
//                    +"JOIN FETCH i.instructorDetail "
//                    + "where i.id =:theInstructorId",
//                    InstructorMany.class);
//            query.setParameter("theInstructorId",theid);
//            System.out.println("nhat bui"+tmp.getCourses().toString());
            session.getTransaction().commit();
            session.close();
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
//            session.delete(tmp);
//Detete int this zone
//            InstructorMany tmp = query.getSingleResult();
//            System.out.println("nhat bui"+tmp.toString());
//            System.out.println("nhat bui"+tmp.getCourses().toString());
//            System.out.println("Done");
        } catch (Exception ignored) {

        } finally {
            session.close();
            factory.close();
        }
    }
}
