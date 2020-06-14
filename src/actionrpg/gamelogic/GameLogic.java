package actionrpg.gamelogic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import actionrpg.gamelogic.entities.Collectible;
import actionrpg.gamelogic.entities.Monster;
import actionrpg.gamelogic.entities.NonStaticEntity;
import actionrpg.gamelogic.entities.Player;
import actionrpg.gamelogic.world.Area;
import actionrpg.gamelogic.world.Tile;
import actionrpg.gamelogic.world.WorldMap;
import actionrpg.gui.DisplayManager;
import actionrpg.utils.Direction;
import actionrpg.utils.ResourceManager;

public class GameLogic {

	private static final int TIME = 10;
	private static Timer timer;
	private static Random randomizer;
	private static boolean gameStarted = false;
	
	private static WorldMap worldMap;
	private static Area currentArea;
	private static Player player;
	private static List<Monster> activeMonsters;
	private static List<Collectible> loot;
	
	/**Creates a Timer objects and starts the timer*/
	public static void startGame() {
		timer = new Timer(TIME, new GameLoop());
		randomizer = new Random();

		player = new Player(19, 8);
		
		worldMap = new WorldMap();
		buildWorld();
		
		activeMonsters = currentArea.getAreaMonsters();
		
		loot = new ArrayList<Collectible>();
		
		gameStarted = true;
		timer.start();
		
		System.out.println("[GameLogic]: Game Started");
	}
	
	/**Detects collision and moves player*/
	public static void handlePlayerMovement(Direction direction) {
		player.setFacing(direction);
		if(entityCanMove(player) && player.getHealth()>0)
			player.move();
	}
	
	/**Checks if the player is outside this area then changes it*/
	public static void changeArea() {
		if(player.getPosX() > DisplayManager.WINDOW_WIDTH-32) {
			currentArea = worldMap.getAreaAtCoords(currentArea.getCoordX()+1, currentArea.getCoordY());
			player.setPositionX(1);
			activeMonsters = currentArea.getAreaMonsters();
			loot.clear();
		}
		else if(player.getPosX() < 0) {
			currentArea = worldMap.getAreaAtCoords(currentArea.getCoordX()-1, currentArea.getCoordY());
			player.setPositionX(DisplayManager.WINDOW_WIDTH-32);
			activeMonsters = currentArea.getAreaMonsters();
			loot.clear();
		}
		else if(player.getPosY() > DisplayManager.WINDOW_HEIGHT-32) {
			currentArea = worldMap.getAreaAtCoords(currentArea.getCoordX(), currentArea.getCoordY()+1);
			player.setPositionY(1);
			activeMonsters = currentArea.getAreaMonsters();
			loot.clear();
		}
		else if(player.getPosY() < 0) {
			currentArea = worldMap.getAreaAtCoords(currentArea.getCoordX(), currentArea.getCoordY()-1);
			player.setPositionY(DisplayManager.WINDOW_HEIGHT-32);
			activeMonsters = currentArea.getAreaMonsters();
			loot.clear();
		}
		
		if(currentArea.getCoordX() == 0 && currentArea.getCoordY() == 6)
			player.setHasSword(true);
	}
	
	/**Changes the value of player's attackTime*/
	public static void handlePlayerAttacks(boolean shouldAttack) {
		player.decreaseAttackTime();
		
		if(!player.hasSword())
			return;
		
		if(shouldAttack && player.getAttackTime() < 0) {
			player.setAttackTime(50);
		}
		
		for(int i=0;i<activeMonsters.size();i++) {
			if(player.getHitBox().intersects(activeMonsters.get(i).getBoundingBox()) && player.getAttackTime() == 12) {
				activeMonsters.get(i).damage(player.getAttackDamage());
			}
		}
	}
	
	public static void handleMonsterMovement() {
		for(Monster monster : activeMonsters) {
			
			monster.decreaseAttackTime();
			monster.detectPlayer();
			
			if(entityCanMove(monster)) {
				monster.move();
			}
			else {
				monster.turnBack();
			}
			
			if(monster.getBoundingBox().intersects(player.getBoundingBox()) && monster.getAttackTime() == -49 && player.getHealth() > 0) {
				player.damage(monster.getAttackDamage());
			}
		}
		
	}
	
	public static void handleMonsterDrops() {
		for(int i=0;i<activeMonsters.size();i++) {
			if(activeMonsters.get(i).getHealth() <= 0) {
				
				if(activeMonsters.get(i).getMaxHealth() == 40) {
					loot.add(new Collectible(activeMonsters.get(i).getPosX(), activeMonsters.get(i).getPosY(), Collectible.Type.HEART_CONTAINER));
					activeMonsters.remove(i);
					player.addEsaforce();
					return;
				}
				
				switch(randomizer.nextInt(5)) {
				case 0:
					loot.add(new Collectible(activeMonsters.get(i).getPosX(), activeMonsters.get(i).getPosY(), Collectible.Type.GREEN_RUPEE));
					break;
				case 1:
					loot.add(new Collectible(activeMonsters.get(i).getPosX(), activeMonsters.get(i).getPosY(), Collectible.Type.BLUE_RUPEE));
					break;
				case 2:
					loot.add(new Collectible(activeMonsters.get(i).getPosX(), activeMonsters.get(i).getPosY(), Collectible.Type.HEART));
					break;
				default:
					continue;
				}
				activeMonsters.remove(i);
			}
		}
	}
	
	public static void handlePickUpLoot() {
		for(int i=0;i<loot.size();i++) {
			if(loot.get(i).getBoundingBox().intersects(player.getBoundingBox())) {
				switch(loot.get(i).getType()) {
				case GREEN_RUPEE:
					player.addRupees(1);
					break;
				case BLUE_RUPEE:
					player.addRupees(5);
					break;
				case HEART:
					player.heal(4);
					break;
				case HEART_CONTAINER:
					player.increaseHealth();
					break;
				default:
					break;
				}
				loot.remove(i);
			}
		}
	}
	
	/**Called when 'E' is pressed<br>
	 * Checks if player has something in from he can interact with
	 */
	public static void interact() {
		
		Tile tile = null;
		for(int y=0;y<currentArea.getSizeY();y++) {
			for(int x=0;x<currentArea.getSizeX();x++) {
				tile = currentArea.getTile(x, y);
				if(player.getHitBox().intersects(tile.getBoundingBox()) && (tile.getTileName().contains("door") || tile.getTileName().contains("cave"))) {
					switch(player.getFacing()) {
					case DOWN:
						currentArea = worldMap.getAreaAtCoords(currentArea.getCoordX(), currentArea.getCoordY()+1);
						activeMonsters = currentArea.getAreaMonsters();
						player.setPosition(player.getPosX(), -player.getPosY()+DisplayManager.WINDOW_HEIGHT-32);
						return;
					case LEFT:
						currentArea = worldMap.getAreaAtCoords(currentArea.getCoordX()-1, currentArea.getCoordY());
						activeMonsters = currentArea.getAreaMonsters();
						player.setPosition(-player.getPosX()+DisplayManager.WINDOW_WIDTH-32, player.getPosY());
						return;
					case RIGHT:
						currentArea = worldMap.getAreaAtCoords(currentArea.getCoordX()+1, currentArea.getCoordY());
						activeMonsters = currentArea.getAreaMonsters();
						player.setPosition(-player.getPosX()+DisplayManager.WINDOW_WIDTH-32, player.getPosY());
						return;
					case UP:
						currentArea = worldMap.getAreaAtCoords(currentArea.getCoordX(), currentArea.getCoordY()-1);
						activeMonsters = currentArea.getAreaMonsters();
						player.setPosition(player.getPosX(), -player.getPosY()+DisplayManager.WINDOW_HEIGHT-32);
						return;
					}
				}
			}
		}
	}
	
	private static boolean entityCanMove(NonStaticEntity entity) {
		switch(entity.getFacing()) {
		case DOWN:
			for(int y=0;y<currentArea.getSizeY();y++) {
				for(int x=0;x<currentArea.getSizeX();x++) {
					if(currentArea.getTile(x, y).isBlock()) {
						Point upperLeft = currentArea.getTile(x, y).getBoundingBox().getLocation();
						if((upperLeft.x < entity.getPosX() && entity.getPosX() < upperLeft.x+32 && entity.getPosY()+32 == upperLeft.y) ||
							(upperLeft.x < entity.getPosX()+32 && entity.getPosX()+32 < upperLeft.x+32 && entity.getPosY()+32 == upperLeft.y) ||
							(upperLeft.x == entity.getPosX() && upperLeft.x+32 == entity.getPosX()+32 && entity.getPosY()+32 == upperLeft.y)) {
							return false;
						}
					}
				}
			}
			break;
		case LEFT:
			for(int y=0;y<currentArea.getSizeY();y++) {
				for(int x=0;x<currentArea.getSizeX();x++) {
					if(currentArea.getTile(x, y).isBlock()) {
						Point upperLeft = currentArea.getTile(x, y).getBoundingBox().getLocation();
						if((upperLeft.y < entity.getPosY() && entity.getPosY() < upperLeft.y+32 && entity.getPosX() == upperLeft.x+32) ||
							(upperLeft.y < entity.getPosY()+32 && entity.getPosY()+32 < upperLeft.y+32 && entity.getPosX() == upperLeft.x+32) ||
							(upperLeft.y == entity.getPosY() && upperLeft.y+32 == entity.getPosY()+32 && entity.getPosX() == upperLeft.x+32)) {
							return false;
						}
					}
				}
			}
			break;
		case RIGHT:
			for(int y=0;y<currentArea.getSizeY();y++) {
				for(int x=0;x<currentArea.getSizeX();x++) {
					if(currentArea.getTile(x, y).isBlock()) {
						Point upperLeft = currentArea.getTile(x, y).getBoundingBox().getLocation();
						if((upperLeft.y < entity.getPosY() && entity.getPosY() < upperLeft.y+32 && entity.getPosX()+32 == upperLeft.x) ||
							(upperLeft.y < entity.getPosY()+32 && entity.getPosY()+32 < upperLeft.y+32 && entity.getPosX()+32 == upperLeft.x) ||
							(upperLeft.y == entity.getPosY() && upperLeft.y+32 == entity.getPosY()+32 && entity.getPosX()+32 == upperLeft.x)) {
							return false;
						}
					}
				}
			}
			break;
		case UP:
			for(int y=0;y<currentArea.getSizeY();y++) {
				for(int x=0;x<currentArea.getSizeX();x++) {
					if(currentArea.getTile(x, y).isBlock()) {
						Point upperLeft = currentArea.getTile(x, y).getBoundingBox().getLocation();
						if((upperLeft.x < entity.getPosX() && entity.getPosX() < upperLeft.x+32 && entity.getPosY() == upperLeft.y+32) ||
							(upperLeft.x < entity.getPosX()+32 && entity.getPosX()+32 < upperLeft.x+32 && entity.getPosY() == upperLeft.y+32) ||
							(upperLeft.x == entity.getPosX() && upperLeft.x+32 == entity.getPosX()+32 && entity.getPosY() == upperLeft.y+32)) {
							return false;
						}
					}
				}
			}
			break;
		}
		return true;
	}
	
	public static boolean isGameStarted() {
		return gameStarted;
	}
	
	public static Area getCurrentArea() {
		return currentArea;
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public static List<Monster> getActiveMonsters() {
		return activeMonsters;
	}
	
	public static List<Collectible> getLoot() {
		return loot;
	}
	
	private static void buildWorld() {
		Area spawn = new Area(ResourceManager.LEVEL_SPAWN, 1, 8);
		Area monstersArea = new Area(ResourceManager.LEVEL_MONSTERS, 1, 7);
		Area oldMand = new Area(ResourceManager.LEVEL_OLD_MAN, 0, 7);
		Area house = new Area(ResourceManager.OLD_MAN_HOUSE, 0, 6);
		Area pathArea = new Area(ResourceManager.PATH_AREA, 2, 7);
		Area path2 = new Area(ResourceManager.PATH_AREA_2, 3, 7);
		Area path3 = new Area(ResourceManager.PATH_AREA_3, 3, 8);
		Area lakeside = new Area(ResourceManager.LAKESIDE_AREA, 4, 8);
		Area lakeside2 = new Area(ResourceManager.LAKESIDE_AREA_2, 4, 7);
		Area lakeside3 = new Area(ResourceManager.LAKESIDE_AREA_3, 4, 6);
		Area caveEntrance = new Area(ResourceManager.CAVE_ENTRANCE, 3, 6);
		Area caveEntrance2 = new Area(ResourceManager.CAVE_ENTRANCE_2, 2, 6);
		Area cave = new Area(ResourceManager.CAVE_AREA, 3, 5);
		Area cave2 = new Area(ResourceManager.CAVE_AREA_2, 4, 5);
		Area cave3 = new Area(ResourceManager.CAVE_AREA_3, 5, 5);
		Area dungeonEntrance = new Area(ResourceManager.DUNGEON_ENTRANCE, 5, 4);
		Area dungeonEntrance2 = new Area(ResourceManager.DUNGEON_ENTRANCE_2, 4, 4);
		Area dungeon = new Area(ResourceManager.DUNGEON_INTERSECTION, 4, 3);
		Area dungeonL1 = new Area(ResourceManager.DUNGEON_L1, 3, 3);
		Area dungeonL2 = new Area(ResourceManager.DUNGEON_L2, 3, 4);
		Area dungeonR = new Area(ResourceManager.DUNGEON_R, 5, 3);
		Area dungeon2 = new Area(ResourceManager.DUNGEON_2, 4, 2);
		Area dungeonBoss = new Area(ResourceManager.DUNGEON_BOSS, 4, 1);
		
		monstersArea.spawnMonster(new Monster(player, 20, 6, 4));
		monstersArea.spawnMonster(new Monster(player, 21, 8, 4));
		pathArea.spawnMonster(new Monster(player, 14, 4, 4));
		path2.spawnMonster(new Monster(player, 20, 5, 4));
		path2.spawnMonster(new Monster(player, 16, 3, 4));
		path2.spawnMonster(new Monster(player, 19, 9, 4));
		path3.spawnMonster(new Monster(player, 19, 5, 4));
		path3.spawnMonster(new Monster(player, 7, 11, 6));
		lakeside.spawnMonster(new Monster(player, 13, 8, 6));
		lakeside2.spawnMonster(new Monster(player, 12, 4, 6));
		lakeside2.spawnMonster(new Monster(player, 13, 10, 4));
		lakeside3.spawnMonster(new Monster(player, 4, 11, 4));
		lakeside3.spawnMonster(new Monster(player, 10, 3, 4));
		lakeside3.spawnMonster(new Monster(player, 19, 9, 6));
		caveEntrance.spawnMonster(new Monster(player, 12, 7, 4));
		caveEntrance2.spawnMonster(new Monster(player, 13, 7, 6));
		caveEntrance2.spawnMonster(new Monster(player, 14, 8, 4));
		caveEntrance2.spawnMonster(new Monster(player, 13, 9, 6));
		cave.spawnMonster(new Monster(player, 15, 5, 4));
		cave2.spawnMonster(new Monster(player, 4, 4, 6));
		cave2.spawnMonster(new Monster(player, 8, 11, 4));
		cave2.spawnMonster(new Monster(player, 16, 8, 6));
		cave3.spawnMonster(new Monster(player, 17, 5, 6));
		cave3.spawnMonster(new Monster(player, 20, 7, 6));
		dungeonEntrance.spawnMonster(new Monster(player, 11, 4, 4));
		dungeonEntrance2.spawnMonster(new Monster(player, 9, 6, 6));
		dungeonL1.spawnMonster(new Monster(player, 14, 6, 6));
		dungeonL2.spawnMonster(new Monster(player, 9, 8, 4));
		dungeonL2.spawnMonster(new Monster(player, 15, 10, 10));
		dungeonR.spawnMonster(new Monster(player, 17, 6, 10));
		dungeonR.spawnMonster(new Monster(player, 15, 6, 6));
		dungeon2.spawnMonster(new Monster(player, 7, 4, 4));
		dungeon2.spawnMonster(new Monster(player, 9, 4, 4));
		dungeon2.spawnMonster(new Monster(player, 11, 4, 4));
		dungeon2.spawnMonster(new Monster(player, 13, 4, 4));
		dungeonBoss.spawnMonster(new Monster(player, 10, 3, 40));
		
		worldMap.addArea(spawn);
		worldMap.addArea(monstersArea);
		worldMap.addArea(oldMand);
		worldMap.addArea(house);
		worldMap.addArea(pathArea);
		worldMap.addArea(path2);
		worldMap.addArea(path3);
		worldMap.addArea(lakeside);
		worldMap.addArea(lakeside2);
		worldMap.addArea(lakeside3);
		worldMap.addArea(caveEntrance);
		worldMap.addArea(caveEntrance2);
		worldMap.addArea(cave);
		worldMap.addArea(cave2);
		worldMap.addArea(cave3);
		worldMap.addArea(dungeonEntrance);
		worldMap.addArea(dungeonEntrance2);
		worldMap.addArea(dungeon);
		worldMap.addArea(dungeonL1);
		worldMap.addArea(dungeonL2);
		worldMap.addArea(dungeonR);
		worldMap.addArea(dungeon2);
		worldMap.addArea(dungeonBoss);
		
		currentArea = spawn;
	}
}
