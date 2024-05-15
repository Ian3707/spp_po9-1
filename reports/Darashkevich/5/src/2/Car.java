public class Car extends Carrier {
    private double speed;

    public Car(String route, double distance, double speed) {
        super("Car", route, distance);
        this.speed = speed;
    }

    @Override
    public void calculateTime() {
        transportTime = distance / speed;
    }

    @Override
    public void calculateCost() {
        transportCost = distance * 7; // Example cost calculation for a car
    }
}