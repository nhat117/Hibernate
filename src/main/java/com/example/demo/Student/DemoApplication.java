package com.example.demo.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Student tmp = new Student("Paul","Naomi","nhat@gmail.com");
			Student tmp1 = new Student("Thomas","Jefferson","jeffersont@hotmail.com");
			Student tmp2 = new Student("John","Nathan","nathan@yolomail.com");
			Student tmp3 = new Student("Kay","Chou","kaychou@ccmail.com");
			session.beginTransaction();
			session.save(tmp);
			session.save(tmp1);
			session.save(tmp2);
			session.save(tmp3);
			session.getTransaction().commit();;
			System.out.println("Done");
			System.out.println("Genrated id " + tmp.getId());
			//Get new Session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("getting student width id" + tmp.getId());
			Student newStudent = session.get(Student.class, tmp.getId());
			System.out.println(newStudent);

		} catch (Exception ignored){

		} finally{
			session.close();;
		}
	}

}
