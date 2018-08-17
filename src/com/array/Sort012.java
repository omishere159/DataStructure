package com.array;

public class Sort012 {

	public void sortArray(int[] arr)
	{
		int lo = 0,mid = 0,temp = 0;
		int high = arr.length -1;
		
		while( mid <= high)
		{
			switch (arr[mid]) {
			case 0:
				temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;
				lo++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
				break;
			}
		}
	}
	
	public void printArray(int[] arr)
	{
		for( int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 1, 0, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		Sort012 lSort = new Sort012();
		lSort.printArray(arr);
		lSort.sortArray(arr);;
		System.out.println("Array After Sorting : ");
		lSort.printArray(arr);
	}
}
