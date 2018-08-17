package com.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PrintMaximumSumIncreasingSubSequence {

	public int getIncreasinngSubSequence(int[] arr)
	{
		int lSum =arr[arr.length-1];
		Stack<Integer> lSeq = new Stack<>();
		lSeq.add(arr[arr.length-1]);
		for(int i=arr.length-2;i>=0;i--)
		{
			if( lSum < arr[i])
			{
				lSum = arr[i];
				lSeq.clear();
				lSeq.add(arr[i]);
			}
			else if( arr[i] < lSeq.peek())
			{
				lSum+=arr[i];
				lSeq.add(arr[i]);
			}
			else
			{
				int temp = lSeq.pop();
				boolean lISMod = false;
				while( arr[i] < lSeq.peek())
				{
					if( temp < arr[i])
					{
						lSum-=temp;
						temp = lSeq.pop();
						lISMod = true;
					}
					else
					{
						break;
					}
				}
				if( lISMod )
				{
					lSum +=arr[i];
					lSeq.push(temp);
					lSeq.push(arr[i]);
				}
				else
				{
					lSeq.push(temp);
				}
				
			}
		}
		System.out.print("Seq => [ ");
		while( !lSeq.isEmpty())
		{
			System.out.print(lSeq.pop()+" ");
		}
		System.out.print(" ]");
		return lSum;
	}
	
	static int maxSumIS( int arr[], int n )
    {
        int i, j, max = 0;
        int msis[] = new int[n];
        List<Integer> lst = new ArrayList<>();
        /* Initialize msis values for all indexes */
        for ( i = 0; i < n; i++ )
            msis[i] = arr[i];
 
        /* Compute maximum sum values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] &&
                     msis[i] < msis[j] + arr[i])
                {
                    msis[i] = msis[j] + arr[i];
                    lst.add(msis[j]);
                }
 
        /* Pick maximum of all msis values */
        for ( i = 0; i < n; i++ )
        {
            if ( max < msis[i] )
                max = msis[i];
        }
 
        System.out.print(lst );
        return max;
    }
	public static void main(String[] args) {
		PrintMaximumSumIncreasingSubSequence lSeq = new PrintMaximumSumIncreasingSubSequence();
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		int[] arr1 = {3, 4, 5, 10};
		int[] arr2 = {10, 5, 4, 3};
		int[] arr3 = {3, 2, 6, 4, 5, 1};
		int[] arr4 = { 726,32,493,143,223,287,65,901,188,361,414,975,271,171,236,834,712,761,897,668,286,551,141,695,696,625,20,126,577,695,659,303,372,467,679,594,852,485,19,465,120,153,801,88,61,927,11,758,171,316,577,228,44,759,165,110,883,87,566,488,578,475,626,628,630,929,424,521,903,963,124,597,738,262,196,526,265,261,203,117,31,327,12,772,412,548,154,521,791,925,189,764,941,852 };
		System.out.println(" || Sum => "+lSeq.getIncreasinngSubSequence(arr));
		System.out.println(" || Sum => "+lSeq.getIncreasinngSubSequence(arr1));
		System.out.println(" || Sum => "+lSeq.getIncreasinngSubSequence(arr2));
		System.out.println(" || Sum => "+lSeq.getIncreasinngSubSequence(arr3));
		System.out.println(" || Sum => "+lSeq.getIncreasinngSubSequence(arr4));
		System.out.println(" || Sum => "+maxSumIS(arr4,arr4.length));
	}
}
