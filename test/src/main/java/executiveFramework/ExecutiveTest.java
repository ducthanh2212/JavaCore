package executiveFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutiveTest {
	public static void main(String[] args) {
		executors();
	}
	/**
	 * submit là phương thức trong executorservice dùng để gửi callable hoặc runable task(công việc) cho 1 executorsevice để thực thi bất đồng bộ trong 1 luồng hoặc một pool luồng
	 */
	public static void executors() {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		try {
			ex.submit(() ->{
				for(int i = 0; i < 100 ; i++) {
					System.err.println("A["+i+"]: "+Thread.currentThread().getName());
				}
			});
			
//			ex.submit(() ->{
//				for(int i = 0; i < 10 ; i++) {
//					System.err.println("B["+i+"]: "+Thread.currentThread().getName());
//				}
//			});
//			
		}finally {
			ex.shutdown();
		}
	}
}
