package com.array;

public class MaximumOfSubArraySizeK {

	public static void main(String[] args) {
		
		/*int[]  arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3;*/
		int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int k=4;
		int[] lMaxArray = getMaximum(arr, k);
		printArray(lMaxArray);
	}
	
	private static void printArray(int[] lMaxArray) {
		
		for(int i=0;i< lMaxArray.length;i++)
		{
			System.out.print(lMaxArray[i]+" ");
		}
		System.out.println();
	}

	public static int[] getMaximum(int[] arr,int k)
	{
		int[] result = new int[arr.length-k+1];
		
		int lMax = getMax(arr,0,k-1);
		result[0] = lMax;
		for(int i=k,j=1;i<arr.length;i++,j++)
		{
			lMax = getMax(arr, j, i);
			/*if( lMax < arr[i])
			{
				 lMax = arr[i];
			}*/
			result[j] = lMax;
		}
		return result;
	}

	private static int getMax(int[] arr, int i, int j) {
		int lmax = arr[i];
		for(int m=i+1;m<=j;m++)
		{
			if( lmax < arr[m])
			{
				lmax = arr[m];
			}
		}
		return lmax;
	}
}
