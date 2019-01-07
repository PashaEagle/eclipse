//package test;
import java.util.Scanner;
import java.util.Arrays; 

class global {
	public static void main1(String args[]) 
	{
		Scanner reader = new Scanner(System.in); 
		int win_amt = 1;
		int[] win_ind = new int [100000];
		int max = 0;
		int sum = 0;
		int n= reader.nextInt();
		int m = reader.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; ++i) 
		{
			for (int j = 0; j < m; ++j) 
			{
				arr[i][j] = reader.nextInt();
			}
		}
		
		
		for (int i = 0; i < n; ++i) 
		{
			Arrays.sort(arr[i]);
		}
		int k = 0;
		max = arr[0][m - 1];
		for (int i = 1; i < n; ++i) 
		{
			if (arr[i][m - 1] > max) {max = arr[i][m - 1]; win_amt = 1; k = 0; win_ind[k] = i;}
			else if (arr[i][m - 1] == max) {++win_amt; ++k; win_ind[k] = i;}
		}
		
		
		System.out.println(win_amt);
		
		for(int i = 0; i < win_amt; ++i) 
		{
			System.out.println(win_ind[i]);
		}
		
		
		/*for (int i = 0; i < n; ++i) 
		{
			for (int j = 0; j < m; ++j) 
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		int k = 0;
		for(int i = 0; i < m; ++i) max += arr[0][i];
		
		for (int i = 0; i < n; ++i) 
		{
			sum = 0;
			for (int j = 0; j < m; ++j) 
			{
				sum += arr[i][j];
			}
			if (sum > max) {max = sum; k = 0; win_ind[k] = i; win_amt = 1;}
			else if (sum  ==  max && i != 0) {++k; win_ind[k] = i; ++win_amt;}
		}
		*/
		
	}
}