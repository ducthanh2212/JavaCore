package test;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

public class Thread1 extends Thread {
	
	@Autowired
	ShareData shareData;
	
	public Thread1(ShareData shareData) {
		this.shareData = shareData;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			synchronized (shareData) {
				int radom = random.nextInt(10);
				shareData.setRad(radom);
				System.err.println("thread 1 have random number: "+radom );
				shareData.notifyAll();
				try {
					System.err.println("thread 1 stop");
					shareData.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
