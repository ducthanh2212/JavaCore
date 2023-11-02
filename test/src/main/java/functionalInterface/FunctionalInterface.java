package functionalInterface;

import java.util.function.Function;

public class FunctionalInterface {

	// function là 1 functional interfacec với định nghĩa có tham số đầu vào và đầu ra
	
	public static void main(String[] args) {
		// cách 1:
		Function<String, Integer> function = new Function<String, Integer>() {
			
			@Override
			public Integer apply(String t) {
				// TODO Auto-generated method stub
				return t.length();
			}
		};
		// cách 2: dùng lambda expression
		Function<String, Integer> function2 = (str) -> str.length();
		
		System.err.println(function.apply("thanh"));
		System.err.println(function2.apply("Q12neverdie"));
	}

}
