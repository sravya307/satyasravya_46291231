package com.cg.client;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.cg.model.Student;
import com.cg.service.StudentServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		StudentServiceImpl serve = new StudentServiceImpl();
		
		
		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		
		while(op !=3) {
			System.out.println("Choose an Option");
			System.out.println("1. Add data");
			System.out.println("2. Display data");
			System.out.println("3.Exit");
			System.out.println("4.Remove an Entry");
			System.out.println("5.Get by Id");
			System.out.println("6. Remove all entries");
			op = sc.nextInt();
			
		
		switch(op) {
		case 1:System.out.println("How many Entries: ");
		int en = sc.nextInt();
		
		for(int i =0;i<en;i++) {
		try {	
			
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter First Name: ");
		String fname = sc.nextLine();
		
		System.out.println("Enter Last Name: ");
		String lname = sc.nextLine();
		
		System.out.println("Enter Your Score: ");
		float score = sc.nextFloat();
		
		Student st = new Student(id,fname,lname,score);

		serve.add(st);
		
		}
		catch(RuntimeException e) {
			System.out.println("*******Invalid Input*******");
		}
		
		sc.nextLine();
		

		
		}	
		break;
		
		case 2:serve.display();
			System.out.println("\n");
				break;
				
				
						
			
				
		case 3:exit(0);
				System.out.println("Done");
				break;
		
			
		case 4: System.out.println("Entry number to be removed: ");
				int en1 = sc.nextInt();
				serve.remove(en1);
				serve.display();
				break;
				
		case 5: System.out.println("Entry the id ");
				int id = sc.nextInt();
				 serve.findById(id);
				 break;
		
		case 6: serve.removeAll();
				serve.display();		
				break;
				
		default: System.out.println("Please enter valid choice");
		}
		}
		
		
		
		
		
		

	}

	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}

}
