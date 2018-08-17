package com.array;

public class ArrayPartition {

	public static void main(String[] args) {
		
		int[]  a = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int mid = a.length/2;
		int start=1,second=mid;
		int temp;
		while(second < a.length )
		{
			temp = a[second];
			shift(a,start,second);
			a[start] = temp;
			start+=2;
			second++;
		}
		print(a);
	}

	private static void print(int[] a) {
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	private static void shift(int[] a, int start, int second) {
		int temp;
		int prev  = a[start];
		while( (start+1) < a.length && start < second)
		{
			temp = a[start+1];
			a[start+1] = prev;
			prev = temp;
			start++;
		}
	}
}
