import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1 extends JPanel implements Runnable {
    private String[] strings; // Массив строк для отображения
    private int[] xPos; // Массив для хранения текущих горизонтальных позиций строк
    private int[] yPos; // Массив для хранения текущих вертикальных позиций строк
    private int[] xVel; // Массив для хранения скоростей перемещения по горизонтали
    private int[] yVel; // Массив для хранения скоростей перемещения по вертикали
    private int numStrings; // Количество строк
    private int speed; // Скорость движения строк

    // Конструктор класса
    public Task1(String[] strings, int speed) {
        this.strings = strings;
        this.speed = speed;
        numStrings = strings.length;
        xPos = new int[numStrings];
        yPos = new int[numStrings];
        xVel = new int[numStrings];
        yVel = new int[numStrings];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Отображение каждой строки на экране
        for (int i = 0; i < numStrings; i++) {
            g.drawString(strings[i], xPos[i], yPos[i]);
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        // Инициализация начальных позиций и скоростей строк
        for (int i = 0; i < numStrings; i++) {
            xPos[i] = random.nextInt(getWidth());
            yPos[i] = random.nextInt(getHeight());

            xVel[i] = random.nextInt(numStrings) - (numStrings / 2);
            yVel[i] = random.nextInt(numStrings) - (numStrings / 2);
        }

        while (true) {
            moveStrings(); // Перемещение строк
            repaint(); // Перерисовка экрана
            try {
                Thread.sleep(this.speed); // Задержка для скорости движения
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Метод для перемещения строк
    private void moveStrings() {
        for (int i = 0; i < numStrings; i++) {
            xPos[i] += xVel[i];
            yPos[i] += yVel[i];

            // Проверка на выход строки за границы экрана, если это происходит, меняем направление скорости
            if (xPos[i] < 0 || xPos[i] > getWidth()) {
                xVel[i] = -xVel[i];
            }

            if (yPos[i] < 0 || yPos[i] > getHeight()) {
                yVel[i] = -yVel[i];
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строки (для завершения введите пустую строку):");

        String input;
        while (!(input = scanner.nextLine()).isEmpty()) {
            strings.add(input);
        }

        System.out.println("Cкорость движения строк: ");
        int speed = scanner.nextInt();

        // Создание графического окна и запуск анимации
        JFrame frame = new JFrame("Moving Strings");
        Task1 movingStrings = new Task1(strings.toArray(new String[0]), speed);
        frame.add(movingStrings);
        frame.setSize(1000, 700); // Размер окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Thread thread = new Thread(movingStrings);
        thread.start();
    }
}
