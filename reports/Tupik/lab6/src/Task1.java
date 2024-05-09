// Абстрактный класс автомобиля
abstract class Car {
    abstract String getType();
}

// Конкретные классы автомобилей
class SedanCar extends Car {
    @Override
    String getType() {
        return "Седан";
    }
}

class SUVCar extends Car {
    @Override
    String getType() {
        return "Внедорожник";
    }
}

// Абстрактная фабрика для производства автомобилей
interface CarFactory {
    Car createCar();
}

// Конкретные фабрики для производства различных типов автомобилей
class SedanCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new SedanCar();
    }
}

class SUVCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new SUVCar();
    }
}

public class Task1 {
    public static void main(String[] args) {
        CarFactory sedanFactory = new SedanCarFactory();
        CarFactory suvFactory = new SUVCarFactory();

        Car sedan = sedanFactory.createCar();
        System.out.println("Произведен автомобиль типа: " + sedan.getType());

        Car suv = suvFactory.createCar();
        System.out.println("Произведен автомобиль типа: " + suv.getType());
    }
}
