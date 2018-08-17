package com.array;

import java.util.Arrays;

public class KthSmallestLargestElement {
	
	public static void main(String[] args) {
		int[] arr = {7, 10, 4, 3, 20, 15};
		int k =4;
		System.out.println(smallest(arr, k));
	}
	
	public static int smallest(int[] arr,int k)
	{
		Arrays.sort(arr);
		
		return arr[k-1];
	}
}
