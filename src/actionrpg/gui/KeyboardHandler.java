package actionrpg.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {

	private static boolean[] keys;
	
	public KeyboardHandler() {
		keys = new boolean[100];
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
	}
	
	public static boolean isKeyDown(int keyEvent) {
		return keys[keyEvent];
	}
	
	public static void forceRelease(int keyEvent) {
		keys[keyEvent] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
