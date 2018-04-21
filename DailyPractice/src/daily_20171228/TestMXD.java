package daily_20171228;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class TestMXD {
	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		while(true){
			Thread.sleep(2000); 
			robot.keyPress(KeyEvent.VK_SPACE);
			Thread.sleep(3000);
		}
	}
}
