package org.kro.main;

import org.kro.calculator.Calculator;
import org.kro.calculator.CalculatorImpl;
import org.kro.calculator.ExecTimeCalculator;
import org.kro.calculator.ReCalculator;

public class MainProxy {

	public static void main(String[] args) {
		Calculator ttCal1 = new ExecTimeCalculator(new CalculatorImpl());
		System.out.println(ttCal1.factorial(60));
		
		Calculator ttCal2 = new ExecTimeCalculator(new ReCalculator());
		System.out.println(ttCal1.factorial(60));

	}

}
