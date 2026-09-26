package com.mycompany.productsales;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static final int YEARS = 2;
    static final int QUARTERS = 3;

    public static void main(String[] args) {
        int[][] productSales = readProductSales();

        ProductSales calculator = new ProductSales();

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("----------------------------");

        System.out.printf("%-8s%-10s%-10s%-10s%n", "", "Quarter1", "Quarter2", "Quarter3");
        for (int year = 0; year < productSales.length; year++) {
            System.out.printf("%-8s", "Year" + (year + 1));
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                System.out.printf("%-10d", productSales[year][quarter]);
            }
            System.out.println();
        }

        System.out.println("----------------------------");
        System.out.println("Total sales: " + (int) calculator.getSalesMetric(SalesMetric.TOTAL_SALES, productSales));
        System.out.println("Average sales: " + Math.round(calculator.getSalesMetric(SalesMetric.AVERAGE_SALES, productSales)));
        System.out.println("Maximum sale: " + (int) calculator.getSalesMetric(SalesMetric.MAXIMUM_SALE, productSales));
        System.out.println("Minimum sale: " + (int) calculator.getSalesMetric(SalesMetric.MINIMUM_SALE, productSales));
        System.out.println("----------------------------");
    }

    static int[][] readProductSales() {
        Scanner scanner = new Scanner(System.in);
        int[][] productSales = new int[YEARS][QUARTERS];

        for (int year = 0; year < YEARS; year++) {
            for (int quarter = 0; quarter < QUARTERS; quarter++) {
                int value = -1;
                while (value < 0) {
                    System.out.printf("Enter sales for Year%d Quarter%d: ", year + 1, quarter + 1);
                    try {
                        value = scanner.nextInt();
                        if (value < 0) {
                            System.out.println("Sales cannot be negative, try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a whole number.");
                        scanner.nextLine();
                        value = -1;
                    }
                }
                productSales[year][quarter] = value;
            }
        }
        return productSales;
    }
}
