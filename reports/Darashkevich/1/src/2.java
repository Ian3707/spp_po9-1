import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(args[0]);
        double a = Integer.parseInt(args[1]);
        double b = Integer.parseInt(args[2]);


        double[][] randomMatrix = random(a, b, size);

        System.out.println("Сгенерированная матрица:");
        printMatrix(randomMatrix);
    }

    public static double[][] random(double a, double b, int size) {
        double[][] matrix = new double[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double randomValue = a + (b - a) * random.nextDouble();
                matrix[i][j] = randomValue;
            }
        }

        return matrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}