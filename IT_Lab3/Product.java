public class Product{
    static Main main = new Main();
    static int num = main.num;
    String[] product;
    String[] price;
    String[] count;

    public Product(String[] product, String[] price, String[] count) {
        this.product = product;
        this.price = price;
        this.count = count;
    }

    public static String Return() {
        Product[] arr = new Product[5];
        arr[num] = new Product(new String[]{"apple", "milk", "meat"},
                new String[]{"20", "80", "300"},
                new String[]{"100", "50", "20"});
        return arr[num].display();
    }

    public String display() {
        return "product-" + product[num]
                + ", price-" +  price[num]
                + ", count-" +  count[num];
    }
}
