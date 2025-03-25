import java.util.Random;
import java.util.Scanner;

public class SortingComparison {
    static final int MAX = 10005;
    static int[] a = new int[MAX];
    static int[] b = new int[MAX]; 

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Max array size: ");
        int n = input.nextInt();
        Random random = new Random();

        System.out.println("Generating random array elements:");
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(1000); 
            b[i] = a[i]; 
        }
        
        System.out.println("Input Array:");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        
        // Measure Merge Sort Time
        long startMerge = System.nanoTime();
        mergeSort(0, n - 1);
        long endMerge = System.nanoTime();
        double mergeTime = (double) (endMerge - startMerge) / 1_000_000;

        System.out.println("\nSorted Array (Merge Sort):");
        for (int i = 0; i < n; i++)
            System.out.print(b[i] + " ");
        System.out.println("\nTime Complexity (Merge Sort) in ms: " + mergeTime);

        // Measure Quick Sort Time
        long startQuick = System.nanoTime();
        quickSort(0, n - 1);
        long endQuick = System.nanoTime();
        double quickTime = (double) (endQuick - startQuick) / 1_000_000;

        System.out.println("\nSorted Array (Quick Sort):");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println("\nTime Complexity (Quick Sort) in ms: " + quickTime);
        
        input.close();
    }

    // Merge Sort Algorithm
    public static void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public static void merge(int low, int mid, int high) {
        int[] temp = new int[MAX];
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (b[i] < b[j]) temp[k++] = b[i++];
            else temp[k++] = b[j++];
        }
        while (i <= mid) temp[k++] = b[i++];
        while (j <= high) temp[k++] = b[j++];
        for (i = low; i <= high; i++) b[i] = temp[i];
    }

    // Quick Sort Algorithm
    public static void quickSort(int p, int r) {
        if (p < r) {
            int j = partition(p, r);
            quickSort(p, j - 1);
            quickSort(j + 1, r);
        }
    }

    public static int partition(int p, int r) {
        int pivot = a[p], i = p, j = r + 1;
        while (true) {
            do { i++; } while (i < r && a[i] < pivot);
            do { j--; } while (a[j] > pivot);
            if (i >= j) break;
            swap(i, j);
        }
        swap(p, j);
        return j;
    }

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}