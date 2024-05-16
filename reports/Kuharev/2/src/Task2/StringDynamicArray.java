public class StringDynamicArray {
    private String[] array;
    private int size;
    private int capacity;
    public StringDynamicArray(){
        capacity = Const.default_capacity;
        array = new String[capacity];
        size = Const.INITIALIZE_INT;
    }
    public int size(){
        return size;
    }
    public void resize(){
        capacity *= Const.inc_capacity;
        String[] newArray = new String[capacity];
        System.arraycopy(array, Const.srcPos, newArray, Const.destPos, size);
        array = newArray;
    }
    public void add(String str){
        if(size == capacity){
            resize();
        }
        array[size] = str;
        ++size;
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
    public String get(int index){
        if(index < Const.ISNEG || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }
    public int find(String cmp){
        for(int i = Const.INITIALIZE_INT; i < size; ++i){
            if(array[i].equals(cmp)){
                return i;
            }
        }
        return Const.NO_RES;
    }
    public void show(){
        System.out.print('[');
        for(int i = Const.INITIALIZE_INT; i < size; ++i){
            if(i < size-Const.size_chng){
                System.out.print(array[i] + ", ");
            }
            else{
                System.out.print(array[i]);
            }
        }
        System.out.print(']'); System.out.println();
    }
    public String getRandom(){
        String result = "";
        result = array[(int) (Math.random()*size)];

        return result;
    }
}

