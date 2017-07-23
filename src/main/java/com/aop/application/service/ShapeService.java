package com.aop.application.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.aop.application.aspect.Loggable;
import com.aop.application.model.Circle;
import com.aop.application.model.Triangle;

public class ShapeService {
	
	@Autowired
	private Circle circle;

	@Autowired
	private Triangle triangle;

	@Loggable
	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	
	

}
