package chap05;

public class MainCalculator {

	public static void main(String[] args) {
		Calculator cal = new ExeCalculator(new implCalculator());
		long r = cal.factorial(10);
		
		System.out.println(r);

	}

}
