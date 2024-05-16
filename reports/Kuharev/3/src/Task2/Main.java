import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Warehouse name can't be empty!");
            System.exit(1);
        }
        Warehouse storage1 = new Warehouse(args[0]);
        ManageStorage(storage1);
    }
    private static int ManageStorage(Warehouse storage){
        Scanner in = new Scanner(System.in);
        int choose = 0;
        while(true){
            ShowName(storage.getName());
            Menu();
            try{
                choose = in.nextInt();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                in.nextLine();
                ManageStorage(storage);
            }
            in.nextLine();
            switch (choose){
                case Const.EXIT:
                    System.exit(Const.EXIT);
                    break;
                case Const.CHANGE_NAME:
                    ShowName(storage.getName());
                    ChangeName(storage);
                    ManageStorage(storage);
                    break;
                case Const.ADD_PRODUCT:
                    ShowName(storage.getName());
                    AddProduct(storage);
                    ManageStorage(storage);
                    break;
                case Const.SHOW_ALL:
                    ShowName(storage.getName());
                    ShowAll(storage);
                    ManageStorage(storage);
                    break;
                case Const.SHOW_BY_NAME:
                    ShowName(storage.getName());
                    ShowByName(storage);
                    ManageStorage(storage);
                    break;
                case Const.SHOW_BY_NAME_AND_PRICE:
                    ShowName(storage.getName());
                    ShowByNamePrice(storage);
                    ManageStorage(storage);
                    break;
                case Const.SHOW_EXPIRED:
                    ShowName(storage.getName());
                    ShowExpired(storage);
                    ManageStorage(storage);
                    break;
                case Const.BACK:
                    ShowName(storage.getName());
                    ManageStorage(storage);
                    break;
                default:
                    System.out.println("No such action");
                    continue;
            }
            break;
        }
        return Const.ALL_PROCESSED;
    }
    private static void Menu(){
        System.out.println("1 - Change name;\n2 - Add product\n3 - Show all products\n" +
                "4 - Show products list with selected name\n" +
                "5 - Show products list with selected name with price lower then selected\n" +
                "6 - Show products with expired shelf life date\n7 - Back\n0 - Exit\nChoose action: ");
    }
    private static void ChangeName(Warehouse storage){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter new name: " );
        storage.setName(in.nextLine());
    }
    private static void AddProduct(Warehouse storage){
        Scanner in = new Scanner(System.in);
        Product prod;
        System.out.println("Choose action:\n\t1 - Auto product\n\t2 - Enter name, manufacturer and price\n\t3 - Enter all data");
        int choose = 0;
        try{
            choose = in.nextInt();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            ManageStorage(storage);
        }
        in.nextLine();
        String name, manufacturer;
        int price = 0;
        LocalDate date_of_manufacture, shelf_time;
        int year_of_manufacture = 0, month_of_manufacture = 0, day_of_manufacture = 0;
        int shelf_year = 1, shelf_month = 1, shelf_day = 1;
        switch (choose){
            case Const.AUTO:
                prod = new Product();
                storage.addProduct(prod);
                break;
            case Const.MINIMAL:
                ShowName(storage.getName());
                System.out.print("Enter product name: "); name = in.nextLine();
                System.out.print("Enter product manufacturer: "); manufacturer = in.nextLine();
                System.out.print("Enter product price: "); price = in.nextInt();
                prod = new Product(name, manufacturer, price);
                storage.addProduct(prod);
                break;
            case Const.ALL:
                ShowName(storage.getName());
                System.out.print("Enter product name: "); name = in.nextLine();
                System.out.print("Enter product manufacturer: "); manufacturer = in.nextLine();
                System.out.print("Enter product price: ");
                try{
                    price = in.nextInt();
                }catch(Exception ex){
                    ex.getMessage();
                    in.nextLine();
                    AddProduct(storage);
                }
                System.out.print("\t- Enter year of manufacture: ");
                if (in.hasNextInt()) {
                    year_of_manufacture = in.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer value.");
                    AddProduct(storage);
                }
                System.out.print("\t- Enter month of manufacture: ");
                if (in.hasNextInt()) {
                    month_of_manufacture = in.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer value.");
                    AddProduct(storage);
                }
                System.out.print("\t- Enter day of manufacture: ");
                if (in.hasNextInt()) {
                    day_of_manufacture = in.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer value.");
                    AddProduct(storage);
                }
                date_of_manufacture = LocalDate.of(year_of_manufacture, month_of_manufacture, day_of_manufacture);
                System.out.print("\t- Enter years of shelf time: ");
                if (in.hasNextInt()) {
                    shelf_year += in.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer value.");
                    AddProduct(storage);
                }
                System.out.print("\t- Enter months of shelf time: ");
                if (in.hasNextInt()) {
                    shelf_month += in.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer value.");
                    AddProduct(storage);
                }
                System.out.print("\t- Enter days of shelf time: ");
                if (in.hasNextInt()) {
                    shelf_day += in.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer value.");
                    AddProduct(storage);
                }
                shelf_time = LocalDate.of(shelf_year, shelf_month, shelf_day);

                prod = new Product(name, manufacturer, price, date_of_manufacture, shelf_time);
                storage.addProduct(prod);
                break;
            default:
                System.out.println("No such action");
                ManageStorage(storage);
                break;
        }
    }
    private static void ShowAll(Warehouse storage){
        Scanner in = new Scanner(System.in);
        storage.ShowList();
        String name = in.nextLine();
    }
    private static void ShowByName(Warehouse storage){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = in.nextLine();
        storage.ShowListOf(name);
        name = in.nextLine();
    }
    private static void ShowByNamePrice(Warehouse storage){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = in.nextLine();
        System.out.print("Enter price: ");
        int price = 0;
        try{
            price = in.nextInt();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            in.nextLine();
            ShowByNamePrice(storage);
        }
        storage.ShowListOf(name, price);
        name = in.nextLine();
        name = in.nextLine();
    }
    private static void ShowExpired(Warehouse storage){
        Scanner in = new Scanner(System.in);
        storage.ExpiredShelfLifeList();
        String name = in.nextLine();
    }
    public static void ShowName(String storage_name){
        //System.out.print("\033[H\033[J"); //it has to clear the console, but it didn't...
        System.out.println(storage_name);
    }
}