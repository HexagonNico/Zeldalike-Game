package actionrpg.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import actionrpg.gamelogic.entities.Collectible;
import actionrpg.gamelogic.entities.Monster;
import actionrpg.gamelogic.entities.Player;
import actionrpg.gamelogic.world.Area;
import actionrpg.utils.DialogueLine;
import actionrpg.utils.Direction;
import actionrpg.utils.ResourceManager;

public class Renderer {

	public void drawMap(Graphics g, Area levelData) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, DisplayManager.WINDOW_WIDTH, DisplayManager.WINDOW_HEIGHT);
			
		for(int y=0;y<14;y++) {
			for(int x=0;x<25;x++) {
				if(levelData.getTileName(x, y).contains("grass")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_tile")) {
					g.drawImage(ResourceManager.PATH, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("stone_tile")) {
					g.drawImage(ResourceManager.STONE, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("brick_tile")) {
					g.drawImage(ResourceManager.BRICK, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("wood")) {
					g.drawImage(ResourceManager.STONE, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.WOOD, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("door_tile")) {
					g.drawImage(ResourceManager.DOOR, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("old_man")) {
					g.drawImage(ResourceManager.PATH, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.OLD_MAN, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("bush")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.BUSH, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_side_right")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.PATH_OVERLAY, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_side_left")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(rotate90deg(ResourceManager.PATH_OVERLAY)), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_side_top")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(rotate90deg(rotate90deg(ResourceManager.PATH_OVERLAY))), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_side_bottom")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(ResourceManager.PATH_OVERLAY), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_corner_bottom_right")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.PATH_CORNER, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_corner_bottom_left")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(ResourceManager.PATH_CORNER), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_corner_top_left")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(rotate90deg(ResourceManager.PATH_CORNER)), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_corner_top_right")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(rotate90deg(rotate90deg(ResourceManager.PATH_CORNER))), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_angle_bottom_right")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.PATH_ANGLE, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_angle_top_right")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(rotate90deg(rotate90deg(ResourceManager.PATH_ANGLE))), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_angle_bottom_left")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(ResourceManager.PATH_ANGLE), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("path_angle_top_left")) {
					g.drawImage(ResourceManager.GRASS, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(rotate90deg(ResourceManager.PATH_ANGLE)), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("water_tile")) {
					g.drawImage(ResourceManager.PATH, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.WATER, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("water_angle_bottom_right")) {
					g.drawImage(ResourceManager.PATH, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.WATER_ANGLE, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("water_corner_bottom_right")) {
					g.drawImage(ResourceManager.PATH, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.WATER_CORNER, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("water_side_right")) {
					g.drawImage(ResourceManager.PATH, x*32, y*32, 32, 32, null);
					g.drawImage(ResourceManager.WATER_SIDE, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("water_side_bottom")) {
					g.drawImage(ResourceManager.PATH, x*32, y*32, 32, 32, null);
					g.drawImage(rotate90deg(ResourceManager.WATER_SIDE), x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("cave")) {
					g.drawImage(ResourceManager.CAVE, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("dungeon_floor")) {
					g.drawImage(ResourceManager.DUNGEON_FLOOR, x*32, y*32, 32, 32, null);
				}
				else if(levelData.getTileName(x, y).contains("dungeon_brick")) {
					g.drawImage(ResourceManager.DUNGEON_BRICK, x*32, y*32, 32, 32, null);
				}
			}
		}
	}
	
	public void drawPlayer(Graphics g, Player playerData) {
		BufferedImage imageToUse = null;
		
		switch(playerData.getFacing()) {
		case DOWN:
			if(playerData.getAttackTime() >= 25) imageToUse = ResourceManager.PLAYER_ATTACK_1;
			else if(playerData.getAttackTime() > 0) imageToUse = ResourceManager.PLAYER_ATTACK;
			else if(playerData.getAnimationFrame() < 15) imageToUse = ResourceManager.PLAYER;
			else imageToUse = ResourceManager.PLAYER_1;
			break;
		case LEFT:
			if(playerData.getAttackTime() >= 25) imageToUse = ResourceManager.PLAYER_ATTACK_LEFT_1;
			else if(playerData.getAttackTime() > 0) imageToUse = ResourceManager.PLAYER_ATTACK_LEFT;
			else if(playerData.getAnimationFrame() < 15) imageToUse = ResourceManager.PLAYER_LEFT;
			else imageToUse = ResourceManager.PLAYER_LEFT_1;
			break;
		case RIGHT:
			if(playerData.getAttackTime() >= 25) imageToUse = ResourceManager.PLAYER_ATTACK_RIGHT_1;
			else if(playerData.getAttackTime() > 0) imageToUse = ResourceManager.PLAYER_ATTACK_RIGHT;
			else if(playerData.getAnimationFrame() < 15) imageToUse = ResourceManager.PLAYER_RIGHT;
			else imageToUse = ResourceManager.PLAYER_RIGHT_1;
			break;
		case UP:
			if(playerData.getAttackTime() >= 25) imageToUse = ResourceManager.PLAYER_ATTACK_BACK_1;
			else if(playerData.getAttackTime() > 0) imageToUse = ResourceManager.PLAYER_ATTACK_BACK;
			else if(playerData.getAnimationFrame() < 15) imageToUse = ResourceManager.PLAYER_BACK;
			else imageToUse = ResourceManager.PLAYER_BACK_1;
			break;
		}
		if(playerData.getAttackTime() <= 25 && playerData.getAttackTime() > 0 && playerData.getFacing() == Direction.LEFT)
			g.drawImage(imageToUse, playerData.getPosX()-26, playerData.getPosY(), imageToUse.getWidth()*2, imageToUse.getHeight()*2, null);
		else if(playerData.getAttackTime() <= 25 && playerData.getAttackTime() > 0 && playerData.getFacing() == Direction.UP)
			g.drawImage(imageToUse, playerData.getPosX(), playerData.getPosY()-26, imageToUse.getWidth()*2, imageToUse.getHeight()*2, null);
		else
			g.drawImage(imageToUse, playerData.getPosX(), playerData.getPosY(), imageToUse.getWidth()*2, imageToUse.getHeight()*2, null);
	}
	
	public void drawMonsters(Graphics g, List<Monster> monsters) {
		BufferedImage imageToUse = null;
		
		for(Monster monster : monsters) {
			switch(monster.getFacing()) {
			case DOWN:
				if(monster.getAnimationFrame() < 15) {
					if(monster.getMaxHealth() == 4) imageToUse = ResourceManager.MONSTER;
					else if(monster.getMaxHealth() == 6) imageToUse = ResourceManager.MONSTER2;
					else if(monster.getMaxHealth() == 10) imageToUse = ResourceManager.MONSTER3;
					else if(monster.getMaxHealth() == 40) imageToUse = ResourceManager.MONSTER4;
				}
				else {
					if(monster.getMaxHealth() == 4) imageToUse = ResourceManager.MONSTER_1;
					else if(monster.getMaxHealth() == 6) imageToUse = ResourceManager.MONSTER2_1;
					else if(monster.getMaxHealth() == 10) imageToUse = ResourceManager.MONSTER3_1;
					else if(monster.getMaxHealth() == 40) imageToUse = ResourceManager.MONSTER4_1;
				}
				break;
			case LEFT:
				if(monster.getAnimationFrame() < 15) { 
					if(monster.getMaxHealth() == 4) imageToUse = ResourceManager.MONSTER_LEFT;
					else if(monster.getMaxHealth() == 6) imageToUse = ResourceManager.MONSTER2_LEFT;
					else if(monster.getMaxHealth() == 10) imageToUse = ResourceManager.MONSTER3_LEFT;
					else if(monster.getMaxHealth() == 40) imageToUse = ResourceManager.MONSTER4_LEFT;
				}
				else {
					if(monster.getMaxHealth() == 4) imageToUse = ResourceManager.MONSTER_LEFT_1;
					else if(monster.getMaxHealth() == 6) imageToUse = ResourceManager.MONSTER2_LEFT_1;
					else if(monster.getMaxHealth() == 10) imageToUse = ResourceManager.MONSTER3_LEFT_1;
					else if(monster.getMaxHealth() == 40) imageToUse = ResourceManager.MONSTER4_LEFT_1;
				}
				break;
			case RIGHT:
				if(monster.getAnimationFrame() < 15) {
					if(monster.getMaxHealth() == 4) imageToUse = ResourceManager.MONSTER_RIGHT;
					else if(monster.getMaxHealth() == 6) imageToUse = ResourceManager.MONSTER2_RIGHT;
					else if(monster.getMaxHealth() == 10) imageToUse = ResourceManager.MONSTER3_RIGHT;
					else if(monster.getMaxHealth() == 40) imageToUse = ResourceManager.MONSTER4_RIGHT;
				}
				else {
					if(monster.getMaxHealth() == 4) imageToUse = ResourceManager.MONSTER_RIGHT_1;
					else if(monster.getMaxHealth() == 6) imageToUse = ResourceManager.MONSTER2_RIGHT_1;
					else if(monster.getMaxHealth() == 10) imageToUse = ResourceManager.MONSTER3_RIGHT_1;
					else if(monster.getMaxHealth() == 40) imageToUse = ResourceManager.MONSTER4_RIGHT_1;
				}
				break;
			case UP:
				if(monster.getAnimationFrame() < 15) {
					if(monster.getMaxHealth() == 4) imageToUse = ResourceManager.MONSTER_BACK;
					else if(monster.getMaxHealth() == 6) imageToUse = ResourceManager.MONSTER2_BACK;
					else if(monster.getMaxHealth() == 10) imageToUse = ResourceManager.MONSTER3_BACK;
					else if(monster.getMaxHealth() == 40) imageToUse = ResourceManager.MONSTER4_BACK;
				}
				else {
					if(monster.getMaxHealth() == 4) imageToUse = ResourceManager.MONSTER_BACK_1;
					else if(monster.getMaxHealth() == 6) imageToUse = ResourceManager.MONSTER2_BACK_1;
					else if(monster.getMaxHealth() == 10) imageToUse = ResourceManager.MONSTER3_BACK_1;
					else if(monster.getMaxHealth() == 40) imageToUse = ResourceManager.MONSTER4_BACK_1;
				}
				break;
			}
			
			g.drawImage(imageToUse, monster.getPosX(), monster.getPosY(), 32, 32, null);
		}
	}
	
	public void drawLoot(Graphics g, List<Collectible> lootList) {
		BufferedImage imageToUse = null;
		
		for(Collectible drop : lootList) {
			if(drop == null) break;
			
			switch(drop.getType()) {
			case GREEN_RUPEE:
				imageToUse = ResourceManager.GREEN_RUPEE;
				break;
			case BLUE_RUPEE:
				imageToUse = ResourceManager.BLUE_RUPEE;
				break;
			case HEART:
				imageToUse = ResourceManager.HEART;
				break;
			case HEART_CONTAINER:
				imageToUse = ResourceManager.HEART_CONTAINER;
				break;
			default:
				break;
			}
			g.drawImage(imageToUse, drop.getPosX(), drop.getPosY(), 32, 32, null);
		}
	}
	
	public void drawHUD(Graphics g, Player playerData) {
		g.setColor(Color.BLACK);
		g.fillRect(0, DisplayManager.WINDOW_HEIGHT-32, DisplayManager.WINDOW_WIDTH, 200);
		g.setColor(Color.RED);
		g.setFont(new Font("Arial black", 20, 20));
		g.drawString("- LIFE -", 10, 480);
		
		int posX = 10;
		for(int i=0;i<playerData.getMaxHealth()/4;i++) {
			g.drawImage(ResourceManager.HEART_0, posX, 490, 24, 24, null);
			posX+=20;
		}
		
		int hp = playerData.getHealth();
		posX = 10;
		while(hp>=4) {
			g.drawImage(ResourceManager.HEART, posX, 490, 24, 24, null);
			posX+=20;
			hp-=4;
		}
		
		if(hp == 3) g.drawImage(ResourceManager.HEART_3_4, posX, 490, 24, 24, null);
		else if(hp == 2) g.drawImage(ResourceManager.HEART_1_2, posX, 490, 24, 24, null);
		else if(hp == 1) g.drawImage(ResourceManager.HEART_1_4, posX, 490, 24, 24, null);
		
		g.setColor(Color.GREEN);
		g.drawString("- RUPEES -", 10, 540);
		g.setColor(Color.WHITE);
		g.drawImage(ResourceManager.GREEN_RUPEE, 10, 550, 24, 24, null);
		g.drawString("x"+playerData.getRupees(), 40, 570);
		
		g.drawRoundRect(200, 460, 75, 125, 5, 5);
		g.drawRoundRect(205, 465, 65, 115, 5, 5);
		g.drawRoundRect(300, 460, 75, 125, 5, 5);
		g.drawRoundRect(305, 465, 65, 115, 5, 5);
		g.setColor(Color.BLACK);
		g.fillRect(225, 580, 25, 25);
		g.fillRect(325, 580, 25, 25);
		g.setColor(Color.WHITE);
		g.drawString("Q", 230, 590);
		g.drawString("F", 330, 590);
		
		if(playerData.hasSword())
			g.drawImage(ResourceManager.SWORD, 210, 490, 64, 64, null);
		
		int xPoints[] = {500, 530, 590, 620, 590, 530, 500};
		int yPoints[] = {540, 490, 490, 540, 590, 590, 540};
		
		g.setColor(Color.WHITE);
		g.drawPolygon(xPoints, yPoints, 6);
		g.drawString("- ESAFORCE -", 490, 480);
		
		for(int i=0;i<6;i++) {
			if(playerData.getEsaforce() >= i+1) {
				g.setColor(Color.YELLOW);
				g.fillPolygon(new int[] {xPoints[i], xPoints[i+1], 560}, new int[] {yPoints[i], yPoints[i+1], 540}, 3);
				g.setColor(Color.WHITE);
				g.drawPolygon(new int[] {xPoints[i], xPoints[i+1], 560}, new int[] {yPoints[i], yPoints[i+1], 540}, 3);
			}
		}
		
		if(playerData.getHealth() <= 0) {
			g.setColor(Color.BLACK);
			g.fillRect(50, 200, 700, 100);
			g.setColor(Color.RED);
			g.setFont(new Font("Arial black", 20, 75));
			g.drawString("- GAME  OVER! -", 75, 280);
		}
	}
	
	public void drawDialogue(Graphics g, DialogueLine dialogue) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial black", 20, 30));
		for(int i=0;i<dialogue.getLines().length;i++) {
			g.drawString(dialogue.getLines()[i], 30, 400+i*30);
		}
	}
	
	public void debug(Graphics g, Player player, List<Monster> monsters) {
		g.setColor(Color.BLACK);
		
		for(Monster monster : monsters) {
			g.drawRect(monster.getPosX(), monster.getPosY(), 32, 32);
			g.drawLine(player.getPosX()+16, player.getPosY()+16, monster.getPosX()+16, monster.getPosY()+16);
		}
		g.drawRect(player.getPosX(), player.getPosY(), 32, 32);
		g.drawRect((int)player.getHitBox().getX(), (int)player.getHitBox().getY(), (int)player.getHitBox().getWidth(), (int)player.getHitBox().getHeight());
		g.drawImage(ResourceManager.LEVEL_SPAWN, 0, 0, 50, 28, null);
	}
	
	private BufferedImage rotate90deg(BufferedImage img) {
		int h = img.getHeight();
		int w = img.getWidth();
		BufferedImage rotated = new BufferedImage(h, w, img.getType());
		
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				rotated.setRGB(w-1-j, i, img.getRGB(i, j));
			}
		}
		return rotated;
	}
}
