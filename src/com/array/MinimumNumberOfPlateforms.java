package com.array;

import java.util.Arrays;

public class MinimumNumberOfPlateforms {
	
	public static void main(String[] args) {
		
		int arr[]  = {900,  940, 950,  1100, 1500, 1800};
		int dep[]  = {910, 1200, 1120, 1130, 1900, 2000};
		
		System.out.println(findMinimumPlateforms(arr,dep));
		System.out.println(findPlatform(arr,dep));
	}

	private static int findMinimumPlateforms(int[] arr, int[] dep) {
		int[] trains = new int[arr.length];
		Arrays.fill(trains, 0);
		trains[0] = 1;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(dep[j] > arr[i])
				{
					trains[i] +=1;
				}
			}
		}
		
		int maxTrains = 0;
		for(int i=0;i<trains.length;i++)
		{
			if( maxTrains  < trains[i])
				maxTrains = trains[i];
		}
		return maxTrains;
	}
	
	private static int findPlatform(int[] arr,int[] dep)
	{
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i=0,j=0,platformNeeded=0;
		int result = 0;
		
		while( i < arr.length && j < dep.length)
		{
			if( arr[i] <= dep[j])
			{
				platformNeeded++;
				if( result < platformNeeded)
				{
					result = platformNeeded;
				}
				i++;
			}
			else
			{
				platformNeeded--;
				j++;
			}
		}
		
		return result;
	}
}
