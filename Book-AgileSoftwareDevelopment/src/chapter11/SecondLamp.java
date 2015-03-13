package chapter11;

public class SecondLamp {
	int light;

	public int getState() {
		return light;
	}
	
	public void on() {
		light = 1;
	}
	
	public void off() {
		light = 0;
	}
}
