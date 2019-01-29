package org.kro.main;

import org.kro.calculator.Calculator;
import org.kro.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Calculator cal = (Calculator) ctx.getBean("reCalculator");
		long time = cal.factorial(30);
		System.out.println("calculatorImpl(30)" + time);
		ctx.close();
	}

}
