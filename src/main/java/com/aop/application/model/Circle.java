package com.aop.application.model;



public class Circle {
	private String name ="this is circle";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("setNameReturn called");
		return name + "haha";
	}
}
