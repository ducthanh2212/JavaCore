package concurrencyAndMultiThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Data;

@Data
public class DownloadStatus {
	private int totalByte;
	private volatile boolean isDone;
	/**
	 * ngoài cách dùng lock để khóa thread và cập nhật giá trị thì ta có thẻ  dùng Atomic để thay thế 
	 */
	private AtomicInteger totalByte2 = new AtomicInteger();
	public void increateTotalByte2() {
		this.totalByte2.incrementAndGet();// ++ totalByte2;
//		this.totalByte2.getAndIncrement(); // totalByte2 ++;
	}
	/**
	 * Ngoài cách dùng Atomatic ra thì có thể dùng Adder 
	 * 
	 * Ưu điểm của LongAdder so với AtomicLong là nó cải thiện hiệu suất trong các tình huống với nhiều luồng cộng vào cùng một biến, vì nó giảm thiểu sự cạnh tranh và xung đột đồng thời giữa các luồng
	 */
	private LongAdder totalByte3 = new LongAdder();
	
	public int getTotalByte3() {
		return this.totalByte3.intValue();
	}
	public void setTotalByte3() {
		this.totalByte3.increment();
	}
	public int getTotalByte2() {
		return this.totalByte2.get();
	}
	// dùng lock để khóa thread
	private Lock lock = new ReentrantLock();
	public void increaTotalByte() {
		lock.lock();
		try {
			totalByte++;
			
		} finally {
			lock.unlock();
		}
	}
	
	public boolean getIsDone() {
		return isDone;
	}
	public void setIsDone() {
		this.isDone = true;
	}
}
