import java.time.LocalDate;

public class Const {
    final public static int INITIALIZE_INT = 0;
    final public static int ALL_PROCESSED = 0;
    //Switch-case making product
    final public static int AUTO = 1;
    final public static int MINIMAL = 2;
    final public static int ALL = 3;
    //Swith-case menu options
    final public static int EXIT = 0;
    final public static int CHANGE_NAME = 1;
    final public static int ADD_PRODUCT = 2;
    final public static int SHOW_ALL = 3;
    final public static int SHOW_BY_NAME = 4;
    final public static int SHOW_BY_NAME_AND_PRICE = 5;
    final public static int SHOW_EXPIRED = 6;
    final public static int BACK = 7;
    //Default values for Product class
    final public static String def_name = "NoName";
    final public static String def_manufacturer = "demos";
    final public static int def_price = 100;
    final public static LocalDate def_shelf_time = LocalDate.of(2, 1, 1);
}
