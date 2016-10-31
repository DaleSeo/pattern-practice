package seo.dale.practice.pattern.command;

import org.junit.Test;

/**
 * Client
 */
public class CommandTest {

	@Test
	public void test() {
		Lamp lamp = new Lamp();
		Command lampOnCommand = new LampOnCommand(lamp);
		Command lampOffCommand = new LampOffCommand(lamp);

		Button button = new Button();

		button.setCommand(lampOnCommand);
		button.pressed();

		button.setCommand(lampOffCommand);
		button.pressed();
	}

}