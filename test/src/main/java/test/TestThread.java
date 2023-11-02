package test;

public class TestThread {

	public static void main(String []arg) {
		ShareData shareData = new ShareData();
//		Thread1 thread1 = new Thread1(shareData);
//		Thread2 thread2 = new Thread2(shareData);
//		thread1.start();
//		thread2.start();
		 
		ThreadRanNum tNum = new ThreadRanNum(shareData);
		ThreadRanChar tChar = new ThreadRanChar(shareData);
		tNum.start();
		tChar.start();
		
		try {
			tNum.join();
			tChar.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println(shareData.getLstChar());
		System.err.println(shareData.getLstNum());
	}
}
