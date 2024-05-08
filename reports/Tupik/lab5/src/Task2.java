abstract class PassengerCarrier {
    protected int travelTimeInMin;
    protected int costOfTravel;

    // Конструктор суперкласса
    public PassengerCarrier(int travelTimeInSec, int costOfTravel) {
        this.travelTimeInMin = travelTimeInSec;
        this.costOfTravel = costOfTravel;
    }

    // Общий метод для путешествия
    public void travel() {
        System.out.println("Пассажироперевозчик доберется до места назначения за "
                + travelTimeInMin
                + " минут, поездка обойдется вам в "
                + costOfTravel + "$");
    }

    // Общий метод для старта
    public void start() {
        System.out.println("Пассажироперевозчик отправляется");
    }

    // Общий метод для остановки
    public void stop() {
        System.out.println("Пассажироперевозчик прибыл в пункт назначения. " +
                "Благодарим вас за то, что выбрали нас.");
    }
}

class Plane extends PassengerCarrier {
    String airline;

    // Конструктор подкласса Самолет
    public Plane (int travelTimeInSec, int costOfTravel, String airline) {
        super(travelTimeInSec, costOfTravel);
        this.airline = airline;
    }

    // Переопределение метода для путешествия на самолете
    @Override
    public void travel() {
        System.out.println("Самолет долетит до места назначения за "
                + travelTimeInMin
                + " минут, перелет обойдется вам в "
                + costOfTravel + "$");
    }

    // Дополнительный метод для вывода информации об авиакомпании
    public void fly() {
        System.out.println("Вы летите рейсом авиакомпании \"" + airline + "\"");
    }
}

class Train extends PassengerCarrier {
    boolean isElectric;

    // Конструктор подкласса Поезд
    public Train (int travelTimeInSec, int costOfTravel, boolean isElectric) {
        super(travelTimeInSec, costOfTravel);
        this.isElectric = isElectric;
    }

    // Переопределение метода для путешествия на поезде
    @Override
    public void travel() {
        System.out.println("Поезд прибывает в пункт назначения за "
                + travelTimeInMin
                + " минут, проезд обойдется вам в "
                + costOfTravel + "$");
    }

    // Дополнительный метод для вывода информации о типе поезда
    public void showType () {
        if (isElectric) System.out.println("Вы будете ехать на электропоезде");
        else System.out.println("Вы будете ехать на старом поезде");
    }
}

class Car extends PassengerCarrier {
    String brand;

    // Конструктор подкласса Автомобиль
    public Car (int travelTimeInSec, int costOfTravel, String brand) {
        super(travelTimeInSec, costOfTravel);
        this.brand = brand;
    }

    // Переопределение метода для путешествия на автомобиле
    @Override
    public void travel() {
        System.out.println("Автомобиль доедет до места назначения за "
                + travelTimeInMin
                + " минут, поездка обойдется вам в "
                + costOfTravel + "$");
    }

    // Дополнительный метод для вывода информации об автомобиле
    public void showOffModel () {
        System.out.println("Вы будете ехать на автомобиле " + brand);
    }
}

public class Task2 {
    public static void main(String[] args) {
        PassengerCarrier[] carriers = new PassengerCarrier[3];

        carriers[0] = new Plane(300, 999, "Aviasales");
        carriers[1] = new Train(880, 299, true);
        carriers[2] = new Car(1500, 99, "BMW");

        // Итерация по массиву объектов для моделирования ситуаций
        for (PassengerCarrier carrier : carriers) {
            carrier.start();
            carrier.travel();
            // Проверка типа объекта и вызов соответствующего метода
            if (carrier instanceof Plane) {
                ((Plane) carrier).fly();
            } else if (carrier instanceof Train) {
                ((Train) carrier).showType();
            } else if (carrier instanceof Car) {
                ((Car) carrier).showOffModel();
            }
            carrier.stop();
            System.out.println();
        }
    }
}