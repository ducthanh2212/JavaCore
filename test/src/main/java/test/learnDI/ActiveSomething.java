package test.learnDI;

public class ActiveSomething {
	private DoSomething doSomething;
	public ActiveSomething(DoSomething doSomething) {
		this.doSomething = doSomething;
	}
	
	public DoSomething getDoSomething() {
		return doSomething;
	}

	public void setDoSomething(DoSomething doSomething) {
		this.doSomething = doSomething;
	}

	public void active() {
		doSomething.action();
	}
}
