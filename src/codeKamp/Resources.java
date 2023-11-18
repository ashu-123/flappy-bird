package codeKamp;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

abstract public class Resources {

    private static Image grassImage;
    private static Image blockImage;

    private static Image playerJumpImage;
    private static Image[] playerImages;
    private static Image playerDuckImage;

    public static Font titleFont;

    private static java.applet.AudioClip jumpAudio;
    private static java.applet.AudioClip hitAudio;

    public static void load()
    {
        playerImages = new Image[8];
        try {
            grassImage = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("codeKamp/Images/grass.png"));
            blockImage = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("codeKamp/Images/block.png"));

            playerJumpImage = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("codeKamp/Images/jump.png"));
            playerDuckImage = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("codeKamp/Images/duck.png"));
            playerImages[0] = ImageIO.read(Resources.class.getClassLoader().getResource("codeKamp/Images/run_anim1.png"));
            playerImages[1] = ImageIO.read(Resources.class.getClassLoader().getResource("codeKamp/Images/run_anim2.png"));
            playerImages[2] = ImageIO.read(Resources.class.getClassLoader().getResource("codeKamp/Images/run_anim3.png"));
            playerImages[3] = ImageIO.read(Resources.class.getClassLoader().getResource("codeKamp/Images/run_anim4.png"));
            playerImages[4] = ImageIO.read(Resources.class.getClassLoader().getResource("codeKamp/Images/run_anim5.png"));
            playerImages[5] = playerImages[3];
            playerImages[6] = playerImages[2];
            playerImages[7] = playerImages[1];
        } catch (IOException e) {
            System.out.println("Please re-Install the Game!!");
        }

        jumpAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("codeKamp/Audios/onjump.wav"));
        hitAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("codeKamp/Audios/hit.wav"));

        titleFont = new Font("Comic Sans MS",Font.BOLD,30);
    }
    public static Image getGrassImage()
    {
        return grassImage;
    }
    public static Image getBlockImage()
    {
        return blockImage;
    }

    public static Image getPlayerJumpImage(){
        return playerJumpImage;
    }
    public static Image getPlayerDuckImage(){ return playerDuckImage; }

    public static Font getTitleFont()
    {
        return titleFont;
    }

    public static Image[] getPlayerImages()
    {
     return  playerImages;
    }

    public static AudioClip getJumpAudio()
    {
        return jumpAudio;
    }
    public static AudioClip getHitAudio()
    {
        return hitAudio;
    }
}
