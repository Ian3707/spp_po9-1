public class Main {
    public static void main(String[] args) {
        Carrier[] carriers = new Carrier[3];

        carriers[0] = new Airplane("Moscow - New York", 8000, 900);
        carriers[1] = new Train("Moscow - St. Petersburg", 700, 150);
        carriers[2] = new Car("Moscow - Kazan", 800, 100);

        for (Carrier carrier : carriers) {
            carrier.calculateTime();
            carrier.calculateCost();
            carrier.displayTransportInfo();
            System.out.println("---------------------------------");
        }
    }
}