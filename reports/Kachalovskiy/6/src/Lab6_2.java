package Lab6_1;
interface RemoteControl {
    void activateAlarm();
    void toggleDoors();
    void startEngine();
}

class SimpleRemoteControl implements RemoteControl {
    public void activateAlarm() {
        System.out.println("Простое ДУ: Активация сигнализации");
    }

    public void toggleDoors() {
        System.out.println("Простое ДУ: Открытие/закрытие дверей");
    }

    public void startEngine() {
        System.out.println("Простое ДУ: Запуск двигателя");
    }
}

class AdvancedRemoteControl implements RemoteControl {
    public void activateAlarm() {
        System.out.println("Продвинутое ДУ: Активация сигнализации с дополнительной защитой");
    }

    public void toggleDoors() {
        System.out.println("Продвинутое ДУ: Открытие/закрытие дверей с использованием датчиков");
    }

    public void startEngine() {
        System.out.println("Продвинутое ДУ: Запуск двигателя с помощью удаленного зажигания");
    }
}

interface Car {
    void start();
    void stop();
}

class ToyotaCar implements Car {
    public void start() {
        System.out.println("Автомобиль Toyota: Запуск двигателя");
    }

    public void stop() {
        System.out.println("Автомобиль Toyota: Остановка двигателя");
    }
}

class FordCar implements Car {
    public void start() {
        System.out.println("Автомобиль Ford: Запуск двигателя");
    }

    public void stop() {
        System.out.println("Автомобиль Ford: Остановка двигателя");
    }
}

abstract class CarRemoteControl {
    protected RemoteControl remoteControl;

    public CarRemoteControl(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    abstract void activateAlarm();
    abstract void toggleDoors();
    abstract void startEngine();
}

class ToyotaRemoteControl extends CarRemoteControl {
    private ToyotaCar car;

    public ToyotaRemoteControl(RemoteControl remoteControl, ToyotaCar car) {
        super(remoteControl);
        this.car = car;
    }

    public void activateAlarm() {
        remoteControl.activateAlarm();
    }

    public void toggleDoors() {
        remoteControl.toggleDoors();
    }

    public void startEngine() {
        car.start();
    }
}

class FordRemoteControl extends CarRemoteControl {
    private FordCar car;

    public FordRemoteControl(RemoteControl remoteControl, FordCar car) {
        super(remoteControl);
        this.car = car;
    }

    public void activateAlarm() {
        remoteControl.activateAlarm();
    }

    public void toggleDoors() {
        remoteControl.toggleDoors();
    }

    public void startEngine() {
        car.start();
    }
}

public class Lab6_2 {
    public static void main(String[] args) {
        RemoteControl simpleRemoteControl = new SimpleRemoteControl();
        RemoteControl advancedRemoteControl = new AdvancedRemoteControl();

        ToyotaCar toyotaCar = new ToyotaCar();
        FordCar fordCar = new FordCar();

        CarRemoteControl toyotaRemoteControl = new ToyotaRemoteControl(simpleRemoteControl, toyotaCar);
        CarRemoteControl fordRemoteControl = new FordRemoteControl(advancedRemoteControl, fordCar);

        System.out.println("Toyota Car:");
        toyotaRemoteControl.activateAlarm();
        toyotaRemoteControl.toggleDoors();
        toyotaRemoteControl.startEngine();

        System.out.println("\nFord Car:");
        fordRemoteControl.activateAlarm();
        fordRemoteControl.toggleDoors();
        fordRemoteControl.startEngine();
    }
}
