2. Implement a merge sort algorithm to sort a given set of elements and determine 
the time required to sort the elements. Repeat the experiment for different values 
of n, the number of elements in the list to be sorted and plot a graph of the time 
taken versus n. The elements can be read from a file or can be generated using the 
random number generator.

package DAALab;

import java.util.*;

public class mergesort {

	static final int MAX = 10005;
	static int[] a = new int[MAX];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter the numbe rof elemnts required : ");
		int n = input.nextInt();
		Random random = new Random(1000);
		System.out.println("enter your choice :  1.Enter the elements manually 2.Randomly generate the value");
		int choice = input.nextInt();
		switch (choice) {
		case 2:
			for (int i = 0; i < n; i++) {
				a[i] = random.nextInt(1000);
			}
			break;
		case 1: 
			for (int i = 0; i < n; i++) {
				a[i] = input.nextInt();
			}
			break;
		default:
			System.out.println("Invalid choice");
		}
		System.out.println("the Array elemnts are : ");
		for (int i = 0; i < n; i++) {
			System.out.println(a[i] + " ");
		}
		
		long startTime = System.nanoTime();
		MergeSort(0,n-1);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("time complexity for n = " + n + " in ms is " +
				(double)timeElapsed/100000);
		
		System.out.println("the sorted elemnts are :");
		for(int i=0;i<n;i++) {
			System.out.println(a[i] + " ");
		}
	}
	
	public static void MergeSort(int low , int high) {
		int mid;
		if(low<high) {
			mid = (low+high) / 2;
			MergeSort(low,mid);
			MergeSort(mid+1,high);
			Merge(low,mid,high);
		}
		
	}
	
	public static void Merge(int low, int mid , int high) {
		int[] b = new int[MAX];
		int i,j,k,h;
		h=i=low;
		j=mid+1;
		while((h<= mid ) && (j<=high)) {
			if(a[h] < a[j]) {
				b[i++] = a[h++];}
				else {
					b[i++] = a[j++];
				}
		if(h>mid){
			for(k=j;k<=mid ;k++) {
				b[i++] = a[k];
			}
		}else {
			for(k=h;k<=mid ;k++) {
				b[i++] = a[k];			}
		}
		for(k = low ;k<=mid ;k++) {
			a[k] = b[k];
		}
		}
				
			}
	}
