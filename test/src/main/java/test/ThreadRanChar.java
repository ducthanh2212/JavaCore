package test;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

public class ThreadRanChar extends Thread {
	@Autowired
	private ShareData shareData;

	public ThreadRanChar(ShareData shareData) {
		this.shareData = shareData;
	}
	@Override
	public void run() {
		Random random = new Random();
		for(int i = 0 ; i < 11; i ++) {
			char ranChar = (char)(random.nextInt(26)+'a');
			shareData.lstChar.add(ranChar);
		}
	}
}
