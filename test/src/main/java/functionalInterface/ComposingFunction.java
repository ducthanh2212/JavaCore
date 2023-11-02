package functionalInterface;

import java.util.function.Function;

import lombok.var;

public class ComposingFunction {
	public static void main(String[] args) {
		Function<String,String> func1 = str -> str.replace(":", "=");
		Function<String,String> func2 = str -> str.toUpperCase();
		var result = func1.andThen(func2).apply("key:value");
		// đối với compsing function thì nó sẽ thực thiện việc andThen theo cách sau
		var result2 = func2.compose(func1).apply("a:b");
		System.err.println(result);
		System.err.println(result2);
	}
}
