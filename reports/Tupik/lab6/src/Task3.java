// Интерфейс для всех состояний
interface ATMState {
    void insertPin(int pin);
    void withdrawCash(double amount);
    void ejectCard();
}

// Состояние ожидания
class IdleState implements ATMState {
    private final ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertPin(int pin) {
        if (pin == atm.correctPin) {
            System.out.println("PIN введен верно.");
            atm.setState(atm.getAuthenticatedState());
        } else {
            System.out.println("Неверный PIN.");
        }
    }

    @Override
    public void withdrawCash(double amount) {
        System.out.println("Пожалуйста, введите PIN.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Карта извлечена.");
    }
}

// Состояние аутентификации
class AuthenticatedState implements ATMState {
    private final ATM atm;

    public AuthenticatedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertPin(int pin) {
        System.out.println("Вы уже ввели PIN.");
    }

    @Override
    public void withdrawCash(double amount) {
        if (amount <= atm.availableFunds) {
            System.out.println("Выдача наличных: " + amount);
            atm.availableFunds -= amount;
        } else {
            System.out.println("Недостаточно средств.");
            atm.setState(atm.getOutOfCashState());
        }
    }

    @Override
    public void ejectCard() {
        System.out.println("Карта извлечена.");
        atm.setState(atm.getIdleState());
    }
}

// Состояние блокировки
class OutOfCashState implements ATMState {
    private final ATM atm;

    public OutOfCashState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertPin(int pin) {
        System.out.println("Банкомат заблокирован.");
    }

    @Override
    public void withdrawCash(double amount) {
        System.out.println("Банкомат заблокирован.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Банкомат заблокирован.");
    }
}

class ATM {
    private ATMState idleState;
    private ATMState authenticatedState;
    private ATMState outOfCashState;
    private ATMState currentState;

    int correctPin;
    double availableFunds;

    public ATM(int correctPin, double availableFunds) {
        this.correctPin = correctPin;
        this.availableFunds = availableFunds;

        idleState = new IdleState(this);
        authenticatedState = new AuthenticatedState(this);
        outOfCashState = new OutOfCashState(this);

        currentState = idleState;
    }

    public void setState(ATMState state) {
        currentState = state;
    }

    public ATMState getIdleState() {
        return idleState;
    }

    public ATMState getAuthenticatedState() {
        return authenticatedState;
    }

    public ATMState getOutOfCashState() {
        return outOfCashState;
    }

    public void insertCard() {
        System.out.println("Карта вставлена.");
    }

    public void insertPin(int pin) {
        currentState.insertPin(pin);
    }

    public void withdrawCash(double amount) {
        currentState.withdrawCash(amount);
    }

    public void ejectCard() {
        currentState.ejectCard();
    }
}

public class Task3 {
    public static void main(String[] args) {
        ATM atm = new ATM(1234, 1000);
        atm.insertCard();
        atm.insertPin(1234);
        atm.withdrawCash(500);
        atm.ejectCard();
    }
}
