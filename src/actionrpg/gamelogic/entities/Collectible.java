package actionrpg.gamelogic.entities;

public class Collectible extends Entity {

	private Type type;
	
	public Collectible(int posX, int posY, Type type) {
		super(posX, posY);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public enum Type {
		GREEN_RUPEE,
		BLUE_RUPEE,
		HEART,
		HEART_CONTAINER;
	}
}
