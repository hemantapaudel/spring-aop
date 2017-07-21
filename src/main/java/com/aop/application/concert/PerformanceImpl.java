package com.aop.application.concert;

import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements Performance {

	@Override
	public void perform() {
			System.out.println("perform going on");
	}

	@Override
	public void print(int trackNumber) {
			System.out.println("permed call by valye "+trackNumber);
	}

}
