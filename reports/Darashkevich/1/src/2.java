import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 5;
        double a = 0.0;
        double b = 10.0;

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