import acm.graphics.GRect;
import acm.program.GraphicsProgram;

//TODO add comments
public class Task1_pyramid extends GraphicsProgram {

    private static final int BRICK_WIDTH = 30;
    private static final int BRICK_HEIGHT = 12;
    private static final int BRICKS_IN_BASE = 14;
    private static final int WORLD_WIDTH = 300;
    private static final int WORLD_HEIGHT = 200;

    public void run() {
        this.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        for (int i = 0; i < BRICKS_IN_BASE; i++) {
            for (int j = 0; j < BRICKS_IN_BASE - i; j++) {
                int x = calculateX(i, j);
                int y = calculateY(i);
                GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
                add(brick);
            }
        }
    }

    private int calculateY(int i) {
        return WORLD_HEIGHT - BRICK_HEIGHT * (i + 1);
    }

    private int calculateX(int i, int j) {

        return (WORLD_WIDTH / 2) - (BRICK_WIDTH * (BRICKS_IN_BASE - i) / 2) + j * BRICK_WIDTH;

    }


}