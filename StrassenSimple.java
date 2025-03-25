import java.util.Scanner;

public class StrassenSimple {

    // Function to multiply two 2x2 matrices using Strassen's formula
    public static int[][] strassenMultiply(int[][] A, int[][] B) {
        int C[][] = new int[2][2];

        // Strassen's sub-expressions
        int p1 = (A[0][0] + A[1][1]) * (B[0][0] + B[1][1]);
        int p2 = (A[1][0] + A[1][1]) * B[0][0];
        int p3 = A[0][0] * (B[0][1] - B[1][1]);
        int p4 = A[1][1] * (B[1][0] - B[0][0]);
        int p5 = (A[0][0] + A[0][1]) * B[1][1];
        int p6 = (A[1][0] - A[0][0]) * (B[0][0] + B[0][1]);
        int p7 = (A[0][1] - A[1][1]) * (B[1][0] + B[1][1]);

        // Computing the resulting m+atrix
        C[0][0] = p1 + p4 - p5 + p7;
        C[0][1] = p3 + p5;
        C[1][0] = p2 + p4;
        C[1][1] = p1 + p3 - p2 + p6;

        return C;
    }

    // Function to print a 2x2 matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input 2x2 matrices
        int[][] A = new int[2][2];
        int[][] B = new int[2][2];

        System.out.println("Enter elements of first 2x2 matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements of second 2x2 matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        // Multiply using Strassen's Algorithm
        int[][] result = strassenMultiply(A, B);

        System.out.println("Resultant Matrix:");
        printMatrix(result);
    }
}