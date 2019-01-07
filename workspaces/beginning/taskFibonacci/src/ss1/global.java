package ss1;

import java.util.Scanner;
import java.util.Arrays; 
import java.math.RoundingMode;



public class global 
{
	public static void main (String[] args) 
	{
		double[] fibb = new double[1002];
		fibb[0] = fibb[1] = 1;
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		
		for(int i = 2; i < n + 1; ++i) 
		{
			fibb[i] = fibb[i - 1] + fibb[i - 2];
		}
		
		reader.close();
		double y = fibb[n];
		long x = Math.round(y);
		System.out.println(fibb[n]);
	}
}
