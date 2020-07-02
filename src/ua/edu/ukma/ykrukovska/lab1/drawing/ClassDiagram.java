package ua.edu.ukma.ykrukovska.lab1.drawing;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class ClassDiagram extends GraphicsProgram {

    private static final int WORLD_HEIGHT = 200;
    private static final int WORLD_WIDTH = 800;
    private static final double HEIGHT_RATIO = 0.25;
    private static final double WIDTH_RATIO = 0.25;
    private static final int FONT_RATIO = 50;

    public void run() {
        this.setSize(WORLD_WIDTH, WORLD_HEIGHT);


        drawRect(WORLD_WIDTH / 2., WORLD_HEIGHT / 4., "Program");
        drawRect(WORLD_WIDTH / 2., WORLD_HEIGHT * 0.75, "Graphics program");
        drawRect(WORLD_WIDTH * 0.1875, WORLD_HEIGHT * 0.75, "Console program");
        drawRect(WORLD_WIDTH * 0.8125, WORLD_HEIGHT * 0.75, "Dialog program");


        add(linkClasses(WORLD_WIDTH / 2., WORLD_HEIGHT / 4.,
                WORLD_WIDTH * 0.1875, WORLD_HEIGHT * 0.75));


        add(linkClasses(WORLD_WIDTH / 2., WORLD_HEIGHT / 4.,
                WORLD_WIDTH / 2., WORLD_HEIGHT * 0.75));


        add(linkClasses(WORLD_WIDTH / 2., WORLD_HEIGHT / 4.,
                WORLD_WIDTH * 0.8125, WORLD_HEIGHT * 0.75));
    }

    private void drawRect(double xCentre, double yCentre, String text) {
        add(new GRect(xCentre - WORLD_WIDTH * WIDTH_RATIO / 2,
                yCentre - WORLD_HEIGHT * HEIGHT_RATIO / 2, WORLD_WIDTH * WIDTH_RATIO, WORLD_HEIGHT * HEIGHT_RATIO));
        GLabel label = new GLabel(text, xCentre - WORLD_WIDTH * WIDTH_RATIO / 4, yCentre);
        Font font = new Font("Arial", Font.PLAIN, WORLD_WIDTH / FONT_RATIO);
        label.setFont(font);
        add(label);

    }

    private GLine linkClasses(double x1Centre, double y1Centre, double x2Centre, double y2Centre) {
        return new GLine(x1Centre, y1Centre + WORLD_HEIGHT * HEIGHT_RATIO / 2, x2Centre, y2Centre - WORLD_HEIGHT * HEIGHT_RATIO / 2);
    }
}