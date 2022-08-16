package com.everglade.main;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;

    public Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGameThread() {
        gameThread = null;
    }

    // This is the Game Loop function!
    @Override
    public void run() {

        // This is the game loop!
        while (gameThread != null) {
            /*
            * In the game loop, we update information such as character position,
            * but we also draw the screen with the updated information
            * */

            // Calls the update function every frame:
            try {
                update();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Draws the graphic on the screen:
            repaint();
        }
    }

    // Function that will call every frame.
    public void update() throws InterruptedException {
        // Stops the thread for 20ms, find a better way to cap the framerate of the game!
        Thread.sleep(20);
        System.out.println("Game is running!");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(20,20,tileSize,tileSize);
        g2.dispose();
    }
}
