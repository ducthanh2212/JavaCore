package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class ThreadRanNum extends Thread {
	@Autowired
	private ShareData shareData;

	public ThreadRanNum(ShareData shareData) {
		this.shareData = shareData;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (int i = 0; i < 11; i++) {
			int randNum = random.nextInt(100);
			shareData.lstNum.add(randNum);
		}
	}

	abstract class shape {
		abstract void run();

		abstract void sing();

		void hi() {
			System.err.println("d");
		}
	}

	public static void main(String[] agr) {
		System.err.println(strStr("mississippi", "issip"));
	}

	public static int removeDup(int[] prices) {
		int min = prices[0];
		int max = 0;
		int j = prices.length - 1;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min && i < j) {
				min = prices[i];
			}
			if (prices[j] > max && j > i) {
				max = prices[j];
			}
			j--;
		}
		int profit = max - min;
		System.err.println("min: " + min + " max: " + max);
		return profit;
	}

	public static int strStr(String haystack, String needle) {
		char[]chNeedle = needle.toCharArray();
		char[]chHayStack = haystack.toCharArray();
		int count = 0;
		int index = 0;
		for(int i = 0; i < chHayStack.length; i++) {
			if(count < chNeedle.length && String.valueOf(chHayStack[i]).equals(String.valueOf(chNeedle[count])) ) {
				if(count == 0) {
					index = i;
				}
				
				count ++;
			}
			else if(count < chNeedle.length && count > 0 && !String.valueOf(chHayStack[i]).equals(String.valueOf(chNeedle[count]))) {
				count = 0;
			}
		}
		if(count == needle.length()) {
			return index;
		}
		return -1;
	}
}
