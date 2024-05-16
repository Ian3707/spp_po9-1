public class IntDynamicArray {
    private int[] array;
    private int size;
    private int capacity;
    public IntDynamicArray(){
        capacity = Const.default_capacity;
        array = new int[capacity];
        size = Const.INITIALIZE_INT;
    }
    public int size(){
        return size;
    }
    public boolean find(int number){
        for(int i = Const.ISNEG; i < size; ++i){
            if(array[i] == number){
                return true;
            }
        }
        return false;
    }
    public void resize(){
        capacity *= Const.inc_capacity;
        int[] newArray = new int[capacity];
        System.arraycopy(array, Const.srcPos, newArray, Const.destPos, size);
        array = newArray;
    }
    public void add(int number){
        if(size == capacity){
            resize();
        }
        array[size] = number;
        ++size;
    }
    public int replace(int number, int index){
        if(index < size){
            array[index] = number;
            return Const.ALL_PROCESSED;
        }else{
            return Const.NO_RES;
        }
    }
    public void remove(int index){
        if(index < Const.ISNEG || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        for(int i = index; i < size-Const.size_chng; ++i){
            array[i] = array[i+Const.next_num];
        }
        --size;
    }
    public int get(int index){
        if(index < Const.ISNEG || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }
    public void show(){
        System.out.print('[');
        for(int i = Const.ISNEG; i < size; ++i){
            if(i < size-Const.size_chng){
                System.out.print(array[i] + ", ");
            }
            else{
                System.out.print(array[i]);
            }
        }
        System.out.print(']'); System.out.println();
    }
}
