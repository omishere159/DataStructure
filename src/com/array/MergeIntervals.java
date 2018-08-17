package com.array;

import java.util.Set;
import java.util.TreeSet;

public class MergeIntervals {

	class Interval implements Comparable<Interval>
	{
		int start;
		int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Interval o) {
			if( this.start < o.start)
			{
				return -1;
			}
			else if( this.start > o.start)
			{
				return 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
		
	}
	public static void main(String[] args) {
		
		MergeIntervals lInterval = new MergeIntervals();
		int[] start = {1,2,5,6};
		int[] end = {3,4,7,8};
		lInterval.merge(start,end);
	}

	private void merge(int[] start, int[] end) {
		
		Set<Interval> lSortedInterval = new TreeSet<>();
		
		for(int i=0;i<start.length;i++)
		{
			lSortedInterval.add(new Interval(start[i], end[i]));
		}
		
		System.out.println(lSortedInterval);
	}
}

