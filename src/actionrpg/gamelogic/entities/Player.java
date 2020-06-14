package actionrpg.gamelogic.entities;

import java.awt.Rectangle;

public class Player extends NonStaticEntity {
	
	private Rectangle hitBox;
	
	private boolean sword;
	private int rupees;
	
	private int esaforce;
	
	public Player(int startPosX, int startPosY) {
		super(startPosX*32, startPosY*32, 12, 4);
		System.out.println("[Player]: Creating player");
		
		hitBox = new Rectangle(posX+1, posY+33, 30, 30);
		
		sword = false;
		rupees = 0;
		esaforce = 0;
	}
	
	public void move() {
		if(attackTime < 0) {
			switch(facing) {
			case DOWN:
				posY++;
				hitBox.setLocation(posX+1, posY+33);
				break;
			case LEFT:
				posX--;
				hitBox.setLocation(posX-30, posY+1);
				break;
			case RIGHT:
				posX++;
				hitBox.setLocation(posX+33, posY+1);
				break;
			case UP:
				posY--;
				hitBox.setLocation(posX+1, posY-30);
				break;
			}
		}
		boundingBox.setLocation(posX, posY);
		
		animationFrame++;
		if(animationFrame == 30) animationFrame = 0;
	}
	
	public boolean hasSword() {
		return sword;
	}

	public void setHasSword(boolean sword) {
		this.sword = sword;
	}

	public void addRupees(int amount) {
		rupees += amount;
	}
	
	public int getRupees() {
		return rupees;
	}
	
	public Rectangle getHitBox() {
		return hitBox;
	}
	
	public void heal(int amount) {
		health += amount;
		if(health > maxHealth)
			health = maxHealth;
	}
	
	public void increaseHealth() {
		this.maxHealth += 4;
		this.health = maxHealth;
	}
	
	public int getEsaforce() {
		return esaforce;
	}
	
	public void addEsaforce() {
		this.esaforce++;
	}
}
