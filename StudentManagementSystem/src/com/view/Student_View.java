package com.view;
import java.util.Scanner;
import com.controller.Student_Controller;
import com.model.Student;
public class Student_View {
	static int count=0;
	static Scanner sc=new Scanner(System.in);
	public static void updateStudentObject(Student s) {
		System.out.println("Press 1 to Update your Name");
		System.out.println("Press 2 to Update your Mobile Number");
		System.out.println("Press 3 to Update your Gender");
		System.out.println("Press 4 to Update your Email Id");
		System.out.println("Press 5 to Update your Date of Birth");
		System.out.println("Press 6 to Update your Relationship Status");
		System.out.println("Enter Your Choice ");
		int ch=sc.nextInt();
		switch (ch) {
		case 1:
			 System.out.println("Enter Your New Name: ");
			 sc.nextLine();
			 String name=sc.nextLine();
			 s.setName(name);
			break;
		case 2:
			 System.out.println("Enter Your New Mobile No: ");
			 long mob=sc.nextLong();
			 s.setMob(mob);;	
			break;
		case 3:
			 System.out.println("Enter Your New Gender: ");
			 sc.nextLine();
			 String gender=sc.nextLine();
			 s.setGender(gender);
			break;
		case 4:
			 System.out.println("Enter Your New Email Id: ");
			 sc.nextLine();
			 String email=sc.nextLine();
			 s.setEmail(email);	
			break;
		case 5:
			 System.out.println("Enter Your New Date of Birth: ");
			 sc.nextLine();
			 String dob=sc.nextLine();
			 s.setDob(dob);	
			break;
		case 6:
			System.out.println("Enter Your New Relationship Status: ");
			sc.nextLine();
			String rel=sc.nextLine();
			s.setRelationshipstatu(rel);	
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
	}
	public static Student getStudentObject() {
		System.out.println("Enter The Id: ");
		int id=sc.nextInt();
		System.out.println("Enter the name: ");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter Mobile Number: ");
		long mob=sc.nextLong();
		System.out.println("Enter The Gender: ");
		sc.nextLine();
		String gender=sc.nextLine();
		System.out.println("Enter The Email Id: ");
		String email=sc.nextLine();
		System.out.println("Enter The Date of Birth: ");
		String dob=sc.nextLine();
		System.out.println("Enter Relationship Status: ");
		String rel=sc.nextLine();
		Student s=new Student();
		s.setId(id);
		s.setName(name);
		s.setMob(mob);
		s.setGender(gender);
		s.setEmail(email);
		s.setDob(dob);
		s.setRelationshipstatu(rel);
		return s;
		
	}
    public static void main(String[] args) {
		System.out.println("Welcome to Student Portal.....");
		Student_Controller controller=new Student_Controller();
		while(true) {
			System.out.println("1.Save Student");
			System.out.println("2.Find the Student By Id");
			System.out.println("3.Update the Student By Id");
			System.out.println("4.Delete the Student BY Id");
			System.out.println("5.Find All");
			System.out.println("6.Exit");
			System.out.println("Enter Your Choice: ");
			int choice=sc.nextInt();
		    switch (choice) {
			case 1:
				Student student=getStudentObject();
				controller.saveStudent(student);
				System.out.println("Student Record is Store in the Data Base Successfully");
				count++;
				break;
			case 2:
				System.out.println("Enter Student Id");
				int id=sc.nextInt();
				Student s=controller.findStudentById(id);
				if(s!=null)
				System.out.println(s);
				else 
					System.out.println("Student Not Found");
				break;
			case 3:
				System.out.println("Enter Student Id Which Student you want to Update");
				int upId=sc.nextInt();
				Student record=controller.updateStudentById(upId);
				if(record!=null)
				updateStudentObject(record);
				else 
					System.out.println("No Data found "+ upId+" Id");
				break;
			case 4:
				System.out.println("Enter Student Id Which Student you want to delete");
				int dlId=sc.nextInt();
				boolean b=controller.deleteStudentById(dlId);
				if(b)
					System.out.println("Student Record is delete successfully");
				else 
					System.out.println("Record Not Found");
				count--;
				break;
			case 5:
				System.out.println("Total Record Found is= "+count);
				if(count>0) {
				System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------|");
				System.out.println("   ID   |     Name     |     Mobile NO     |     Gender     |           Email Id           |          DOB          |          Status          |");
				System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------|");
                for(int i=0;i<count;i++) {
                	Student fetchObject=controller.fetchAllStudent(i);
                	System.out.println("  "+fetchObject.getId()+"     "+fetchObject.getName()+"        "+fetchObject.getMob()+"         "+fetchObject.getGender()+"          "+fetchObject.getEmail()+"             "+fetchObject.getDob()+"              "+fetchObject.getRelationshipstatu());
                }
				System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------|");
				}
				else {
					System.out.println("No Data Found");
				}
				break;
			case 6:
				System.out.println("Thank You...");
			    return;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
}
