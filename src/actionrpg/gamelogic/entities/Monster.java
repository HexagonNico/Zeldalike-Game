package actionrpg.gamelogic.entities;

import java.util.Random;

import actionrpg.utils.Direction;

public class Monster extends NonStaticEntity {

	private Random random;
	private byte stepsCount;
	
	private int range;
	private Player target;
	
	public Monster(Player target, int startPosX, int startPosY, int health) {
		super(startPosX*32, startPosY*32, health, 2);
		
		this.random = new Random();
		this.stepsCount = 0;
		
		this.range = 150;
		this.target = target;
	}
	
	public void move() {
		if(stepsCount > 50)
			resetSteps();
		
		if(stepsCount % 2 == 0) {
			switch(facing) {
			case DOWN:
				posY++;
				break;
			case LEFT:
				posX--;
				break;
			case RIGHT:
				posX++;
				break;
			case UP:
				posY--;
				break;
			}
		}
		
		stepsCount++;
		
		boundingBox.setLocation(posX, posY);
		
		animationFrame++;
		if(animationFrame == 30) animationFrame = 0;
	}
	
	public void resetSteps() {
		switch(random.nextInt(4)) {
		case 0:
			setFacing(Direction.DOWN);
			break;
		case 1:
			setFacing(Direction.LEFT);
			break;
		case 2:
			setFacing(Direction.RIGHT);
			break;
		case 3:
			setFacing(Direction.UP);
			break;
		}
		stepsCount = (byte) random.nextInt(20);
	}
	
	/**Inverts facing direction*/
	public void turnBack() {
		switch(facing) {
		case DOWN:
			setFacing(Direction.UP);
			break;
		case LEFT:
			setFacing(Direction.RIGHT);
			break;
		case RIGHT:
			setFacing(Direction.LEFT);
			break;
		case UP:
			setFacing(Direction.DOWN);
			break;
		}
	}
	
	public void detectPlayer() {
		float ac = -((float)target.getPosY()-(float)posY)/((float)target.getPosX()-(float)posX);
		float distance = (float) Math.sqrt(Math.pow(target.getPosX()-posX, 2)+Math.pow(target.getPosY()-posY, 2));
		
		if(distance < range) {
			if(ac>-1 && ac<1 && target.getPosX()<posX) {
				setFacing(Direction.LEFT);
			} else if((ac<-1 || ac>1) && target.getPosY()<posY) {
				setFacing(Direction.UP);
			} else if(ac>-1 && ac<1 && target.getPosX()>posX) {
				setFacing(Direction.RIGHT);
			} else if((ac<-1 || ac>1) && target.getPosY()>posY) {
				setFacing(Direction.DOWN);
			}
//			else {
//				System.out.println("[Monster]: I don't know what to do...");
//			}
		}
	}
}
