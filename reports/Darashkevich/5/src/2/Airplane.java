public class Airplane extends Carrier {
    private double speed;

    public Airplane(String route, double distance, double speed) {
        super("Airplane", route, distance);
        this.speed = speed;
    }

    @Override
    public void calculateTime() {
        transportTime = distance / speed;
    }

    @Override
    public void calculateCost() {
        transportCost = distance * 10;
    }
}