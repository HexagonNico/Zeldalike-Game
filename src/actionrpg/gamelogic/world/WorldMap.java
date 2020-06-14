package actionrpg.gamelogic.world;

public class WorldMap {

	private Area[][] map;
	
	public WorldMap() {
		this.map = new Area[10][10];
	}
	
	public boolean addArea(Area area) {
		if(area.getCoordX() > 9 || area.getCoordX() < 0 || area.getCoordY() > 9 || area.getCoordY() < 0)
			return false;
		
		this.map[area.getCoordX()][area.getCoordY()] = area;
		return true;
	}
	
	public Area getAreaAtCoords(int coordX, int coordY) {
		return map[coordX][coordY];
	}
}
