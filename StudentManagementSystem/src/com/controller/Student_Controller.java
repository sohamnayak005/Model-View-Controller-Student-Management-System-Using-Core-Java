package com.controller;

import java.util.ArrayList; 

import com.model.Student;

public class Student_Controller {
   private ArrayList<Student>al=new ArrayList<Student>();
   public void saveStudent(Student s) {
	   al.add(s);
   }
   public Student findStudentById(int id) {
	   for(Student s:al) {
		   if(s.getId()==id)
			   return s;
	   }
	   return null;
   }
   public boolean deleteStudentById(int id){
	   Student student=findStudentById(id);
	   if(student!=null)
		   return true;
	   return false;
   }
   public Student updateStudentById(int id) {
	   Student student=findStudentById(id);
	   if(student!=null)
		   return student;
	   return null;
   }
   public Student fetchAllStudent(int index){
	   return al.get(index);
   }
}
