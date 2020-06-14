package actionrpg.gamelogic.entities;

import java.awt.Rectangle;

public class Entity {

	protected int posX;
	protected int posY;
	protected Rectangle boundingBox;
	
	public Entity(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.boundingBox = new Rectangle(posX, posY, 32, 32);
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public void setPositionX(int x) {
		this.posX = x;
	}
	
	public void setPositionY(int y) {
		this.posY = y;
	}
	
	public void setPosition(int x, int y) {
		setPositionX(x);
		setPositionY(y);
	}
	
	public Rectangle getBoundingBox() {
		return boundingBox;
	}
}
