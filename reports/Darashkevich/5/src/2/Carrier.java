public abstract class Carrier {
    protected String type;
    protected String route;
    protected double distance;
    protected double transportTime;
    protected double transportCost;

    public Carrier(String type, String route, double distance) {
        this.type = type;
        this.route = route;
        this.distance = distance;
    }

    public abstract void calculateTime();

    public abstract void calculateCost();

    public void displayTransportInfo() {
        System.out.println("Carrier type: " + type);
        System.out.println("Route: " + route);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Transport time: " + transportTime + " hours");
        System.out.println("Transport cost: " + transportCost + " RUB");
    }
}