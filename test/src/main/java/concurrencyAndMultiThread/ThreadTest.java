package concurrencyAndMultiThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import lombok.var;

public class ThreadTest {
	/**
	 * parallel: song song
	 * interrupting: gián đoạn
	 */
	
	
	public static void main(String[] args) {
//		System.err.println(Thread.activeCount()); // xem những luồng nào đang hoạt động
//		System.err.println(Runtime.getRuntime().availableProcessors()); // xem máy đang trống bao nhiu luồng
//		joinMultiThrad();
//		volatileKeyword();
		synchronizeCollection();
	}
	
	/**
	 * Pausing a thread: để dừng thread ta dùng interrupt() để gửi message lên cho thread biết rằng nó cần phải gián đoạn
	 * flow của đoạn code dưới như sau:
	 * + sau khi tạo luồng nó sẽ chạy method run và in theo vòng lặp đã khai báo, sau đó luồng chính vẫn chạy tiếp tới dòng sleep(1000) thì đánh dấu là luồng cần gián đoạn và bên kia (ThreadObject) nhận được tín hiệu sẽ dừng lại 
	 */
	
	public static void interruptingThread() {
		Thread thread = new Thread(new DownloadFileTask(new DownloadStatus()));
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.interrupt(); // đánh dấu luồng cần phải gián đoạn 
	}
	
	/**
	 * Cách tạo ra nhiều luồng chạy song song và đợi join các luồng lại 
	 * + Tạo ra 1 list<thread> sau đó add hết vào list rồi chạy vòng lặp trên mảng này và join từ phần tử thread lại, nó sẽ đợi nhau hoàn thành
	 */
	public static void joinMultiThrad() {
		List<Thread> lst = new ArrayList<>();
		DownloadStatus status = new DownloadStatus();
		for(int i = 0; i < 10; i++) {
			Thread thread = new Thread(new DownloadFileTask(status));
			thread.start();
			lst.add(thread);
		}
		
		for(var th : lst) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.err.println(status.getTotalByte());
	}
	
	/**
	 * volatile keyword: từ khóa dùng để đánh dấu cho biết rằng biến này là biến không đồng bộ, vì vậy mỗi lần truy cập thì sẽ truy cập xuống bộ nhớ cứng để lấy dữ liệu lên
	 * nó hoạt động như synchonize
	 * flow bình thường là khi luồng 1 cập nhật dữ liệu cho 1 file thì nó mới ghi xuống cache chứ chưa ghi xuống bộ nhớ cứng, vì vậy khi luồng 2 truy cập cũng vào cache thì lấy lên dữ liệu chưa update nên sai => dùng volatile để đánh dấu cho biết rằng xuống bộ nhớ cứng lấy dữ liệu lên sẽ chính xác nhất
	 */
	public static void volatileKeyword() {
		DownloadStatus status = new DownloadStatus();
		Thread thr1 = new Thread(new DownloadFileTask(status));
		/**
		 * công việc của luồng 2 là khởi tạo vòng lặp đợi đến khi nào luồng 1 cập nhật trạng thái done rồi break khỏi vòng lặp và in ra số byte được tăng
		 * đã dùng từ khóa volatile cho biến done nên nó đợi hoàn thành xong hết nó mới cập nhật trạng thái
		 */
		Thread thr2 = new Thread(() -> {
			while (!status.getIsDone()) {
				
			}
			System.err.println(status.getTotalByte());
		});
		thr1.start();
		thr2.start();
	}
	
	public static void synchronizeCollection() {
		/** 
		 * với cách ban đầu này arraylist dùng trong đa luồng sẽ không được đồng bộ dữ liệu, đôi lúc nó sẽ có kết quả của luồng 1 hoặc 2 là do bị ghi đè
		 * -> để đồng bộ dữ liệu giữa các luồng khi dùng List thì dùng CopyOnWriteArrayList  hoặc Collections.synchronizedList
		 * Còn đối với Map dùng trong đa luồng thì dùng Map<String,Object> map = new ConcurrentHahMap<>();
		 */
		// cách này sẽ ko đồng bộ dược dữ liệu giữa các luồng
//		List<Integer> lst = new ArrayList<>();
		// cách này sẽ đồng được dữ liệu giữa các luồng
		List<Integer> lst = Collections.synchronizedList(new ArrayList<>());
		Thread th1 = new Thread(()->{
			lst.addAll(Arrays.asList(1,2,3));
		});
		Thread th2 = new Thread(()->{
			lst.addAll(Arrays.asList(4,5,6));
		});
		th1.start();
		th2.start();
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(lst);
	}
}
