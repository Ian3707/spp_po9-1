import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task2 extends JFrame {
    private List<Integer> turns; // Список поворотов для построения фрактала
    private double startingAngle, sideLength; // Начальный угол и длина стороны для отрисовки
    private static final double ANGLE_45DEGREES = Math.PI / 4; // Угол в радианах для поворота на 45 градусов

    // Конструктор класса, принимает количество итераций для построения фрактала
    public Task2(int amountOfIterations) {
        super("Dragon Curve");
        setBounds(100, 100, 1000, 800); // Установка размеров и положения окна
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Установка операции по закрытию окна
        turns = getSequence(amountOfIterations); // Получение последовательности поворотов
        startingAngle = -amountOfIterations * ANGLE_45DEGREES; // Начальный угол для отрисовки
        sideLength = 550 / Math.pow(2, amountOfIterations / 2.); // Длина стороны фрактала
    }

    // Метод для получения последовательности поворотов
    public List<Integer> getSequence(int iterations) {
        List<Integer> turnSequence = new ArrayList<>(); // Инициализация списка поворотов
        for (int i = 0; i < iterations; i++) { // Цикл по количеству итераций
            List<Integer> copy = new ArrayList<>(turnSequence); // Создание копии текущей последовательности
            Collections.reverse(copy); // Реверс списка
            turnSequence.add(1); // Добавление поворота вправо
            for (Integer turn : copy) { // Цикл по копии последовательности
                turnSequence.add(-turn); // Добавление поворота влево, инвертируя повороты из копии
            }
        }
        return turnSequence; // Возврат полученной последовательности поворотов
    }

    // Переопределение метода отрисовки компонента
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.orange); // Установка цвета для рисования
        double angle = startingAngle; // Установка начального угла
        int x1 = 230, y1 = 450; // Начальные координаты
        int x2 = x1 + (int) (Math.cos(angle) * sideLength); // Вычисление конечных координат
        int y2 = y1 + (int) (Math.sin(angle) * sideLength);
        g.drawLine(x1, y1, x2, y2); // Отрисовка начальной линии
        x1 = x2; // Обновление начальных координат
        y1 = y2;
        for (Integer turn : turns) { // Цикл по последовательности поворотов
            angle += turn * (Math.PI / 2); // Вычисление угла поворота
            x2 = x1 + (int) (Math.cos(angle) * sideLength); // Вычисление конечных координат
            y2 = y1 + (int) (Math.sin(angle) * sideLength);
            g.drawLine(x1, y1, x2, y2); // Отрисовка линии
            x1 = x2; // Обновление начальных координат
            y1 = y2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Количество шагов: ");
        int amountOfIterations = scanner.nextInt();

        new Task2(amountOfIterations).setVisible(true);
    }
}
