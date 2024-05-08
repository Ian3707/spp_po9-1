// Определение интерфейса Doctor с методом treatPatient()
interface Doctor {
    void treatPatient();
}

// Класс-реализация интерфейса Doctor, представляющий Хирурга
class Surgeon implements Doctor {
    // Переопределение метода treatPatient(), который выводит сообщение о проведении операции
    @Override
    public void treatPatient() {
        System.out.println("Врач делает операцию");
    }
}

// Класс-реализация интерфейса Doctor, представляющий Нейрохирурга
class Neurosurgeon extends Surgeon {
    // Переопределение метода treatPatient() с использованием метода суперкласса и добавлением дополнительного сообщения
    @Override
    public void treatPatient() {
        super.treatPatient(); // Вызов метода суперкласса
        System.out.println("- на мозге"); // Дополнительное сообщение
    }
}

// Класс, представляющий пациента
class Patient {
    // Конструктор класса, принимающий объект типа Doctor и выводящий сообщение о лечении пациента
    public Patient (Doctor attendingDoctor) {
        System.out.println("Лечение пациента:");
        attendingDoctor.treatPatient();
    }
}

public class Task1 {
    public static void main(String[] args) {
        Surgeon Alex = new Surgeon();
        Neurosurgeon Anna = new Neurosurgeon();

        new Patient(Alex); // Создание объекта Пациента с Хирургом
        System.out.println();
        new Patient(Anna); // Создание объекта Пациента с Нейрохирургом
    }
}
