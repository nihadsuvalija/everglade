package com.everglade.util;

public class Constants {

    // Screen:
    public final static int ORIGINAL_TILE_SIZE = 16;
    public final static int SCALE = 3;
    public final static int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    public final static int MAX_SCREEN_COL = 16;
    public final static int MAX_SCREEN_ROW = 12;
    public final static int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    public final static int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;
    public final static int FPS = 60;
    public final static int DRAW_INTERVAL = 1000000000/FPS;



    // Names:
    public final static String PLAYER_NAME = "Player";
    public final static String ENTITY_NAME = "Entity";



    // Positions:
    public final static int INITIAL_POSITION_X = 100;
    public final static int INITIAL_POSITION_Y = 100;
    public final static int INITIAL_SPEED = 3;
}
