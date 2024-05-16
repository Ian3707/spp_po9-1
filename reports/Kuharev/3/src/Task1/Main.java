import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> r = new ArrayList<>();
        r.add(21.3); r.add(22.5);
        VariablePowerRealNumbers set1 = new VariablePowerRealNumbers();
        VariablePowerRealNumbers set2 = new VariablePowerRealNumbers();
        VariablePowerRealNumbers set3 = new VariablePowerRealNumbers();
        VariablePowerRealNumbers set4 = new VariablePowerRealNumbers();
        set1.add(50.3); set1.add(0.3); set1.add(20.3); set1.add(10.3); set1.add(40.3);
        set2.add(50.3); set2.add(0.5); set2.add(20.3); set2.add(10.3); set2.add(40.4);
        set3.add(10); set3.add(20); set3.add(30); set3.add(40); set3.add(50);
        set4.add(10); set4.add(20); set4.add(30); set4.add(40); set4.add(50);

        if(!set1.equals(set2)){
            System.out.println("Sets are not equal");
            System.out.println(set1.Intersection(set2).toString());
        }else{
            System.out.println("Sets are equal");
            System.out.println(set1.toString());
        }

        if(!set3.equals(set4)){
            System.out.println("Sets are not equal");
            System.out.println(set3.Intersection(set4).toString());
        }else{
            System.out.println("Sets are equal");
            System.out.println(set3.toString());
        }
    }
}