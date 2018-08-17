package com.array;

public class MissingNumber {
	
	public static void main(String[] args) {
		
		int N = 8;
		int[] arr = new int[]{1, 2, 4, 6, 3, 7, 8};
		MissingNumber lMissingNumber = new MissingNumber();
		System.out.println( "Missing Number is : "+lMissingNumber.findMissingNumber(arr,N));
		System.out.println( "Missing Number is : "+lMissingNumber.findMissingNumberXOR(arr,N));
	}

	private int findMissingNumberXOR(int[] arr, int n) {
		
		int X1 = arr[0];
		int X2 = 1;
		
		for( int i=2;i<=n;i++)
		{
			X2 = ( X2 ^ i);
		}
		
		for( int i=1;i<n-1;i++)
		{
			X1 = ( X1 ^ arr[i]);
		}
		
		return ( X2 ^ X1);
	}

	private int findMissingNumber(int[] numberArray, int range) {
		int lRangeSum = getRangeSum(range);
		int lArraySum = 0;
		for(int i=0;i<range-1;i++)
		{
			lArraySum+=numberArray[i];
		}
		return lRangeSum - lArraySum;
	}

	private int getRangeSum(int range) {
		return (range*(range+1))/2;
	}
}
