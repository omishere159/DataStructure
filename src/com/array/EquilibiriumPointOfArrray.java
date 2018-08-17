package com.array;

public class EquilibiriumPointOfArrray {

	public int getEquilibiriumIndex(int[] arr)
	{
		int totalSum=0,leftSum=0,N = arr.length;
		
		for( int i=0;i<N;i++)
		{
			totalSum+=arr[i];
		}
		System.out.println();
		for(int i=0;i<N;i++)
		{
			totalSum =- arr[i];
			if( totalSum == leftSum)
			{
				return i;
			}
			leftSum+=arr[i];
		}
		return -1;
	}
	public static void main(String[] args) {
		EquilibiriumPointOfArrray lEqPoint = new EquilibiriumPointOfArrray();
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		System.out.println(lEqPoint.getEquilibiriumIndex(arr));
	}
}

