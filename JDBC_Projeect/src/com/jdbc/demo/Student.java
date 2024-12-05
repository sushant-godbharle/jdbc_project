package com.jdbc.demo;

public class Student {

	
	private int id;
	private String name;
	private String Address;
	private float marks;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String address, float marks) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Address=" + Address + ", marks=" + marks + "]";
	}
	
	
	
	
	

}
