package genericsPackage;

public class Utils {

	public static void print(GenericList<? extends User> lst) {
		System.err.println(lst.get(0));
	}
	
}
