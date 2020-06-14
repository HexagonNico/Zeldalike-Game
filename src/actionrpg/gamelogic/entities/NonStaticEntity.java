package actionrpg.gamelogic.entities;

import actionrpg.utils.Direction;

public class NonStaticEntity extends Entity {

	protected Direction facing;
	
	protected byte health;
	protected byte maxHealth;
	protected byte attackDamage;
	
	protected byte animationFrame;
	protected byte attackTime;
	
	public NonStaticEntity(int posX, int posY, int health, int attackDamage) {
		super(posX, posY);
		this.facing = Direction.DOWN;
		
		this.health = (byte) health;
		this.maxHealth = (byte) health;
		this.attackDamage = (byte) attackDamage;
		
		this.animationFrame = 0;
		this.attackTime = 0;
	}
	
	public Direction getFacing() {
		return facing;
	}
	
	public void setFacing(Direction facing) {
		this.facing = facing;
	}
	
	public int getHealth() {
		return health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void damage(int amount) {
		health-=amount;
	}
	
	public int getAttackDamage() {
		return attackDamage;
	}
	
	public byte getAnimationFrame() {
		return animationFrame;
	}
	
	public void decreaseAttackTime() {
		this.attackTime--;
		if(attackTime == -50) attackTime = -1;
	}
	
	public void setAttackTime(int attackTime) {
		this.attackTime = (byte) attackTime;
	}
	
	public short getAttackTime() {
		return attackTime;
	}

}
