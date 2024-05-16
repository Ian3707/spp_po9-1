public class IntDynamicArray {
    private int[] array;
    private int size;
    private int capacity;
    public IntDynamicArray(){
        capacity = 10;
        array = new int[capacity];
        size = Const.INITIALIZE_INT;
    }
    public int size(){
        return size;
    }
    public void resize(){
        capacity *=2;
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
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
            return 0;
        }else{
            return -1;
        }
    }
    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        for(int i = index; i < size-1; ++i){
            array[i] = array[i+1];
        }
        --size;
    }
    public int get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }
    public int find(int value){
        for(int i = Const.INITIALIZE_INT; i < size; ++i){
            if(array[i] == value){
                return i;
            }
        }
        return Const.NO_RES;
    }
    public void show(){
        System.out.print('[');
        for(int i = 0; i < size; ++i){
            if(i < size-1){
                System.out.print(array[i] + ", ");
            }
            else{
                System.out.print(array[i]);
            }
        }
        System.out.print(']'); System.out.println();
    }
}
