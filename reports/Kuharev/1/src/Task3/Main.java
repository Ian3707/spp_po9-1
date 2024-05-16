import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Enter 2 strings!");
            return;
        }
        System.out.println(xor(args[0], args[1]));
    }
    public static String xor(String str1, String str2){
        byte[] bytes1 = str1.getBytes(StandardCharsets.UTF_8);
        byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
        byte[] bytes;
        byte fill_remainder = 0;
        if(bytes1.length > bytes2.length){
            bytes = new byte[bytes1.length];
            for(int i = 0; i < bytes1.length; ++i){
                if(i <= bytes2.length-1){
                    bytes[i] = (byte) (bytes1[i] ^ bytes2[i]);
                }else{
                    bytes[i] = (byte) (bytes1[i] ^ fill_remainder);
                }
            }
        }else{
            bytes = new byte[bytes2.length];
            for(int i = 0; i < bytes2.length; ++i){
                if(i <= bytes1.length-1){
                    bytes[i] = (byte) (bytes1[i] ^ bytes2[i]);
                }else{
                    bytes[i] = (byte) (bytes2[i] ^ fill_remainder);
                }
            }
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}