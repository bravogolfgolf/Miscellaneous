package chapter11;

public class Lamp {
	boolean light;

	public boolean getState() {
		return light;
	}
	
	public void turnOn() {
		light = true;
	}
	
	public void turnOff() {
		light = false;
	}
}
