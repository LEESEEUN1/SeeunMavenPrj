package test_aop;

public class NewlecCalc implements Calc{

	private int x;
	private int y;
	
	@Override
	public void set(int x, int y) {
		this.x=x;
		this.y=y;
	}

	@Override
	public int add() {
		int result=x+y;
		return result;
	}

	@Override
	public int sub() {
		int result=x-y;
		return result;
	}
}
