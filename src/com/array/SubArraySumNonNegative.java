package com.array;

public class SubArraySumNonNegative {

	public static void main(String[] args) {
		
		int arr[] = {15, 2, 4, 8, 9, 5, 10, 2};
        int n = arr.length;
        int sum = 12;
        
        SubArraySumNonNegative lSum = new SubArraySumNonNegative();
        lSum.findSubArraySum(arr,n,sum);
        lSum.efficientApproach(arr,n,sum);
	}

	private int efficientApproach(int[] arr, int n, int sum) {
		
		int curr_sum = arr[0], start = 0, i;
		 
        // Pick a starting point
        for (i = 1; i <= n; i++) 
        {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i-1)
            {
                curr_sum = curr_sum - arr[start];
                start++;
            }
             
            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum) 
            {
                int p = i-1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                return 1;
            }
             
            // Add this element to curr_sum
            if (i < n)
            curr_sum = curr_sum + arr[i];
             
        }
 
        System.out.println("No subarray found");
        return 0;
	}

	private int findSubArraySum(int[] arr, int n, int sum) {
		
		int lSubArraySum;
		boolean lSumFound = false;
		
		for(int i=0;i<n;i++)
		{
			lSubArraySum = arr[i];
			
			for( int j=i+1;j<n;j++)
			{
				lSubArraySum+=arr[j];
				if( lSubArraySum == sum)
				{
					System.out.println("Sum found between "+i+" and "+(j)+" indexes");
					lSumFound = true;
					break;
				}
				if( lSubArraySum > sum || j == n)
					break;
			}
		}
		if( ! lSumFound )
		{
			System.out.println("No SubArray Found");
			return 0;
		}
		return 1;
	}
}
