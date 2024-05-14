package Lab6_1;
import java.util.ArrayList;
import java.util.List;

class Pizza {
    private String name;

    public Pizza(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface Command {
    void execute();
}

class AddPizzaCommand implements Command {
    private Pizza pizza;
    private List<Pizza> order;

    public AddPizzaCommand(Pizza pizza, List<Pizza> order) {
        this.pizza = pizza;
        this.order = order;
    }

    public void execute() {
        order.add(pizza);
        System.out.println(pizza.getName() + " Добавлен в заказ.");
    }
}

class CancelOrderCommand implements Command {
    private List<Pizza> order;

    public CancelOrderCommand(List<Pizza> order) {
        this.order = order;
    }

    public void execute() {
        order.clear();
        System.out.println("Заказ отменен.");
    }
}

class RepeatOrderCommand implements Command {
    private List<Pizza> order;
    private List<Pizza> previousOrder;

    public RepeatOrderCommand(List<Pizza> order, List<Pizza> previousOrder) {
        this.order = order;
        this.previousOrder = previousOrder;
    }

    public void execute() {
        order.addAll(previousOrder);
        System.out.println("Заказ продублирован.");
    }
}

class Pizzeria {
    private List<Pizza> order;
    private List<Pizza> previousOrder;
    private List<Command> commands;

    public Pizzeria() {
        order = new ArrayList<>();
        previousOrder = new ArrayList<>();
        commands = new ArrayList<>();
    }

    public void addPizzaToOrder(Pizza pizza) {
        commands.add(new AddPizzaCommand(pizza, order));
    }

    public void cancelOrder() {
        commands.add(new CancelOrderCommand(order));
    }

    public void repeatOrder() {
        commands.add(new RepeatOrderCommand(order, previousOrder));
    }

    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
        previousOrder.clear();
        previousOrder.addAll(order);
        commands.clear();
    }
}

public class Lab6_3 {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria();
        Pizza pizza1 = new Pizza("Маргарита");
        Pizza pizza2 = new Pizza("Пепперони");

        pizzeria.addPizzaToOrder(pizza1);
        pizzeria.addPizzaToOrder(pizza2);
        pizzeria.executeCommands();

        pizzeria.cancelOrder();
        pizzeria.executeCommands();

        pizzeria.repeatOrder();
        pizzeria.executeCommands();
    }
}

