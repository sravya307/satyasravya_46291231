package com.cg.service;


import com.cg.model.Student;

public interface StudentService {
	
	public void add(Student stud);
	
	public void display();
	
	public void remove(int id);
	
	public void findById(int id);
	
	public void removeAll();

}
