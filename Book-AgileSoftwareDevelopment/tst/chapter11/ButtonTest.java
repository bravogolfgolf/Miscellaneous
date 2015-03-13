package chapter11;

import static org.junit.Assert.*;

import org.junit.Test;

public class ButtonTest {

	@Test
	public void testButtonOn() {
		Lamp lamp = new Lamp();
		Button button = new Button(lamp);
		button.click();
		assertEquals(true,lamp.getState());	
	}
	
	@Test
	public void testButtonOff() {
		Lamp lamp = new Lamp();
		Button button = new Button(lamp);
		button.click();
		button.click();
		assertEquals(false,lamp.getState());	
	}

	@Test
	public void testButtonOnSecondLamp() {
		SecondLampWrapper lamp = new SecondLampWrapper();
		Button button = new Button(lamp);
		button.click();
		assertEquals(1,lamp.getState());	
	}
	
	@Test
	public void testButtonOffSecondLamp() {
		SecondLampWrapper lamp = new SecondLampWrapper();
		Button button = new Button(lamp);
		button.click();
		button.click();
		assertEquals(0,lamp.getState());	
	}
	
	
}
