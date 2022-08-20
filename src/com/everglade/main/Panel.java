package com.everglade.main;

import com.everglade.entity.Entity;
import com.everglade.entity.Player;
import com.everglade.util.Constants;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();

    private Entity player = new Player(keyHandler);

    public Panel() {
        this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.requestFocusInWindow();
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

        double drawInterval = Constants.DRAW_INTERVAL;
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
                player.logPosition();
                drawCount = 0;
                timer = 0;
            }
        }
    }

    // Function that will call every frame.
    public void update() {
        player.update();
    }

    // Function used for painting the graphics onto the panel.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);

        player.draw(g2);

        g2.dispose();
    }
}
