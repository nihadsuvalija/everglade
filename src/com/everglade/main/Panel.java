package com.everglade.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Panel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;


    final int fps = 60;

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();

    // Players default position:
    int x = 100;
    int y = 100;
    int speed = 4;

    public Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
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

        double drawInterval = 1000000000/fps;
        double delta = 0;
        long initialTime = System.nanoTime();
        long currentTime;

        long timer = 0;
        int drawCount = 0;

        // This is the game loop!
        while (gameThread != null) {
            /*
            * In the game loop, we update information such as character position,
            * but we also draw the screen with the updated information
            * */

            currentTime = System.nanoTime();
            delta += (currentTime - initialTime) / drawInterval;
            timer += (currentTime - initialTime);
            initialTime = currentTime;

            if (delta >= 1) {
                // Calls the update function every frame:
                update();

                // Draws the graphic on the screen:
                repaint();

                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    // Function that will call every frame.
    public void update() {
        if (keyHandler.upPressed) {
            y -= speed;
        } else if (keyHandler.downPressed) {
            y += speed;
        } else if (keyHandler.leftPressed) {
            x -= speed;
        } else if (keyHandler.rightPressed) {
            x += speed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(x,y,tileSize,tileSize);
        g2.dispose();
    }
}
