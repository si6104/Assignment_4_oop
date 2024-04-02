/* *****************
Title:      Driver Class
Author:     Sai Trivedi
Date:       April 1, 2024
Purpose:    A Driver class to test product and perishibleProducts.
***************** */

// Importing necessary Java libraries
import java.time.LocalDate;
import java.util.ArrayList;

// Driver class definition
public class Driver {
    public static void main(String[] args) {
        // Creating instances of Product and PerishableProduct
        Product product1 = new Product(1001, "Milk", 2.99, 20, 50, "Keep Refrigerated");
        Product product2 = new Product(1002, "Bread", 1.99, 30, 40, "Store in a cool, dry place");
        Product product3 = new Product(1003, "Eggs", 4.49, 50, 60, "Handle with care");
        PerishableProduct perishableProduct1 = new PerishableProduct(2001, "Yogurt", 3.49, 15, 25, "Keep Refrigerated",
                LocalDate.of(2024, 4, 15));
        PerishableProduct perishableProduct2 = new PerishableProduct(2002, "Cheese", 5.99, 10, 20,
                "Store in a cool, dry place", LocalDate.of(2024, 5, 10));

        // Creating ArrayLists to store products and perishableProducts
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        ArrayList<PerishableProduct> perishableProducts = new ArrayList<>();
        perishableProducts.add(perishableProduct1);
        perishableProducts.add(perishableProduct2);

        // Displaying details of non-perishable products
        System.out.println("Details of Non-Perishable Products:");
        System.out.println(displayProductDetails(products));

        // Displaying details of perishable products
        System.out.println("\nDetails of Perishable Products:");
        System.out.println(displayPerishableProductDetails(perishableProducts));
    }

    // Method to display details of non-perishable products
    private static String displayProductDetails(ArrayList<Product> products) {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append(product).append("\n\n");
        }
        return sb.toString();
    }

    // Method to display details of perishable products
    private static String displayPerishableProductDetails(ArrayList<PerishableProduct> perishableProducts) {
        StringBuilder sb = new StringBuilder();
        for (PerishableProduct perishableProduct : perishableProducts) {
            sb.append(perishableProduct).append("\n\n");
        }
        return sb.toString();
    }
}
