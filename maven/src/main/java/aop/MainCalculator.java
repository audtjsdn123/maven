package aop;

import chap05.Calculator;
import chap05.ExeCalculator;
import chap05.implCalculator;
import chap05.implCalculator2;

public class MainCalculator {

	public static void main(String[] args) {
		Calculator cal = new ExeCalculator(new implCalculator2());
		long r = cal.factorial(10);
		
		System.out.println(r);

	}

}
