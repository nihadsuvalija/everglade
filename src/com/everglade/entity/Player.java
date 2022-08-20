package com.everglade.entity;

import com.everglade.main.KeyHandler;
import com.everglade.util.Constants;
import com.everglade.util.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity {

    private KeyHandler keyHandler;

    public Player(KeyHandler keyHandler) {
        this.name = Constants.PLAYER_NAME;
        this.keyHandler = keyHandler;
        getAnimationImages();
    }

    @Override
    public void update() {
        if (keyHandler.upPressed) {
            direction = Direction.UP;
            this.posY -= this.speed;
        } else if (keyHandler.downPressed) {
            direction = Direction.DOWN;
            this.posY += this.speed;
        } else if (keyHandler.leftPressed) {
            direction = Direction.LEFT;
            this.posX -= this.speed;
        } else if (keyHandler.rightPressed) {
            direction = Direction.RIGHT;
            this.posX += this.speed;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage currImage = null;
        switch(direction) {
            case LEFT:
                currImage = animLeft.get(0);
                break;
            case RIGHT:
                currImage = animRight.get(0);
                break;
            default: break;
        }
        g2.drawImage(currImage, posX, posY, Constants.TILE_SIZE, Constants.TILE_SIZE, null);
    }

    @Override
    public void getAnimationImages() {
        try {

            for (int i = 0; i < 6; i++) {
                animLeft.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_left/move_left/move_left_" + (i + 1) + ".png"))));
                animRight.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_right/move_right/move_right_" + (i + 1) + ".png"))));
            }

            for (int i = 0; i < 3; i++) {
                animIdleLeft.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_left/idle_left/idle_left_" + (i + 1) + ".png"))));
                animIdleRight.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/character_right/idle_right/idle_right_" + (i + 1) + ".png"))));
            }

        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
}
