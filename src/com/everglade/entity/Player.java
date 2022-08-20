package com.everglade.entity;

import com.everglade.main.KeyHandler;
import com.everglade.util.Constants;

import java.awt.*;

public class Player extends Entity {

    private KeyHandler keyHandler;

    public Player(KeyHandler keyHandler) {
        this.name = Constants.PLAYER_NAME;
        this.keyHandler = keyHandler;
    }

    @Override
    public void update() {
        if (keyHandler.upPressed) {
            this.posY -= this.speed;
        } else if (keyHandler.downPressed) {
            this.posY += this.speed;
        } else if (keyHandler.leftPressed) {
            this.posX -= this.speed;
        } else if (keyHandler.rightPressed) {
            this.posX += this.speed;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.fillRect(this.posX, this.posY, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g2.dispose();
    }
}
