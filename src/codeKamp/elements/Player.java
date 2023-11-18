package codeKamp.elements;

import codeKamp.Resources;

import java.awt.*;

public class Player extends Element {
    public static final int WIDTH = 72;
    public static final int HEIGHT = 97;

    private  boolean inAir = false;
    private boolean bend = false;
    private int imageIndex = 0;
    public Player(int x,int y)
    {
     super(x,y,WIDTH,HEIGHT,null);
     this.image = getNextImage();
    }

    @Override
    public void update() {
        super.update();
        this.image = getNextImage();
    }

    public Image getNextImage()
    {
        if(inAir)
        {
            return Resources.getPlayerJumpImage();
        }
        if(bend)
        {
            return Resources.getPlayerDuckImage();
        }
        else
        {
            imageIndex++;
            imageIndex%=8;
           return Resources.getPlayerImages()[imageIndex];
        }
    }
    public void jump()
    {
        Resources.getJumpAudio().play();
        this.inAir = true;
        this.yAcc = 1;
        this.yVel = -16;
    }
    public void land()
    {
        this.inAir = false;
        this.yVel= 0;
        this.yAcc = 0;
    }
    public void setBendTrue()
    {

        this.bend = true;
    }
    public void setBendFalse()
    {

        this.bend = false;
    }
}
