package com.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javafx.scene.effect.Lighting;

public class LeadersInArray {
	
	public static void main(String[] args) {
		int[] arr = {16, 17, 4, 3, 5, 2};
		
		leaderSimple(arr);
		leaderEfficient(arr);
	}

	private static void leaderSimple(int[] arr) {
		
		int N = arr.length;
		boolean lIsLeader;
		for(int i=0;i<N-1;i++)
		{
			lIsLeader = true;
			for(int j=i+1;j<N;j++)
			{
				if( arr[j] > arr[i])
				{
					lIsLeader = false;
					break;
				}
			}
			if(lIsLeader)
			{
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println(arr[arr.length-1]+" ");
	}
	
	private static void leaderEfficient(int[] arr)
	{
		Stack<Integer> lStack = new Stack<>();
		
		lStack.push(arr[arr.length-1]);
		for(int i=arr.length-2;i>=0;i--)
		{
			if( arr[i] > lStack.peek())
			{
				lStack.push(arr[i]);
			}
		}
		System.out.println(lStack);
	}
}
