package genericsPackage;

import lombok.Data;

// để sử dụng generic ta sẽ khai báo ngay đầu class và muốn sử dụng bao nhiêu biến generic thì khai báo bấy nhiêu
@Data
public class User<T, U> {

	private T id;
	private U age;

	public User(T id, U age) {
		this.id = id;
		this.age = age;
	}

}
//
//class TestMain {
//	public static void main(String[] agr) {
//		// khi tạo đối tượng thì khai báo như này để truyền vào kiểu dữ liệu mong muốn
//		User<Integer, Double> user = new User<Integer, Double>(1, 1.4);
//		User<String, Integer> user1 = new User<String, Integer>("12", 1);
//
//		doSomething("xin chao");
//	}
//
//	// áp dụng generic cho phương thức
//	public static <T> void doSomething(T value) {
//		System.err.println(value);
//	}
//}
