package actionrpg.utils;

import java.awt.image.BufferedImage;
//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import javax.imageio.ImageIO;

public class ResourceManager {
	
	public static final BufferedImage GRASS;
	public static final BufferedImage PATH;
	public static final BufferedImage STONE;
	public static final BufferedImage DOOR;
	public static final BufferedImage BRICK;
	public static final BufferedImage PATH_OVERLAY;
	public static final BufferedImage PATH_CORNER;
	public static final BufferedImage PATH_ANGLE;
	public static final BufferedImage BUSH;
	public static final BufferedImage WOOD;
	public static final BufferedImage WATER;
	public static final BufferedImage WATER_SIDE;
	public static final BufferedImage WATER_CORNER;
	public static final BufferedImage WATER_ANGLE;
	public static final BufferedImage CAVE;
	public static final BufferedImage DUNGEON_BRICK;
	public static final BufferedImage DUNGEON_FLOOR;

	public static final BufferedImage OLD_MAN;
	
	public static final BufferedImage PLAYER;
	public static final BufferedImage PLAYER_1;
	public static final BufferedImage PLAYER_BACK;
	public static final BufferedImage PLAYER_BACK_1;
	public static final BufferedImage PLAYER_LEFT;
	public static final BufferedImage PLAYER_LEFT_1;
	public static final BufferedImage PLAYER_RIGHT;
	public static final BufferedImage PLAYER_RIGHT_1;
	
	public static final BufferedImage SWORD;
	
	public static final BufferedImage PLAYER_ATTACK;
	public static final BufferedImage PLAYER_ATTACK_1;
	public static final BufferedImage PLAYER_ATTACK_BACK;
	public static final BufferedImage PLAYER_ATTACK_BACK_1;
	public static final BufferedImage PLAYER_ATTACK_LEFT;
	public static final BufferedImage PLAYER_ATTACK_LEFT_1;
	public static final BufferedImage PLAYER_ATTACK_RIGHT;
	public static final BufferedImage PLAYER_ATTACK_RIGHT_1;
	
	public static final BufferedImage MONSTER;
	public static final BufferedImage MONSTER_1;
	public static final BufferedImage MONSTER_BACK;
	public static final BufferedImage MONSTER_BACK_1;
	public static final BufferedImage MONSTER_LEFT;
	public static final BufferedImage MONSTER_LEFT_1;
	public static final BufferedImage MONSTER_RIGHT;
	public static final BufferedImage MONSTER_RIGHT_1;

	public static final BufferedImage MONSTER2;
	public static final BufferedImage MONSTER2_1;
	public static final BufferedImage MONSTER2_BACK;
	public static final BufferedImage MONSTER2_BACK_1;
	public static final BufferedImage MONSTER2_LEFT;
	public static final BufferedImage MONSTER2_LEFT_1;
	public static final BufferedImage MONSTER2_RIGHT;
	public static final BufferedImage MONSTER2_RIGHT_1;

	public static final BufferedImage MONSTER3;
	public static final BufferedImage MONSTER3_1;
	public static final BufferedImage MONSTER3_BACK;
	public static final BufferedImage MONSTER3_BACK_1;
	public static final BufferedImage MONSTER3_LEFT;
	public static final BufferedImage MONSTER3_LEFT_1;
	public static final BufferedImage MONSTER3_RIGHT;
	public static final BufferedImage MONSTER3_RIGHT_1;

	public static final BufferedImage MONSTER4;
	public static final BufferedImage MONSTER4_1;
	public static final BufferedImage MONSTER4_BACK;
	public static final BufferedImage MONSTER4_BACK_1;
	public static final BufferedImage MONSTER4_LEFT;
	public static final BufferedImage MONSTER4_LEFT_1;
	public static final BufferedImage MONSTER4_RIGHT;
	public static final BufferedImage MONSTER4_RIGHT_1;
	
	public static final BufferedImage HEART;
	public static final BufferedImage HEART_3_4;
	public static final BufferedImage HEART_1_2;
	public static final BufferedImage HEART_1_4;
	public static final BufferedImage HEART_0;

	public static final BufferedImage GREEN_RUPEE;
	public static final BufferedImage BLUE_RUPEE;
	public static final BufferedImage HEART_CONTAINER;
	
	public static final BufferedImage LEVEL_SPAWN;
	public static final BufferedImage LEVEL_MONSTERS;
	public static final BufferedImage LEVEL_OLD_MAN;
	public static final BufferedImage OLD_MAN_HOUSE;
	public static final BufferedImage PATH_AREA;
	public static final BufferedImage PATH_AREA_2;
	public static final BufferedImage PATH_AREA_3;
	public static final BufferedImage LAKESIDE_AREA;
	public static final BufferedImage LAKESIDE_AREA_2;
	public static final BufferedImage LAKESIDE_AREA_3;
	public static final BufferedImage CAVE_ENTRANCE;
	public static final BufferedImage CAVE_ENTRANCE_2;
	public static final BufferedImage CAVE_AREA;
	public static final BufferedImage CAVE_AREA_2;
	public static final BufferedImage CAVE_AREA_3;
	public static final BufferedImage DUNGEON_ENTRANCE;
	public static final BufferedImage DUNGEON_ENTRANCE_2;
	public static final BufferedImage DUNGEON_INTERSECTION;
	public static final BufferedImage DUNGEON_L1;
	public static final BufferedImage DUNGEON_L2;
	public static final BufferedImage DUNGEON_R;
	public static final BufferedImage DUNGEON_2;
	public static final BufferedImage DUNGEON_BOSS;
	
	static {
		GRASS = readImageFile("tiles/grass_tile");
		PATH = readImageFile("tiles/path_tile");
		STONE = readImageFile("tiles/stone_tile");
		DOOR = readImageFile("tiles/door_tile");
		BRICK = readImageFile("tiles/brick_tile");
		PATH_OVERLAY = readImageFile("tiles/path_side_overlay");
		PATH_CORNER = readImageFile("tiles/path_corner_overlay");
		PATH_ANGLE = readImageFile("tiles/path_angle_overlay");
		BUSH = readImageFile("tiles/bush_overlay");
		WOOD = readImageFile("tiles/wood_overlay");
		WATER = readImageFile("tiles/water");
		WATER_SIDE = readImageFile("tiles/water_side");
		WATER_CORNER = readImageFile("tiles/water_corner");
		WATER_ANGLE = readImageFile("tiles/water_angle");
		CAVE = readImageFile("tiles/cave");
		DUNGEON_BRICK = readImageFile("tiles/dungeon_brick");
		DUNGEON_FLOOR = readImageFile("tiles/dungeon_floor");
		
		OLD_MAN = readImageFile("tiles/old_man");
		
		PLAYER = readImageFile("entities/player");
		PLAYER_1 = readImageFile("entities/player_1");
		PLAYER_BACK = readImageFile("entities/player_back");
		PLAYER_BACK_1 = readImageFile("entities/player_back_1");
		PLAYER_LEFT = readImageFile("entities/player_left");
		PLAYER_LEFT_1 = readImageFile("entities/player_left_1");
		PLAYER_RIGHT = readImageFile("entities/player_right");
		PLAYER_RIGHT_1 = readImageFile("entities/player_right_1");
		
		SWORD = readImageFile("icons/sword");

		PLAYER_ATTACK = readImageFile("entities/player_attack");
		PLAYER_ATTACK_1 = readImageFile("entities/player_attack_1");
		PLAYER_ATTACK_BACK = readImageFile("entities/player_attack_back");
		PLAYER_ATTACK_BACK_1 = readImageFile("entities/player_attack_back_1");
		PLAYER_ATTACK_LEFT = readImageFile("entities/player_attack_left");
		PLAYER_ATTACK_LEFT_1 = readImageFile("entities/player_attack_left_1");
		PLAYER_ATTACK_RIGHT = readImageFile("entities/player_attack_right");
		PLAYER_ATTACK_RIGHT_1 = readImageFile("entities/player_attack_right_1");
		
		MONSTER = readImageFile("entities/monster");
		MONSTER_1 = readImageFile("entities/monster_1");
		MONSTER_BACK = readImageFile("entities/monster_back");
		MONSTER_BACK_1 = readImageFile("entities/monster_back_1");
		MONSTER_LEFT = readImageFile("entities/monster_left");
		MONSTER_LEFT_1 = readImageFile("entities/monster_left_1");
		MONSTER_RIGHT = readImageFile("entities/monster_right");
		MONSTER_RIGHT_1 = readImageFile("entities/monster_right_1");

		MONSTER2 = readImageFile("entities/monster2");
		MONSTER2_1 = readImageFile("entities/monster2_1");
		MONSTER2_BACK = readImageFile("entities/monster2_back");
		MONSTER2_BACK_1 = readImageFile("entities/monster2_back_1");
		MONSTER2_LEFT = readImageFile("entities/monster2_left");
		MONSTER2_LEFT_1 = readImageFile("entities/monster2_left_1");
		MONSTER2_RIGHT = readImageFile("entities/monster2_right");
		MONSTER2_RIGHT_1 = readImageFile("entities/monster2_right_1");

		MONSTER3 = readImageFile("entities/monster3");
		MONSTER3_1 = readImageFile("entities/monster3_1");
		MONSTER3_BACK = readImageFile("entities/monster3_back");
		MONSTER3_BACK_1 = readImageFile("entities/monster3_back_1");
		MONSTER3_LEFT = readImageFile("entities/monster3_left");
		MONSTER3_LEFT_1 = readImageFile("entities/monster3_left_1");
		MONSTER3_RIGHT = readImageFile("entities/monster3_right");
		MONSTER3_RIGHT_1 = readImageFile("entities/monster3_right_1");

		MONSTER4 = readImageFile("entities/monster4");
		MONSTER4_1 = readImageFile("entities/monster4_1");
		MONSTER4_BACK = readImageFile("entities/monster4_back");
		MONSTER4_BACK_1 = readImageFile("entities/monster4_back_1");
		MONSTER4_LEFT = readImageFile("entities/monster4_left");
		MONSTER4_LEFT_1 = readImageFile("entities/monster4_left_1");
		MONSTER4_RIGHT = readImageFile("entities/monster4_right");
		MONSTER4_RIGHT_1 = readImageFile("entities/monster4_right_1");
		
		HEART = readImageFile("icons/heart");
		HEART_3_4 = readImageFile("icons/heart_3_4");
		HEART_1_2 = readImageFile("icons/heart_1_2");
		HEART_1_4 = readImageFile("icons/heart_1_4");
		HEART_0 = readImageFile("icons/heart_0");

		GREEN_RUPEE = readImageFile("icons/green_rupee");
		BLUE_RUPEE = readImageFile("icons/blue_rupee");
		HEART_CONTAINER = readImageFile("icons/heart_container");
		
		LEVEL_SPAWN = readImageFile("maps/spawn");
		LEVEL_MONSTERS = readImageFile("maps/area_monsters");
		LEVEL_OLD_MAN = readImageFile("maps/area_old_man");
		OLD_MAN_HOUSE = readImageFile("maps/old_man_house");
		PATH_AREA = readImageFile("maps/path");
		PATH_AREA_2 = readImageFile("maps/path_2");
		PATH_AREA_3 = readImageFile("maps/path_3");
		LAKESIDE_AREA = readImageFile("maps/lakeside");
		LAKESIDE_AREA_2 = readImageFile("maps/lakeside_2");
		LAKESIDE_AREA_3 = readImageFile("maps/lakeside_3");
		CAVE_ENTRANCE = readImageFile("maps/cave_entrance");
		CAVE_ENTRANCE_2 = readImageFile("maps/cave_entrance_2");
		CAVE_AREA = readImageFile("maps/cave");
		CAVE_AREA_2 = readImageFile("maps/cave_2");
		CAVE_AREA_3 = readImageFile("maps/cave_3");
		DUNGEON_ENTRANCE = readImageFile("maps/dungeon_entrance");
		DUNGEON_ENTRANCE_2 = readImageFile("maps/dungeon_entrance_2");
		DUNGEON_INTERSECTION = readImageFile("maps/dungeon_intersection");
		DUNGEON_L1 = readImageFile("maps/dungeon_left_1");
		DUNGEON_L2 = readImageFile("maps/dungeon_left_2");
		DUNGEON_R = readImageFile("maps/dungeon_right_1");
		DUNGEON_2 = readImageFile("maps/dungeon_2");
		DUNGEON_BOSS = readImageFile("maps/dungeon_boss");
	}
	
	private static BufferedImage readImageFile(String fileName) {
		BufferedImage img = null;
		System.out.println("[ResourceManager]: Reading "+fileName+".png");
		
		try {
			img = ImageIO.read(new File("res/"+fileName+".png"));
		} catch (IOException e) {
			System.err.println("[ResourceManager]: Error when reading res/textures/"+fileName+".png");
			System.exit(-1);
		}
		
		return img;
	}
}
