package actionrpg.gamelogic.world;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import actionrpg.gamelogic.entities.Monster;

public class Area {
	
	private int coordX;
	private int coordY;
	
	private String[][] data;
	private Tile[][] tiles;
	
	private List<Monster> areaMonsters;
	
	public Area(BufferedImage levelData, int coordX, int coordY) {
		System.out.println("[Area]: Creating "+coordX+" "+coordY);
		
		this.tiles = new Tile[levelData.getWidth()][levelData.getHeight()];
		this.data = new String[levelData.getWidth()][levelData.getHeight()];
		
		this.coordX = coordX;
		this.coordY = coordY;
		
		for(int y=0;y<levelData.getHeight();y++) {
			for(int x=0;x<levelData.getWidth();x++) {
				//System.out.print(levelData.getRGB(x, y)+" ");
				switch(levelData.getRGB(x, y)) {
				case -14254336:
					tiles[x][y] = new Tile(x*32, y*32, true, "bush");
					break;
				case -16711903:
					tiles[x][y] = new Tile(x*32, y*32, false, "grass");
					break;
				case -10240:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_tile");
					break;
				case -4784384:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_side_bottom");
					break;
				case -5377536:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_corner_bottom_left");
					break;
				case -5970688:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_side_left");
					break;
				case -6563840:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_corner_top_left");
					break;
				case -7156736:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_side_top");
					break;
				case -7749888:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_corner_top_right");
					break;
				case -8408576:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_angle_top_right");
					break;
				case -9594624:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_side_right");
					break;
				case -10187776:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_angle_bottom_left");
					break;
				case -10780928:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_angle_bottom_right");
					break;
				case -11374080:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_corner_bottom_right");
					break;
				case -11901440:
					tiles[x][y] = new Tile(x*32, y*32, false, "path_angle_top_left");
					break;
				case -65536:
					tiles[x][y] = new Tile(x*32, y*32, true, "brick_tile");
					break;
				case -8355712:
					tiles[x][y] = new Tile(x*32, y*32, true, "stone_tile");
					break;
				case -8441088:
					tiles[x][y] = new Tile(x*32, y*32, true, "wood");
					break;
				case -16711681:
					tiles[x][y] = new Tile(x*32, y*32, true, "door_tile");
					break;
				case -16744690:
					tiles[x][y] = new Tile(x*32, y*32, true, "old_man");
					break;
				case -16767233:
					tiles[x][y] = new Tile(x*32, y*32, true, "water_tile");
					break;
				case -14268673:
					tiles[x][y] = new Tile(x*32, y*32, false, "water_angle_bottom_right");
					break;
				case -15123457:
					tiles[x][y] = new Tile(x*32, y*32, false, "water_corner_bottom_right");
					break;
				case -15977985:
					tiles[x][y] = new Tile(x*32, y*32, false, "water_side_right");
					break;
				case -13479425:
					tiles[x][y] = new Tile(x*32, y*32, false, "water_side_bottom");
					break;
				case -13619152:
					tiles[x][y] = new Tile(x*32, y*32, true, "cave");
					break;
				case -3947581:
					tiles[x][y] = new Tile(x*32, y*32, false, "dungeon_floor");
					break;
				case -5111553:
					tiles[x][y] = new Tile(x*32, y*32, true, "dungeon_brick");
					break;
				default:
					tiles[x][y] = new Tile(x*32, y*32, true, "ERROR ERROR ERROR");
					break;
				}
			}
			//System.out.print("\n");
		}
		
		areaMonsters = new ArrayList<Monster>();
	}
	
	public int getCoordX() {
		return coordX;
	}
	
	public int getCoordY() {
		return coordY;
	}
	
	public int getSizeX() {
		return tiles[0].length;
	}
	
	public int getSizeY() {
//		for(int i=0;i<getDataLines();i++) {
//			if(data[i][0].contains("/")) return i;
//		}
//		return getDataLines();
		return tiles.length;
	}
	
	public int getDataLines() {
		return data.length;
	}
	
	public String getTileName(int x, int y) {
		return tiles[x][y].getTileName();
	}
	
	public Tile getTile(int x, int y) {
		return tiles[y][x];
	}
	
	public List<Monster> getAreaMonsters() {
		return areaMonsters;
	}
	
	public void spawnMonster(Monster monster) {
		this.areaMonsters.add(monster);
	}
}