package com.everglade.entity;

import com.everglade.util.Constants;

import java.awt.*;

public abstract class Entity {

    protected String name = Constants.ENTITY_NAME;
    protected int posX = Constants.INITIAL_POSITION_X;
    protected int posY = Constants.INITIAL_POSITION_Y;
    protected int speed = Constants.INITIAL_SPEED;

    public abstract void update();
    public abstract void draw(Graphics2D g2);

    public void logPosition() {
        System.out.println(this.name + ": " + this.posX + ", " + this.posY);
    }
}
