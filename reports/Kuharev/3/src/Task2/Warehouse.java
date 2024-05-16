import java.util.ArrayList;

public class Warehouse {
    ArrayList<Product> products;
    private String warehouse_name;
    public Warehouse(String name){
        warehouse_name = name;
        products = new ArrayList<Product>();
    }
    public String getName(){
        return warehouse_name;
    }
    public void setName(String name){
        this.warehouse_name = name;
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public void ShowList(){
        System.out.println("All products: ");
        for(int i = 0; i < products.size(); ++i){
            System.out.println(i+"." + products.get(i).getName() +
                    "\n\tUPC: " + products.get(i).getUPC() +
                    "\n\tManufacturer: " + products.get(i).getManufacturer()+
                    "\n\tPrice: " + products.get(i).getPrice() +
                    "\n\tDate of manufacture: " + products.get(i).getManufactureDate() +
                    "\n\tShelf life: " + products.get(i).getShelf_time());
        }
        System.out.println("Total: " + products.size());
    }
    public void ShowListOf(String name){
        int total = 0;
        System.out.println("Products with name '" + name + "': ");
        for(int i = 0; i < products.size(); ++i){
            if(products.get(i).getName().equals(name)){
                ++total;
                System.out.println(i+"." + products.get(i).getName() +
                        "\n\tUPC: " + products.get(i).getUPC() +
                        "\n\tManufacturer: " + products.get(i).getManufacturer()+
                        "\n\tPrice: " + products.get(i).getPrice() +
                        "\n\tDate of manufacture: " + products.get(i).getManufactureDate() +
                        "\n\tShelf life: " + products.get(i).getShelf_time());
            }
        }
        System.out.println("Total: " + total);
    }
    public void ShowListOf(String name, int max_price){
        int total = 0;
        System.out.println("Products with name '" + name + "' and price under " + max_price + ": ");
        for(int i = 0; i < products.size(); ++i){
            if(products.get(i).getName().equals(name) && products.get(i).getPrice() <= max_price){
                ++total;
                System.out.println(i+"." + products.get(i).getName() +
                        "\n\tUPC: " + products.get(i).getUPC() +
                        "\n\tManufacturer: " + products.get(i).getManufacturer()+
                        "\n\tPrice: " + products.get(i).getPrice() +
                        "\n\tDate of manufacture: " + products.get(i).getManufactureDate() +
                        "\n\tShelf life: " + products.get(i).getShelf_time());
            }
        }
        System.out.println("Total: " + total);
    }
    public void ExpiredShelfLifeList(){
        int total = 0;
        System.out.println("Expired products: ");
        for(int i = 0; i < products.size(); ++i){
            if(!products.get(i).isExpired()){
                ++total;
                System.out.println(i+"." + products.get(i).getName() +
                        "\n\tUPC: " + products.get(i).getUPC() +
                        "\n\tManufacturer: " + products.get(i).getManufacturer()+
                        "\n\tPrice: " + products.get(i).getPrice() +
                        "\n\tDate of manufacture: " + products.get(i).getManufactureDate() +
                        "\n\tShelf life: " + products.get(i).getShelf_time());
            }
        }
        System.out.println("Total: " + total);
    }
}
