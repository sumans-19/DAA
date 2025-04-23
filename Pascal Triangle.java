package pgm32;

import java.util.Scanner;

public class Arr {
    // Method to print Pascal's Triangle
    public static void printPascal(int numRows) {
        for (int row = 0; row < numRows; row++) {
            int value = 1; // First value in each row is always 1

            // Print leading spaces for alignment
            for (int space = 0; space < numRows - row - 1; space++) {
                System.out.print(" ");
            }

            // Print values in the current row
            for (int col = 0; col <= row; col++) {
                System.out.print(value + " ");
                value = value * (row - col) / (col + 1); // Calculate next value using binomial coefficient
            }

            // Move to the next line after each row
            System.out.println();
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of rows
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int numRows = scanner.nextInt();

        // Print the Pascal's Triangle
        printPascal(numRows);

        scanner.close();
    }
}
