package com.array;
import java.util.Stack;

public class ReverseArrayInGroup {
	
	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int k=3;
		printArray(arr1,"Original");
		reverseEfficient(arr1, k);
		printArray(arr1,"Group Reversed");
		reverseAlternateGrp(arr2, k);
		printArray(arr2,"Alternate Group Reversed");
		int distance = 2;
		printArray(arr3,"Original Distnace Array");
		reverseGrpAtGivenDistance(arr3, k, distance);
		printArray(arr3,"Group Reversed At Distance");
	}
	
	private static void reverseGrpAtGivenDistance(int[] arr, int k, int distance) {
		int left,right,temp;
		for( int i=0;i< arr.length;i+=(k+distance))
		{
			left = i;
			
			right = Integer.min(i+k-1, arr.length-1);
			
			while(left < right)
			{
				temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				left++;
				right--;
			}
		}
	}

	public static void printArray(int[] arr,String type)
	{
		System.out.print(type+" => ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static int[] reverseAlternateGrp(int[] arr,int k)
	{
		int left,right,temp;
		for( int i=0;i< arr.length;i+=(2*k))
		{
			left = i;
			
			right = Integer.min(i+k-1, arr.length-1);
			
			while(left < right)
			{
				temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				left++;
				right--;
			}
		}
		
		return arr;
	}
	
	public static int[] reverseEfficient(int[] arr,int k)
	{
		int left,right,temp;
		for( int i=0;i< arr.length;i+=k)
		{
			left = i;
			
			right = Integer.min(i+k-1, arr.length-1);
			
			while(left < right)
			{
				temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				left++;
				right--;
			}
		}
		
		return arr;
	}
	
	public static int[] reverse(int[] arr,int k)
	{
		int counter = 0,index=0;
		Stack<Integer> lQueue = new Stack<>();
		for(int i=0;i<arr.length;i++)
		{
			lQueue.add(arr[i]);
			counter++;
			if( counter == k)
			{
				while(!lQueue.isEmpty())
				{
					arr[index] = lQueue.pop();
					counter--;
					index++;
				}
			}
			else if( counter < k && i == arr.length-1 && !lQueue.isEmpty())
			{
				while(!lQueue.isEmpty())
				{
					arr[index] = lQueue.pop();
					index++;
				}
			}
		}
		return arr;
	}
}
