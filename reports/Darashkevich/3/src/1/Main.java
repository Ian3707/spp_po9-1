public class Main {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(5, 4);
        Rectangle rectangle2 = new Rectangle(8, 8);

        System.out.println("Прямоугольник 1:");
        System.out.println(rectangle1);
        System.out.println("Прямоугольник 2:");
        System.out.println(rectangle2);

        System.out.println("Площадь прямоугольника: " + rectangle1.calculateArea());
        System.out.println("Периметр прямоугольника: " + rectangle1.calculatePerimeter());
        System.out.println("Площадь прямоугольника: " + rectangle2.calculateArea());
        System.out.println("Периметр прямоугольника: " + rectangle2.calculatePerimeter());

        if (rectangle1.isSquare()) {
            System.out.println("Прямоугольник 1 является квадратом.");
        } else {
            System.out.println("Прямоугольник 1 не является квадратом.");
        }

        if (rectangle2.isSquare()) {
            System.out.println("Прямоугольник 2 является квадратом.");
        } else {
            System.out.println("Прямоугольник 2 не является квадратом.");
        }

        if (rectangle1.isRectangleExist()) {
            System.out.println("Прямоугольник 1 существует.");
        } else {
            System.out.println("Прямоугольник 1 не существует.");
        }

        if (rectangle2.isRectangleExist()) {
            System.out.println("Прямоугольник 2 существует.");
        } else {
            System.out.println("Прямоугольник 2 не существует.");
        }


        if (rectangle1.equals(rectangle2)) {
            System.out.println("Прямоугольники 1 и 2 равны.");
        } else {
            System.out.println("Прямоугольники 1 и 2 не равны.");
        }
    }
}