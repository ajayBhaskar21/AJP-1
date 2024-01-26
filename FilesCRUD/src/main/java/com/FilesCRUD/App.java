package com.FilesCRUD;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	static Scanner in;
	static SessionFactory sessionFactory;
	static List<file> files;

	private static void createFile() {
		in.nextLine();
		System.out.print("Enter file name : ");
		String name = in.nextLine();
		System.out.print("Enter file type : ");
		String type = in.nextLine();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			file obj = new file();
			obj.setFileName(name);
			obj.setFileType(type);
			obj.setLastModified(new Date().toString().substring(4, 19));
			session.persist(obj);
			session.getTransaction().commit();
			System.out.println("File created. " + obj);

		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}

	private static void displayFiles() {
		System.out.println("Displaying the list of files : ");
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<file> files = session.createQuery("from file", file.class).getResultList();
			for (file i : files) {
				System.out.print(i);
			}
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	private static void updateFile() {
		System.out.print("Enter file id : ");
		int id = in.nextInt();
		in.nextLine();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			file mainFileObj = session.get(file.class, id);

			if (mainFileObj != null) {
				System.out.print("Enter new file name : ");
				String name = in.nextLine();
				System.out.print("Enter new file type : ");
				String type = in.nextLine();

				mainFileObj.setFileName(name);
				mainFileObj.setFileType(type);
				mainFileObj.setLastModified(new Date().toString().substring(4, 19));
				session.getTransaction().commit();
				System.out.println("update file : " + mainFileObj);
			} else {
				System.out.println("File id does not exist.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteFile() {
		System.out.print("Enter file id to delete : ");
		int id = in.nextInt();
		in.nextLine();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			file mainFileObj = session.get(file.class, id);
			if (mainFileObj != null) {

				session.remove(mainFileObj);
				session.getTransaction().commit();
				System.out.println("file deleted.");
			} else {
				System.out.println("File id does not exist.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		in = new Scanner(System.in);

		while (true) {
			System.out.println("1. create file");
			System.out.println("2. display files");
			System.out.println("3. update file");
			System.out.println("4. delete file");
			System.out.println("0. exit");
			System.out.print("Enter choice : ");

			int choice = in.nextInt();
			if (choice == 1) {
				createFile();
			} else if (choice == 2) {
				displayFiles();
			} else if (choice == 3) {
				updateFile();
			} else if (choice == 4) {
				deleteFile();
			} else if (choice == 0) {
				sessionFactory.close();
				System.out.println("stopped!!!");
				System.exit(1);
			} else {
				System.out.println("Invalid choice");
			}

		}

	}
}
