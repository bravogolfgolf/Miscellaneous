package chapter11;

public class SecondLampWrapper extends SecondLamp implements SwitchableDevice{

	@Override
	public void turnOn() {
		super.on();
	}

	@Override
	public void turnOff() {
		super.off();
	}
}
