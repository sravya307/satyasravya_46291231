package com.cg.model;

public class Student {
	
	//Grades gr = new Grades();
	private int id;
	private String fname;
	private String lname;
	private float percentage;
	private String grade;
	
	public Student() {
		super();
	}


	


	public Student(int id, String fname, String lname, float percentage) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.percentage = percentage;
		
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}



	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public float getPercentage() {
		return percentage;
	}


	public void setPercentage(float percentage) {//89
		this.percentage = percentage;
	}
	public void setGrade(String grade) {

		this.grade = grade;
	}
	
	public String getGrade() {
		return grade;
	}

	





	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", percentage=" + percentage + ", grade="
				+ grade + "]";
	}





	
	
	

}
