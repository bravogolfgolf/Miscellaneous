package chapter11;

public class Button {
	private boolean button = false;
	SwitchableDevice device;

	public Button(SwitchableDevice device) {
		this.device = device;	}

	public void click() {
		if (button){
			device.turnOff();
		}
		else {
			device.turnOn();
		}
		button = !button; 
	}
}
