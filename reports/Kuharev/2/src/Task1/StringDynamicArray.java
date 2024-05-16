public class StringDynamicArray {
    private String[] array;
    private int size;
    private int capacity;
    public StringDynamicArray(){
        capacity = 10;
        array = new String[capacity];
        size = 0;
    }
    public int size(){
        return size;
    }
    public void resize(){
        capacity *= 2;
        String[] newArray = new String[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
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
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        for(int i = index; i < size-1; ++i){
            array[i] = array[i+1];
        }
        --size;
    }
    public String get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
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
    public String getRandom(){
        String result = "";
        result = array[(int) (Math.random()*size)];

        return result;
    }
}

