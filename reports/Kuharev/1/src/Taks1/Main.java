import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        IntDynamicArray[] value;
        IntDynamicArray digits_amount = new IntDynamicArray();
        IntDynamicArray initial = new IntDynamicArray();
        for(int i = Const.CYCLE_NULL; i < args.length; ++i){
            initial.add(Integer.parseInt(args[i]));
        }
        System.out.print("Initial array: "); initial.show();
        for(int i = Const.CYCLE_NULL; i < args.length; ++i){
            if(digits_amount.find(args[i].length()) == Const.NO_RES){
                digits_amount.add(args[i].length());
            }
        }
        value = new IntDynamicArray[digits_amount.size()];
        for(int i = Const.INITIALIZE_INT; i < digits_amount.size(); ++i){
            value[i] = new IntDynamicArray();
        }
        for(int i = Const.CYCLE_NULL; i < args.length; ++i){
            for(int j = Const.CYCLE_NULL; j < digits_amount.size(); ++j){
                if(digits_amount.get(j) == args[i].length()){
                    value[j].add(Integer.parseInt(args[i]));
                }
            }
        }
        for(int i = Const.INITIALIZE_INT; i < digits_amount.size(); ++i){
            System.out.print("Array with " + digits_amount.get(i) + " significant numbers: "); value[i].show();
        }
    }
}