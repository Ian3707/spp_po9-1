import java.util.ArrayList;
import java.util.List;

enum drinkType{
    Cold,
    Hot
}

enum burgerType{
    Vegan,
    Meat
}

enum packingType{
    ToGo,
    InPlace
}

class Burger {
    private String type; // Тип
    private int patties = 1; // Кол-во котлет
    private List<String> toppings; // Топпинги
    private double price; // Цена

    public Burger(String type, double price, int patties) {
        this.type = type;
        this.price = price;
        this.patties = patties;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
    }

    public String getType() {
        return type;
    }

    public int getPatties() {
        return patties;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }
}

// Класс для представления напитка
class Drink {
    private String type; // Тип
    private String name; // Название
    private double price; // Цена

    public Drink(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}

class Packaging {
    private String type;

    public Packaging(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
class Order {
    private String orderDetails;

    public Order(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderDetails() {
        return orderDetails;
    }
}
// Строитель заказа
class OrderBuilder {
    private Burger burger;
    private Drink drink;
    private Packaging packaging;

    public OrderBuilder() {
    }

    public OrderBuilder addBurger(burgerType type, double price, int patty) {
        this.burger = new Burger(type.toString(), price, patty);
        return this;
    }

    public OrderBuilder addTopping(String topping) {
        this.burger.addTopping(topping);
        return this;
    }

    public OrderBuilder addDrink(drinkType type,String name, double price) {
        this.drink = new Drink(type.toString(), name, price);
        return this;
    }

    public OrderBuilder addPackaging(packingType type) {
        this.packaging = new Packaging(type.toString());
        return this;
    }

    public Order getOrderDetails() {
        double burgerPrice = (burger != null) ? burger.getPrice() : 0.0;
        double drinkPrice = (drink != null) ? drink.getPrice() : 0.0;
        double totalPrice = burgerPrice + drinkPrice;
        StringBuilder details = new StringBuilder();
        if (burger != null) {
            details.append("Burger: ").append(burger.getType()).append("\n");
            details.append("Patties: ").append(burger.getPatties()).append("\n");
            details.append("Toppings: ").append(burger.getToppings()).append("\n");
            details.append("Burger Price: $").append(burger.getPrice()).append("\n");
        } else {
            details.append("Burger: ").append("N/A").append("\n");
            details.append("Burger Price: $").append("0.0").append("\n");
        }
        if (drink != null) {
            details.append("Drink type: ").append(drink.getType()).append("\n");
            details.append("Drink: ").append(drink.getName()).append("\n");
            details.append("Drink Price: $").append(drinkPrice).append("\n");
        } else {
            details.append("Drink: ").append("N/A").append("\n");
            details.append("Drink Price: $").append("0.0").append("\n");
        }
        details.append("Packaging: ").append(packaging.getType()).append("\n");
        details.append("---------------------------\n");
        details.append("Total Price: $").append(totalPrice).append("\n");
        return new Order(details.toString());
    }
}
public class task1 {
    public static void main(String[] args) {
        // Создаем заказ
        OrderBuilder orderBuilder = new OrderBuilder();
        Order order = orderBuilder
                .addBurger(burgerType.Vegan, 20, 2)
                .addDrink(drinkType.Cold, "Cola", 10)
                .addPackaging(packingType.ToGo)
                .getOrderDetails();

        OrderBuilder orderBuilder1 = new OrderBuilder();
        Order order1 = orderBuilder1
                .addBurger(burgerType.Meat, 32, 3)
                .addTopping("onion, tomato")
                .addPackaging(packingType.InPlace)
                .getOrderDetails();

        // Получаем информацию о заказе
        System.out.println("Order details:");
        System.out.println(order.getOrderDetails());
        System.out.println(order1.getOrderDetails());
    }
}
