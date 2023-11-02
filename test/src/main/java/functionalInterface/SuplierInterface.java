package functionalInterface;

import java.util.function.Supplier;

public class SuplierInterface {
	
	// Suplier là 1 functional interface có 1 abstarct method là get: không có input chỉ có output
	
	public static void main(String[] args) {
		// cách 1:
		Supplier<Double> suplier = new Supplier<Double>() {
			
			@Override
			public Double get() {
				// TODO Auto-generated method stub
				return Math.random();
			}
		};
		
		// cách 2: dùng lambda expression
		Supplier<Double> suplier2 = () -> Math.random();
		System.err.println(suplier2.get());
		
		System.err.println(suplier.get());
	}
}
