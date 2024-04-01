/* *****************
Title:      Main Class
Author:     Sai Trivedi
Date:       April 1, 2024
Purpose:    A Main class is to run the app
***************** */

// Importing necessary Java libraries
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Main class definition
public class Main {
    // ArrayLists to store products and perishable products
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<PerishableProduct> perishableProducts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Main method to start the program
    public static void main(String[] args) {
        loadData();

        boolean exit = false;
        while (!exit) {
            // Displaying main menu options
            System.out.println("\nMain Menu:");
            System.out.println("1. Display Products List");
            System.out.println("2. Display Product");
            System.out.println("3. Add new Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = getUserChoice();

            // Switch case to handle user input
            switch (choice) {
                case 1:
                    displayProductsList();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    addNewProduct();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Please enter a valid input.");
            }
        }
    }

    // Method to get user input for menu choice
    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Please enter a valid input.");
            return getUserChoice();
        }
    }

    // Method to load initial data into products ArrayLists
    private static void loadData() {
        products.add(new Product(1001, "Milk", 2.99, 20, 50, "Keep Refrigerated"));
        products.add(new Product(1002, "Bread", 1.99, 30, 40, "Store in a cool, dry place"));
        products.add(new Product(1003, "Eggs", 4.49, 50, 60, "Handle with care"));
        perishableProducts.add(
                new PerishableProduct(2001, "Yogurt", 3.49, 15, 25, "Keep Refrigerated", LocalDate.of(2024, 4, 15)));
        perishableProducts.add(new PerishableProduct(2002, "Cheese", 5.99, 10, 20, "Store in a cool, dry place",
                LocalDate.of(2024, 5, 10)));
    }

    private static void displayProductsList() {
        System.out.println("\nList of Products:");
        System.out.println(PerishableProduct.productToTable(products));
        System.out.println(PerishableProduct.perishableProductToTable(perishableProducts));
    }

    // Method to display list of products
    private static void displayProduct() {
        int sku;
        try {
            System.out.println("Enter SKU of the product: ");
            sku = Tools.getIntFromConsole();
        } catch (NumberFormatException e) {

            System.out.println("please enter a valid input.");
            return;
        }

        boolean found = false;

        // Check non-perishable products
        for (Product product : products) {
            if (product.getSku() == sku) {
                System.out.println("non-Perishable Product Found:");
                System.out.println(product);
                found = true;
                break;
            }
        }

        // Check perishable products if not found in non-perishable
        if (!found) {
            for (PerishableProduct perishableProduct : perishableProducts) {
                if (perishableProduct.getSku() == sku) {
                    System.out.println("Perishable Product Found:");
                    System.out.println(perishableProduct);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Product with SKU " + sku + " not found.");
        }
    }

    // Method to add a new product
    private static void addNewProduct() {
        System.out.println("Add a New Product:");

        int productType = getProductType();

        // If product type is invalid return
        if (productType == -1) {
            System.out.println("Invalid product type.");
            return;
        }
        try {
            System.out.print("Enter SKU: ");
            int sku = Tools.getIntFromConsole();
            System.out.print("Enter Product Name: ");
            String productName = Tools.getStringFromConsole();
            System.out.print("Enter Unit Cost: ");
            double unitCost = Tools.getDblFromConsole();
            System.out.print("Enter Quantity on hand: ");
            int quantityOnHand = Tools.getIntFromConsole();
            System.out.print("Enter Quantity Needed: ");
            int quantityNeeded = Tools.getIntFromConsole();
            System.out.print("Enter Special Instructions: ");
            String specialInstructions = Tools.getStringFromConsole();
            if (productType == 1) {

                products.add(
                        new Product(sku, productName, unitCost, quantityOnHand, quantityNeeded, specialInstructions));
            } else if (productType == 2) {
                LocalDate expiryDate;
                try {
                    System.out.print("Please enter a valid date (YYYY-MM-DD): ");
                    expiryDate = Tools.getUserInputDate();
                    perishableProducts.add(new PerishableProduct(sku, productName, unitCost, quantityOnHand,
                            quantityNeeded, specialInstructions, expiryDate));
                } catch (Exception e) {
                    System.out.println("please enter a valid date.");
                    return;
                }

            }

            System.out.println("product added successfully.");
        } catch (NumberFormatException e) {

            System.out.println("please enter a valid input.");
            return;

        }

    }


    // Method to get product type from user
    private static int getProductType() {
        System.out.println("Select product type:");
        System.out.println("1. Non-Perishable Product");
        System.out.println("2. Perishable Product");
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1 || choice == 2) {
                return choice;
            } else {
                return -1;
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }
}
