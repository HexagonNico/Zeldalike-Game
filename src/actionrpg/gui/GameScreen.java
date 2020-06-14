package actionrpg.gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import actionrpg.gamelogic.GameLogic;
import actionrpg.utils.DialogueLine;

public class GameScreen extends JPanel {

	private Renderer renderer;
	
	public GameScreen() {
		super();
		this.setFocusable(true);
		this.addKeyListener(new KeyboardHandler());
		
		renderer = new Renderer();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(GameLogic.isGameStarted()) {
			super.paintComponent(g);
			renderer.drawMap(g, GameLogic.getCurrentArea());
			renderer.drawPlayer(g, GameLogic.getPlayer());
			renderer.drawMonsters(g, GameLogic.getActiveMonsters());
			renderer.drawLoot(g, GameLogic.getLoot());
			renderer.drawHUD(g, GameLogic.getPlayer());
			//renderer.debug(g, GameLogic.getPlayer(), GameLogic.getActiveMonsters());
			
			if(GameLogic.getCurrentArea().getCoordX() == 0 && GameLogic.getCurrentArea().getCoordY() == 6)
				renderer.drawDialogue(g, DialogueLine.OLD_MAN);
		}
		repaint();
	}
}
