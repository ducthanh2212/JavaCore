package test;

import org.springframework.beans.factory.annotation.Autowired;

public class Thread2 extends Thread {
	@Autowired
	private ShareData shareData;
	public Thread2(ShareData shareData) {
		this.shareData = shareData;
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			synchronized (shareData) {
				System.err.println("thread 2 start -> value is: "+shareData.getRad() * shareData.getRad());
				shareData.notifyAll();
				try {
					System.err.println("thread 2 stop");
					shareData.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
