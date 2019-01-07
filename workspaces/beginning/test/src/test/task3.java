//package test;
import java.util.Scanner;
import java.util.Arrays; 

class task3 {
	public static void main(String args[]) 
	{
		Scanner reader = new Scanner(System.in); 
		int N = reader.nextInt();
		int k = reader.nextInt();
		
		int[] a = new int[k];
		for (int i = 0; i < k; ++i)
			a[i] = reader.nextInt();
		Arrays.sort(a);
		
		int i = 0;
		int amt = 0;
		while (N > 0 && i < k) 
		{
			if (N - a[i] >= 0) {N -= a[i];}
			else break;
			++i;
			++amt;
		}
		
		System.out.println(amt);
	}
}