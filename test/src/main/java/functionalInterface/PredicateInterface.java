package functionalInterface;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import lombok.var;

public class PredicateInterface {
	// predicate là function interface nhận vào tham số là generic và đầu ra là boolean
	
	public static void main(String[] args) {
		
		// thường nếu đầu vào là biến nguyên thủy nếu chúng ta dùng wrapper class thì tốc độ sẽ rất chậm vì vậy nếu cầu sử dụng biến nguyên thủy thì có thể dùng những thứ đưới dây sẽ nhanh hơn
//		IntPredicate, DoublePredicate,LongPredicate
		
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				return t.length() > 5;
			}
		};
		String text = "thanh";
		Predicate<String> pre2 = str -> str.length() > 5;
		var result = pre2.test(text);
		if(result) {
			System.err.println(true);
		}
		if(text.length() > 5) {
			System.err.println(true);
		}
	}
}
