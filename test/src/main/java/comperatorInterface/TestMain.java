package comperatorInterface;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

import lombok.var;

public class TestMain {
	
	// trong bài này nói về cách so sánh giữa các đối tượng pojo, muốn so sánh được thì chúng ta phải implement interface sau:
	// + compearble<T> 
		// Interface Comparable được sử dụng để thực hiện sự so sánh giữa các đối tượng của cùng một lớp.
		//Đối tượng thực hiện Comparable cung cấp một cách để tự so sánh chính nó với các đối tượng khác cùng kiểu.
		//Đối tượng này phải triển khai phương thức compareTo(T o) trong đó o là đối tượng cần so sánh với đối tượng hiện tại.
		// ví dụ so sánh 2 đối tượng với nhau o1.compareTo(o2) thì dùng cái này
	// + comperator<T>
		// Interface này dùng để so sánh nhiều đối tượng khác nhau, thường dùng trong sắp xếp mảng để so sánh các đối tượng rồi sắp xếp như ví dụ code bên dưới
	
	
	public static void main(String[] args) {
//		List<Customer> lst = new ArrayList<Customer>();
//		lst.add(new Customer("a1","e1"));
//		lst.add(new Customer("a4","e4"));
//		lst.add(new Customer("a2","e2"));
//		Collections.sort(lst, new CompareByEmail());
//		System.err.println(lst);
//		System.out.println(lst);
		
		
		Queue<String> lstQueue = new ArrayDeque<String>();
		Collections.addAll(lstQueue, "a","b","c");
		var t = lstQueue.remove();
		System.err.println(t);
		System.err.println(lstQueue);
	}
}
