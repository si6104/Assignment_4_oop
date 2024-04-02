/* *****************
Title:      Tools Class
Author:     Sai Trivedi
Date:       April 1, 2024
Purpose:    A Tools class all the common methods
***************** */

// Importing necessary Java libraries
import java.time.LocalDate;
import java.util.Scanner;

// Tools class definition
public class Tools {
    private static Scanner sc = new Scanner(System.in);

    // Method to get an integer input from the console
    public static int getIntFromConsole() throws NumberFormatException {
        while (true) {
            try {
                String inputString = sc.nextLine();
                if (!isValidInt(inputString)) {
                    throw new NumberFormatException();
                }
                return Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
    }

    // Method to get a double input from the console
    public static double getDblFromConsole() throws NumberFormatException {
        while (true) {
            try {
                String inputString = sc.nextLine();
                if (!isValidDbl(inputString)) {
                    throw new NumberFormatException();
                }
                return Double.parseDouble(inputString);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
    }

    // Method to get a string input from the console
    public static String getStringFromConsole() {
        return sc.nextLine();
    }

    // Method to get a LocalDate input from the console
    public static LocalDate getUserInputDate() throws Exception {
        while (true) {
            try {
                return LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                throw new Exception();
            }
        }
    }

    // Optional methods for input validation
    private static boolean isValidDbl(String inputString) {
        try {
            Double.parseDouble(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidInt(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
