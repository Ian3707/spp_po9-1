class Burger {
    private String type;
    private double price;

    public Burger(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Beverage {
    private String type;
    private double price;

    public Beverage(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Packaging {
    private String type;
    private double price;

    public Packaging(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private Burger burger;
    private Beverage beverage;
    private Packaging packaging;

    public Order(Burger burger, Beverage beverage, Packaging packaging) {
        this.burger = burger;
        this.beverage = beverage;
        this.packaging = packaging;
    }

    public double calculateTotalCost() {
        return burger.getPrice() + beverage.getPrice() + packaging.getPrice();
    }
}

class OrderBuilder {
    private Burger burger;
    private Beverage beverage;
    private Packaging packaging;

    public OrderBuilder addBurger(Burger burger) {
        this.burger = burger;
        return this;
    }

    public OrderBuilder addBeverage(Beverage beverage) {
        this.beverage = beverage;
        return this;
    }

    public OrderBuilder addPackaging(Packaging packaging) {
        this.packaging = packaging;
        return this;
    }

    public Order build() {
        return new Order(burger, beverage, packaging);
    }
}

public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger("Веганский", 150.0);
        Beverage beverage = new Beverage("Пепси", 50.0);
        Packaging packaging = new Packaging("С собой", 10.0);

        Order order = new OrderBuilder()
                .addBurger(burger)
                .addBeverage(beverage)
                .addPackaging(packaging)
                .build();

        double totalCost = order.calculateTotalCost();

        System.out.println("Итоговая стоимость заказа: " + totalCost);
    }
}
