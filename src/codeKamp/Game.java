package codeKamp;

import javax.swing.*;

public class Game {
    public static final int HEIGHT = 450;
    public static final int WIDTH = 800;
    public static void main(String[] args) {
        GamePanel panel = new GamePanel();
        JFrame jFrame = new JFrame();
        jFrame.add(panel);
        jFrame.pack();
        jFrame.setVisible(true);
        
    }
}
