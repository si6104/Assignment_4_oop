/* *****************
Title:      PerishableProduct Class
Author:     Sai Trivedi
Date:       April 1, 2024
Purpose:    A PerishableProduct class for getters and setters of PerishableProduct and to get all methods of product
***************** */

// Importing necessary Java libraries
import java.time.LocalDate;
import java.util.ArrayList;

// PerishableProduct class definition, inheriting from Product class
public class PerishableProduct extends Product {
    private LocalDate expiryDate;
    public PerishableProduct() {
        super();
        this.expiryDate = LocalDate.now();
    }

    // Parameterized constructor
    public PerishableProduct(int sku, String productName, double unitCost, int quantityOnHand, int quantityNeeded,
                             String specialInstructions, LocalDate expiryDate) {
        super(sku, productName, unitCost, quantityOnHand, quantityNeeded, specialInstructions);

        this.expiryDate = expiryDate;
    }

    // Getter method for expiry date
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Setter method for expiry date
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Overriding toString method to include expiry date
    @Override
    public String toString() {
        String baseDetails = super.toString();
        StringBuilder sb = new StringBuilder(baseDetails);
        sb.append("\nExpiry Date: ").append(expiryDate);
        return sb.toString();
    }

    // Method to generate a formatted table of non-perishable products
    public static String productToTable(ArrayList<Product> productList) {
        StringBuilder table = new StringBuilder();
        table.append(String.format("| %-10s | %-20s | $%-10s | %-15s | %-17s | %-29s | %-15s |%n", "Product sku", "Product Name",
                "Unit Cost", "Quantity on hand", "Quantity Needed", "Special Instructions", "Expiry Date"));
        table.append("|-------------|----------------------|-------------|------------------|-------------------|-------------------------------|-----------------|\n");
        for (Product product : productList) {
            table.append(String.format("| %-11d | %-20s | $%-10f | %-15d | %-17d | %-30s | %-15s |%n",
                    product.getSku(), product.getProductName(), product.getUnitCost(), product.getQuantityOnHand(),
                    product.getQuantityNeeded(), product.getSpecialInstructions(), "-"));
        }
        return table.toString();
    }

    // Method to generate a formatted table of perishable products
    public static String perishableProductToTable(ArrayList<PerishableProduct> perishableProductList) {
        StringBuilder table = new StringBuilder();
        for (PerishableProduct perishableProduct : perishableProductList) {
            table.append(String.format("| %-11d | %-20s | $%-10f | %-15d | %-17d | %-30s | %-15s |%n",
                    perishableProduct.getSku(), perishableProduct.getProductName(), perishableProduct.getUnitCost(), perishableProduct.getQuantityOnHand(),
                    perishableProduct.getQuantityNeeded(), perishableProduct.getSpecialInstructions(), perishableProduct.getExpiryDate()));
        }
        return table.toString();
    }
}
