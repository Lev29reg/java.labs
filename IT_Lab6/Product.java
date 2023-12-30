import java.util.HashMap;
import java.util.Map;

public class Product {
    private HashMap<String, Integer> salesData;

    public Product() {
        salesData = new HashMap<>();
    }

    public void addSale(String product, int quantity) {
        salesData.put(product, salesData.getOrDefault(product, 0) + quantity);
    }

    public void displaySales() {
        System.out.println("List of sold products:");
        for (Map.Entry<String, Integer> entry : salesData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " pc.");
        }
    }

    public void calculateTotalSales() {
        int totalSales = 0;
        for (int quantity : salesData.values()) {
            totalSales += quantity;
        }
        System.out.println("Total sales amount: " + totalSales + " pc.");
    }

    public void findMostPopularProduct() {
        String mostPopularProduct = null;
        int maxQuantity = 0;

        for (Map.Entry<String, Integer> entry : salesData.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                mostPopularProduct = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }

        if (mostPopularProduct != null) {
            System.out.println("Most popular product: " + mostPopularProduct);
        } else {
            System.out.println("There are no sales.");
        }
    }

    public static void main(String[] args) {
        Product products = new Product();

        products.addSale("ProductA", 5);
        products.addSale("ProductB", 10);
        products.addSale("ProductA", 3);
        products.addSale("ProductC", 20);
        products.addSale("ProductB", 5);

        products.displaySales();
        products.calculateTotalSales();
        products.findMostPopularProduct();
    }
}