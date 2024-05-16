import java.util.ArrayList;

public class VariablePowerRealNumbers {
    private ArrayList<Double> set;
    public VariablePowerRealNumbers(){
        set = new ArrayList<Double>();
    }
    public double get(int index){
        return set.get(index);
    }
    public void add(double value){
        set.add(value);
    }
    public void remove(int index){
        set.remove(index);
    }
    public int size(){
        return set.size();
    }
    public VariablePowerRealNumbers Intersection(VariablePowerRealNumbers set2){
        VariablePowerRealNumbers set1 = new VariablePowerRealNumbers();
        set1 = ConvertToVPRN(set);
        int i = 0;
        int sizeof_s1 = set1.size();
        int sizeof_s2 = set2.size();
        if(sizeof_s1 > sizeof_s2){
            while (i < sizeof_s1) {
                if (set2.Find(set1.get(i)) > -1) {
                    i++;
                } else {
                    set1.remove(i);
                    sizeof_s1--;
                }
            }
            return set1;
        }else{
            while (i < sizeof_s2) {
                if (set1.Find(set2.get(i)) > -1) {
                    i++;
                } else {
                    set2.remove(i);
                    sizeof_s2--;
                }
            }
            return set2;
        }
    }
    public VariablePowerRealNumbers ConvertToVPRN(ArrayList<Double> array){
        VariablePowerRealNumbers converted = new VariablePowerRealNumbers();
        for(int i = 0; i < array.size(); ++i){
            converted.add(array.get(i));
        }
        return converted;
    }
    public int Find(double value){
        int index = set.indexOf(value);
        if(index < 0){
            return -1;
        }else{
            return index;
        }
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VariablePowerRealNumbers other = (VariablePowerRealNumbers) obj;
        if (set.size() != other.set.size()) {
            return false;
        }
        for (int i = 0; i < set.size(); i++) {
            if (!set.get(i).equals(other.set.get(i))) {
                return false;
            }
        }
        return true;
    }
    @Override
    public String toString() {//Вывод на печать
        String out ="[";
        for(int i = 0; i < set.size(); ++i){
            if(i < set.size()-1){
                out += set.get(i) + ", ";
            }else{
                out += set.get(i) + "]";
            }
        }
        return out;
    }
}
