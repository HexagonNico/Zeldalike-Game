package actionrpg.gamelogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import actionrpg.gui.KeyboardHandler;
import actionrpg.utils.Direction;

public class GameLoop implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(KeyboardHandler.isKeyDown(KeyEvent.VK_W))
				GameLogic.handlePlayerMovement(Direction.UP);
			if(KeyboardHandler.isKeyDown(KeyEvent.VK_A))
				GameLogic.handlePlayerMovement(Direction.LEFT);
			if(KeyboardHandler.isKeyDown(KeyEvent.VK_S))
				GameLogic.handlePlayerMovement(Direction.DOWN);
			if(KeyboardHandler.isKeyDown(KeyEvent.VK_D))
				GameLogic.handlePlayerMovement(Direction.RIGHT);
			
			if(KeyboardHandler.isKeyDown(KeyEvent.VK_Q))
				GameLogic.handlePlayerAttacks(true);
			else
				GameLogic.handlePlayerAttacks(false);
			
			if(KeyboardHandler.isKeyDown(KeyEvent.VK_E)) {
				GameLogic.interact();
				KeyboardHandler.forceRelease(KeyEvent.VK_E);
			}
				
			
			GameLogic.handleMonsterMovement();
			GameLogic.handleMonsterDrops();
			GameLogic.handlePickUpLoot();
			
			GameLogic.changeArea();
		} catch(Exception e) {
			System.err.println("\n[GameLoop]: Uncaught exception!\n");
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
