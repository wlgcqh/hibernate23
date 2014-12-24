package com.qiheng.hibernate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test1 {
	public static SessionFactory sessionFactory;

	static {
		try {
			Configuration cfg = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).buildServiceRegistry();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		Student student = new Student();
		student.setStudent_name("qiheng");
		student.setTimestamp(new Timestamp(new Date().getTime()));
		student.setCourses(new HashSet<Course>());
		
		for(int i=0;i<1200;i++){
			Course course = new Course();
			course.setCourse_name("course"+i);
			course.setCredit(4);
			course.setStudent(student);
			student.getCourses().add(course);
		}
		
		
		try{
			tx = session.beginTransaction();
			session.save(student);
			
			
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		
		
		}finally{
			session.close();
		}
		
		
	}
}

