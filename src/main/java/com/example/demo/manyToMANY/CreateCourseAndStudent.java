package com.example.demo.manyToMANY;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudent {

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
            Course tmp = new Course("Pacman -How to Score One Million Point");


            //Saving the course
            System.out.println("----Saving the course ------");
            session.save(tmp);

            //Create Student
            Student stud1 = new Student("Joe","Doe","jodoe@mail");
            Student stud2 = new Student("Mary","Popin","popin@mail");

            //Add Student to course
            tmp.addStudent(stud1);
            tmp.addStudent(stud2);

            //Saving stydent
            System.out.println("-----Saving Student-----");
            session.save(stud1);
            session.save(stud2);

            session.getTransaction().commit();
        } catch (Exception ignored) {

        } finally {
            session.close();
            factory.close();
        }
    }
}
