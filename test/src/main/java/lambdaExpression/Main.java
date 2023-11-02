package lambdaExpression;

public class Main {
	
	public static void main(String[] args) {
		show();
	}
	
	public static void print (String message) {
		message = "day la dau vao " + message;
		System.err.println(message);
	}
	
	public static void show() {
		greet(message -> print(message));
	}
	
	public static void greet(Printer printer) {
		printer.print("this is me");
	}
}
