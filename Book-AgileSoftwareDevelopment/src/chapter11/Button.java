package chapter11;

public class Button {
	private boolean button = false;
	Lamp lamp;;

	public Button(Lamp lamp) {
		this.lamp = lamp;	}

	public void click() {
		if (button){
			lamp.turnOff();
		}
		else {
			lamp.turnOn();
		}
		button = !button; 
	}
}
