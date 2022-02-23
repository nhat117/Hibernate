package com.example.demo.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

//            int studId =1;
//            Student student = session.get(Student.class, studId);
//            session.delete(student);
            session.createQuery("delete from Student where id =2").executeUpdate();

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
