package com.everglade.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean escPressed;

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // This is not used.
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        checkMovementKeysPressed(keyEvent);
        checkInteractionKeysPressed(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        checkMovementKeysReleased(keyEvent);
        checkInteractionKeysReleased(keyEvent);
    }

    private void checkMovementKeysPressed(KeyEvent keyEvent) {
        switch(keyEvent.getKeyCode()) {
            case KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
            default: break;
        }
    }

    private void checkMovementKeysReleased(KeyEvent keyEvent) {
        switch(keyEvent.getKeyCode()) {
            case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
            default: break;
        }
    }

    private void checkInteractionKeysPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                escPressed = true;
                break;
            default: break;
        }
    }

    private void checkInteractionKeysReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                escPressed = false;
                break;
            default: break;
        }
    }
}
