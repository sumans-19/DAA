package pgm32;
import java.util.Scanner;

public class Solution {
    public int brokenCalc(int startValue, int target) {
        int operations = 0;

        while (target > startValue) {
            if (target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
            operations++;
        }

        return operations + (startValue - target);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input startValue and target
        System.out.print("Enter startValue: ");
        int startValue = scanner.nextInt();
        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        // Create an instance of BrokenCalculator
        Solution calculator = new Solution();

        // Calculate the minimum number of operations
        int result = calculator.brokenCalc(startValue, target);

        // Output the result
        System.out.println("Minimum operations: " + result);

        scanner.close();
    }
}
