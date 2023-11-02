package test.leetCode;

public class Practice {
	public static void main(String[] args) {
//		System.err.println(strStr("mssissississp", "iss"));
		//===================================================
//		System.err.println(isPalindrome2("A man, a plan, a canal: Panama"));
		//==================================================
		System.err.println(compare("xin",1));
		
	}

	public static int strStr(String haystack, String needle) {
		int i = 0;
		int t = 0;
		int j = 0;
		char[] cHayStk = haystack.toCharArray();
		char[] cNeed = needle.toCharArray();
		boolean check = true;
		int count = 0;
		while (check) {
			if (cHayStk.length < cNeed.length) {
				return -1;
			} else {
				if (cHayStk[i] == cNeed[j]) {
					i++;
					j++;
					count++;
				} else {
					j = 0;
					i = ++t;
					count = 0;
				}
				if (count == cNeed.length) {
					return t;
				}
				if (i == cHayStk.length && count != cNeed.length) {
					return -1;
				}
			}

		}

		return -1;

	}

	public static boolean isPalindrome(String s) {
		if(s.trim().length()==0) {
			return true;
		}
		char[] chArr = s.toCharArray();
		StringBuilder newS = new StringBuilder();
		for(int i = 0; i < chArr.length; i ++) {
			if(Character.isLetterOrDigit(chArr[i])) {
				newS.append(chArr[i]);
			}
		}
		char[] newChArr = newS.toString().toLowerCase().toCharArray();
		int j = newChArr.length-1;
		for(int i = 0; i < newChArr.length/2; i ++) {
			if(newChArr[i]!= newChArr[j]) {
				return false;
			}
			j--;
		}
		return true;
	}
	public static boolean isPalindrome2(String s) {
		if(s.trim().length()==0) {
			return true;
		}
		char[] chArr = s.toCharArray();
		int i = 0;
		int j = chArr.length-1;
		while(i <= j) {
			if(!Character.isLetterOrDigit(chArr[i])) {
				i++;
			}
			else if(!Character.isLetterOrDigit(chArr[j])) {
				j--;
			}
			else {
				if(Character.toLowerCase(chArr[i]) != Character.toLowerCase( chArr[j])) {
				return false;
			}
				i++;
				j--;
			}
			
			
			
		}
		return true;
	}
	
	public static <T,U> boolean compare(T value1, U value2){
		
		if(value1.equals(value2)) {
			return true;
		}
		return false;
	}
	public static boolean compareObject(Object ob1, Object ob2) {
		if(ob1.equals(ob2)) {
			return true;
		}
		return false;
	}
}
