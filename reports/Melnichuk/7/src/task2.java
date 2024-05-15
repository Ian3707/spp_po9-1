import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class task2 extends JPanel {
    private static final int MAX_ITER = 1000;
    private static final double ZOOM = 150;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public task2() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    private int mandelbrot(double x, double y) {
        double zx = 0;
        double zy = 0;
        double cX = (x - WIDTH / 2) / ZOOM;
        double cY = (y - HEIGHT / 2) / ZOOM;
        int iter = 0;
        while ((zx * zx + zy * zy) < 4 && iter < MAX_ITER) {
            double tmp = zx * zx - zy * zy + cX;
            zy = 2.0 * zx * zy + cY;
            zx = tmp;
            iter++;
        }
        if (iter == MAX_ITER) return 0;
        return iter % 256;
    }

    public void paintComponent(Graphics g) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                int color = mandelbrot(x, y);
                image.setRGB(x, y, color | (color << 8));
            }
        }
        g.drawImage(image, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot Set");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        task2 mandelbrotSet = new task2();
        frame.add(mandelbrotSet);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
