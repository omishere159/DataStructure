package com.array;

public class AdditiveSequence {

	public static void main(String[] args) {
		
		//String lStr = "199100199";
		//String lStr = "235813";
		String lStr = "12122436";
		
		System.out.println("Sdditive ? "+isAdditive(lStr));
	}

	private static String isAdditive(String lStr) {
		
		int[] pattern = getPattern(lStr,lStr.length()/2,new int[2],0,1);
		return null;
	}

	private static int[] getPattern(String lStr, int k, int[] ls, int l, int m) {
		
		if( m > k)
			return ls;
		int a = Integer.parseInt(lStr.substring(0,l+1));
		int b = Integer.parseInt(lStr.substring(l+1,l+m+1));
		int sum = a + b;
		int numberOfChars = getChars(sum);
		if( sum == Integer.parseInt(lStr.substring(l+m+1,l+m+1+numberOfChars)))
		{
			ls[0] = l;
			ls[1] = m;
			return ls;
		}
		getPattern(lStr,k,ls,l,m+1);
		if(ls[1] != 0)
		{
			return ls;
		}
		else
		{
			getPattern(lStr,k,ls,l+1,m);
		}
		return ls;
	}

	private static int getChars(int sum) {
		int counter = 0;
		int res = sum;
		while( res != 0)
		{
			res = (res / 10);
			counter++;
		}
		return counter;
	}
}
