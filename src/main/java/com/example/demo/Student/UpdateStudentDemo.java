package com.example.demo.Student;

import com.example.demo.Student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();
//            int studentId = 2;
//            Student stud = session.get(Student.class,studentId);
//            stud.setFirstName("Nhat");
            //Update email for all student
            session.createQuery("update Student set email='yo@gmail.com'").executeUpdate();
            session.getTransaction().commit();;

        } catch (Exception ignored) {

        } finally {
            session.close();
        }
    }

    public static void dsp(List<Student> student) {
        for(Student std: student) {
            System.out.println(std);
        }
    }
}
