package ua.edu.ukma.ykrukovska.controlwork;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Task2 extends GraphicsProgram {

    private RandomGenerator rgen = RandomGenerator.getInstance();
    private static final int N = 6;
    private static final int PARAMETR = 500;


    public void run() {

        this.setSize(PARAMETR, PARAMETR);

        for (int i = 0; i < N; i++) {
            int diametre = rgen.nextInt(0, PARAMETR);
            int maxX = PARAMETR - diametre;
            int maxY = PARAMETR - diametre;
            int x = rgen.nextInt(0, maxX);
            int y = rgen.nextInt(0, maxY);

            GOval oval = new GOval(x, y, diametre / 2., diametre / 2.);
            add(oval);
        }

    }
}
