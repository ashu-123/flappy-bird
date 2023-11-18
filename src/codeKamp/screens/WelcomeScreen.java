package codeKamp.screens;

import codeKamp.Game;
import codeKamp.GamePanel;
import codeKamp.Resources;
import codeKamp.screens.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WelcomeScreen extends Screen {
    private int count = 0;
    private Color textColor = Color.red;

    @Override
    public void update() {
        super.update();
        this.count++;

        if(count>20)
        {
            this.count =0;
            this.textColor = this.textColor == Color.red?Color.BLACK:Color.red;
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.fillRect(0,0, Game.WIDTH,Game.HEIGHT);
        g.setColor(this.textColor);
        g.setFont(Resources.getTitleFont());
        g.drawString("Welcome To Pappu Pakia",100,100);
        g.drawString("Press ENTER to play",100,140);
        g.drawImage(Resources.getGrassImage(),0,405,null);
        super.draw(g);

    }

    @Override
    public void onKeyPress(int keyCode)
    {
        if(keyCode == KeyEvent.VK_ENTER)
        {
            GamePanel.currentScreen = new StageOneScreen();
        }
    }
}
