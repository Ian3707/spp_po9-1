package Lab7_1;

import javax.swing.*;
import java.awt.*;

public class Lab7_2 extends JPanel {

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;

    private void drawKochSnowflake(Graphics g, int x1, int y1, int x5, int y5, int level) {
        if (level == 0) {
            g.drawLine(x1, y1, x5, y5);
        } else {
            int deltaX = x5 - x1;
            int deltaY = y5 - y1;

            int x2 = x1 + deltaX / 3;
            int y2 = y1 + deltaY / 3;

            int x3 = (int) (0.5 * (x1 + x5) + Math.sqrt(3) * (y1 - y5) / 6);
            int y3 = (int) (0.5 * (y1 + y5) + Math.sqrt(3) * (x5 - x1) / 6);

            int x4 = x1 + 2 * deltaX / 3;
            int y4 = y1 + 2 * deltaY / 3;

            drawKochSnowflake(g, x1, y1, x2, y2, level - 1);
            drawKochSnowflake(g, x2, y2, x3, y3, level - 1);
            drawKochSnowflake(g, x3, y3, x4, y4, level - 1);
            drawKochSnowflake(g, x4, y4, x5, y5, level - 1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        int x1 = FRAME_WIDTH / 2;
        int y1 = 100;
        int x2 = x1 + (int) (FRAME_HEIGHT / 2 * Math.cos(Math.PI / 3));
        int y2 = y1 + (int) (FRAME_HEIGHT / 2 * Math.sin(Math.PI / 3));
        int x3 = x1 - (int) (FRAME_HEIGHT / 2 * Math.cos(Math.PI / 3));
        int y3 = y1 + (int) (FRAME_HEIGHT / 2 * Math.sin(Math.PI / 3));
        drawKochSnowflake(g, x2, y2, x1, y1, 3);
        drawKochSnowflake(g, x3, y3, x2, y2, 3);
        drawKochSnowflake(g, x1, y1, x3, y3, 3);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Koch Snowflake");
        JPanel panel = new Lab7_2();
        frame.add(panel);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
