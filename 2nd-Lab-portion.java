
1] FractionalKnapsack :

import java.util.*;

class Item {
    int weight, value;
    Item(int w, int v) { weight = w; value = v; }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and value of item " + (i + 1) + ": ");
            int w = sc.nextInt(), v = sc.nextInt();
            items[i] = new Item(w, v);
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        Arrays.sort(items, (a, b) -> Double.compare((double)b.value/b.weight, (double)a.value/a.weight));

        double maxValue = 0;
        for (Item item : items) {
            if (W == 0) break;
            if (item.weight <= W) {
                maxValue += item.value;
                W -= item.weight;
            } else {
                maxValue += item.value * ((double)W / item.weight);
                W = 0;
            }
        }

        System.out.println("Maximum value in knapsack = " + maxValue);
        sc.close();
    }
}


2] JobAssignmentBacktracking :

import java.util.*;

public class JobAssignmentBacktracking {
    static int[][] cost;
    static boolean[] assigned;
    static int n, minCost = Integer.MAX_VALUE;

    static void assign(int worker, int currCost) {
        if (worker == n) {
            minCost = Math.min(minCost, currCost);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!assigned[j]) {
                assigned[j] = true;
                assign(worker + 1, currCost + cost[worker][j]);
                assigned[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of workers/jobs: ");
        n = sc.nextInt();
        cost = new int[n][n];
        assigned = new boolean[n];

        System.out.println("Enter cost matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        assign(0, 0);
        System.out.println("Minimum assignment cost: " + minCost);
        sc.close();
    }
}




3] SimpleJobScheduling :

import java.util.*;

class Job {
    int start, end, profit;
    Job(int s, int e, int p) {
        start = s;
        end = e;
        profit = p;
    }
}

public class SimpleJobScheduling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter start time, end time, profit of job " + (i + 1) + ": ");
            int s = sc.nextInt(), e = sc.nextInt(), p = sc.nextInt();
            jobs[i] = new Job(s, e, p);
        }

        // Step 1: Sort jobs by end time
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        // Step 2: DP array to store max profit until each job
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int inclProfit = jobs[i].profit;

            // Find latest non-conflicting job (linear scan)
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j].end <= jobs[i].start) {
                    inclProfit += dp[j];
                    break;
                }
            }

            dp[i] = Math.max(dp[i - 1], inclProfit);
        }

        System.out.println("Maximum profit: " + dp[n - 1]);
        sc.close();
    }
}



4] TSPBacktracking :

import java.util.*;

public class TSPBacktracking {
    static int[][] graph;
    static boolean[] visited;
    static int n, minCost = Integer.MAX_VALUE;

    static void tsp(int pos, int count, int cost, int start) {
        if (count == n && graph[pos][start] > 0) {
            minCost = Math.min(minCost, cost + graph[pos][start]);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[pos][i] > 0) {
                visited[i] = true;
                tsp(i, count + 1, cost + graph[pos][i], start);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n];

        System.out.println("Enter cost matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        visited[0] = true;
        tsp(0, 1, 0, 0);

        System.out.println("Minimum TSP cost: " + minCost);
        sc.close();
    }
}

