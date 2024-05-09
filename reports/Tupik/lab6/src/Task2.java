// Интерфейс Уровня Активности
interface ActivityLevel {
    void accessFunctionality();
    void accessUniqueOffers();
}

// Конкретный класс Уровня Активности: Базовый уровень
class BasicLevel implements ActivityLevel {
    public void accessFunctionality() {
        System.out.println("Доступ к базовым функциям.");
    }

    public void accessUniqueOffers() {
        System.out.println("Доступ к базовым уникальным предложениям.");
    }
}

// Конкретный класс Уровня Активности: Премиум уровень
class PremiumLevel implements ActivityLevel {
    public void accessFunctionality() {
        System.out.println("Доступ к расширенным функциям.");
    }

    public void accessUniqueOffers() {
        System.out.println("Доступ к премиум уникальным предложениям.");
    }
}

// Класс Учетной Записи Покупателя
class CustomerAccount {
    private ActivityLevel activityLevel;

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void accessFunctionality() {
        activityLevel.accessFunctionality();
    }

    public void accessUniqueOffers() {
        activityLevel.accessUniqueOffers();
    }
}

public class Task2 {
    public static void main(String[] args) {
        // Создаем учетную запись покупателя
        CustomerAccount customerAccount = new CustomerAccount();

        // Устанавливаем уровень активности на базовый
        ActivityLevel basicLevel = new BasicLevel();
        customerAccount.setActivityLevel(basicLevel);

        // Покупатель получает доступ к функциональности и уникальным предложениям базового уровня
        System.out.println("Базовый уровень:");
        customerAccount.accessFunctionality();
        customerAccount.accessUniqueOffers();
        System.out.println();

        // Переключаем уровень активности на премиум
        ActivityLevel premiumLevel = new PremiumLevel();
        customerAccount.setActivityLevel(premiumLevel);

        // Покупатель получает доступ к расширенной функциональности и уникальным предложениям премиум уровня
        System.out.println("Премиум уровень:");
        customerAccount.accessFunctionality();
        customerAccount.accessUniqueOffers();
    }
}
