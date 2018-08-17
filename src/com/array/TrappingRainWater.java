package com.array;

public class TrappingRainWater {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;

		System.out.println("Maximum water that " + "can be accumulated is " + findWater(arr, n));
	}

	private static String findWater(int[] arr, int n) {
		
		int left=0,right=-1;
		
		left = arr[0];
		for( int i=1;i<n;i++)
		{
			if( right == -1)
			{
				if( left < arr[i])
				{
					left = arr[i];
				}
			}
			else if( left > arr[i])
			{
				right = arr[i];
			}
			
		}
		return null;
	}
	
	
}
