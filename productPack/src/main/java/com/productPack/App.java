package com.productPack;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class App 
{
	static Scanner in;
	static SessionFactory sessionFactory;
	static List<Product> products;
	
	private static void storeProduct() {
		
		in.nextLine();
		System.out.print("Enter product name : ");
		String name = in.nextLine();
		System.out.print("Enter product description : ");
		String description = in.nextLine();
		System.out.print("Enter product price : ");
		double price = in.nextDouble();
		System.out.print("Enter product inventory : ");
		int inventory = in.nextInt();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Product obj = new Product(name, description, price, inventory);
			
			session.persist(obj);
			session.getTransaction().commit();
			session.close();
			System.out.println("product stored in the cart. " + obj);

		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
		
	}
	
	private static void displayProducts() {
		System.out.println("Displaying the list of products : ");
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Product> products = session.createQuery("from Product", Product.class).getResultList();
			for (Product i : products) {
				System.out.print(i);
			}
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	
	private static void updateProduct() {
		System.out.print("Enter product id to update : ");
		int id = in.nextInt();
		in.nextLine();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Product mainFileObj = session.get(Product.class, id);

			if (mainFileObj != null) {
				System.out.print("Enter new product name : ");
				String name = in.nextLine();
				System.out.print("Enter new product description : ");
				String description = in.nextLine();
				System.out.print("Enter new product price : ");
				double price = in.nextDouble();
				System.out.print("Enter new product inventory : ");
				int inventory = in.nextInt();

				mainFileObj.setProductName(name);
				mainFileObj.setProductDescription(description);
				mainFileObj.setProductPrice(price);
				mainFileObj.setProductInventory(inventory);
				session.merge(mainFileObj);
				session.getTransaction().commit();
				session.close();
				System.out.println("product updated successfully : " + mainFileObj);
			} else {
				System.out.println("product id does not exist.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteProduct() {
		System.out.print("Enter product id to delete : ");
		int id = in.nextInt();
		in.nextLine();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Product mainFileObj = session.get(Product.class, id);

			if (mainFileObj != null) {
				System.out.println("product deleted successfully : " + mainFileObj);
				session.remove(mainFileObj);
				session.getTransaction().commit();
			} else {
				System.out.println("product id does not exist.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void main( String[] args )
    {
        in = new Scanner(System.in);
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        while (true) {
			System.out.println("\n1. store product");
			System.out.println("2. display products");
			System.out.println("3. update product");
			System.out.println("4. delete product");
			System.out.println("0. exit");
			System.out.print("Enter choice : ");

			int choice = in.nextInt();
			if (choice == 1) {
				storeProduct();
			} else if (choice == 2) {
				displayProducts();
			} else if (choice == 3) {
				updateProduct();
			} else if (choice == 4) {
				deleteProduct();
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
