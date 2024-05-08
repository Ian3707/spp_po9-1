import java.util.ArrayList;
import java.util.List;

// Интерфейс, описывающий товар
interface ProductDescription {
    String getDescription();
}

// Класс, представляющий товар
class Product implements ProductDescription {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

// Класс, представляющий корзину с товарами
class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

// Абстрактный класс, обобщающий атрибуты и методы администратора и клиента
abstract class User {
    // Общие атрибуты и методы
}

// Класс, представляющий администратора
class Administrator extends User {
    static private List<String> paymentRegistry = new ArrayList<>();
    static private List<String> blacklist = new ArrayList<>();

    // Метод для регистрации оплаты товара клиентом
    public static void registerPayment(String clientName, double amount) {
        paymentRegistry.add("Клиент: " + clientName + "; Сумма: " + amount + "руб");
        System.out.println("Клиент: " + clientName + "; Сумма: " + amount + "руб");
    }

    // Метод для добавления клиента в "черный список"
    public static void addToBlacklist(String clientName) {
        blacklist.add(clientName);
    }

    // Метод для проверки, находится ли клиент в "черном списке"
    public static boolean isBlacklisted(String clientName) {
        return blacklist.contains(clientName);
    }

    // Метод для добавления описания товара
    public static void addProductDescription(Product product, String description) {
        product.setDescription(description);
    }
}

// Класс, представляющий клиента
class Client extends User {
    private String name;
    private double money;
    private Cart cart;

    public Client(String name, double money) {
        this.name = name;
        this.money = money;
        this.cart = new Cart();
    }

    // Метод для добавления товара в корзину клиента
    public void addProductToCart(Product product) {
        cart.addProduct(product);
    }

    // Метод для оплаты товаров в корзине
    public void pay() {
        double totalPrice = cart.calculateTotalPrice();
        if (totalPrice <= money) {
            money -= totalPrice;
            Administrator.registerPayment(name, totalPrice);
        } else {
            Administrator.addToBlacklist(name);
            System.out.println("Клиент " + name + " не имеет достаточно денежных средств " +
                    "и будет добавлена в \"Черный список\".");
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        Client client1 = new Client("Даша", 40);
        Client client2 = new Client("Оля", 20);

        Product product1 = new Product("Тушь для ресниц", 27);
        Product product2 = new Product("Помада для губ", 13);

        Administrator.addProductDescription(product1,
                "Супер объем со сценическим эффектом, тон 01");
        Administrator.addProductDescription(product2,
                "Жидкая стойкая матовая помада для губ, тон 15");

        client1.addProductToCart(product1);
        client1.addProductToCart(product2);

        client2.addProductToCart(product1);

        client1.pay();
        client2.pay();

        System.out.println("Оля есть в \"Черном списке\"? " +
                Administrator.isBlacklisted("Оля"));

        System.out.println(product1.getName() + " (" + product1.getDescription() + ")");
        System.out.println(product2.getName() + " (" + product2.getDescription() + ")");
    }
}
