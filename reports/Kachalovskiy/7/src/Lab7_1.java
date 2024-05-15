package Lab7_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab7_1 extends JPanel implements ActionListener {

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;
    private static final int POINT_RADIUS = 5;
    private static final int LINE_LENGTH = 200;
    private static final int LINE_Y = FRAME_HEIGHT / 2;

    private Timer timer;
    private boolean moveRight = true;
    private double angle;
    private double centerX = FRAME_WIDTH/2;
    private double centerY = FRAME_HEIGHT/2;
    private double pointX=200;
    private double pointX2=300;

    public Lab7_1() {
        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        int pointY = (int) centerY - POINT_RADIUS / 2;
        g.fillOval((int) pointX - POINT_RADIUS / 2, pointY, POINT_RADIUS, POINT_RADIUS);

        double tempPointX = pointX + LINE_LENGTH / 2 * Math.cos(angle);
        double tempPointY = centerY + LINE_LENGTH / 2 * Math.sin(angle);

        double lineStartX = tempPointX + LINE_LENGTH / 4 * Math.cos(angle+Math.PI/2);
        double lineStartY = tempPointY + LINE_LENGTH / 4 * Math.sin(angle+Math.PI/2);
        double lineEndX = tempPointX - LINE_LENGTH / 4 * Math.cos(angle+Math.PI/2);
        double lineEndY = tempPointY - LINE_LENGTH / 4 * Math.sin(angle+Math.PI/2);

        g.setColor(Color.BLACK);
        g.drawLine((int) lineStartX, (int) lineStartY, (int) lineEndX, (int) lineEndY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (moveRight) {
            pointX += 1;
            if (pointX >= centerX + LINE_LENGTH/2) {
                moveRight = false;
            }
        } else {
            pointX -= 1;
            if (pointX <= centerX - LINE_LENGTH/2) {
                moveRight = true;
            }
        }
        angle += 0.05;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Point Applet");
        JPanel applet = new Lab7_1();
        frame.add(applet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
