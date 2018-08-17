package com.heap;

public class HeapUtil {
	
	public static int leftOrRight(int a, int b)
	{
		if( a== b)
			return 0;
		
		return a < b ? -1 : 1;
	}
	
	public static float average(int a, int b)
	{
		return ((float)a - (float)b)/2;
	}
}
