package com.qiheng.hibernate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test2 {
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
		
		
		
//		Session session1 = sessionFactory.openSession();
//		Transaction tx1 = null;
//		
//		try{
//			
//			tx1 = session1.beginTransaction();
//			List<Course> list = session1.createQuery("from Course").list();
//			for(Course course:list){
//				System.out.println(course.getCourse_name());
//			}
//			
//			tx1.commit();
//
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//			if(tx1!=null){
//				tx1.rollback();
//			}
//		
//		
//		}finally{
//			session1.close();
//		}
		
		
		Session session2 = sessionFactory.openSession();
		Transaction tx2 = null;
		
		try{
			
			tx2 = session2.beginTransaction();
			Course course = (Course) session2.get(Course.class, "002636f9-f6bd-4246-9afd-60982c1122b9");
			System.out.println(course);
			Course course1 = (Course) session2.get(Course.class, "002636f9-f6bd-4246-9afd-60982c1122b9");
			System.out.println(course1);
			tx2.commit();

			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx2!=null){
				tx2.rollback();
			}
		
		
		}finally{
			session2.close();
		}
		
	}
}

