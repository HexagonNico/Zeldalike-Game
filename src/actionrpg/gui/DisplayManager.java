package actionrpg.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayManager {

	public static final int WINDOW_WIDTH = 805; //32x25
	public static final int WINDOW_HEIGHT = 480; //32x15
	
	private static JFrame window;
	private static JPanel gameScreen;
	
	/**Creates a new JFrame object and adds a GameScreen component*/
	public static void createDisplay() {
		window = new JFrame("Link thingy");
		window.setBounds(50, 50, WINDOW_WIDTH, WINDOW_HEIGHT+150);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		gameScreen = new GameScreen();
		window.add(gameScreen);
		gameScreen.requestFocusInWindow();
		
		System.out.println("[DisplayManager]: Created display");
	}
	
	/**Sets JFrame visible*/
	public static void setVisible() {
		if(window != null) {
			window.setVisible(true);
			System.out.println("[DisplayManager]: Display is now visible");
		}
	}
}
