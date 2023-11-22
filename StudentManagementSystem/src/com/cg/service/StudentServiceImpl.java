package com.cg.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.cg.model.Student;


public class StudentServiceImpl implements StudentService {
	
	List<Student> studinfo = new ArrayList<Student>();
	Student stud1 = new Student();
	String grade;
	float per;
	Iterator<Student> itr = studinfo.iterator();

	@Override
	public void add(Student stud) {
		
		studinfo.add(stud);
	}

	@Override
	public void display(){
		
		System.out.println("ID"+"\t"+"Name"+"\t\t"+"Scores"+"\t"+"Grades");
		
		if(studinfo.isEmpty()) {
			System.out.println("No Data to be Displayed");
		}
		else {
			
		
		for(Student student:studinfo) {
			 per = student.getPercentage();
			 
			 if (per>=85) {
					grade = "A";
				}
				else if(per>=70&&per<85) {
					grade = "B";
				}
				else if(per>=60&&per<70) {
					grade = "c";
				}
				else {
					grade = "D";
				}
			 student.setGrade(grade);
			 System.out.println(student.getId()+" "+student.getFname()+" "+student.getLname()+"\t"+student.getPercentage()+"\t"+student.getGrade());
		}
	}
 
	
}

	@Override
	public void remove(int id)//53
	{
		
		for(Student stud: studinfo) {
			if(id == stud.getId()) //42
				{
				studinfo.remove(stud);
				System.out.println("Entry with "+id+" is removed");
				break;
			}			
		}

	}

	@Override
	public void findById(int id) {
		System.out.println("Name"+"\t"+"Score"+"\t"+"Grade");
		for(Student stud: studinfo) {
			if(id == stud.getId()) {
				System.out.println(stud.getFname()+" "+stud.getLname()+" "+stud.getPercentage()+" "+stud.getGrade());
			}
		}
		
	}

	@Override
	public void removeAll() {
		studinfo.clear();
		
		
	}}
