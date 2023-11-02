package functionalInterface;

import java.util.function.UnaryOperator;

public class UnaryOPerator {

	// unary khác với binary là chỉ nhận vào 1 đối số và thực hiện tính toán còn binary thì dùng trên nhiều đối số
	public static void main(String[] args) {
		UnaryOperator<Integer> unary1 = n -> n + 1 ;
		UnaryOperator<Integer> unary2 = n -> n - 2;
		System.err.println(unary1.andThen(unary2).apply(3));
		

	}

}
