import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter elements amount: ");
        int amount = in.nextInt();
        double[] initial = fillRandom(amount);
        double[] shifted;
        System.out.print("Enter shift: ");
        int shift = in.nextInt();
        System.out.println(shift);
        System.out.print("Initial array: "); Show(initial);
        long startTime = System.nanoTime();
        shifted = rshiftLeft(initial, shift);
        long endTime = System.nanoTime();
        System.out.print("Recursion shift (runtime " + (endTime-startTime) + " ns): "); Show(shifted);
        startTime = System.nanoTime();
        shifted = shiftLeft(initial, shift);
        endTime = System.nanoTime();
        System.out.print("Reversal shift (runtime " + (endTime-startTime) + " ns): "); Show(shifted);


    }
    public static double[] rshiftLeft(double[] array, int shift) {
        if (shift <= 0) {
            return array;
        } else {
            double[] shiftedArray = new double[array.length];
            double tmp = array[0];

            for (int i = 0; i < array.length - 1; i++) {
                shiftedArray[i] = array[i + 1];
            }

            shiftedArray[array.length - 1] = tmp;

            return rshiftLeft(shiftedArray, shift - 1);
        }
    }
    public static double[] shiftLeft(double[] array, int shift){
        int length = array.length;
        shift = shift % length;
        reverseArray(array, 0, shift-1);
        reverseArray(array, shift, length-1);
        reverseArray(array, 0, length-1);
        return array;
    }
    public static void reverseArray(double[] array, int start_pos, int end_pos){
        double tmp = 0;
        while(start_pos < end_pos){
            tmp = array[start_pos];
            array[start_pos] = array[end_pos];
            array[end_pos] = tmp;
            ++start_pos;
            --end_pos;
        }
    }
    public static double[] fillRandom(int amount){
        double[] res = new double[amount];
        for(int i = 0; i < amount; ++i){
            res[i] = Math.random()*100;
        }
        return res;
    }
    public static void Show(double[] arr){
        DecimalFormat doubleFormat = new DecimalFormat("#o##");
        String formatted;
        System.out.print("[");
        for(int i = 0; i < arr.length; ++i){
            formatted = doubleFormat.format(arr[i]);
            if(i < arr.length-1){
                System.out.print(formatted + ", ");
            } else{
                System.out.println(formatted + "]");
            }
        }
    }
}