package com.everglade.main;

public class Main {
    public static void main(String[] args) {

        Window window = new Window("Everglade");
        Panel panel = new Panel();
        window.add(panel);

        // Sizes the window so that the panel and it's components fit.
        window.pack();

        panel.startGameThread();

    }

}
