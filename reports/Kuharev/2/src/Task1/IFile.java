import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class IFile {
    static String read_string = "";
    public static StringDynamicArray ReadStrings(String filename){
        StringDynamicArray file_words_array = new StringDynamicArray();
        try(BufferedReader reader = new BufferedReader(new FileReader(Paths.PATH + filename + ".txt"))){
            read_string = reader.readLine();
            if(read_string != null){
                file_words_array.add(read_string);
            }
            while(read_string != null){
                read_string = reader.readLine();
                if(read_string != null){
                    file_words_array.add(read_string);
                }
            }
            reader.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return file_words_array;
    }
    public static void WriteString(String str, String file_name){
        FileOutputStream fout = null;
        try{
            fout = new FileOutputStream(Paths.PATH + file_name + ".txt", true);
            byte[] buffer = str.getBytes();

            fout.write(buffer, 0, buffer.length);
            System.out.println(str);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                if(fout != null){
                    fout.close();
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void ClearFile(String filename){
        FileOutputStream fout = null;
        try{
            fout = new FileOutputStream(Paths.PATH + filename + ".txt");
            byte[] buffer = Const.CLEAR.getBytes();
            fout.write(buffer, 0, buffer.length);
            System.out.println("The file was cleaned");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if(fout != null){
                    fout.close();
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
