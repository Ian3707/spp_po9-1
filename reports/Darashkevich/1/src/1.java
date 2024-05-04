public class Main {

    public static void main(String[] args) {
        int[] numbers = {5, -3, 8, -2, 0, -7};

        int sumOfNegativeSquares = calculateSumOfNegativeSquares(numbers);

        System.out.println("Сумма квадратов всех отрицательных чисел: " + sumOfNegativeSquares);
    }

    public static int calculateSumOfNegativeSquares(int[] numbers) {
        int sum = 0;

        for (int num : numbers) {
            if (num < 0) {
                sum += num * num;
            }
        }

        return sum;
    }
}