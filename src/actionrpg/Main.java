package actionrpg;

import actionrpg.gamelogic.GameLogic;
import actionrpg.gui.DisplayManager;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("[Main]: Starting...");
		
		try {
			DisplayManager.createDisplay();
			GameLogic.startGame();
			DisplayManager.setVisible();
		} catch(Exception e) {
			System.err.println("\n[Main]: Uncaught exception!\n");
			e.printStackTrace();
			System.exit(-1);
		}
		
		System.out.println("[Main]: Started!");
	}

}
