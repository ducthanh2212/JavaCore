package functionalInterface;

import java.util.function.BinaryOperator;
import java.util.function.Function;

import lombok.var;

public class BinaryOperators {

	// là 1 functional interface dùng để thực hiện các phép tính toán nhị phân và trả về kết quả cùng kiểu dữ liệu với kiểu dữ liệu đầu vào
	public static void main(String[] args) {
		// lưu ý chỉ đầu vào và đầu ra phải cùng kiểu dữ liệu
		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t+u;
			}
		};
		// đây là 1 phép toán kết hợp giữa binary vs function ( nhận vào 1 kiểu dữ liệu và có thể trả về 1 kiểu dữ liệu khác)
		
		BinaryOperator<Integer> binary2 = (t,u) -> t + u;
		binary2.apply(1, 12);
		Function<Integer, Double> fun = (a) -> a * 3.14; //dầu vào kiểu int từ binary operator và đầu ra kiểu double
		var result = binary2.andThen(fun).apply(1, 2);
		System.err.println(result);
	}

}
