import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {
    private static int nextId = Const.INITIALIZE_INT;
    private int id;
    private String name;
    private String UPC;
    private String manufacturer;
    private int price;
    private LocalDate date_of_manufacture;
    private LocalDate shelf_time;

    public Product(){
        id = nextId;
        nextId++;
        name = Const.def_name;
        UPC = MakeUPC();
        manufacturer = Const.def_manufacturer;
        price = Const.def_price;
        date_of_manufacture = LocalDate.now();
        shelf_time = Const.def_shelf_time;
    }
    public Product(String name, String manufacturer, int price){
        id = nextId;
        nextId++;
        this.name = name;
        UPC = MakeUPC();
        this.manufacturer = manufacturer;
        this.price = price;
        date_of_manufacture = LocalDate.now();
        shelf_time = Const.def_shelf_time;
    }
    public Product(String name, String manufacturer, int price, LocalDate date_of_manufacture, LocalDate shelf_time){
        id = nextId;
        nextId++;
        this.name = name;
        UPC = MakeUPC();
        this.manufacturer = manufacturer;
        this.price = price;
        this.date_of_manufacture = date_of_manufacture;
        this.shelf_time = shelf_time;
    }

    public int getId(){
        return id;
    }
    public int getAmount(){
        return nextId;
    }
    public String getName(){
        return name;
    }
    public String getUPC(){
        return UPC;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public int getPrice(){
        return price;
    }
    public String getManufactureDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return date_of_manufacture.format(formatter);
    }
    public String getShelf_time(){
        String shelf = (shelf_time.getYear()-1) + "." + (shelf_time.getMonthValue()-1) + "." + (shelf_time.getDayOfMonth()-1);
        return shelf;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setManufactureDate(LocalDate date_of_manufacture){
        this.date_of_manufacture = date_of_manufacture;
    }
    public void setShelf_time(LocalDate shelf_time){
        this.shelf_time = shelf_time;
    }
    public boolean isExpired(){
        LocalDate now = LocalDate.now();
        LocalDate manufacture = date_of_manufacture;

        date_of_manufacture.plusYears(shelf_time.getYear()-1);
        date_of_manufacture.plusMonths(shelf_time.getMonthValue()-1);
        date_of_manufacture.plusDays(shelf_time.getDayOfMonth()-1);

        if(now.isAfter(manufacture)){
            return false;
        }else{
            return true;
        }
    }
    private String MakeUPC(){
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"+id));
    }
}
