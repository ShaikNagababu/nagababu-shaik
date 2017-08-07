package com.sathya.entity;

import java.util.Scanner;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.util.HibernateUtil;

public class Test 
{
	private static SessionFactory factory;
	
	public static void main(String[] args)
	{
		factory=HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
//		Scanner scanner = new Scanner(System.in);
//		int id = Integer.parseInt(scanner.nextLine());
		Transaction tx = session.beginTransaction();
		Student student = (Student)session.get(Student.class, 1);
		String name = JOptionPane.showInputDialog("Enter new student name");
		student.setStudentName(name);
		tx.commit();
		session.close();
//		scanner.close();
		factory.close();
	}
	

}
