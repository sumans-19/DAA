class MaxMinFinder {
    static void findMaxMin(int[] arr, int low, int high, int[] maxMin) {
        
        if (low == high) {
            maxMin[0] = arr[low]; // max
            maxMin[1] = arr[low]; // min
            return;
        }

        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                maxMin[0] = arr[low]; // max
                maxMin[1] = arr[high]; // min
            } else {
                maxMin[0] = arr[high]; // max
                maxMin[1] = arr[low]; // min
            }
            return;
        }

        int mid = (low + high) / 2;
        int[] leftMaxMin = new int[2];
        int[] rightMaxMin = new int[2];

        findMaxMin(arr, low, mid, leftMaxMin);
        findMaxMin(arr, mid + 1, high, rightMaxMin);

        maxMin[0] = Math.max(leftMaxMin[0], rightMaxMin[0]);
        maxMin[1] = Math.min(leftMaxMin[1], rightMaxMin[1]);
    }

    public static void main(String[] args) {
        int[] arr = {24, 15, -5, -8, 15, 60, 19, 33, 42};
        int n = arr.length;
        int[] maxMin = new int[2]; 

        findMaxMin(arr, 0, n - 1, maxMin);

        System.out.println("Maximum value: " + maxMin[0]);
        System.out.println("Minimum value: " + maxMin[1]);
    }
}