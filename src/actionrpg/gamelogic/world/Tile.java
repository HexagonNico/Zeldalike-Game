package actionrpg.gamelogic.world;

import java.awt.Rectangle;

public class Tile {

	private Rectangle boundingBox;
	private boolean block;
	
	private String tileName;
	
	public Tile(int x, int y, boolean blocksPlayer, String tileName) {
		this.boundingBox = new Rectangle(x, y, 32, 32);
		this.block = blocksPlayer;
		this.tileName = tileName;
	}

	public Rectangle getBoundingBox() {
		return boundingBox;
	}

	public boolean isBlock() {
		return block;
	}
	
	public String getTileName() {
		return tileName;
	}
	
}
