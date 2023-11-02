package test.learnDI;

import java.util.ArrayList;
import java.util.List;

public class MainActive {
	
	private static List<ActiveSomething> lst = new ArrayList<ActiveSomething>();
	
	public static void main(String[] args) {
		SingSomething singSomething = new SingSomething();
		WalkSomething walkSomething = new WalkSomething();
		ActiveSomething actv1 = new ActiveSomething(singSomething);
		ActiveSomething actv2 =  new ActiveSomething(walkSomething);
		actv1.getDoSomething().action();
		actv2.active();
		
		lst.get(0);
	}
}
