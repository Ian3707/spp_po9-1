public class Train extends Carrier {
    private double speed;

    public Train(String route, double distance, double speed) {
        super("Train", route, distance);
        this.speed = speed;
    }

    @Override
    public void calculateTime() {
        transportTime = distance / speed;
    }

    @Override
    public void calculateCost() {
        transportCost = distance * 5;
    }
}