package com.axelor.hiberDemo.app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.axelor.hiberDemo.db.Address;
import com.axelor.hiberDemo.db.Department;
import com.axelor.hiberDemo.db.Phone;
import com.axelor.hiberDemo.db.Student;
import com.axelor.hiberDemo.db.Subject;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("myJpaUnit");
		EntityManager entitymanager = emfactory.createEntityManager();

		create(entitymanager);
		read(entitymanager);
		update(entitymanager);
//		delete(entitymanager);

		entitymanager.close();
		emfactory.close();
	}

	private static void create(EntityManager em) {
		System.out.println("Creating records...");
		em.getTransaction().begin();

		Student s1 = new Student("Bhumi p s");
		em.persist(s1);
		Student s2 = new Student("Bhumi Suvagiya");
		em.persist(s2);
		em.flush();

		Phone ph1 = new Phone(9865327845L);
		Phone ph2 = new Phone(8165325895L);

		s1.setPhone(ph1);
		s2.setPhone(ph2);

		Address address1 = new Address();
		address1.setStreet("Bhagavati");
		address1.setCity("Surat");
		address1.setState("Gujarat");

		Address address2 = new Address("sadhna", "Puna", "gujarat");
		Address address3 = new Address("Laxmi", "Rajkot", "gujarat");

		s1.setAddress(address1);
		s1.setAddress(address2);
		s2.setAddress(address3);

		Department d1 = new Department("Computer engineering");
		s1.setDepartment(d1);
		s2.setDepartment(d1);

		Subject sub1 = new Subject("Web development");
		Subject sub2 = new Subject("Java development");

		s1.setSubject(sub1);
		s1.setSubject(sub2);
		s2.setSubject(sub2);

		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	private static void read(EntityManager em) {

		Query q = em.createQuery(" from  Student s");

		List<Student> list = (List<Student>) q.getResultList();
		Iterator<Student> itr = list.iterator();

		while (itr.hasNext()) {
			Student s1 = itr.next();
			System.out.println("Student ID :" + s1.getId());
			System.out.println("\t Student Name :" + s1.getName());

			Phone p = s1.getPhone();
			System.out.println("\t Student phone number :" + p.getNumber());

			List addresses = s1.getAddress();
			for (Iterator itr2 = addresses.iterator(); itr2.hasNext();) {
				Address addr = (Address) itr2.next();
				System.out.println("\t Address: " + addr.getStreet() + ", " + addr.getCity() + ", " + addr.getState());
			}

			Department d = s1.getDepartment();
			System.out.println("\t Student department name :" + d.getName());

			List subjects = s1.getSubject();
			for (Iterator itr3 = subjects.iterator(); itr3.hasNext();) {
				Subject sub = (Subject) itr3.next();
				System.out.println("\t Subject: " + sub.getName());
			}

		}
	}

	private static void update(EntityManager em) {

		System.out.println("Updating Students data...");
		em.getTransaction().begin();

		Address e = (Address) em.find(Address.class, 1L);
		e.setStreet("abc");
		e.setCity("xyz");
		em.getTransaction().commit();
	}

	private static void delete(EntityManager em) {
		Student s = em.find(Student.class, 2L);

		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();

	}

}
