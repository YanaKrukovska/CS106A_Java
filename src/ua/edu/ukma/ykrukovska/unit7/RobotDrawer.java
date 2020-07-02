package ua.edu.ukma.ykrukovska.unit7;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class RobotDrawer extends GraphicsProgram {

    private final static int WORLD_WIDTH = 800;
    private final static int WORLD_HEIGHT = 800;
    private final static int HEAD_WIDTH = 400;
    private final static int HEAD_HEIGHT = 400;
    private final static int EYE_RADIUS = 200;
    private final static int MOUTH_WIDTH = 500;
    private final static int MOUTH_HEIGHT = 100;

    public void run() {
        this.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        GRect head = new GRect(WORLD_WIDTH / 2. - HEAD_WIDTH / 2., WORLD_HEIGHT / 2. - HEAD_HEIGHT / 2., HEAD_WIDTH, HEAD_HEIGHT);
        head.setFilled(true);
        head.setColor(Color.lightGray);
        add(head);

        GOval firstEye = new GOval(WORLD_WIDTH / 2. - HEAD_WIDTH / 4. - EYE_RADIUS / 2., WORLD_HEIGHT / 2. - HEAD_HEIGHT / 3.,
                EYE_RADIUS, EYE_RADIUS);
        firstEye.setFilled(true);
        firstEye.setColor(Color.red);
        add(firstEye);

        GOval secondEye = new GOval(WORLD_WIDTH / 2. + HEAD_WIDTH / 4. - EYE_RADIUS / 2., WORLD_HEIGHT / 2. - HEAD_HEIGHT / 3.,
                EYE_RADIUS, EYE_RADIUS);
        secondEye.setFilled(true);
        secondEye.setColor(Color.red);
        add(secondEye);

        GRect mouth = new GRect(WORLD_WIDTH / 2. - MOUTH_WIDTH / 2., WORLD_HEIGHT / 2. + HEAD_HEIGHT / 6., MOUTH_WIDTH, MOUTH_HEIGHT);
        mouth.setFilled(true);
        mouth.setColor(Color.black);
        add(mouth);


    }
}
