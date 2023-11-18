package codeKamp.screens;

import codeKamp.Game;
import codeKamp.GamePanel;
import codeKamp.RandomNumberGenerator;
import codeKamp.Resources;
import codeKamp.elements.Block;
import codeKamp.elements.Player;
import codeKamp.screens.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.RandomAccess;

public class StageOneScreen extends Screen {
 private ArrayList<Block> blocks = new ArrayList<>();

 private Player player;
 private static final int GRASS_HEIGHT = 45;
 private static final int GRASS_Y = Game.HEIGHT - GRASS_HEIGHT;
 private static final int PLAYER_GROUND_Y = GRASS_Y - Player.HEIGHT;
 private static final int BLOCK_START = 900;
 private static final int BLOCK_GAP = 200;

 public StageOneScreen()
 {
  blocks.add(new Block(BLOCK_START,getRandomBlockY(),-5));
  blocks.add(new Block(BLOCK_START+BLOCK_GAP,getRandomBlockY(),-5));
  blocks.add(new Block(BLOCK_START+2*BLOCK_GAP,getRandomBlockY(),-5));
  blocks.add(new Block(BLOCK_START+3*BLOCK_GAP,getRandomBlockY(),-5));
  blocks.add(new Block(BLOCK_START+4*BLOCK_GAP,getRandomBlockY(),-5));

  player = new Player(400,PLAYER_GROUND_Y);

  this.elements.add(player);
  this.elements.addAll(blocks);
 }
 private int getRandomBlockY()
 {
  int position = RandomNumberGenerator.next(2);
  if(position==0){
   return 255;
  }
else
  {
   return 345;
  }
 }

 @Override
 public void update()
 {
  super.update();

  if(player.x < -Player.WIDTH){
   GamePanel.currentScreen = new GameOverScreen();
   return;

  }
  if(player.y >= PLAYER_GROUND_Y && player.yVel>0)
  {
   player.y = PLAYER_GROUND_Y;
   player.land();
  }
  for (Block b :blocks
       ) {
   if(b.x<-b.width)
   {
    b.x = 980;
    b.visible = true;
    b.y = getRandomBlockY();
   } else if (b.isCollidingWith(player)) {
    Resources.getHitAudio().play();
    player.x-=20;
    b.visible = false;

   }
  }
 }
 @Override
 public void draw(Graphics g) {
  g.setColor(Color.cyan);
  g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
  g.drawImage(Resources.getGrassImage(), 0, GRASS_Y, null);

  super.draw(g);
 }


@Override
 public void onKeyPress(int keyCode){
  if(keyCode == KeyEvent.VK_SPACE && player.y == PLAYER_GROUND_Y)
  {
player.jump();
  }
  if(keyCode == KeyEvent.VK_DOWN && player.y == PLAYER_GROUND_Y)
  {
   player.setBendTrue();
  }
 if(keyCode == KeyEvent.VK_UP && player.y == PLAYER_GROUND_Y)
 {
  player.setBendFalse();
 }
}
}
