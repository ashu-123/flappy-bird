package codeKamp;

import codeKamp.screens.Screen;
import codeKamp.screens.WelcomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements KeyListener, MouseListener,Runnable {
    public static Screen currentScreen;
    public GamePanel()
    {
        Dimension d = new Dimension(Game.HEIGHT,Game.WIDTH);
        this.setPreferredSize(d);
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);

    }

    @Override
    public void addNotify()
    {
      super.addNotify();

      this.requestFocus();
      Resources.load();
      currentScreen = new WelcomeScreen();
      Thread t= new Thread(this);
      t.setName("loop");
      t.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentScreen.onKeyPress(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        Image bigImage = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_RGB);

        while (true)
        {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {

            }
            Graphics panelGraphics=  this.getGraphics();
            Graphics imageGraphics = bigImage.getGraphics();
            currentScreen.update();
            currentScreen.draw(imageGraphics);

            imageGraphics.dispose();

            panelGraphics.drawImage(bigImage,0,0,null);
            panelGraphics.dispose();



        }
    }
}
