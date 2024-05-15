import java.util.Random;
import java.util.Random;

class PremiumLevelDecorator extends BasicLevelDecorator {
    @Override
    public void purchaseBook(Book book, CustomerAccount customer) {
        super.purchaseBook(book, customer);
    }

    @Override
    public void checkUpgrade(CustomerAccount customer) {
        if (customer.getPoints() >= 10) {
            customer.setActivityLevel(new EliteLevelDecorator());
            System.out.println("Поздравляю! Вы были повышены до элитного уровня.");
        }
    }
    public void participateInContest(CustomerAccount customer) {
        Random random = new Random();
        int result = random.nextInt(100);
        if (result < 30) {
            System.out.println("Вы выиграли конкурс!");
            customer.addBalance(10);
        } else {
            System.out.println("На этот раз никаких призов. В следующий раз точно повезет!");
        }
    }
}


class EliteLevelDecorator extends PremiumLevelDecorator {
    @Override
    public void purchaseBook(Book book, CustomerAccount customer) {
        System.out.println("Купленная книга: " + book.getTitle());
        customer.incrementPoints(book.getPoints());
        double discount = book.getPrice() * 0.1; // 10% скидка для элиты
        customer.addBalance(discount);
        System.out.println("Вы получили кэшбэк в размере $" + discount + " для вашего элитного уровня.");
    }

    @Override
    public void participateInContest(CustomerAccount customer) {
        Random random = new Random();
        int result = random.nextInt(100);
        if (result < 30) {
            System.out.println("Вы выиграли конкурс!");
            customer.addBalance(15);
        } else {
            System.out.println("На этот раз никаких призов. В следующий раз точно повезет!");
        }
    }
}

interface ActivityLevel {
    void purchaseBook(Book book, CustomerAccount customer);
    void checkUpgrade(CustomerAccount customer);
    void participateInContest(CustomerAccount customer);
}

class BasicLevelDecorator implements ActivityLevel {
    @Override
    public void purchaseBook(Book book, CustomerAccount customer) {
        System.out.println("Купленная книга: " + book.getTitle());
        customer.incrementPoints(book.getPoints());
        checkUpgrade(customer);
    }

    @Override
    public void checkUpgrade(CustomerAccount customer) {
        if (customer.getPoints() >= 5) {
            customer.setActivityLevel(new PremiumLevelDecorator());
            System.out.println("Поздравляю! Вы были повышены до премиум-уровня.");
        }
    }

    @Override
    public void participateInContest(CustomerAccount customer){
        System.out.println("Участие в конкурсе недоступно для текущего уровня активности.");
    }
}

class Book {
    private String title;
    private int points;
    private double price;

    public Book(String title, int points, double price) {
        this.title = title;
        this.points = points;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPoints() {
        return points;
    }

    public double getPrice() {
        return price;
    }
}

class CustomerAccount {
    private ActivityLevel activityLevel;
    private int points;
    private double balance;

    public CustomerAccount() {
        this.activityLevel = new BasicLevelDecorator();
        this.points = 0;
        this.balance = 0;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void incrementPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public double getBalance() {
        return balance;
    }

    public void purchaseBook(Book book) {
        if (book.getPrice() <= balance) {
            System.out.println("Купленная книга: " + book.getTitle() + " за $" +
                    book.getPrice());
            balance -= book.getPrice();
            System.out.println("Оставшийся баланс: $" + balance);
            activityLevel.purchaseBook(book, this);
        } else {
            System.out.println("Недостаточно средств для покупки " + book.getTitle());
        }
    }

    public void participateInContest() {
        activityLevel.participateInContest(this);
    }

    public void addBalance(double amount) {
        balance += amount;
        System.out.println("Добавлено $" + amount + " на ваш баланс. Текущий баланс: $" + balance);
    }
}

public class Main2 {
    public static void main(String[] args) {
        CustomerAccount customer1 = new CustomerAccount();
        Book book1 = new Book("Книга 1", 2, 15.0);
        Book book2 = new Book("Книга 2", 3, 10.0);
        Book book3 = new Book("Книга 3", 4, 25.0);
        Book book4 = new Book("Книга 4", 2, 20.0);
        customer1.addBalance(100.0);

        customer1.purchaseBook(book1);
        customer1.purchaseBook(book2);
        customer1.purchaseBook(book3);

        System.out.println("Очки клиента: " + customer1.getPoints());
        System.out.println("Баланс клиента: $" + customer1.getBalance());

        customer1.addBalance(50.0);

        customer1.participateInContest();

        customer1.purchaseBook(book2);

        customer1.purchaseBook(book4);


        customer1.participateInContest();
    }
}