package com.example.demo.Employee;

import com.example.demo.Student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

//            //Create
//            Employee employee1 = new Employee("Nhat", "Bui", "RMIT");
//            Employee employee2 = new Employee("Nhat", "Bui", "RMIT");
//            Employee employee3 = new Employee("Nhat", "Bui", "RMIT");
//            Employee employee4 = new Employee("Nhat", "Bui", "RMIT");
//
//            session.save(employee1);
//            session.save(employee2);
//            session.save(employee3);
//            session.save(employee4);

            //Read
            List<Employee> employeeList = session.createQuery("from Employee ").getResultList();

            dsp(employeeList);

            Employee tmp = session.get(Employee.class, 1);

            System.out.println("Read from word" + tmp);

//            //Update
//
//            Employee tmp2 = session.get(Employee.class, 2);
//            tmp2.setCompany("Yo Most");
//
//            //Delete
//            session.createQuery("delete from Employee where id =3").executeUpdate();

            session.getTransaction().commit();


        } catch (Exception ignored) {

        } finally {
            session.close();
        }
    }

    public static void dsp(List<Employee> student) {
        for (Employee std : student) {
            System.out.println(std);
        }
    }
}
