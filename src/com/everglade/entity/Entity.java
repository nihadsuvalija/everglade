package com.everglade.entity;

import com.everglade.util.Constants;
import com.everglade.util.Direction;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.sql.Array;
import java.util.ArrayList;

public abstract class Entity {

    protected String name = Constants.ENTITY_NAME;
    protected int posX = Constants.INITIAL_POSITION_X;
    protected int posY = Constants.INITIAL_POSITION_Y;
    protected int speed = Constants.INITIAL_SPEED;
    public Direction direction = Direction.RIGHT;

    protected ArrayList<BufferedImage> animUp = new ArrayList<>();
    protected ArrayList<BufferedImage> animDown = new ArrayList<>();
    protected ArrayList<BufferedImage> animLeft = new ArrayList<>();
    protected ArrayList<BufferedImage> animRight = new ArrayList<>();
    protected ArrayList<BufferedImage> animIdleLeft = new ArrayList<>();
    protected ArrayList<BufferedImage> animIdleRight = new ArrayList<>();

    public abstract void update();
    public abstract void draw(Graphics2D g2);

    public abstract void getAnimationImages();

    public void logPosition() {
        System.out.println(this.name + ": " + this.posX + ", " + this.posY);
    }
}
