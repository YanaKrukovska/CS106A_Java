import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class RobotDrawer extends GraphicsProgram {

    private final static int WORLD_WIDTH = 800;
    private final static int WORLD_HEIGHT = 800;
    private final static int HEAD_WIDTH = 400;
    private final static int HEAD_HEIGHT = 300;
    private final static int EYE_RADIUS = 100;
    private final static int MOUTH_WIDTH = 300;
    private final static int MOUTH_HEIGHT = 150;

    public void run() {
        this.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        GRect head = new GRect(WORLD_WIDTH/2. - HEAD_WIDTH/2., WORLD_HEIGHT/2. - HEAD_HEIGHT/2., HEAD_WIDTH, HEAD_HEIGHT);
        add(head);

        GOval firstEye = new GOval (WORLD_WIDTH/2. - HEAD_WIDTH/4. - EYE_RADIUS/2.,WORLD_HEIGHT/2. - HEAD_HEIGHT/3.,
                EYE_RADIUS, EYE_RADIUS );
        add(firstEye);

        GOval secondEye = new GOval(WORLD_WIDTH/2. + HEAD_WIDTH/4. - EYE_RADIUS/2., WORLD_HEIGHT/2. - HEAD_HEIGHT/3.,
                EYE_RADIUS, EYE_RADIUS);
        add(secondEye);

        GRect mouth = new GRect(WORLD_WIDTH/2. - MOUTH_WIDTH/2., WORLD_HEIGHT/2. + HEAD_HEIGHT/6., MOUTH_WIDTH, MOUTH_HEIGHT );
        add(mouth);


    }
}
