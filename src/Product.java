/* *****************
Title:      Product Class
Author:     Sai Trivedi
Date:       April 1, 2024
Purpose:    A Product class for getters and setters of product
***************** */


// Product class definition
public class Product {
    // Private member variables
    private int sku;
    private String productName;
    private double unitCost;
    private int quantityOnHand;
    private int quantityNeeded;
    private String specialInstructions;


    // Default constructor initializing member variables to default values
    public Product() {
        this.sku = 0;
        this.productName = "";
        this.unitCost = 0.0;
        this.quantityOnHand = 0;
        this.quantityNeeded = 0;
        this.specialInstructions = "";
    }

    // Parameterized constructor
    public Product(int sku, String productName, double unitCost, int quantityOnHand, int quantityNeeded,
                   String specialInstructions) {
        this.sku = sku;
        this.productName = productName;
        this.unitCost = unitCost;
        this.quantityOnHand = quantityOnHand;
        this.quantityNeeded = quantityNeeded;
        this.specialInstructions = specialInstructions;
    }

    // Getter method for SKU
    public final int getSku() {
        return sku;
    }

    // Setter method for SKU
    public final void setSku(int sku) {
        this.sku = sku;
    }

    // Getter method for product name
    public final String getProductName() {
        return productName;
    }

    // Setter method for product name
    public final void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter method for unit cost
    public final double getUnitCost() {
        return unitCost;
    }

    // Setter method for unit cost
    public final void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    // Getter method for quantity on hand
    public final int getQuantityOnHand() {
        return quantityOnHand;
    }

    // Setter method for quantity on hand
    public final void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    // Getter method for quantity needed
    public final int getQuantityNeeded() {
        return quantityNeeded;
    }

    // Setter method for quantity needed
    public final void setQuantityNeeded(int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    // Getter method for special instructions
    public final String getSpecialInstructions() {
        return specialInstructions;
    }

    // Setter method for special instructions
    public final void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }


    // Method to display product details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SKU: ").append(sku).append("\n");
        sb.append("Product Name: ").append(productName).append("\n");
        sb.append("Unit Cost: ").append(unitCost).append("\n");
        sb.append("Quantity on hand: ").append(quantityOnHand).append("\n");
        sb.append("Quantity Needed: ").append(quantityNeeded).append("\n");
        sb.append("Special Instructions: ").append(specialInstructions);
        return sb.toString();
    }
}
