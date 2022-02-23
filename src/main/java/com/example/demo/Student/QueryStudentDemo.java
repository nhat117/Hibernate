package com.example.demo.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();
            //Query student
            List<Student> student = session.createQuery("from Student ").getResultList();

            //Display student
            for (Student stud : student) {
                System.out.println(stud);
            }

            //query students: lastname: ' Paul'
            student = session.createQuery("from Student s where s.lastName = 'Wall'").getResultList();

            //query student lastname='Wall' or first name'Chou'
            student = session.createQuery("from Student s where s.lastName='Wall' OR s.lastName='Chou'").getResultList();

            //query like
            student = session.createQuery("from Student s where s.email LIKE '%ccmail.com'").getResultList();
            dsp(student);


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
