package chapter11;

public class SecondLamp implements SwitchableDevice{
	int light;

	public int getState() {
		return light;
	}
	
	public void turnOn() {
		light = 1;
	}
	
	public void turnOff() {
		light = 0;
	}
}
