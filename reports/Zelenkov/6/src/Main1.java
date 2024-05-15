import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Observer {
    void update(News news);
}

class News {
    private String text;

    public News(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class MusicStore {
    private List<Observer> observers = new ArrayList<>();
    private Map<String, Double> availableAlbums = new HashMap<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(News news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void addNews(String newsText) {
        News news = new News(newsText);
        notifyObservers(news);
    }

    public void addAlbum(String albumName, double price) {
        availableAlbums.put(albumName, price);
    }

    public void purchaseAlbum(Customer customer, String albumName) {
        if (availableAlbums.containsKey(albumName)) {
            double price = availableAlbums.get(albumName);
            if (customer.hasEnoughBalance(price)) {
                customer.deductBalance(price);
                availableAlbums.remove(albumName);
                System.out.println(customer.getName() + " приобрел " + albumName + " за $" + price);
            } else {
                System.out.println(customer.getName() + " недостаточно средств для покупки " + albumName);
            }
        } else {
            System.out.println("Альбом " + albumName + " не доступен в магазине.");
        }
    }
}

class Customer implements Observer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void update(News news) {
        System.out.println(name + " узнал о новостях: " + news.getText());
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean hasEnoughBalance(double amount) {
        return balance >= amount;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }
}

class Main1 {
    public static void main(String[] args) {
        MusicStore store = new MusicStore();

        Customer customer1 = new Customer("Костя", 120);
        Customer customer2 = new Customer("Андрей", 30);

        store.addObserver(customer1);
        store.addObserver(customer2);

        store.addAlbum("Альбом 1", 25.0);
        store.addAlbum("Альбом 2", 35.0);
        store.addAlbum("Альбом 3", 20.0);

        store.addNews("В магазине появились новые альбомы!");

        store.purchaseAlbum(customer1, "Альбом 1");
        store.purchaseAlbum(customer2, "Альбом 2");
        store.purchaseAlbum(customer2, "Альбом 3");
        store.purchaseAlbum(customer1, "Альбом 2");
    }
}