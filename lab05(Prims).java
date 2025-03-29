
import java.util.Arrays;
import java.util.Scanner;
public class Prims {
static int a[][];
static int V; 
public static void main(String args[]) 
{
System.out.println("Enter the number of vertices\n");
Scanner scanner = new Scanner(System.in);
V = scanner.nextInt();
a = new int[V][V];
System.out.println("Enter the Cost Matrix \n");
for (int i = 0; i < V; i++) 
{
for (int j = 0; j < V; j++) 
{
a[i][j] = scanner.nextInt();
}
}
Prim();
scanner.close();
}
public static void Prim() 
{
 int no_edge=0,sum=0;
 boolean[] selected = new boolean[V];
 Arrays.fill(selected, false);
 selected[0] = true;
 System.out.println("Edge : Weight");
 while (no_edge < V - 1) 
 {
 int x=0,y=0,min = 999;
 for (int i = 0; i < V; i++) 
 {
 if (selected[i] == true) 
 {
 for (int j = 0; j < V; j++) 
 {
 if (!selected[j] && a[i][j] != 0) 
 {
 if (min > a[i][j])
 min = a[i][j];
 x=i;
y=j;
 }
 }
}
 }
 System.out.println(x + " - " + y + " : " + a[x][y]);
 sum=sum+a[x][y];
 selected[y] = true;
 no_edge++;
 }
 System.out.println("Cost of Tree: "+sum);
 }
}
